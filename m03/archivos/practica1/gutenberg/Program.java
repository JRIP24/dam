public class Program {
    
    public static void main (String [] agrs){

        BookTxt libro = new BookTxt("archivo.txt");

        System.out.println(libro.getTitle());
        System.out.println(libro.getAuthor());
        libro.showFile();

        System.out.println("-----------------------------------");
        System.out.println("Líneas del archivo: " + libro.countLines());
        System.out.println("Líneas del libro: " + libro.countLinesBook());
        System.out.println("Palabras: " + libro.countWords());
        System.err.println("Caracteres: " + libro.countChars());
        System.err.println("Veces que aparece una palabra: " + libro.countAWord("EBOOK"));
        System.err.println("Veces que aparece un caracter: " + libro.countAChar('z'));
        
    }
}