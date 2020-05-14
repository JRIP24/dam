public class Program {
    
    public static void main (String [] agrs){

        BookTxt libro = new BookTxt("archivo.txt");

        System.out.println(libro.getTitle());
        System.out.println(libro.getAuthor());
        libro.showFile();

        System.out.println("-----------------------------------");

        String palabra = "EBOOK";
        char caracter = 'z';
        System.out.println("Líneas del archivo: " + libro.countLines());
        System.out.println("Líneas del libro: " + libro.countLinesBook());
        System.out.println("Número de palabras: " + libro.countWords());
        System.err.println("Número de caracteres: " + libro.countChars());
        System.err.println("Veces que aparece la palabra " +  palabra + ": " +  libro.countAWord(palabra));
        System.err.println("Veces que aparece el caracter " +  caracter + ": " + libro.countAChar(caracter));
        libro.copy("copia.txt");
        
    }
}