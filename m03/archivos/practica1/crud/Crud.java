
public class Crud{

    private String masterFile;
    private String createFile;
    private String deleteFile;
    private String updateFile;
    private String fieldDelimiter;

    public Crud(String mF, String cF, String dF, String uF, String fD){

        this.masterFile = mF;
        this.createFile = cF;
        this.deleteFile = dF;
        this.updateFile = uF;
        this.fieldDelimiter = fD;
    }

    public void create(){

        Reader lectorCreate = new Reader("create.dat");
        Reader lector = new Reader(this.masterFile);
        Writer escritor = new Writer("temporalFile.dat");
        String id;

        String line = lectorCreate.readLine();//Encabezado
        //Pasamos a la siguiente línea
        line = lectorCreate.readLine();

        String linea1 = lector.readLine();
        String linea2 = linea1;

        //Escribimos el encabezado
        escritor.println(linea1);

        //Seguimos con las siguientes líneas
        linea1 = lector.readLine();
        linea2 = lector.readLine();

        //Esribimos la primera líena
        escritor.println(linea1);
        

        while (line != null){

            String fields [] = line.split(":");
            id = fields[0];

            boolean salir = false;
            boolean insertado = false;

            while(salir == false){

                String campos1[] = linea1.split(":");
                String campos2[] = linea2.split(":");

                if (id.compareTo(campos1[0]) > 0 && id.compareTo(campos2[0]) < 0){
                    //System.out.println(id + " va entre " + campos1[0] + " y " + campos2[0]);
                    escritor.println(line);
                    
                    insertado = true;

                }

                //Escribimos el resto de datos
                escritor.println(linea2);
                
            
                linea1 = linea2;
                linea2 = lector.readLine();

                if (insertado || linea2 == null){
                    salir = true;
                    //Si llega al final
                    if (id.compareTo(campos2[0]) > 0 && insertado == false){
                        escritor.println(line);
                        
                    }
                }


            }
            
            line = lectorCreate.readLine();
        }

        escritor.close();
        lector.close();
        lectorCreate.close();

        //Eliminamos master.dat
        Files.delete(this.masterFile);

        //Renombramos el archivo temporal
        Files.rename("temporalFile.dat", "master.dat");
        this.masterFile = "master.dat";
    }

    public void delete(){

        Reader lectorDelete = new Reader("delete.dat");
        Reader lector = new Reader(this.masterFile);
        Writer escritor = new Writer("temporalFile.dat");
        String id;

        String line = lectorDelete.readLine();//Encabezado
        //Pasamos a la siguiente línea
        line = lectorDelete.readLine();

        String linea = lector.readLine();

        //Escribimos el encabezado
        escritor.println(linea);

        //Seguimos con las siguientes líneas
        linea = lector.readLine();

        while (line != null || linea != null){

            id = line;

            boolean salir = false;
            boolean eliminado = false;

            while(salir == false){

                String campos[] = linea.split(":");

                if (campos[0].equals(id)){
                    
                    eliminado = true;

                } else {
                    escritor.println(linea);
                    //System.out.println(linea);
                }
                
            
                linea = lector.readLine();

                if (eliminado || linea == null){
                    salir = true;
                }


            }
            
            line = lectorDelete.readLine();
        }

        escritor.close();
        lector.close();
        lectorDelete.close();

        //Eliminamos master.dat
        Files.delete(this.masterFile);

        //Renombramos el archivo temporal
        Files.rename("temporalFile.dat", "master.dat");
        this.masterFile = "master.dat";

    }

    public void update(){
        
        Reader lectorUpdate = new Reader("update.dat");
        Reader lector = new Reader(this.masterFile);
        Writer escritor = new Writer("temporalFile.dat");
        String id;

        String line = lectorUpdate.readLine();//Encabezado
        //Pasamos a la siguiente línea
        line = lectorUpdate.readLine();

        String linea = lector.readLine();

        //Escribimos el encabezado
        escritor.println(linea);

        //Seguimos con las siguientes líneas
        linea = lector.readLine();

        while (line != null || linea != null){

            if (line == null){
                
                id = null;
                
            } else {
                
                String fields [] = line.split(":");

                id = fields[0];
            }

            boolean salir = false;
            boolean actualizado = false;

            while(salir == false){

                String campos[] = linea.split(":");

                if (campos[0].equals(id)){
                    
                    escritor.println(line);
                    actualizado = true;

                } else {
                    escritor.println(linea);
                    //System.out.println(linea);
                }
                
            
                linea = lector.readLine();

                if (actualizado || linea == null){
                    salir = true;
                }

            }
            
            line = lectorUpdate.readLine();
        }

        escritor.close();
        lector.close();
        lectorUpdate.close();

        //Eliminamos master.dat
        Files.delete(this.masterFile);

        //Renombramos el archivo temporal
        Files.rename("temporalFile.dat", "master.dat");
        this.masterFile = "master.dat";

    }

}