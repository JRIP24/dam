/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examstreams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author ronald
 */
public class Exercici2 {
    
    
     //30. Guardar les naus amb RandomAccesFile
	static void menu30() throws IOException {
        LocalDateTime today;
        ArrayList<Naus_Dades> arrayListDeNaus = new ArrayList<Naus_Dades>();
        File fitxer = new File("Naus_Dades.dat");
        File fitxerIndexs = new File("Naus_Dades_Index.dat");
        RandomAccessFile fitxerEmmagatzematge = null;
        int longString;
        StringBuffer stringBuffer = null;
        
        ArrayList<Long> pos = new ArrayList<Long>();
       
        
        today = LocalDateTime.now();

        // Per a passar de String --> char[]: es fa servir .toCharArray() sobre el string.
        arrayListDeNaus.add(new Naus_Dades("Agamemnon", "destructor", "Omega".toCharArray(), today, "Enviat a la flota de Babylon 5"));
        arrayListDeNaus.add(new Naus_Dades("Achilles", "destructor", "Omega".toCharArray(), today, "Enviat a la flota de Babylon 5"));
        arrayListDeNaus.add(new Naus_Dades("Cortez", "explorador", "Explorer".toCharArray(), today, "Enviat a l'espai profund"));
        arrayListDeNaus.add(new Naus_Dades("Orion", "destructor", "Omega".toCharArray(), today, "Enviat a la flota de Mart"));
        arrayListDeNaus.add(new Naus_Dades("Nimrod", "destructor", "Omega".toCharArray(), today, "Enviat a la flota de Mart"));
        
		try {
			fitxerEmmagatzematge = new RandomAccessFile(fitxer, "rw");
			
			// RandomAccessFile no sap escriure i llegir objectes, ni String, ni LocalDateTime,...
	        for(Naus_Dades nauTmp : arrayListDeNaus){
	            // Gravem el nom (String nom).
	            longString = nauTmp.getNom().length();
	            fitxerEmmagatzematge.writeInt(longString);
	            fitxerEmmagatzematge.writeChars(nauTmp.getNom());
	            System.out.println("longString = " + longString + ", nauTmp.getNom() = " + nauTmp.getNom());
	            System.out.println();
	            
	            // Gravem el tipus (String tipus).
	            longString = nauTmp.getTipus().length();
	            fitxerEmmagatzematge.writeInt(longString);
	            fitxerEmmagatzematge.writeChars(nauTmp.getTipus());                
	            System.out.println("longString = " + longString + ", nauTmp.getTipus() = " + nauTmp.getTipus());
	            System.out.println();
	            
	            // Gravem el model (char model[50]).
	            // Per a passar de char[] --> String: String.valueOf(X) on X és de tipus char[].
	            stringBuffer = new StringBuffer(String.valueOf(nauTmp.getModel()));
	            stringBuffer.setLength(50);
	            fitxerEmmagatzematge.writeChars(stringBuffer.toString());
	            System.out.println("stringBuffer.length() = " + stringBuffer.length() + ", StringBuffer(String.valueOf(nauTmp.getModel())) = " + stringBuffer);
	            System.out.println();
	            
	            // Gravem la dataConstruccio (LocalDateTime dataConstruccio).
	            // ALERTA: la LocalDateTime ocupa 23 caràcters en Java 8 i 26 en Java 11.
	            // Potser la millor solució per a gravar el contingut d'una LocalDateTime sería calcular la quantitat de caràcters que
	            // té (dataAGravar.length()) i gravar el número en el fitxer (amb writeInt()) i després gravar el valor de la LocalDateTime.
	            //System.out.println(nauTmp.getDataConstruccio().toString());
                    //fitxerEmmagatzematge.writeInt(String.valueOf(nauTmp.getDataConstruccio().toString().length()));
	            fitxerEmmagatzematge.writeChars(String.valueOf(nauTmp.getDataConstruccio().toString()));
	            System.out.println("nauTmp.getDataConstruccio() = " + nauTmp.getDataConstruccio());
	            System.out.println("String.valueOf(nauTmp.getDataConstruccio().toString().length) = " + String.valueOf(nauTmp.getDataConstruccio().toString().length()));
	            System.out.println("String.valueOf(nauTmp.getDataConstruccio().toString()) = " + String.valueOf(nauTmp.getDataConstruccio().toString()));
	            System.out.println();
	            
	            // Gravem la descripció (String descripcio).
	            longString = nauTmp.getDescripcio().length();
	            fitxerEmmagatzematge.writeInt(longString);
	            fitxerEmmagatzematge.writeChars(nauTmp.getDescripcio()); 
	            System.out.println("longString = " + longString + ", nauTmp.getNom() = " + nauTmp.getDescripcio());
	            System.out.println();
	            
	            System.out.println("Gravada la nau " + nauTmp.getNom());
	            System.out.println("----------------");
	        }
	        
	        System.out.println();
	        System.out.println("S'han gravat totes les naus amb èxit.");
                
                
                
                
                
                
		} finally {
			fitxerEmmagatzematge.close();
			System.out.println("Fitxer tancat amb èxit.");
		}
                
                
                //Lectura
                
                
                String stringTmp;


                fitxerEmmagatzematge = new RandomAccessFile(fitxer, "r");

                long posicion = fitxerEmmagatzematge.getFilePointer();

                while (posicion != fitxerEmmagatzematge.length()) {
                        
                            
                        pos.add(posicion);
                        
                        System.out.println("----------------");

                    // LLegim el nom (String nom).
                        stringTmp = "";
                    longString = fitxerEmmagatzematge.readInt();
                    System.out.println("Nom.length(): " + longString);
                    for(int i = 0; i< longString; i++) {
                        //System.out.println("Nom: " + fitxerEmmagatzematge.readChar());
                        stringTmp = stringTmp + fitxerEmmagatzematge.readChar();
                    }
                    System.out.println("Nom: " + stringTmp);

                    // LLegim el tipus (String tipus).
                    stringTmp = "";
                    longString = fitxerEmmagatzematge.readInt();
                    System.out.println("tipus.length(): " + longString);
                    for(int i = 0; i< longString; i++) {
                        //System.out.println("Tipus: " + fitxerEmmagatzematge.readChar());
                        stringTmp = stringTmp + fitxerEmmagatzematge.readChar();
                    }
                    System.out.println("Tipus: " + stringTmp);

                    // LLegim el model (char model[50]).    
                    stringTmp = "";
                    for(int i = 0; i< 50; i++) {
                        //System.out.println("Model: " + fitxerEmmagatzematge.readChar());
                        stringTmp = stringTmp + fitxerEmmagatzematge.readChar();
                    }
                    System.out.println("Model: " + stringTmp);

                    // LLegim la dataConstruccio (LocalDateTime dataConstruccio).
                    // ALERTA: la LocalDateTime ocupa 23 caràcters en Java 8 i 26 en Java 11.
                    // Potser la millor solució per a gravar el contingut d'una LocalDateTime sería calcular la quantitat de caràcters que
                    // té (dataAGravar.length()) i gravar el número en el fitxer (amb writeInt()) i després gravar el valor de la LocalDateTime.
                    stringTmp = "";
                    for(int i = 0; i< 23; i++) {		// Si s'executés amb Java 8 hauriem de posar 23 en comptes de 26.
                        //System.out.println("Data construcció: " + fitxerEmmagatzematge.readChar());
                        stringTmp = stringTmp + fitxerEmmagatzematge.readChar();
                    }
                    System.out.println("Data construcció: " + Data.imprimirData(LocalDateTime.parse(stringTmp)));

                    // LLegim la descripció (String descripcio).
                    stringTmp = "";
                    longString = fitxerEmmagatzematge.readInt();
                    System.out.println("descripcio.length(): " + longString);
                    for(int i = 0; i< longString; i++) {
                        //System.out.println("Descripció: " + fitxerEmmagatzematge.readChar());
                        stringTmp = stringTmp + fitxerEmmagatzematge.readChar();
                    }
                    System.out.println("Descripció: " + stringTmp);
                    
                    posicion = fitxerEmmagatzematge.getFilePointer();
                }

                        fitxerEmmagatzematge.close();

                        System.out.println();
                System.out.println("Fitxer llegit i tancat amb èxit.");
                
                FileUtils.writeLines(fitxerIndexs, "UTF-8", pos, null, false);
                
                //Apartat2.4
                
                RandomAccessFile archivoIndices = new RandomAccessFile(fitxerIndexs, "rw");
                
                llegirUnaNau(fitxerEmmagatzematge, archivoIndices);
                
                
	}
        
        
    static void llegirUnaNau(RandomAccessFile fitxerEmmagatzematge, RandomAccessFile fitxerIndexs){
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("\n-------------Recuperamos una de las 5 naves---------\n");
        System.out.print("Introduce una de las naves (1-5)");
        int opcion = teclado.nextInt();
        String line;
        int contador = 0;
        String stringTmp;
        int longString;
        try{
            
            while ( (line = fitxerIndexs.readLine()) != null ) {
                //System.out.println(line);
                if (contador == opcion){
                    
                    System.out.println("posComienzoNave (bytes): " + line);
                    int posicion = Integer.parseInt(line);
                    System.out.println(posicion);
                    fitxerEmmagatzematge.seek(posicion);
                    System.out.println("" + fitxerEmmagatzematge.readUTF());
                    
                        System.out.println("----------------");

                    // LLegim el nom (String nom).
                        stringTmp = "";
                    longString = fitxerEmmagatzematge.readInt();
                    System.out.println("Nom.length(): " + longString);
                    for(int i = 0; i< longString; i++) {
                        //System.out.println("Nom: " + fitxerEmmagatzematge.readChar());
                        stringTmp = stringTmp + fitxerEmmagatzematge.readChar();
                    }
                    System.out.println("Nom: " + stringTmp);

                    // LLegim el tipus (String tipus).
                    stringTmp = "";
                    longString = fitxerEmmagatzematge.readInt();
                    System.out.println("tipus.length(): " + longString);
                    for(int i = 0; i< longString; i++) {
                        //System.out.println("Tipus: " + fitxerEmmagatzematge.readChar());
                        stringTmp = stringTmp + fitxerEmmagatzematge.readChar();
                    }
                    System.out.println("Tipus: " + stringTmp);

                    // LLegim el model (char model[50]).    
                    stringTmp = "";
                    for(int i = 0; i< 50; i++) {
                        //System.out.println("Model: " + fitxerEmmagatzematge.readChar());
                        stringTmp = stringTmp + fitxerEmmagatzematge.readChar();
                    }
                    System.out.println("Model: " + stringTmp);

                    // LLegim la dataConstruccio (LocalDateTime dataConstruccio).
                    // ALERTA: la LocalDateTime ocupa 23 caràcters en Java 8 i 26 en Java 11.
                    // Potser la millor solució per a gravar el contingut d'una LocalDateTime sería calcular la quantitat de caràcters que
                    // té (dataAGravar.length()) i gravar el número en el fitxer (amb writeInt()) i després gravar el valor de la LocalDateTime.
                    stringTmp = "";
                    for(int i = 0; i< 23; i++) {		// Si s'executés amb Java 8 hauriem de posar 23 en comptes de 26.
                        //System.out.println("Data construcció: " + fitxerEmmagatzematge.readChar());
                        stringTmp = stringTmp + fitxerEmmagatzematge.readChar();
                    }
                    System.out.println("Data construcció: " + Data.imprimirData(LocalDateTime.parse(stringTmp)));

                    // LLegim la descripció (String descripcio).
                    stringTmp = "";
                    longString = fitxerEmmagatzematge.readInt();
                    System.out.println("descripcio.length(): " + longString);
                    for(int i = 0; i< longString; i++) {
                        //System.out.println("Descripció: " + fitxerEmmagatzematge.readChar());
                        stringTmp = stringTmp + fitxerEmmagatzematge.readChar();
                    }
                    System.out.println("Descripció: " + stringTmp);
                    
                    //posicion = fitxerEmmagatzematge.getFilePointer();
                    
                 break;   
                }
                
                contador++;
            }
        
            
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
        
        
    
    
    
    public static void main(String[] args){
        
        boolean exitCreacioRandomAccesFile = false;
        
        try {
            menu30();
            exitCreacioRandomAccesFile = true;
            
        } catch (IOException e) {
            System.out.println("ERROR: hi ha hagut algun error al gravar i/o tancar el fitxer.");
            exitCreacioRandomAccesFile = false;
            e.printStackTrace();
        }
        
        
      
        
    }
    
    
}
