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

            escritor.close();
            
            line = lectorCreate.readLine();
        }

        lector.close();

        lectorCreate.close();
    }

    public void delete(){

        Reader lector = new Reader("temporalFile.dat");
        

    }

    public void update(){
        
    }

}