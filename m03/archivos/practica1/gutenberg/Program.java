public class Program {
    
    public static void main (String [] agrs){

        BookTxt libro = new BookTxt("archivo.txt");

        System.out.println(libro.getTitle());
        System.out.println(libro.getAuthor());
    }
}