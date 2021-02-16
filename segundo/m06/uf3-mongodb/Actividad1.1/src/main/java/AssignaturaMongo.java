import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.gt;
import com.mongodb.client.result.DeleteResult;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class AssignaturaMongo {

    public static void insereix(Assignatura assig) {
        try(MongoClient mongoClient= MongoClients.create();)
        {
            MongoDatabase database= mongoClient.getDatabase("bd_prova");
            MongoCollection<Document> collection= database.getCollection("assignatures");
            Document doc= new Document("nom",assig.nom).append("hores_setmana", assig.hores_setmana);
            collection.insertOne(doc);
        }
    }

    public static void elimina() {
        try(MongoClient mongoClient= MongoClients.create();)
        {
            MongoDatabase database= mongoClient.getDatabase("bd_prova");
            MongoCollection<Document> collection= database.getCollection("assignatures");
            DeleteResult deleteResult = collection.deleteMany(gt("numero_soci",1));
            System.out.println("Documents esborrats: "+deleteResult.getDeletedCount());
        }

    }

    public static List<Assignatura> llegeix(int hores_min) {
        List<Assignatura> resultat = new ArrayList<>();
        try(MongoClient mongoClient= MongoClients.create();)
        {
            MongoDatabase database= mongoClient.getDatabase("bd_prova");
            MongoCollection<Document> collection= database.getCollection("assignatures");
            try (MongoCursor<Document> cursor = collection.find(gt("hores_setmana",hores_min)).iterator()) {
                while (cursor.hasNext()) {
                    Assignatura assig = new Assignatura();
                    Document d = cursor.next();
                    assig.nom = d.getString("nom");
                    assig.hores_setmana = d.getInteger("hores_setmana");
                    resultat.add(assig);
                }
            }
        }
        return resultat;
    }


}


