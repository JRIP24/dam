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

        

    }
    
    //54. Quants venedors estan assignats a cada oficina?
    public void m54(){

    }
    
    //55. Quants clients diferents són atesos per cada venedor?
    public void m55(){

    }
    
    //56. Identificador de venedor, nom i total import de les comandes de cada venedor.
    public void m56(){

    }
    
    //57. Quin és l’import mitjà de les comandes ateses per cada venedor que superen un valor en vendes donat (per exemple 30.000 €).
    public void m57(){

    }
    
    //58. Ciutat on es troben les oficines on el seus objectius superen a la suma de les vendes actuals del seus venedors assignats.
    public void m58(){

    }
    
    //59. Nom dels venedors que han venut per un import superior a l’objectiu d'una oficina (per exemple la d'Atlanta).
    public void m59(){

    }
    
    //60. Nom de les empreses ateses per un venedor (per exemple Bill Adams)
    public void m60(){

    }
    
}