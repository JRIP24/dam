
//package edt.dam.m6.uf3.exuf3;
import com.mongodb.client.*;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

public class ExUF3 {

    public static void main(String[] args) {
        NomComercial renault_clio = new NomComercial("Renault","Clio");
        NomComercial bmw_golf = new NomComercial("BMW","Golf");
        Revisio r1 = new Revisio(2018,true,"Sense incidències");
        Revisio r2 = new Revisio(2019,true,"Sense incidències");
        Revisio r3 = new Revisio(2020,true,"Retrovisor dret amb mala visibilitat");
        Revisio r4 = new Revisio(2021,false,"Presió dels pneumàtics insuficient");
        Cotxe c1 = new Cotxe("1234ABC",120,renault_clio);
        c1.revisions.add(r1);
        c1.revisions.add(r2);
        Cotxe c2 = new Cotxe("5678DEF",150,bmw_golf);
        c2.revisions.add(r2);
        c2.revisions.add(r3);
        c2.revisions.add(r4);  
        
        exercici1(c1);
        exercici1(c2);
        
        List<Cotxe> llista_cotxes = exercici2("BMW");
        for (Cotxe c: llista_cotxes) {
            System.out.println(c);
        }
    }
    
    public static void exercici1 (Cotxe cotxe) {
        /* TODO: Persistir el cotxe a la BBDD noSQL (Mongo) */
        try(MongoClient mongoClient = MongoClients.create();) {

            MongoDatabase database = mongoClient.getDatabase("bd_examenuf3");
            MongoCollection<Document> collection = database.getCollection("coches");

            Document doc = new Document("matricula", cotxe.matricula).append("cavalls", cotxe.cavalls);

            //Ahora insertaremos los subdocumentos

            //NomComercial
            Document nomComercial = new Document("marca", cotxe.nom_comercial.marca).append("model", cotxe.nom_comercial.model);
            doc.append("nom_comercial", nomComercial);

            //Revisions
            if (cotxe.revisions!= null){
                //SubDocumentos
                List<Document> arrayRevisions = new ArrayList<>();
                for (Revisio revisio : cotxe.revisions){
                    arrayRevisions.add(new Document("any", revisio.any).append("favorable", revisio.favorable).append("comentaris", revisio.comentaris));
                }

                doc.append("revisions", arrayRevisions);
            }

            collection.insertOne(doc);
        }
    }
    
    public static List<Cotxe> exercici2 (String marca) {        
        List<Cotxe> llista_cotxes = new ArrayList<>();
        /* TODO: Recuperar d'una BBDD noSQL (Mongo) la llista de cotxes */
        /* Tan sols recuperarem els cotxes de la marca especificada que tinguin almenys 3 revisions */;
        try(MongoClient mongoClient= MongoClients.create();){
            MongoDatabase database= mongoClient.getDatabase("bd_examenuf3");
            MongoCollection<Document> collection= database.getCollection("coches");
            try (MongoCursor<Document> cursor = collection.find(eq("nom_comercial.marca",marca)).iterator()) {

                if(cursor.hasNext()){

                    while (cursor.hasNext()) {

                        Document d = cursor.next();
                        String matricula = d.getString("matricula");
                        int cavalls = d.getInteger("cavalls");


                        String marcaGet = "";
                        String model = "";

                        Document sub = (Document) d.get("nom_comercial");
                        /*for (Document subdoc : nom) { //Solo debe haber 1...
                            marcaGet = subdoc.getString("marca");
                            model = subdoc.getString("model");
                        }*/

                        marcaGet = sub.getString("marca");
                        model = sub.getString("model");

                        NomComercial nom_comercial = new NomComercial(marcaGet, model);

                        //Revisiones
                        if (d.getList("revisions", Document.class) != null){

                            if ( d.getList("revisions",Document.class).size() >= 3){
                                List<Revisio> revisiones = new ArrayList<>();

                                List<Document> llistaRevisions = d.getList("revisions", Document.class);
                                for (Document subdoc : llistaRevisions) {
                                    Revisio revisio = new Revisio(subdoc.getInteger("any"), subdoc.getBoolean("favorable"), subdoc.getString("comentaris"));
                                    revisiones.add(revisio);
                                }
                                Cotxe cotxe = new Cotxe(matricula, cavalls, nom_comercial);
                                cotxe.revisions = revisiones;
                                llista_cotxes.add(cotxe);
                            }
                        }

                    }

                } else {
                    System.out.println("No se han encontrado resultados");
                }
            }
        }

        return llista_cotxes;
    }
    
}
