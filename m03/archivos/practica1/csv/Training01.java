import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class Training01 {

    public Training01(){

    }


    //1. Oficines, ciutats on estan ubicades i vendes actuals. 
    public void m1(){

        Reader lector = new Reader("oficinas.dat");
        Writer escritor = new Writer("output1.dat");

        //Leemos la primera línea
        String linea = lector.readLine();
        
        while (linea != null) {
            
            String campos[] = linea.split("\\s+");
            escritor.println(campos[0] + "\t" + campos[1] + "\t" + campos[5]);
            linea = lector.readLine();

        }

        escritor.close();


    }

    //2. Nom dels venedors, oficines on treballen, vendes actuals i quota de cada venedor.

    public void m2(){
        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output2.dat");

        //Leemos la primera línea
        String linea = lector.readLine();
        
        while (linea != null) {
            
            String campos[] = linea.split("\\s+");
            escritor.println(campos[1] + "\t" + campos[4] + "\t" + campos[9] + "\t" + campos[8]);
            linea = lector.readLine();

        }

        escritor.close();
    }

    //3. Nom dels venedors, vendes actuals, quota assignada a cada venedor, quantitat de desviació de la quota respecte a les vendes efectuades.

    public void m3(){

        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output3.dat");

        //Leemos la primera línea
        String linea = lector.readLine();
        String cabecera[] = linea.split("\\s+");
        escritor.println(cabecera[1] + "\t" + cabecera[9] + "\t" + cabecera[8] + "\t" + "DESVIACIÓN");
        int desv, cuota, ventas;

        //Seguimos con la siguiente línea
        linea = lector.readLine();
        
        while (linea != null) {

            String campos[] = linea.split("\\s+");

            ventas = 0;
            if (campos[9] != "\\N"){
                ventas = Integer.parseInt(campos[9]);
                
            }

            cuota = 0;
            
            if (!campos[8].equals("\\N")){
                cuota = Integer.parseInt(campos[8]);
            }

            desv = ventas-cuota;

            escritor.println(campos[1] + "\t" + campos[9] + "\t" + campos[8] + "\t" + desv);

            linea = lector.readLine();

        }

        escritor.close();
    }

    //4. Número de comanda, client, producte, quantitat, per comandes amb imports superiors a un valor donat (per exemple 25000), ordenats per import.
    public void m4(){
        
    }
    //5. Import mitjà de les comandes.
    public void m5(){
        
        Reader lector = new Reader("pedidos.dat");
        Writer escritor = new Writer("output5.dat");

        int contador = 0;
        int suma = 0;
        int importe;


        //Leemos la primera línea
        String linea = lector.readLine();
        //Seguimos a la otra línea
        linea = lector.readLine();

        while (linea != null) {

            String campos[] = linea.split("\\s+");

            importe = Integer.parseInt(campos[7]);

            contador++;
            suma = suma + importe;


            linea = lector.readLine();

        }

        escritor.print(suma/contador);

        escritor.close();
    }

    //6. Import mitjà de les comandes fetes per un client (per exemple el 2103).
    public void m6(){
        
        Reader lector = new Reader("pedidos.dat");
        Writer escritor = new Writer("output6.dat");

        int cliente = 2103;
        int cliecod;
        int contador = 0;
        int suma = 0;
        int importe;


        //Leemos la primera línea
        String linea = lector.readLine();
        //Seguimos a la otra línea
        linea = lector.readLine();

        while (linea != null) {

            String campos[] = linea.split("\\s+");

            importe = Integer.parseInt(campos[7]);

            cliecod = Integer.parseInt(campos[2]);

            if (cliecod == cliente){
                contador++;
                suma = suma + importe;
            }

            linea = lector.readLine();

        }

        if (contador > 0){
            escritor.print(suma/contador);
        } else {
            escritor.print("No hay pedidos del cliente " + cliente );
        }

        escritor.close();
    }

    //7. Import total de les comandes enviades a cada client.
    public void m7(){

        //Primero guardaremos la lista de clientes
        HashSet<Integer> clientes = new HashSet<Integer>();

        Reader lector = new Reader("pedidos.dat");
        int client;

        //Leemos la primera línea
        String linea = lector.readLine();
        //Pasamos a la segunda línea
        linea = lector.readLine();

        while (linea != null) {
            
            String campos[] = linea.split("\\s+");

            client = Integer.parseInt(campos[2]);
            
            clientes.add(client);
               
            linea = lector.readLine();

        }

        //Recorremos el hashset
        Writer escritor = new Writer("output7.dat");

        for (int i : clientes){

            Reader l = new Reader("pedidos.dat");

            int suma = 0;
            int importe = 0;

            String line = l.readLine();
            //Pasamos a la segunda línea
            line = l.readLine();

            while (line != null) {
                
                String campos[] = line.split("\\s+");

                client = Integer.parseInt(campos[2]);
                importe = Integer.parseInt(campos[7]);
                
                if (client == i){
                    suma = suma + importe;
                }
                
                line = l.readLine();

            }

            

            escritor.println("Importe total del cliente " + i + ": " + suma + "€");
        }


        escritor.close();

    }

    //8. Nom dels venedors i data contracte per contractes posteriors a una data donada (per exemple el 14 de juny de 1989).

    //Conversor de String a Date 

	public static Date stringToDate(String string){

        Date result = new Date();

        try{

            DateFormat newFormato = new SimpleDateFormat("yyyy-MM-dd");
            result = newFormato.parse(string);
        } catch (java.text.ParseException e){
            e.printStackTrace();
        }

        return result;
	}
	
	//Conversor de Date a String
    public static String dateToString(Date date){

        String pattern = "yyyy-MM-dd";

        DateFormat df = new SimpleDateFormat(pattern);

        String result = df.format(date);

        return result;
    }
    
    public void m8(){
        
        String strf = "1989-06-14";
        Date fecha = stringToDate(strf);

        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output8.dat");

        //Leemos la primera línea
        String linea = lector.readLine();//Es el encabezado;
        //Leemos la siguiente líena
        linea = lector.readLine();

        while (linea != null) {
            
            String campos[] = linea.split("\\s+");

            Date f = stringToDate(campos[6]);

            if (f.after(fecha)){
                escritor.println(campos[1] + "\t" + campos[6]);
            }

            linea = lector.readLine();

        }

        escritor.close();

    }

    //9. Ciutats on hi ha oficines on l’objectiu supera un cert valor (per exemple 10000€) la quota de vendes incrementada en un cert valor (per exemple un 10 %).
    public void m9(){
        
    }

    //10. Ciutats, objectius, vendes actuals i vendes actuals en % respecte dels objectius. 
    public void m10(){
        
    }



}