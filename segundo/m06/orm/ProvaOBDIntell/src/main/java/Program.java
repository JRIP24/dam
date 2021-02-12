import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.Configuration;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Predicate;

import java.util.List;


public class Program {


    public static void main(String[] args){

        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        config.common().objectClass(Persona.class).cascadeOnUpdate(true);

        ObjectContainer db = Db4oEmbedded.openFile(config, "db.db4o");

        //Persona p = new Persona("Y2671909", "Ronald", 20);
        //db.store(p);
        Predicate p = new Predicate<Persona>() {
            @Override
            public boolean match(Persona person) {
                return true;
            }
        };

        List<Persona> result = db.query(p);

        for( Persona persona : result){
            System.out.println(persona.getName());
        }




        db.close();

    }



}
