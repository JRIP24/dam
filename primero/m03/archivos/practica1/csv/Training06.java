public class Training06{

    //51. Quantes oficines tenen venedors tal que les seves vendes actuals superin les seves quotes.
    public void m51(){

        Reader lector = new Reader("oficinas.dat");
        Writer escritor = new Writer("output51.dat");
        int contador = 0;
        int oficina;
        int id;
        int ventas;
        int cuota;

        //Leemos la primera línea
        String linea = lector.readLine();
        //Pasamos a la siguiente
        linea = lector.readLine();

        //Extraemos el id del vendedor
        while(linea != null){

            String campos[] = linea.split("\\s+");

            id = Integer.parseInt(campos[0]);

            //Leemos repventas.dat
            Reader lectorRep = new Reader("repventas.dat");

            //Primera línea y  pasamos a la siguiente;
            String lineaRep = lectorRep.readLine();
            lineaRep = lectorRep.readLine();

            while(lineaRep != null){

                String c[] = lineaRep.split("\\s+");
                
                if (!c[4].equals("\\N") || !c[8].equals("\\N")){

                    oficina = Integer.parseInt(c[4]);
                    cuota = Integer.parseInt(c[8]);
                    ventas = Integer.parseInt(c[9]);

                    if (oficina == id){

                        if (ventas > cuota){
                            contador++;
                        }
                    }
                }
                

                lineaRep = lectorRep.readLine();
                
            }

            linea = lector.readLine();
        }

        escritor.println(contador);

        escritor.close();
    }

    //52. Import mitja de comandes per cada venedor.
    public void m52(){

        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output52.dat");
        int contador = 0;
        int suma = 0;
        int importe;
        int id;
        int idVendedor;
        int media;

        //Leemos la primera línea
        String linea = lector.readLine();
        //Pasamos a la siguiente
        linea = lector.readLine();

        escritor.println("IMPORTE MEDIO DE LOS PEDIDOS DE CADA VENDEDOR: ");

        //Extraemos el id del vendedor
        while(linea != null){

            String campos[] = linea.split("\\s+");

            id = Integer.parseInt(campos[0]);
            suma = 0;
            contador = 0;

            //Buscamos los importes
            Reader lectorPedidos = new Reader("pedidos.dat");

            //Primera línea y  pasamos a la siguiente;
            String lineaPedidos = lectorPedidos.readLine();
            lineaPedidos = lectorPedidos.readLine();

            while(lineaPedidos != null){

                String c[] = lineaPedidos.split("\\s+");
                
                idVendedor = Integer.parseInt(c[3]);
                importe = Integer.parseInt(c[7]);

                if (idVendedor == id){
                    suma = suma + importe;
                    contador++;
                }

                lineaPedidos = lectorPedidos.readLine();
            }


            if (contador == 0){
                media = 0;
            } else {
                media = suma/contador;
            }

            escritor.println(id + "\t" + media + "€");
            
            linea = lector.readLine();
        }


        escritor.close();
    }
    
    //53. Rang de quotes (min, max) de cada oficines.
    public void m53(){

        Reader lector = new Reader("oficinas.dat");
        Writer escritor = new Writer("output53.dat");
        int max;
        int min;
        int cuota;

        //Leemos la primera línea
        String linea = lector.readLine();
        //Pasamos a la siguiente
        linea = lector.readLine();

        //Asignamos el mayor y el menor
        String fields[] = linea.split("\\s+");
    
        max = Integer.parseInt(fields[4]);
        min = Integer.parseInt(fields[4]);

        while(linea != null){

            String campos[] = linea.split("\\s+");

            cuota = Integer.parseInt(campos[4]);

            if (cuota > max){
                max = cuota;
            } else if (cuota < min){
                min = cuota;
            }
            

            linea = lector.readLine();
        }

        escritor.println("RANGO DE CUOTAS DE LAS OFICINAS: " + min + "€ - " + max + "€");
        

        escritor.close();

    }
    
    //54. Quants venedors estan assignats a cada oficina?
    public void m54(){

        Reader lector = new Reader("oficinas.dat");
        Writer escritor = new Writer("output54.dat");
        int contador = 0;
        int id;
        int oficina;

        //Leemos la primera línea
        String linea = lector.readLine();
        //Pasamos a la siguiente
        linea = lector.readLine();

        while(linea != null){

            String campos[] = linea.split("\\s+");

            contador = 0;
            id = Integer.parseInt(campos[0]);

            //Leemos repventas.dat
            Reader lectorRep = new Reader("repventas.dat");

            //Primera línea y  pasamos a la siguiente;
            String lineaRep = lectorRep.readLine();
            lineaRep = lectorRep.readLine();

            while(lineaRep != null){

                String c[] = lineaRep.split("\\s+");
                
                if (!c[4].equals("\\N")){

                    oficina = Integer.parseInt(c[4]);

                    if (oficina == id){
                        contador++;
                    }

                }    

                lineaRep = lectorRep.readLine();
                
            }

            //Podemos sumar 1 en todos los casos para incluir al director de la oficina
            escritor.println("Nº de vendedores de la oficina " + id + ": " + contador);
            

            linea = lector.readLine();
        }


        escritor.close();
    }
    
    //55. Quants clients diferents són atesos per cada venedor?
    public void m55(){

        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output55.dat");
        int contador = 0;
        int id;
        int idVendedor;

        //Leemos la primera línea
        String linea = lector.readLine();
        //Pasamos a la siguiente
        linea = lector.readLine();

        //Extraemos el id del vendedor
        while(linea != null){

            String campos[] = linea.split("\\s+");

            contador = 0;
            id = Integer.parseInt(campos[0]);

            //Recorremos clientes.dat
            Reader lectorClientes = new Reader("clientes.dat");

            //Primera línea y  pasamos a la siguiente;
            String lineaCliente = lectorClientes.readLine();
            lineaCliente = lectorClientes.readLine();
            boolean salir = false;

            while(lineaCliente != null){

                String c[] = lineaCliente.split("\\s+");

                idVendedor = Integer.parseInt(c[2]);

                if (idVendedor == id){
                    contador++;
                }

                lineaCliente = lectorClientes.readLine();
            }

            escritor.println(id + ": " + contador);
            
            linea = lector.readLine();
        }


        escritor.close();
    }
    
    //56. Identificador de venedor, nom i total import de les comandes de cada venedor.
    public void m56(){

        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output56.dat");
        int suma = 0;
        int importe;
        int id;
        int idVendedor;
        String nombre;

        //Leemos la primera línea
        String linea = lector.readLine();
        //Pasamos a la siguiente
        linea = lector.readLine();

        escritor.println("ID" + "\t" + "NOMBRE" + "\t" + "IMPORTE TOTAL DE VENTAS");

        //Extraemos el id del vendedor
        while(linea != null){

            String campos[] = linea.split("\\s+");

            id = Integer.parseInt(campos[0]);
            nombre = campos[1];
            suma = 0;

            //Buscamos los importes
            Reader lectorPedidos = new Reader("pedidos.dat");

            //Primera línea y  pasamos a la siguiente;
            String lineaPedidos = lectorPedidos.readLine();
            lineaPedidos = lectorPedidos.readLine();

            while(lineaPedidos != null){

                String c[] = lineaPedidos.split("\\s+");
                
                idVendedor = Integer.parseInt(c[3]);
                importe = Integer.parseInt(c[7]);

                if (idVendedor == id){
                    suma = suma + importe;
                }

                lineaPedidos = lectorPedidos.readLine();
            }

            escritor.println(id + "\t" + nombre +  "\t" + suma + "€");
            
            linea = lector.readLine();
        }


        escritor.close();
    }
    
    //57. Quin és l’import mitjà de les comandes ateses per cada venedor que superen un valor en vendes donat (per exemple 30.000 €).
    public void m57(){

        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output57.dat");
        int contador = 0;
        int suma = 0;
        int importe;
        int id;
        int idVendedor;
        int media;
        int valor = 30000;

        //Leemos la primera línea
        String linea = lector.readLine();
        //Pasamos a la siguiente
        linea = lector.readLine();

        //Extraemos el id del vendedor
        while(linea != null){

            String campos[] = linea.split("\\s+");

            id = Integer.parseInt(campos[0]);
            suma = 0;
            contador = 0;

            //Buscamos los importes
            Reader lectorPedidos = new Reader("pedidos.dat");

            //Primera línea y  pasamos a la siguiente;
            String lineaPedidos = lectorPedidos.readLine();
            lineaPedidos = lectorPedidos.readLine();

            while(lineaPedidos != null){

                String c[] = lineaPedidos.split("\\s+");
                
                idVendedor = Integer.parseInt(c[3]);
                importe = Integer.parseInt(c[7]);

                if (idVendedor == id){
                    suma = suma + importe;
                    contador++;
                }

                lineaPedidos = lectorPedidos.readLine();
            }


            if (contador == 0){
                media = 0;
            } else {
                media = suma/contador;
            }

            if (media > valor){
                escritor.println(id + "\t" + media + "€");

            }

            
            linea = lector.readLine();
        }


        escritor.close();
    }
    
    //58. Ciutat on es troben les oficines on el seus objectius superen a la suma de les vendes actuals del seus venedors assignats.
    public void m58(){

        //Se puede simplemente comparar objetivos con ventas de la oficina
        //Con esta forma calculamos las ventas nosotros
        Reader lector = new Reader("oficinas.dat");
        Writer escritor = new Writer("output58.dat");
        int oficina;
        int id;
        int suma = 0;
        int ventas;
        String ciudad;
        int objectivo;

        //Leemos la primera línea
        String linea = lector.readLine();
        escritor.println("CIUDAD" + "\t" + "OBJETIVO" + "\t" + "VENTAS DE EMPLEADOS");
        //Pasamos a la siguiente
        linea = lector.readLine();

        //Extraemos el id del vendedor
        while(linea != null){

            String campos[] = linea.split("\\s+");

            id = Integer.parseInt(campos[0]);
            objectivo = Integer.parseInt(campos[4]);
            ciudad = campos[1];
            suma = 0;

            //Leemos repventas.dat
            Reader lectorRep = new Reader("repventas.dat");

            //Primera línea y  pasamos a la siguiente;
            String lineaRep = lectorRep.readLine();
            lineaRep = lectorRep.readLine();

            while(lineaRep != null){

                String c[] = lineaRep.split("\\s+");
                
                if (!c[4].equals("\\N") || !c[8].equals("\\N")){

                    oficina = Integer.parseInt(c[4]);
                    ventas = Integer.parseInt(c[9]);

                    if (oficina == id){

                        suma = suma + ventas;
                    }
                }

                lineaRep = lectorRep.readLine();
            }

            if (objectivo > suma){

                escritor.println(ciudad + "\t" + objectivo + "\t" + suma);
            }

            linea = lector.readLine();
        }


        escritor.close();

    }
    
    //59. Nom dels venedors que han venut per un import superior a l’objectiu d'una oficina (per exemple la d'Atlanta).
    public void m59(){

        Reader lector = new Reader("oficinas.dat");
        Writer escritor = new Writer("output59.dat");
        int objectivo = 0;
        int ventas;
        String ciudad = "Atlanta";
        String nombre;

        //Leemos la primera línea
        String linea = lector.readLine();
        escritor.println("NOMBRE" + "\t" + "VENTAS" + "\t" + "OBJETIVO DE OFICINA EN " + ciudad);
        //Pasamos a la siguiente
        linea = lector.readLine();

        //Extraemos el objetivo de la ciudad
        while(linea != null){

            String campos[] = linea.split("\\s+");

            objectivo = Integer.parseInt(campos[4]);

            linea = lector.readLine();

            //Condición de salida
            if (campos[1].equals(ciudad)){
                linea = null;
            }

        }

        //Leemos repventas.dat
        Reader lectorRep = new Reader("repventas.dat");

        //Primera línea y  pasamos a la siguiente;
        String lineaRep = lectorRep.readLine();
        lineaRep = lectorRep.readLine();

        while(lineaRep != null){

            String c[] = lineaRep.split("\\s+");

            ventas = Integer.parseInt(c[9]);
            nombre = c[1];

            if (ventas > objectivo){

                escritor.println(nombre + "\t" + ventas + "\t" + objectivo);
            }

            lineaRep = lectorRep.readLine();
        }    


        escritor.close();
    }
    
    //60. Nom de les empreses ateses per un venedor (per exemple Bill Adams)
    public void m60(){

        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output60.dat");
        String nombreEmpresa;
        int idVendedor;
        int id = 0;
        String nombreVendedor = "Bill Adams";

        //Leemos la primera línea
        String linea = lector.readLine();
        escritor.println("EMPRESAS ANTENDIDAS POR " + nombreVendedor + ": ");
        //Pasamos a la siguiente
        linea = lector.readLine();

        //El id del vendedor
        while(linea != null){

            String campos[] = linea.split("\\s+");

            id = Integer.parseInt(campos[0]);

            linea = lector.readLine();

            //Condición de salida
            if (nombreVendedor.equals(campos[1] + " " + campos[2])){
                linea = null;
            }

        }

        //Recorremos clientes.dat
        Reader lectorClientes = new Reader("clientes.dat");

        //Primera línea y  pasamos a la siguiente;
        String lineaCliente = lectorClientes.readLine();
        lineaCliente = lectorClientes.readLine();
        boolean salir = false;

        while(lineaCliente != null){

            String c[] = lineaCliente.split("\\s+");

            idVendedor = Integer.parseInt(c[2]);
            nombreEmpresa = c[1];

            if (idVendedor == id){
                escritor.println(nombreEmpresa);
            }

            lineaCliente = lectorClientes.readLine();
        }

        escritor.close();
    }
    
}