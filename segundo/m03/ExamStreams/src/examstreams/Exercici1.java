/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examstreams;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

/**
 *
 * @author ronald
 */
public class Exercici1 {
    
    
    static void escribir2Lineas(File archivo) throws IOException{
            
        
        //FileUtils.writeLines(archivo, "UTF-8", totsNomsFitxers, null, true);
        ArrayList<String> lineas = new ArrayList<String>();
        
        lineas.add("Linea 1");
        lineas.add("Linea 2");
        
        FileUtils.writeLines(archivo, "UTF-8", lineas, null, true);
        
    }
    
    public static void main(String[] args){
        
    File origen = null;
    String pathOrigen = "fitxers_examen_2019_2020"; 
    String path = null;
    File directoriArrel = null;

    try {
        File patata = new File("patata");

        origen = new File(pathOrigen);

    if (FileUtils.directoryContains(origen, patata)) {

            System.out.println("Se ha encontrado el directorio" + patata.getName());

    } else { //Creamos el directorio
        
        FileUtils.forceMkdir(patata);
        
        File index = new File(patata.getPath() + "/" + "index.txt");
        index.createNewFile();
        
        if (index.exists()){
            
            System.out.println("El archivo " + index.getName() + " está dentro de " + patata.getName());
            try{
                escribir2Lineas(index);                
                        
            } catch (Exception e) {

                   e.getMessage();
            
            }
                    
                    
        }
        
        //5. Copia el contingut del directori dirACopiar dins del directori patata (FileUtils).
        File source = new File("fitxers_examen_2019_2020/dirACopiar");
        try {
            FileUtils.copyDirectory(source, patata);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        //6. Copia el fitxer index.txt en el directori fitxers_examen_2019_2020 (FileUtils).
        File sourceOrigen = new File(pathOrigen);
        try {
            FileUtils.copyFileToDirectory(index, sourceOrigen);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        //7. Rastreja tots els directoris i fitxers que hi ha dins del directori patata (FileUtils).
        ArrayList<File> listaArchivos = new ArrayList<File>();
        /*final IOFileFilter dirFilter = FileFilterUtils.asFileFilter(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });*/
         
        System.out.println(listaArchivos.size());
        
        try{
            
            listaArchivos = (ArrayList<File>)FileUtils.listFilesAndDirs(patata, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
        
            System.out.println(listaArchivos.size());

            for(File archivo : listaArchivos){

                System.out.println(archivo.getName());

            }
            
        }  catch (Exception e) {

            e.getMessage();

           }
        
        /*
        8. Per cada directori i fitxer trobat, comproba els seus permisos de lectura, escriptura i execució, si
        és ocult i el seu tamany.
        */
        
        //10. Neteja el directori patata (esborra tot el seu contingut sense destruir el directori) (FileUtils).
        
        FileUtils.cleanDirectory(patata); 
        
        //12. Comprova que el contingut dels 2 fitxers index.txt és el mateix (FileUtils).
        File index2 = new File("fitxers_examen_2019_2020/index.txt");
        //boolean isTwoEqual = FileUtils.contentEquals(index, index2);
        
        if(FileUtils.contentEquals(index, index2)){
            
          System.out.println("Ej12- Son iguales");
            
        } else {
            System.out.println("Ej12- Son diferentes");
        }
        
        
        
    }


    } catch (Exception e) {

            e.getMessage();

    }
        
        
        
    }
    
    
  

}
