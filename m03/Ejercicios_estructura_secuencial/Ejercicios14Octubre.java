import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Ejercicios14Octubre {

    /**
     * @param args the command line arguments
     */
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcion, numero, suma, contador;
        do {
            System.out.println("Elige opcion");
            System.out.println("1) numeros naturales.");
            System.out.println("2) Hola,Adios Alternativa.");
            System.out.println("3) contar y sumar multiplos de 3 hasta numero introducido.");
            System.out.println("4) tablas de multiplicar alternativa.");
            System.out.println("5) la media aritmetica (positivos y negativos).");
            System.out.println("6) adivinar numero.");
            System.out.println("7) dibujar triangulo.");
            System.out.println("0) SALIR.");
            opcion = in.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introduzca un numero");
                    numero = in.nextInt();
                    for (int i = 1; i <= numero; i++) {
                        System.out.print(i + ", ");
                    }
                    System.out.println("");
                    break;
                case 2:
                    for (int i = 1; i <= 10; i++) {
                        numero = (int) (Math.random() * 100);
                        if (numero % 2 == 0) {
                            System.out.println("Hola.");
                        } else if (numero % 2 != 0) {
                            System.out.println("Adios.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Introduzca un numero :");
                    numero = in.nextInt();
                    suma = 0;
                    contador = 0;
                    for (int i = 1; i <= numero; i++) {
                        if (i % 3 == 0) {
                            System.out.print(i + ", ");
                            suma = suma + i;
                            contador = contador + 1;
                        }
                    }
                    System.out.println("");
                    System.out.println("Hay " + contador + " multiplos de 3 ," + "y la suma total de ellos es " + suma);
                    break;
                case 4:
                    System.out.println("Introduzca el primer numero : ");
                    int numero1 = in.nextInt();
                    System.out.println("Introduzca el segundo numero : ");
                    int numero2 = in.nextInt();
                    for (int i = 1; i <= 10; i++) {
                        numero = (int) (Math.random() * 100);
                        if (numero % 2 == 0) {
                            System.out.println(numero1 + " * " + i + " = " + numero1 * i);
                        } else {
                            System.out.println(numero2 + " * " + i + " = " + numero2 * i);
                        }
                    }
                    break;
                case 5:
                    float sumaPositivos = 0;
                    float sumaNegativos = 0;
                    float contadorPositivos = 0;
                    float contadorNegativos = 0;
                    System.out.println("Introduzca un numero : ");
                    numero = in.nextInt();
                    while (numero != 0) {
                        if (numero > 0) {
                            sumaPositivos = sumaPositivos + numero;
                            contadorPositivos = contadorPositivos + 1;
                        } else if (numero < 0) {
                            sumaNegativos = sumaNegativos + numero;
                            contadorNegativos = contadorNegativos + 1;
                        }
                        numero = in.nextInt();
                    }
                    System.out.println("la media de los numeros positivos es " + sumaPositivos / contadorPositivos);
                    System.out.println("la media de los numeros negativos es " + sumaNegativos / contadorNegativos);

                    break;
                case 6:
                    int numeroAdivinado;
                    System.out.println("Introduzca un numero ");
                    numero = in.nextInt();
                    do {
                        System.out.println("Adivina el numero ");
                        numeroAdivinado = in.nextInt();
                        if (numeroAdivinado < numero) {
                            System.out.println("el numero adivinado es menor que el original");
                        } else if (numeroAdivinado > numero) {
                            System.out.println("el numero adivinado es mayor que el original.");
                        }
                    } while (numeroAdivinado != numero);
                    System.out.println("Numero acertado.");
                    break;
                case 7:
                    System.out.println("altura");
                    int altura = in.nextInt();
                    int numeroPuntos = 0;
                    for (contador = 1; contador <= altura; contador++) {
                        for (numeroPuntos = 1; numeroPuntos <= contador; numeroPuntos++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    altura = altura - 1;
                    for (contador = altura; contador >= 1; contador--) {
                        for (numeroPuntos = 1; numeroPuntos <= contador; numeroPuntos++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 0:
                    System.out.println("Fin programa.");
                    break;
            }

        } while (opcion != 0);

    }

}

