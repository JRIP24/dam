public class Training03{

    //21. Nom de venedors que les seves vendes actuals són superiors a les seves quotes.
    public void m21(){

        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output21.dat");
        int ventas;
        int cuotas;

        //Leemos la primera línea
        String linea = lector.readLine();
        //Leemos la siguiente línea
        linea = lector.readLine();

        while(linea != null){

            String campos[] = linea.split("\\s+");


            if (!campos[8].equals("\\N") && !campos[9].equals("\\N")){

                cuotas = Integer.parseInt(campos[8]);
                ventas = Integer.parseInt(campos[9]);

                if (ventas > cuotas){
                    escritor.println(campos[1]);
                }
            }

            linea = lector.readLine();

        }

        escritor.close();

    }

    //22. Nombre de comanda i import on l’import de la comanda estigui entre dos valor donats (per exemple entre 30.000 i 40.000€).
    public void m22(){

        Reader lector = new Reader("pedidos.dat");
        Writer escritor = new Writer("output22.dat");
        int maximo = 40000;
        int minimo = 30000;
        int importe;

        //Leemos la primera línea
        String linea = lector.readLine();
        String encabezado[] = linea.split("\\s+");
        escritor.println(encabezado[0] + "\t" + encabezado[7]);
        //Leemos la siguiente línea
        linea = lector.readLine();

        while(linea != null){

            String campos[] = linea.split("\\s+");

            importe = Integer.parseInt(campos[7]);

            if (importe >= minimo && importe <= maximo){

                escritor.println(campos[0] + "\t" + campos[7]);
            }

            linea = lector.readLine();

        }

        escritor.close();
    }
    
    //23. Nom, vendes actuals, i quota dels venedors d’aquells venedors que les seves vendes no estan 
    //entre dos valors donats (per exemple el 80% i el 120%) de la seva quota.
    public void m23(){

        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output23.dat");
        int ventas;
        int cuotas;
        int minP = 80;
        int maxP = 120;
        int minC;
        int maxC;

        //Leemos la primera línea
        String linea = lector.readLine();
        //Leemos la siguiente línea
        linea = lector.readLine();

        while(linea != null){

            String campos[] = linea.split("\\s+");


            if (!campos[8].equals("\\N") && !campos[9].equals("\\N")){

                cuotas = Integer.parseInt(campos[8]);
                ventas = Integer.parseInt(campos[9]);
                
                minC = (cuotas * minP ) / 100;
                maxC = (cuotas * maxP ) / 100;

                if (ventas >= minC && ventas <= maxC){

                    escritor.println(campos[1] + "\t" + campos[8] + "\t" + campos[9]);
                }

                
            }

            linea = lector.readLine();

        }

        escritor.close();

    }
    
    //24. Nom dels venedors que treballen a tres ciutats (per exemple a New York, Atlanta o Denver).
    public void m24(){

        Reader lector = new Reader("repventas.dat");
        Reader lectorOficina = new Reader("oficinas.dat");
        Writer escritor = new Writer("output24.dat");
        String city1 = "NewYork";
        String city2 = "Atlanta";
        String city3 = "Denver";
        int oficinas[] = new int[3];
        int ofinum;
        int ofinumRepventas;
        int contador = 0;

        String l = lectorOficina.readLine();
        l = lectorOficina.readLine();

        //Este primer bucle nos servirá para saber el ID de las oficinas
        while(l != null){

            String c[] = l.split("\\s+");

            if (c[1].equals(city1) || c[1].equals(city2) || c[1].equals(city3)){

                ofinum = Integer.parseInt(c[0]);
                oficinas[contador] = ofinum;
                contador++;

            }

            l = lectorOficina.readLine();

            if (contador >= 3){//Condición de salida
                l = null;
            }

        }


        //Leemos la primera línea
        String linea = lector.readLine();
        //Leemos la siguiente línea
        linea = lector.readLine();

        while(linea != null){

            String campos[] = linea.split("\\s+");

            if (!campos[4].equals("\\N")){
                
                ofinumRepventas = Integer.parseInt(campos[4]);

                if (ofinumRepventas == oficinas[0] || ofinumRepventas == oficinas[1] || ofinumRepventas == oficinas[2] ){

                    escritor.println(campos[1] + "\t" + campos[4]);
                }
            }


            linea = lector.readLine();

        }

        escritor.close();
    }
    
    //25. Número de comanda, data comanda, import de totes les comandes fetes un dijous del mes de gener de 1990. (Eren els dies 4, 11,18 i 25).
    public void m25(){

        Reader lector = new Reader("pedidos.dat");
        Writer escritor = new Writer("output25.dat");
        int dias[] = {4,11,18,25};
        String fecha = "1990-01-";//Contendrá el mes y año pero no el día

        //Leemos la primera línea
        String linea = lector.readLine();
        //Leemos la siguiente línea
        linea = lector.readLine();

        while(linea != null){

            String campos[] = linea.split("\\s+");
            
            for (int i = 0; i < dias.length; i++) {
                
                if (campos[1].equals( fecha + String.valueOf(dias[i]))){

                    escritor.println(campos[0] + "\t" + campos[1] + "\t" + campos[7]);

                }
            }

            linea = lector.readLine();

        }

        escritor.close();

    }
    
    //26. Noms dels venedors sense oficines assignades.
    public void m26(){

        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output26.dat");

        //Leemos la primera línea
        String linea = lector.readLine();
        //Leemos la siguiente línea
        linea = lector.readLine();

        while(linea != null){

            String campos[] = linea.split("\\s+");


            if (campos[4].equals("\\N")){

                escritor.println(campos[1]);
            }

            linea = lector.readLine();

        }

        escritor.close();
    }
    
    //27. Nom venedors, quotes i vendes actuals dels venedors que tenen vendes per sota de la seva quota o vendes inferiors a un cert valor (per exemple 300.000 €.)
    public void m27(){

        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output27.dat");
        int ventas;
        int cuotas;
        int valor = 300000;

        //Leemos la primera línea
        String linea = lector.readLine();
        //Leemos la siguiente línea
        linea = lector.readLine();

        while(linea != null){

            String campos[] = linea.split("\\s+");

            if (!campos[8].equals("\\N") && !campos[9].equals("\\N")){

                cuotas = Integer.parseInt(campos[8]);
                ventas = Integer.parseInt(campos[9]);

                if (ventas < cuotas || ventas < valor){
                    escritor.println(campos[1] + "\t" + campos[8] + "\t" + campos[9]);
                }

            }

            linea = lector.readLine();

        }

        escritor.close();
    }
    
    //28. Nom venedors, quotes i vendes actuals dels venedors que tenen vendes per sota de la seva quota i vendes inferiors a un cert valor (per exemple 300.000€).
    public void m28(){

        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output28.dat");
        int ventas;
        int cuotas;
        int valor = 300000;

        //Leemos la primera línea
        String linea = lector.readLine();
        //Leemos la siguiente línea
        linea = lector.readLine();

        while(linea != null){

            String campos[] = linea.split("\\s+");

            if (!campos[8].equals("\\N") && !campos[9].equals("\\N")){

                cuotas = Integer.parseInt(campos[8]);
                ventas = Integer.parseInt(campos[9]);

                if (ventas < cuotas && ventas < valor){
                    escritor.println(campos[1] + "\t" + campos[8] + "\t" + campos[9]);
                }

            }

            linea = lector.readLine();

        }

        escritor.close();
    }
    
    //29. Nom venedors, quotes i vendes actuals dels venedors que tenen vendes per sota de la seva quota
    //però les seves vendes no són inferiors a un cert valor (per exemple 150.000 €).
    public void m29(){

        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output29.dat");
        int ventas;
        int cuotas;
        int valor = 150000;

        //Leemos la primera línea
        String linea = lector.readLine();
        //Leemos la siguiente línea
        linea = lector.readLine();

        while(linea != null){

            String campos[] = linea.split("\\s+");

            if (!campos[8].equals("\\N") && !campos[9].equals("\\N")){

                cuotas = Integer.parseInt(campos[8]);
                ventas = Integer.parseInt(campos[9]);

                if (ventas < cuotas && ventas >= valor){
                    escritor.println(campos[1] + "\t" + campos[8] + "\t" + campos[9]);
                }

            }

            linea = lector.readLine();

        }

        escritor.close();
    }
    
    //30. Ciutat, regió i vendes ordenades per regió i ciutat.
    public void m30(){

    }
    


}