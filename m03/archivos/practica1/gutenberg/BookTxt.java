import java.io.File;
import java.util.StringTokenizer;

public class BookTxt{

    private String filePath;



    public BookTxt(String fp){
        this.filePath = fp;
    }

    public void showFile(){

        Reader fr = new Reader(this.filePath);
        String lf = fr.readLine();

        while (lf != null) {

                System.out.println(lf);
            
            
            lf = fr.readLine();

        }

        fr.close();
    }

    public int countLines(){

        Reader fr = new Reader(this.filePath);

        String lf = fr.readLine();
        int sum = 1;

        while (lf != null){
            lf = fr.readLine();
            sum++;
        }

        fr.close();

        return sum;

    }


    public int countWords(){

        Reader fr = new Reader(this.filePath);

        String lf = fr.readLine();
        int suma = 0;

        while (lf != null){

            StringTokenizer st = new StringTokenizer(lf);

            suma = suma + st.countTokens();
            
            lf = fr.readLine();
        }

        fr.close();

        return suma;

    }

    public int countChars(){

        Reader fr = new Reader(this.filePath);

        String lf = fr.readLine();
        int suma = 0;

        while (lf != null){

            if (!lf.isEmpty()){//No se tienen en cuenta las líneas vacías

                lf = lf.replace(" ", "");//Para no tener en cuenta los espacios como caracteres

                suma = suma + lf.split("").length;
            }

            
            lf = fr.readLine();
        }

        fr.close();

        return suma;

    }


    public void copy(String outPut){

        File f = new File(outPut);
        System.out.println(f.getAbsolutePath());

    }


    public int countAWord(String sTextoBuscado){

        Reader fr = new Reader(this.filePath);
        String lf = fr.readLine();
        int contador = 0;

        while (lf != null) {

            //Se dintinguen entre mayúsculas y minúsculas
            while (lf.indexOf(sTextoBuscado) > -1) {

                lf = lf.substring(lf.indexOf(sTextoBuscado)+sTextoBuscado.length(),lf.length());
                contador++; 
            }
            
            
            lf = fr.readLine();

        }

        fr.close();


        return contador;
    
    }


    public int countAChar(char c){


        Reader fr = new Reader(this.filePath);
        String lf = fr.readLine();
        int posicion, contador = 0;

        while (lf != null) {

            //se busca la primera vez que aparece
            posicion = lf.indexOf(c);

            while (posicion != -1) { //mientras se encuentre el caracter
                contador++;           //se cuenta
                //se sigue buscando a partir de la posición siguiente a la encontrada
                posicion = lf.indexOf(c, posicion + 1);
            }
            
            
            lf = fr.readLine();

        }

        fr.close();

        return contador;
    }


    public String getTitle(){
     
        Reader fr = new Reader(this.filePath);
        String title ="";

        String lf = fr.readLine();
        int contador = 1;

        while (lf != null){

            lf = fr.readLine();
            
            contador++;

            if (contador == 9){
                
                String cadena = lf;
                String[] parts = cadena.split("Title: ");
                title = parts[1];

            }
        }

        fr.close();

        return title;

    }

    public String getAuthor(){
     
        Reader fr = new Reader(this.filePath);
        String autor ="";

        String lf = fr.readLine();
        int contador = 1;

        while (lf != null){
            lf = fr.readLine();
            contador++;

            if (contador == 11){
                
                String cadena = lf;
                String[] parts = cadena.split("Author: ");
                autor = parts[1];
                
            }
        }

        fr.close();

        return autor;

    }

    public int countLinesBook(){

        //Usaremos estas variables para saber dónde comienza el contenido del libro
        String titulo = this.getTitle();
        String inicio_contenido = "*** START OF THIS PROJECT GUTENBERG EBOOK "  + titulo +  " ***";
        boolean empezado = false; //determinamos si ya ha empezado el contenido del libro

        Reader fr = new Reader(this.filePath);
        String lf = fr.readLine();

        int suma = 0;

        while (lf != null) {

            if (lf.equals(inicio_contenido)){
                empezado = true;
            }

            if (empezado && !(lf.equals(inicio_contenido))){
                suma++;
            }
            
            lf = fr.readLine();

            
        }

        fr.close();

        return suma;
    }
}