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
        
    }
    
    //34. Nom dels venedors, ciutat i oficines on treballen.
    public void m34(){

    }
    
    //35. Ciutats, nombres dels directors i càrrecs de totes les oficines.
    public void m35(){

    }
    
    //36. Ciutats, nombres dels directors i càrrecs de les oficines amb objectius superiors a un cert valor (per exemple 600.000 €).
    public void m36(){

    }
    
    //37. Número de comanda, import i descripció.
    public void m37(){

    }
    
    //38. Número de comanda, import, empresa, nom del venedor de les comandes amb import superior a un cert valor (per exemple 25.000 €).
    public void m38(){

    }
    
    //39. Número de comanda, import, empresa, nom del venedor i ciutat de l’oficina del venedor de les comandes amb import superior a un cert valor 
    //(per exemple 25.000 €).
    public void m39(){

    }
    
    //40. Número de comanda, import, data de la comanda i venedor de les comandes fetes els dies que algun venedor va ser contractat.
    public void m40(){

    }
    
}