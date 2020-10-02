public class Training02{

    //11. Ciutats, objectius i vendes d'una regió (per exemple "Oeste"), on les vendes actuals superen els objectius, ordenats per ciutats.
    public void m11(){

        Reader lector = new Reader("oficinas.dat");
        Writer escritor = new Writer("output11.dat");
        String region = "Oeste";
        int ventas;
        int objetivo;

        //Leemos la primera línea y pasamos a la segunda
        String linea = lector.readLine();
        linea = lector.readLine();

        while (linea != null) {
            
            String campos[] = linea.split("\\s+");

            objetivo = Integer.parseInt(campos[4]);
            ventas = Integer.parseInt(campos[5]);

            
            if (campos[2].equals(region)){

                if (ventas > objetivo){
                    
                    escritor.println(campos[1] + "\t" + objetivo + "\t" + ventas + "\t" + campos[2]);
                }
            }

            linea = lector.readLine();

        }

        escritor.close();

    }
    //12. Valors mitjans dels objectius i vendes actuals d'una regió(per exemple “Oeste”).
    public void m12(){
        
        Reader lector = new Reader("oficinas.dat");
        Writer escritor = new Writer("output12.dat");
        String region = "Oeste";
        int ventas;
        int objetivo;
        int sumaObj = 0;
        int contadorObj = 0;
        int sumaVent = 0;
        int contadorVent = 0;

        //Leemos la primera línea y pasamos a la segunda
        String linea = lector.readLine();
        linea = lector.readLine();

        while (linea != null) {
            
            String campos[] = linea.split("\\s+");

            objetivo = Integer.parseInt(campos[4]);
            ventas = Integer.parseInt(campos[5]);

            
            if (campos[2].equals(region)){            

                contadorObj++;
                sumaObj = sumaObj + objetivo;

                contadorVent++;
                sumaVent = sumaVent + ventas;
            
            }

            linea = lector.readLine();

        }

        escritor.println("Oficinas de la región " + region + ": ");
        escritor.println("MEDIA DE OBJETIVOS" + "\t" + "MEDIA DE VENTAS");
        escritor.println((sumaObj/contadorObj) + "\t" + (sumaVent/contadorVent) );

        escritor.close();
    }

    //13. Noms, oficines i dates de contracte de tots els venedors.
    public void m13(){
        
        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output13.dat");

        //Escribimos el encabezado
        String linea = lector.readLine();
        String encabezados[] = linea.split("\\s+");
        escritor.println(encabezados[1] + "\t" + encabezados[4] + "\t" + encabezados[6]);

        //Pasamos a la siguiente línea
        linea = lector.readLine();

        while(linea != null){

            String campos[] = linea.split("\\s+");

            escritor.println(campos[1] + "\t" + campos[4] + "\t" + campos[6]);

            linea = lector.readLine();
        }


        escritor.close();

    }

    //14. Nom, quota i vendes actuals d'un empleat ( per exemple el 107).
    public void m14(){
        
        int empleado = 107;
        int id;

        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output14.dat");        

        //Escribimos el encabezado
        String linea = lector.readLine();
        String encabezados[] = linea.split("\\s+");
        escritor.println(encabezados[0] + "\t" + encabezados[8] + "\t" + encabezados[9]);

        //Pasamos a la siguiente línea
        linea = lector.readLine();

        while(linea != null){

            String campos[] = linea.split("\\s+");

            id = Integer.parseInt(campos[0]);

            if (id == empleado){
                escritor.println(campos[0] + "\t" + campos[8] + "\t" + campos[9]);
            }

            linea = lector.readLine();
        }


        escritor.close();

    }

    //15. Valor mitjà de totes les vendes.
    public void m15(){
        
        //Se supondrá que se refiere a las ventas del archivo repventas.dat
        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output15.dat");
        int suma = 0;
        int contador = 0;
        int ventas;

        //Escribimos el encabezado
        String linea = lector.readLine();
        //Pasamos a la siguiente línea
        linea = lector.readLine();

        while(linea != null){

            String campos[] = linea.split("\\s+");

            ventas = Integer.parseInt(campos[9]);

            suma = suma + ventas;
            contador++;

            linea = lector.readLine();
        }

        escritor.println(suma/contador);

        escritor.close();
    }

    //16. Noms i dates del contracte dels venedors tal que les seves vendes actuals superen un valor (per exemple 500.000 €).
    public void m16(){
        
        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output16.dat");
        int valor = 500000;
        int ventas;

        //Escribimos el encabezado
        String linea = lector.readLine();
        String encabezados[] = linea.split("\\s+");
        escritor.println(encabezados[1] + "\t" + encabezados[6] + "\t" + encabezados[9]);
        //Pasamos a la siguiente línea
        linea = lector.readLine();

        while(linea != null){

            String campos[] = linea.split("\\s+");

            ventas = Integer.parseInt(campos[9]);

            if (ventas > valor){

                escritor.println(campos[1] + "\t" + campos[6] + "\t" + ventas);
            }

            linea = lector.readLine();
        }

        escritor.close();
    }

    //17. Valor de l’inventari de cada producte.
    public void m17(){
        
        Reader lector = new Reader("productos.dat");
        Writer escritor = new Writer("output17.dat");
        int valor;
        int precio_ud;
        int stock;

        //Escribimos el encabezado
        String linea = lector.readLine();
        String encabezados[] = linea.split("\\s+");
        escritor.println(encabezados[1] + "\t" + "VALOR DE STOCK");
        //Pasamos a la siguiente línea
        linea = lector.readLine();

        while(linea != null){

            String campos[] = linea.split("\\s+");

            precio_ud = Integer.parseInt(campos[3]);
            stock = Integer.parseInt(campos[4]);

            valor = precio_ud * stock;

            escritor.println(campos[1] + "\t" + valor);
        
            linea = lector.readLine();
        }

        escritor.close();
    }

    //18. Nom, quota i quota incrementada en un valor (per exemple un 3%) de les vendes actuals.
    public void m18(){
        
        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output18.dat");
        int porcentaje = 3;
        int cuota;
        int incremento;

        //Escribimos el encabezado
        String linea = lector.readLine();
        String encabezados[] = linea.split("\\s+");
        escritor.println(encabezados[1] + "\t" + encabezados[8] + "\t" + "QUOTA INCREMENTADA " + porcentaje + "%");
        //Pasamos a la siguiente línea
        linea = lector.readLine();

        while(linea != null){

            String campos[] = linea.split("\\s+");

            if (!campos[8].equals("\\N")){

                cuota = Integer.parseInt(campos[8]);
                incremento = cuota + ((cuota*porcentaje)/100);

                escritor.println(campos[1] + "\t" + campos[8] + "\t" + incremento);
            }
        

            linea = lector.readLine();
        }

        escritor.close();
    }

    //19. Ciutat, vendes actuals, objectius de les oficines on les vendes actuals són inferiors a un valor (per exemple 80%) dels seus objectius.
    public void m19(){
        
        Reader lector = new Reader("oficinas.dat");
        Writer escritor = new Writer("output19.dat");
        int ventas;
        int objetivo;
        int porcentajeObj;
        int porcentaje = 80;

        //Leemos la primera línea y pasamos a la segunda
        String linea = lector.readLine();
        String encabezados[] = linea.split("\\s+");
        escritor.println("Ciudades con ventas inferiores al " + porcentaje + "% " + "de su objetivo \n");
        escritor.println(encabezados[1] + "\t" + encabezados[5] + "\t" + encabezados[4]);
        linea = lector.readLine();

        while (linea != null) {
            
            String campos[] = linea.split("\\s+");
        
            if (!campos[4].equals("\\N") && !campos[5].equals("\\N")){

                objetivo = Integer.parseInt(campos[4]);
                ventas = Integer.parseInt(campos[5]);

                porcentajeObj = (objetivo * porcentaje)/100;

                if (ventas < porcentajeObj){
                    escritor.println(campos[1] + "\t" + campos[5] + "\t" + campos[4]);
                }

            }

            linea = lector.readLine();

        }

        escritor.close();
    }

    //20. Ciutats on hi ha oficines no dirigides per un empleat (per exemple el 108). 
    public void m20(){
        
        Reader lector = new Reader("oficinas.dat");
        Writer escritor = new Writer("output20.dat");
        int empleado = 108;
        int director;

        //Leemos la primera línea y pasamos a la segunda
        String linea = lector.readLine();
        String encabezados[] = linea.split("\\s+");
        escritor.println("Ciudades no dirigidas por el empleado " + empleado + "\n");
        escritor.println(encabezados[1] + "\t" + encabezados[3]);
        linea = lector.readLine();

        while (linea != null) {
            
            String campos[] = linea.split("\\s+");

            director = Integer.parseInt(campos[3]);

            if (director != empleado){
                escritor.println(campos[1] + "\t" + campos[3]);
            }      

            linea = lector.readLine();

        }

        escritor.close();

    }


}