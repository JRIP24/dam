# Apuntes Mongo

## Mongo Driver for Java

### Dependencia Maven
```xml
<!-- https://mvnrepository.com/artifact/org.mongodb/mongo-java-driver -->
<dependency>
    <groupId>org.mongodb</groupId>
    <artifactId>mongo-java-driver</artifactId>
    <version>3.12.7</version>
</dependency>
```

### Ocultar los logs
```Java
import java.util.logging.Level;
import java.util.logging.Logger;
...
Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
mongoLogger.setLevel(Level.SEVERE);

```


### Insert

```Java
try(MongoClient mongoClient = MongoClients.create();) {
    
    MongoDatabase database = mongoClient.getDatabase("bd_prova");
    MongoCollection<Document> collection = database.getCollection("clientes");
    
    Document doc = new Document("nif", cliente.getNif()).append("nombre", cliente.getNombre()).append("total_facturacion", cliente.getTotal_facturacion());

    //Atributos opcionales
    if (cliente.getTelefono() != 0){//Por defecto es 0
        doc.append("telefono", cliente.getTelefono());
    }
    if (cliente.getEmail() != null){
        doc.append("email", cliente.getEmail());
    }

    if (cliente.getPedidos() != null){

        //SubDocumentos
        List<Document> arrayPedidos = new ArrayList<>();
        for (Pedido pedido : cliente.getPedidos()){
            arrayPedidos.add(new Document("fecha_pedido", pedido.getFecha_pedido()).append("importe", pedido.getImporte()).append("pagado", pedido.isPagado()));
        }

        doc.append("pedidos", arrayPedidos);
    }

    collection.insertOne(doc);
}
```


### Query

#### - Get All
```Java
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
```


#### - Get with filters

`gte("field",value)` >=

`gt("field",value)` >

`lte("field",value)` <=

`lt("field",value)` <

`eq("field",value)` =

`eq("field",value).first()` devuelve el primer documento

`and(condition, condition)` AND

`and(gt("i", 50), lte("i", 100))` "i" > 50 AND "i" <= 100

```Java
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
```

### Delete

#### - Delete All
```Java
try (MongoClient mongoClient = MongoClients.create();){
    MongoDatabase database = mongoClient.getDatabase("bd_prova");
    MongoCollection<Document> collection = database.getCollection("clientes");
    DeleteResult deleteResult = collection.deleteMany(new Document());
    System.out.println("Documentos borrados: " + deleteResult.getDeletedCount());
}
```

#### - Delete one document
```Java
try (MongoClient mongoClient = MongoClients.create();){
    MongoDatabase database = mongoClient.getDatabase("bd_prova");
    MongoCollection<Document> collection = database.getCollection("clientes");
    DeleteResult deleteResult = collection.deleteOne(new Document("nif", cliente.getNif()));
    //System.out.println("Documentos borrados: " + deleteResult.getDeletedCount());
}
```

## Soluciones consultas

1.- Nombre de restaurants que han tingut una puntuació amb grade B i score 14

`db.restaurants.find({grades:{$elemMatch:{"score":{$eq:14},"grade":{$eq:"B"}}}}).count()`

154 results

2.- Nombre de restaurants que han tingut una puntuació més gran que 92 i més petita que 100.

`db.restaurants.find({grades:{$elemMatch:{$and:[{"score":{$gt:92}},{"score":{$lt:100}}]}}}).count()`

1 result


3.- Mostra l'identificador de restaurant, el nom, l'adreça i les coordenades dels restaurants que es troben en una latitud < -74.0

`db.restaurants.find({"address.coord.0" : {$lt : -74.0}},{restaurant_id:1,name:1,address:1})`

629 results

4.- Mostra l'identificador de restaurant, el nom, l'adreça i les coordenades dels restaurants que es troben en una latitud < -88.0 i longitud > 46.8

`db.restaurants.find({$and: [ {"address.coord.0": {$lt: -88.0}}, {"address.coord.1": {$gt: 46.8}} ] } , {restaurant_id:1, name:1, address:1, coord:1})`

0 results

5.- Trobar els identificadors dels restaurants, que tenen al menys 3 opinions i no tenen cap opinió que sigui A

`db.restaurants.find( { "grades.2":{$exists:true}, "grades.grade":{$nin: ["A"]}} )`

`db.restaurants.find( { $where: "this.grades && this.grades.length >=3", "grades.grade":{$nin: ["A"]}} )`

results: 12

6.- Trobar quants restaurants tenen 9 opinions

`db.restaurants.find( { "grades": { $size: 9 } } )`

7.- Trobar quants restaurants tenen entre 3 i 6 opinions

`db.restaurants.find({"grades.2":{$exists:true},"grades.6":{$exists:false}}).count()`

`db.restaurants.find( { $where: "this.grades && this.grades.length >=3 && this.grades.length <= 6"} )`

8.- Trobar quants restaurants tenen al menys 8 opinions, de les quals al menys una és A, al menys una B i al menys una C

`db.restaurants.find( { "grades.7":{$exists:true}, $and: [ { "grades.grade": { $eq: "A" } }, { "grades.grade": { $eq: "B" } },{ "grades.grade":{ $eq: "C" } } ] } ).count()
db.restaurants.find( { $where: "this.grades && this.grades.length >=8", $and: [ { "grades.grade": { $eq: "A" } }, { "grades.grade": { $eq: "B" } },{ "grades.grade":{ $eq: "C" } } ] } ).count()`

results: 11