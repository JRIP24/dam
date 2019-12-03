public class Program{


    public static void writeASCII(){

        for (int i = 0; i <= 127; i++){

            System.out.println("Carácter ASCII " + i + " = " + (char)i);

        }
    }

    public static void main(String[] args){

        writeASCII();

    }
}