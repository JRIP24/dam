public class Training04{

    //31. Ciutat i regió de les oficines ordenades pel millor rendiment en les vendes.
    public void m31(){

    }

    //32. Fabricant i producte de les comandes superiors a un cert valor (per exemple 30.000 €).
    public void m32(){

        Reader lector = new Reader("pedidos.dat");
        Writer escritor = new Writer("output32.dat");
        int valor = 30000;
        int importe;

        //Leemos la primera línea
        String linea = lector.readLine();
        String encabezados [] = linea.split("\\s+");
        escritor.println(encabezados[4] + "\t" + encabezados[5] + "\t" + encabezados[7]); 
        //Pasamos a la siguiente
        linea = lector.readLine();

        while(linea != null){

            String campos [] = linea.split("\\s+");

            importe = Integer.parseInt(campos[7]);

            if (importe > valor){

                escritor.println(campos[4] + "\t" + campos[5] + "\t" + importe);
            }


            linea = lector.readLine();

        }

        escritor.close();

    }
    
    //33. Número de comanda, import, empresa, límit de crèdit del client.
    public void m33(){
        
        Reader lector = new Reader("pedidos.dat");
        Writer escritor = new Writer("output33.dat");
        int cliente;//Se usará en pedidos.dat
        int idCliente; //Se usará en clientes.dat
        int limCredit = 0;
        String empresa = "";

        //Leemos la primera línea
        String linea = lector.readLine();
        String encabezados [] = linea.split("\\s+");
        escritor.println(encabezados[0] + "\t" + encabezados[7]); 
        //Pasamos a la siguiente
        linea = lector.readLine();

        while(linea != null){

            String campos [] = linea.split("\\s+");

            cliente = Integer.parseInt(campos[2]);


            Reader lectorClientes = new Reader("clientes.dat");

            //Primera línea y  pasamos a la siguiente;
            String lineaCliente = lectorClientes.readLine();
            lineaCliente = lectorClientes.readLine();
            boolean salir = false;


            while(salir == false){

                String c[] = lineaCliente.split("\\s+");

                idCliente = Integer.parseInt(c[0]);
                limCredit = Integer.parseInt(c[3]);
                empresa = c[1];

                lineaCliente = lectorClientes.readLine();
                

                //Condición de salida
                if (cliente == idCliente){
                    salir = true;
                }
            }

            escritor.println(campos[0] + "\t" + campos[7] + "\t" + empresa + "\t" + limCredit);
            


            linea = lector.readLine();

        }

        escritor.close();
    }
    
    //34. Nom dels venedors, ciutat i oficines on treballen.
    public void m34(){
        
        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output34.dat");
        int oficina;//Se usará en repventas.dat
        int idOficina;//Se usará en oficinas.dat
        String ciudad = "";

        //Leemos la primera línea
        String linea = lector.readLine();
        //Pasamos a la siguiente
        linea = lector.readLine();

        while(linea != null){

            String campos [] = linea.split("\\s+");

            if (!campos[4].equals("\\N")){
                oficina = Integer.parseInt(campos[4]);

                Reader lectorOficinas = new Reader("oficinas.dat");

                //Primera línea y  pasamos a la siguiente;
                String lineaOficina = lectorOficinas.readLine();
                lineaOficina = lectorOficinas.readLine();
                boolean salir = false;


                while(salir == false){

                    String c[] = lineaOficina.split("\\s+");
                    
                    idOficina = Integer.parseInt(c[0]);

                    ciudad = c[1];

                    lineaOficina = lectorOficinas.readLine();

                    //Condición de salida
                    if (idOficina == oficina){
                        salir = true;
                    }
                }

                escritor.println(campos[1] + "\t" + ciudad + "\t" + oficina);
            }

            

            linea = lector.readLine();

        }

        escritor.close();
    }
    
    //35. Ciutats, nombres dels directors i càrrecs de totes les oficines.
    public void m35(){

        Reader lector = new Reader("oficinas.dat");
        Writer escritor = new Writer("output35.dat");
        int director;
        int vendedor;
        String cargo = "";
        String nombre = "";


        //Leemos la primera línea
        String linea = lector.readLine();
        escritor.println("CIUDAD" + "\t" + "DIRECTOR" + "\t" + "Cargo");
        //Pasamos a la siguiente
        linea = lector.readLine();

        while(linea != null){

            String campos [] = linea.split("\\s+");

            director = Integer.parseInt(campos[3]);

            Reader lectorRep = new Reader("repventas.dat");

            //Primera línea y  pasamos a la siguiente;
            String lineaRep = lectorRep.readLine();
            lineaRep = lectorRep.readLine();
            boolean salir = false;


            while(salir == false){

                String c[] = lineaRep.split("\\s+");
                
                vendedor = Integer.parseInt(c[0]);
                cargo = c[5];
                nombre = c[1];


                lineaRep = lectorRep.readLine();

                //Condición de salida
                if (vendedor == director){
                    salir = true;
                }
            }

            escritor.println(campos[1] + "\t" + nombre + "\t" + cargo);

        

            linea = lector.readLine();

        }

        escritor.close();
    }
    
    //36. Ciutats, nombres dels directors i càrrecs de les oficines amb objectius superiors a un cert valor (per exemple 600.000 €).
    public void m36(){

        Reader lector = new Reader("oficinas.dat");
        Writer escritor = new Writer("output36.dat");
        int valor = 600000;
        int objetivo;
        int director;
        int vendedor;
        String cargo = "";
        String nombre = "";


        //Leemos la primera línea
        String linea = lector.readLine();
        escritor.println("CIUDAD" + "\t" + "DIRECTOR" + "\t" + "Cargo");
        //Pasamos a la siguiente
        linea = lector.readLine();

        while(linea != null){

            String campos [] = linea.split("\\s+");

            if (!campos[4].equals("\\N")){

                director = Integer.parseInt(campos[3]);
                objetivo = Integer.parseInt(campos[4]);

                if (objetivo > valor){
                    Reader lectorRep = new Reader("repventas.dat");

                    //Primera línea y  pasamos a la siguiente;
                    String lineaRep = lectorRep.readLine();
                    lineaRep = lectorRep.readLine();
                    boolean salir = false;


                    while(salir == false){

                        String c[] = lineaRep.split("\\s+");
                        
                        vendedor = Integer.parseInt(c[0]);
                        cargo = c[5];
                        nombre = c[1];


                        lineaRep = lectorRep.readLine();

                        //Condición de salida
                        if (vendedor == director){
                            salir = true;
                        }
                    }

                    escritor.println(campos[1] + "\t" + nombre + "\t" + cargo);
                }

                
            }



            linea = lector.readLine();

        }

        escritor.close();
    }
    
    //37. Número de comanda, import i descripció.
    public void m37(){

        Reader lector = new Reader("pedidos.dat");
        Writer escritor = new Writer("output37.dat");
        String producto;//Se usará en pedidos.dat
        String id; //Se usará en productos.dat
        String descripcion = "";

        //Leemos la primera línea
        String linea = lector.readLine();
        escritor.println("Nº PEDIDO" + "\t" + "IMPORTE" + "\t" +  "DESCRIPCION");
        //Pasamos a la siguiente
        linea = lector.readLine();

        while(linea != null){

            String campos [] = linea.split("\\s+");

            producto = campos[5];


            Reader lectorProd = new Reader("productos.dat");

            //Primera línea y  pasamos a la siguiente;
            String lineaProd = lectorProd.readLine();
            lineaProd = lectorProd.readLine();
            boolean salir = false;

            while(salir == false){

                String c[] = lineaProd.split("\\s+");

                id = c[1];
                descripcion = c[2];

                lineaProd = lectorProd.readLine();
                

                //Condición de salida
                if (producto.equals(id)){
                    salir = true;
                }
            }

            escritor.println(campos[0] + "\t" + campos[7]+ "€" + "\t" + descripcion);
            


            linea = lector.readLine();

        }

        escritor.close();
    }
    
    //38. Número de comanda, import, empresa, nom del venedor de les comandes amb import superior a un cert valor (per exemple 25.000 €).
    public void m38(){

        Reader lector = new Reader("pedidos.dat");
        Writer escritor = new Writer("output38.dat");
        int idCliente;
        int vendedor;
        int idVendedor;
        int cliente;
        int importe;
        int valor = 25000;
        String nombreEmpresa = "";
        String nombreVendedor = "";


        //Leemos la primera línea
        String linea = lector.readLine();
        escritor.println("Nº PEDIDO" + "\t" + "IMPORTE" + "\t" +  "EMPRESA" + "\t" + "VENDEDOR");
        //Pasamos a la siguiente
        linea = lector.readLine();

        while(linea != null){

            String campos [] = linea.split("\\s+");

            cliente = Integer.parseInt(campos[2]);
            vendedor = Integer.parseInt(campos[3]);
            importe = Integer.parseInt(campos[7]);

            if (importe > valor){

                //Datos del cliente
                Reader lectorClientes = new Reader("clientes.dat");

                //Primera línea y  pasamos a la siguiente;
                String lineaCliente = lectorClientes.readLine();
                lineaCliente = lectorClientes.readLine();
                boolean salir = false;

                while(salir == false){

                    String c[] = lineaCliente.split("\\s+");

                    idCliente = Integer.parseInt(c[0]);
                    nombreEmpresa = c[1];

                    lineaCliente = lectorClientes.readLine();
                    

                    //Condición de salida
                    if (cliente == idCliente){
                        salir = true;
                    }
                }

                //Datos del vendedor
                Reader lectorRep = new Reader("repventas.dat");

                //Primera línea y  pasamos a la siguiente;
                String lineaRep = lectorRep.readLine();
                lineaRep = lectorRep.readLine();
                boolean exit = false;

                while(exit == false){

                    String c[] = lineaRep.split("\\s+");
                    
                    idVendedor = Integer.parseInt(c[0]);
                    nombreVendedor = c[1];


                    lineaRep = lectorRep.readLine();

                    //Condición de salida
                    if (vendedor == idVendedor){
                        exit = true;
                    }
                }

                escritor.println(campos[0] + "\t" + campos[7]+ "€" + "\t" + nombreEmpresa + "\t" + nombreVendedor);
            }


            linea = lector.readLine();

        }

        escritor.close();
    }
    
    //39. Número de comanda, import, empresa, nom del venedor i ciutat de l’oficina del venedor de les comandes amb import superior a un cert valor 
    //(per exemple 25.000 €).
    public void m39(){

        Reader lector = new Reader("pedidos.dat");
        Writer escritor = new Writer("output39.dat");
        int idCliente;
        int vendedor;
        int idVendedor;
        int oficina = 0;
        int idOficina;
        int cliente;
        int importe;
        int valor = 25000;
        String nombreEmpresa = "";
        String nombreVendedor = "";
        String ciudad = "";


        //Leemos la primera línea
        String linea = lector.readLine();
        escritor.println("Nº PEDIDO" + "\t" + "IMPORTE" + "\t" +  "EMPRESA" + "\t" + "VENDEDOR" + "\t" + "CIUDAD DE LA OFICINA");
        //Pasamos a la siguiente
        linea = lector.readLine();

        while(linea != null){

            String campos [] = linea.split("\\s+");

            cliente = Integer.parseInt(campos[2]);
            vendedor = Integer.parseInt(campos[3]);
            importe = Integer.parseInt(campos[7]);

            if (importe > valor){

                //Datos del cliente
                Reader lectorClientes = new Reader("clientes.dat");

                //Primera línea y  pasamos a la siguiente;
                String lineaCliente = lectorClientes.readLine();
                lineaCliente = lectorClientes.readLine();
                boolean salir = false;

                while(salir == false){

                    String c[] = lineaCliente.split("\\s+");

                    idCliente = Integer.parseInt(c[0]);
                    nombreEmpresa = c[1];

                    lineaCliente = lectorClientes.readLine();
                    

                    //Condición de salida
                    if (cliente == idCliente){
                        salir = true;
                    }
                }

                //Datos del vendedor
                Reader lectorRep = new Reader("repventas.dat");

                //Primera línea y  pasamos a la siguiente;
                String lineaRep = lectorRep.readLine();
                lineaRep = lectorRep.readLine();
                boolean exit = false;

                while(exit == false){

                    String c[] = lineaRep.split("\\s+");
                    
                    idVendedor = Integer.parseInt(c[0]);
                    nombreVendedor = c[1];


                    if (!c[4].equals("\\N")){

                        oficina = Integer.parseInt(c[4]);

                        //Datos de la oficina
                        Reader lectorOficinas = new Reader("oficinas.dat");

                        //Primera línea y  pasamos a la siguiente;
                        String lineaOficina = lectorOficinas.readLine();
                        lineaOficina = lectorOficinas.readLine();
                        boolean salirOficina = false;


                        while(salirOficina == false){

                            String fields[] = lineaOficina.split("\\s+");
                            
                            idOficina = Integer.parseInt(fields[0]);

                            ciudad = fields[1];

                            lineaOficina = lectorOficinas.readLine();

                            //Condición de salida
                            if (idOficina == oficina){
                                salirOficina = true;
                            }
                        }

                    } else {

                        ciudad = "So oficina";
                    }


                    lineaRep = lectorRep.readLine();

                    //Condición de salida
                    if (vendedor == idVendedor){
                        exit = true;
                    }
                }

                escritor.println(campos[0] + "\t" + campos[7]+ "€" + "\t" + nombreEmpresa + "\t" + nombreVendedor + "\t" + ciudad);
            }


            linea = lector.readLine();

        }

        escritor.close();
    }
    
    //40. Número de comanda, import, data de la comanda i venedor de les comandes fetes els dies que algun venedor va ser contractat.
    public void m40(){

        Reader lector = new Reader("pedidos.dat");
        Writer escritor = new Writer("output40.dat");
        int vendedor;
        int idVendedor;
        int importe;
        String nombreVendedor = "";
        String fecha = "";
        String fContrato;


        //Leemos la primera línea
        String linea = lector.readLine();
        escritor.println("Nº PEDIDO" + "\t" + "IMPORTE" + "\t" +  "FECHA" + "\t" + "VENDEDOR");
        //Pasamos a la siguiente
        linea = lector.readLine();

        while(linea != null){

            String campos [] = linea.split("\\s+");

            vendedor = Integer.parseInt(campos[3]);
            importe = Integer.parseInt(campos[7]);
            fecha = campos[1];

            //Datos del vendedor
            Reader lectorRep = new Reader("repventas.dat");

            //Primera línea y  pasamos a la siguiente;
            String lineaRep = lectorRep.readLine();
            lineaRep = lectorRep.readLine();
            boolean exit = false;

            while(exit == false){

                String c[] = lineaRep.split("\\s+");
                
                idVendedor = Integer.parseInt(c[0]);
                nombreVendedor = c[1];

                lineaRep = lectorRep.readLine();

                //Condición de salida
                if (vendedor == idVendedor){
                    exit = true;
                }
            }

            //Otra vuelta para comparar fechas
            Reader lectorFecha = new Reader("repventas.dat");

            //Primera línea y  pasamos a la siguiente;
            String lineaFecha = lectorFecha.readLine();
            lineaFecha = lectorFecha.readLine();

            while(lineaFecha != null){

                String fields[] = lineaFecha.split("\\s+");
                
                fContrato = fields[6];

                lineaFecha = lectorFecha.readLine();

                if (fContrato.equals(fecha)){
                    lineaFecha = null;
                    escritor.println(campos[0] + "\t" + campos[7]+ "€" + "\t" + fecha + "\t" + nombreVendedor);
                }
                
            }

            linea = lector.readLine();

        }

        escritor.close();
    }
    
}