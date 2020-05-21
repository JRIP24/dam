import java.util.HashSet;

public class Training05{

    //41. Total de quotes i vendes actuals.
    public void m41(){

        //Se supondrá que se refiere a oficinas.dat
        Reader lector = new Reader("oficinas.dat");
        Writer escritor = new Writer("output41.dat");
        int sumaCuotas = 0;
        int sumaVentas = 0;
        int cuota;
        int ventas;

        //Leemos la primera línea
        String linea = lector.readLine();
        //Pasamos a la siguiente
        linea = lector.readLine();

        escritor.println("TOTAL DE CUOTAS" + "\t" + "TOTAL DE VENTAS");

        while(linea != null){

            String campos[] = linea.split("\\s+");

            cuota = Integer.parseInt(campos[4]);
            ventas = Integer.parseInt(campos[5]);

            sumaCuotas = sumaCuotas + cuota;
            sumaVentas = sumaVentas + ventas;

            linea = lector.readLine();
        }

        escritor.println(sumaCuotas + "\t" + sumaVentas);

        escritor.close();
    }

    //42. Import total de les comandes d'un venedor (per exemple Bill Adams).
    public void m42(){

        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output42.dat");
        int suma = 0;
        int importe;
        int ventas;
        int idVendedor;
        int id = 0;
        String vendedor = "Bill Adams";
        String nombre;
        String apellido;

        //Leemos la primera línea
        String linea = lector.readLine();
        //Pasamos a la siguiente
        linea = lector.readLine();

        escritor.println("IMPORTE TOTAL DE LOS PEDIDOS DE " + vendedor);

        //Extraemos el id del vendedor
        while(linea != null){

            String campos[] = linea.split("\\s+");

            id = Integer.parseInt(campos[0]);
            nombre = campos[1];
            apellido = campos[2];

            linea = lector.readLine();

            if (vendedor.equals(nombre + " " + apellido)){
                linea = null;
            }
        }

        //Sumamos los importes
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

        escritor.println(suma);


        escritor.close();
    }
    
    //43. Preu mitjà dels productes d'un cert fabricant(per exemple ACI).
    public void m43(){

        Reader lector = new Reader("productos.dat");
        Writer escritor = new Writer("output43.dat");
        int precio;
        int suma = 0;
        int contador = 0;
        int media;
        String fabricante = "aci";

        //Leemos la primera línea
        String linea = lector.readLine();
        //Pasamos a la siguiente
        linea = lector.readLine();

        escritor.println("PRECIO MEEDIO DE LOS PRODUCTOS DEL FABRICANTE" + "\t" + fabricante);

        while(linea != null){

            String campos[] = linea.split("\\s+");

            precio = Integer.parseInt(campos[3]);

            if (campos[0].equals(fabricante)){
                suma = suma + precio;
                contador++;
            }

            
            linea = lector.readLine();
        }

        media = suma/contador;

        escritor.println(media + "€");

        escritor.close();
    }
    
    //44. Import mitjà de les comandes d'una empresa (per exemple Acme Mfg).
    public void m44(){

        Reader lector = new Reader("clientes.dat");
        Writer escritor = new Writer("output44.dat");
        int suma = 0;
        int contador = 0;
        int media;
        int importe;
        int ventas;
        int idCliente;
        int id = 0;
        String cliente = "AcmeMfg.";
        String nombre;

        //Leemos la primera línea
        String linea = lector.readLine();
        //Pasamos a la siguiente
        linea = lector.readLine();

        escritor.println("IMPORTE MEDIO DE LOS PEDIDOS DE " + cliente);

        //Extraemos el id del vendedor
        while(linea != null){

            String campos[] = linea.split("\\s+");

            id = Integer.parseInt(campos[0]);
            nombre = campos[1];

            linea = lector.readLine();

            if (nombre.equals(cliente)){
                linea = null;
            }
        }

        //Sumamos los importes
        Reader lectorPedidos = new Reader("pedidos.dat");

        //Primera línea y  pasamos a la siguiente;
        String lineaPedidos = lectorPedidos.readLine();
        lineaPedidos = lectorPedidos.readLine();

        while(lineaPedidos != null){

            String c[] = lineaPedidos.split("\\s+");
            
            idCliente = Integer.parseInt(c[2]);
            importe = Integer.parseInt(c[7]);

            if (idCliente == id){
                suma = suma + importe;
                contador++;
            }

            lineaPedidos = lectorPedidos.readLine();
        }

        media = suma/contador;

        escritor.println(media + "€");


        escritor.close();
    }
    
    //45. Quotes màxima i mínima dels venedors.
    public void m45(){

        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output45.dat");
        int max;
        int min;
        int cuota;

        //Leemos la primera línea
        String linea = lector.readLine();
        //Pasamos a la siguiente
        linea = lector.readLine();

        //Asignamos el mayor y el menor
        String fields[] = linea.split("\\s+");
    
        max = Integer.parseInt(fields[8]);
        min = Integer.parseInt(fields[8]);

        escritor.println("TOTAL DE CUOTAS DE LOS VENDEDORES");

        while(linea != null){

            String campos[] = linea.split("\\s+");

            if(!campos[8].equals("\\N")){

                cuota = Integer.parseInt(campos[8]);

                if (cuota > max){
                    max = cuota;
                } else if (cuota < min){
                    min = cuota;
                }

            }

            linea = lector.readLine();
        }

        escritor.println("CUOTA MÁXIMA: " + max);
        escritor.println("CUOTA MÍNIMA: " + min);
        

        escritor.close();
    }
    
    //46. Millor rendiment de vendes de tots els venedors.
    public void m46(){

        //Se va a suponer que se refiere al importe de los pedidos de cada vendedor
        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output46.dat");
        int suma = 0;
        int importe = 0;
        int ventas;
        int idVendedor;
        int id = 0;

        //Leemos la primera línea
        String linea = lector.readLine();
        //Pasamos a la siguiente
        linea = lector.readLine();

        //Extraemos el id del vendedor
        while(linea != null){

            String campos[] = linea.split("\\s+");

            suma = 0;
            id = Integer.parseInt(campos[0]);

            //Recorremos pedidos.dat
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


            escritor.println(id + "\t" + suma + "€");


            linea = lector.readLine();
        }


        escritor.close();

    }
    
    //47. Quants clients té l’empresa de recanvis.
    public void m47(){

        //??
    }
    
    //48. Quants venedors tenen vendes actuals que superen la seva quota?
    public void m48(){
        
        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output48.dat");
        int contador = 0;
        int ventas;
        int cuota;

        //Leemos la primera línea
        String linea = lector.readLine();
        //Pasamos a la siguiente
        linea = lector.readLine();

        escritor.println("CANTIDAD DE VENDEDORES CON VENTAS MAYORES A SU CUOTA: ");

        //Extraemos el id del vendedor
        while(linea != null){

            String campos[] = linea.split("\\s+");

            if (!campos[8].equals("\\N")){

                cuota = Integer.parseInt(campos[8]);
                ventas = Integer.parseInt(campos[9]);

                if (ventas > cuota){
                    contador++;
                }

            }            
            
            linea = lector.readLine();
        }

        escritor.println(contador);

        escritor.close();
    }
    
    //49. Quantes comandes superen un cert valor (per exemple 25.000 €).
    public void m49(){

        Reader lector = new Reader("pedidos.dat");
        Writer escritor = new Writer("output49.dat");
        int contador = 0;
        int importe;
        int valor = 25000;

        //Leemos la primera línea
        String linea = lector.readLine();
        //Pasamos a la siguiente
        linea = lector.readLine();

        escritor.println("CANTIDAD DE PEDIDOS QUE SUPERAN LOS " + valor + "€");

        //Extraemos el id del vendedor
        while(linea != null){

            String campos[] = linea.split("\\s+");

            importe = Integer.parseInt(campos[7]);

            if (importe > valor){
                contador++;
            }            

            linea = lector.readLine();
        }

        escritor.println(contador);

        escritor.close();
    }
    
    //50. Quantes categories tenen els empleats de l’empresa? 
    public void m50(){

        Reader lector = new Reader("repventas.dat");
        Writer escritor = new Writer("output50.dat");
        int contador = 0;
        String categoria;
        HashSet <String> categorias = new HashSet<String>();

        //Leemos la primera línea
        String linea = lector.readLine();
        //Pasamos a la siguiente
        linea = lector.readLine();

        //Extraemos el id del vendedor
        while(linea != null){

            String campos[] = linea.split("\\s+");

            categoria = campos[5];

            categorias.add(categoria);
            
            linea = lector.readLine();
        }

        escritor.println(categorias.size());

        escritor.close();
    }
    
}