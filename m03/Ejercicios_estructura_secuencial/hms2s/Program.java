import java.util.Scanner;

public class Program{
    static int hms2s(int h, int min, int segs){

        int segs_h = h * 3600;
        int segs_min = min * 60;
        int segs_totales = segs_h + segs_min + segs;
        return segs_totales;


    }

    public static void main(String[] args){
        //Definimos la entrada de texto
        Scanner teclado = new Scanner(System.in);
        int horas;
        int minutos;
        int segundos;

        System.out.println("Indique la hora:");
        horas = teclado.nextInt();

        System.out.println("Indique los minutos:");
        minutos = teclado.nextInt();

        System.out.println("Indique los segundos:");
        segundos = teclado.nextInt();

        int segundos_equivalentes = hms2s(horas, minutos, segundos);
        System.out.println("En " + horas + "h, " + minutos + "m, y " + segundos + "s, hay un total de "+ segundos_equivalentes + " segundos");

    }
}