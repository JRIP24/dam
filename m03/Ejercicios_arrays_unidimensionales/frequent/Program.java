import java.util.Arrays;
import java.util.Scanner;

public class Program{

    static boolean aparecido(int[] lista, int n){

        boolean esta = false;

        for (int i = 0; i < lista.length; i++){

            if (lista[i] == n){
                esta = true;
            }
        }

        return esta;
    }


    static void frequent(int[] num){

        int contador = 0;
        int contador_anterior = 0;
        int max = 0; //El número de máxima repeticion
        int max2 = 0; //El segundo número de máxima repeticion
        int repetido = 0;
        int repetido2 = 0; //Se guarda el segundo más repetido
        int index = 0;
        int index2 = 0;
        int[] arrays_aparecidos = new int[num.length];


        for(int i = 0; i < num.length; i++){


            if (aparecido(arrays_aparecidos, num[i]) == false) {

                //Se añade a la lista de numeros aparecidos
                arrays_aparecidos[i] = num[i];
                
                for (int x = 0; x < num.length; x++){

                    if (num[i] == num[x]){
                        contador++;
                    }
                }

                System.out.println("El número " + num[i] + " esta " + contador + " veces");
                System.out.println("---Contador " + contador);
                System.out.println("---MAX " + max);
                System.out.println("---MAX2 " + max2);

                if (contador >= max ){

                    index = Arrays.binarySearch(num,num[repetido]);
                    index2 = Arrays.binarySearch(num,num[i]);

                    System.out.println("Index: " + index);
                    System.out.println("Index 2: " + index2);

                    if (index >= index2){

                        repetido = num[i];

                    }
                    
                    max = contador;
                    
                } else if(contador >= max2) {

                    repetido2 = num[i];
                
                    max2 = contador;

                }

                contador_anterior = contador;
                contador = 0;

            }

        }


        System.out.println("El número más repetido es: " + repetido);    
        
        //System.out.println(Arrays.toString(num));
        
    }

    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        int resultado;

        int[] numeros = new int[8];
        int n;

        for (int i = 0; i < numeros.length; i++){

            System.out.print("Introduzca un número: ");
            n = teclado.nextInt();

            numeros[i] = n;
        }

        System.out.println("");//Salto de línea

        Arrays.sort(numeros);//Ordenamos el array antes de enviarlo a la función
        frequent(numeros);

    }
}