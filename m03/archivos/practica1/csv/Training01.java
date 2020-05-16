public class Training01{

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

    public static void m2(){
        
    }

    //3. Nom dels venedors, vendes actuals, quota assignada a cada venedor, quantitat de desviació de la quota respecte a les vendes efectuades.

    public static void m3(){
        
    }

    //4. Número de comanda, client, producte, quantitat, per comandes amb imports superiors a un valor donat (per exemple 25000), ordenats per import.
    public static void m4(){
        
    }
    //5. Import mitjà de les comandes.
    public static void m5(){
        
    }

    //6. Import mitjà de les comandes fetes per un client (per exemple el 2103).
    public static void m6(){
        
    }

    //7. Import total de les comandes enviades a cada client.
    public static void m7(){
        
    }

    //8. Nom dels venedors i data contracte per contractes posteriors a una data donada (per exemple el 14 de juny de 1989).
    public static void m8(){
        
    }

    //9. Ciutats on hi ha oficines on l’objectiu supera un cert valor (per exemple 10000€) la quota de vendes incrementada en un cert valor (per exemple un 10 %).
    public static void m9(){
        
    }

    //10. Ciutats, objectius, vendes actuals i vendes actuals en % respecte dels objectius. 
    public static void m10(){
        
    }



}