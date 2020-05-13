public class BookTxt{

    private String filePath;



    public BookTxt(String fp){
        this.filePath = fp;
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

    public void showFile(){

        Reader fr = new Reader(this.filePath);

        String lf = fr.readLine();
        // While there are lines left, print the line and read another line
        while (lf != null) {
            // Print the read line
            System.out.printf("%s\n", lf);
            // Read a line
            lf = fr.readLine();
        }
        // Close the file reader
        fr.close();
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
}