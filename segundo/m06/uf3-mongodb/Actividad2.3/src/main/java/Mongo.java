import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.gt;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mongo {

    public Mongo(){

    }

    public static void insertClient(Cliente cliente){

        //Recogemos los clientes de la BBDD para ver si el cliente que se intenta insertar ya existe
        List<Cliente> listaClientes = getAllClients();
        boolean clientExists = false;
        for(Cliente c : listaClientes){
            if (c.getNif().equals(cliente.getNif())){
                clientExists = true;
                break;
            }
        }

        if (clientExists){
            System.out.println("El cliente con nif "+ cliente.getNif() +" ya existe");

        } else { //Si el cliente no existe lo insertamos

            try(MongoClient mongoClient = MongoClients.create();) {
                MongoDatabase database = mongoClient.getDatabase("bd_prova");
                MongoCollection<Document> collection = database.getCollection("clientes");
                Document doc = new Document("nif", cliente.getNif()).append("nombre", cliente.getNombre()).append("total_facturacion", cliente.getTotal_facturacion());

                //Verificamos los atributos opcionales

                if (cliente.getTelefono() != 0){//Por defecto es 0
                    doc.append("telefono", cliente.getTelefono());
                }
                if (cliente.getEmail() != null){
                    doc.append("email", cliente.getEmail());
                }

                if (cliente.getPedidos() != null){
                    List<Document> arrayPedidos = new ArrayList<>();
                    for (Pedido pedido : cliente.getPedidos()){
                        arrayPedidos.add(new Document("fecha_pedido", pedido.getFecha_pedido()).append("importe", pedido.getImporte()).append("pagado", pedido.isPagado()));
                    }

                    doc.append("pedidos", arrayPedidos);
                }

                collection.insertOne(doc);
            }

        }



    }


    public static void insertOrder(){
        List<Cliente> clientes = getAllClients();

        if (clientes.size() == 0){
            System.out.println("No se han encontrado clientes");
        } else {
            Scanner teclado = new Scanner(System.in);

            for (int i = 0; i < clientes.size();i++ ){

                System.out.println( (i + 1) + ") " + clientes.get(i).getNif());

            }

            boolean salir = false;
            int opcion = 0;
            while (!salir) {
                System.out.print("Elija un cliente: (" + 1 + " - " + clientes.size() + "): ");
                String opcionStr = teclado.nextLine();
                try {
                     opcion = Integer.parseInt(opcionStr);
                    if( opcion >= 1 && opcion <= clientes.size()){//Comprobamos que sea correcto
                        salir = true;
                    }

                }catch (Exception e){
                    System.out.println("Error: elija un número entre (" + 1 + " - " + clientes.size() + ")");
                }

            }

            int indice = opcion -1;
            List<Pedido> pedidos = clientes.get(indice).getPedidos();

            if (pedidos == null){//Por si no hay pedidos
                pedidos = new ArrayList<Pedido>();
            }

            Pedido pedido = new Pedido(true);
            pedidos.add(pedido);
            clientes.get(indice).setPedidos(pedidos);

            //Aumentamos el importe
            int facturacion = clientes.get(indice).getTotal_facturacion();
            clientes.get(indice).setTotal_facturacion(facturacion + pedido.getImporte());

            deleteClient(clientes.get(indice));
            insertClient(clientes.get(indice));



        }



    }

    public static List<Cliente> getAllClients(){
        List<Cliente> resultado = new ArrayList<>();
        try(MongoClient mongoClient= MongoClients.create();){
            MongoDatabase database= mongoClient.getDatabase("bd_prova");
            MongoCollection<Document> collection= database.getCollection("clientes");
            try (MongoCursor<Document> cursor = collection.find().cursor();) {
                while (cursor.hasNext()) {
                    Cliente cliente = new Cliente();
                    Document d = cursor.next();
                    cliente.setNif(d.getString("nif"));
                    cliente.setNombre(d.getString("nombre"));
                    cliente.setTotal_facturacion(d.getInteger("total_facturacion"));

                    //tambien se puede usar d.containsKey("atribut_opcional")
                    if (d.getInteger("telefono") != null){
                        cliente.setTelefono(d.getInteger("telefono"));
                    }
                    if (d.getString("email") != null){
                        cliente.setEmail(d.getString("email"));
                    }

                    if (d.getList("pedidos", Document.class) != null){

                        List<Pedido> pedidos = new ArrayList<>();

                        List<Document> listaPedidos = d.getList("pedidos", Document.class);
                        for (Document subdoc : listaPedidos) {
                            Pedido p = new Pedido(subdoc.getDate("fecha_pedido"),subdoc.getInteger("importe"), subdoc.getBoolean("pagado"));
                            pedidos.add(p);
                        }
                        cliente.setPedidos(pedidos);
                    }

                    resultado.add(cliente);
                }
            }
        }

        return resultado;
    }

    public static void getClientsByBilling(int facturacion){

        try(MongoClient mongoClient= MongoClients.create();)
        {
            MongoDatabase database= mongoClient.getDatabase("bd_prova");
            MongoCollection<Document> collection= database.getCollection("clientes");
            try (MongoCursor<Document> cursor = collection.find(gte("total_facturacion",facturacion)).iterator()) {

                if(cursor.hasNext()){

                    while (cursor.hasNext()) {

                        Cliente cliente = new Cliente();
                        Document d = cursor.next();
                        cliente.setNif(d.getString("nif"));
                        cliente.setNombre(d.getString("nombre"));
                        cliente.setTotal_facturacion(d.getInteger("total_facturacion"));

                        //tambien se puede usar d.containsKey("atribut_opcional")
                        if (d.getInteger("telefono") != null){
                            cliente.setTelefono(d.getInteger("telefono"));
                        }
                        if (d.getString("email") != null){
                            cliente.setEmail(d.getString("email"));
                        }

                        if (d.getList("pedidos", Document.class) != null){

                            List<Pedido> pedidos = new ArrayList<>();

                            List<Document> listaPedidos = d.getList("pedidos", Document.class);
                            for (Document subdoc : listaPedidos) {
                                Pedido p = new Pedido(subdoc.getDate("fecha_pedido"),subdoc.getInteger("importe"), subdoc.getBoolean("pagado"));
                                pedidos.add(p);
                            }
                            cliente.setPedidos(pedidos);
                        }

                        System.out.println(cliente);
                    }

                } else {
                    System.out.println("No se han encontrado clientes con una facturación igual o mayor a " + facturacion + "€");
                }
            }
        }

    }


    public static void getClientsByOrders(int numOrders){

        try(MongoClient mongoClient= MongoClients.create();){
            MongoDatabase database= mongoClient.getDatabase("bd_prova");
            MongoCollection<Document> collection= database.getCollection("clientes");
            try (MongoCursor<Document> cursor = collection.find().cursor();) {
                while (cursor.hasNext()) {

                    Cliente cliente = new Cliente();
                    Document d = cursor.next();

                    cliente.setNif(d.getString("nif"));
                    cliente.setNombre(d.getString("nombre"));
                    cliente.setTotal_facturacion(d.getInteger("total_facturacion"));

                    //tambien se puede usar d.containsKey("atribut_opcional")
                    if (d.getInteger("telefono") != null){
                        cliente.setTelefono(d.getInteger("telefono"));
                    }
                    if (d.getString("email") != null){
                        cliente.setEmail(d.getString("email"));
                    }

                    int numPedidos = 0; //Se define aqui porque se ha permitido al usuario buscar clientes con 0 o más pedidos

                    if (d.getList("pedidos", Document.class) != null){

                        List<Pedido> pedidos = new ArrayList<>();

                        numPedidos = d.getList("pedidos", Document.class).size();
                        List<Document> listaPedidos = d.getList("pedidos", Document.class);

                        for (Document subdoc : listaPedidos) {
                            Pedido p = new Pedido(subdoc.getDate("fecha_pedido"),subdoc.getInteger("importe"), subdoc.getBoolean("pagado"));
                            pedidos.add(p);
                        }
                        cliente.setPedidos(pedidos);
                    }

                    if (numPedidos >= numOrders){
                        System.out.println(cliente);
                    }
                }
            }
        }

    }

    public static void deleteClient(Cliente cliente){
        try (MongoClient mongoClient = MongoClients.create();){
            MongoDatabase database = mongoClient.getDatabase("bd_prova");
            MongoCollection<Document> collection = database.getCollection("clientes");
            DeleteResult deleteResult = collection.deleteOne(new Document("nif", cliente.getNif()));
            //System.out.println("Documentos borrados: " + deleteResult.getDeletedCount());
        }
    }

    public static void deleteAll(){
        try (MongoClient mongoClient = MongoClients.create();){
            MongoDatabase database = mongoClient.getDatabase("bd_prova");
            MongoCollection<Document> collection = database.getCollection("clientes");
            DeleteResult deleteResult = collection.deleteMany(new Document());
            System.out.println("Documentos borrados: " + deleteResult.getDeletedCount());
        }
    }

}
