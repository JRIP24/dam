/*
 * ArraysUtils.java        1.0 03/01/2016
 *
 * Library with utilities for working with arrays.
 *
 */

package aul;

/**
 * Library with utilities for working with arrays.
 */
public class ArraysUtils {
    
    /**
     * Creates an array.
     * 
     * @param length the length of the new array.
     * @return the array.
     */
    static double[] create(int length) {
        double[] arr = new double[length];
        return arr;
    }

    static String toString(double[] a){
        String result = new String("");

        for (int i = 0; i < a.length; i++) {
            
            result += "";
            result += String.valueOf(a[i]);
        }

        return result;
    }

    static double[] append(double[] a, double value){
        
        double[] newArray = ArraysUtils.create(a.length + 1);


        for (int i = 0; i < a.length; i++) {
            newArray[i] = a[i];
        }

        newArray[newArray.length - 1] = value;

        return newArray;
    }


    static boolean equals(int[] n1, int[] n2){
		
		boolean salir = false;
		boolean resultado = true;
		int cont = 0;
		
		//Primera comprobación fuera del bucle, si es falsa, no entramos
		if (n1[cont] != n2[cont]){
			salir = true;
			resultado = false;
		}
		
		
		while(salir == false){
			
			cont++;
			
			if(n1[cont] != n2[cont]){
				
				resultado = false;
			}
			
			//Condición de salida
			
			if(resultado == false || cont >= n1.length -1){
				salir = true;	
			}
			
		}
		
		return resultado;
    }

    static boolean sorted(double[] a){
        
        boolean ordenat = true;
        int index = 0;
        if(a.length > 1){

            boolean salir = false;
            while(salir == false){

                if(a[index] > a[index + 1]){
                    ordenat = false;
                }


                //Incremento
                index++;

                //Condición de salida
                if(ordenat == false || index >= a.length -1){
                    salir = true;
                }
            }
        }

        return ordenat;

    }
    

    static int binarySearch(double[] a, double key){

        if (sorted(a)){

            int mayor = a.length -1;
            int menor = 0;
            boolean salir = false;
            boolean encontrado = false;
            int medio = 0;
            int vueltas = 0;

            while(salir == false){

                medio = (menor + mayor) / 2;

                if (key > a[medio]){
                    
                    menor = medio + 1;

                } else if (key < a[medio]) {
                    mayor = medio - 1;

                } else {
                    encontrado = true;
                }

                vueltas++;

                if (encontrado == true || vueltas >= a.length){
                    salir = true;
                }    
            }


            if (encontrado == true){
                return medio;
            }
            else {
                return -1;
            }


        }
        return -2;


    }

    //Returns an array with all elements of a and, after them, all elements of b.
    static double[] union(double[] a, double[] b){
        
        double[] c = new double[a.length + b.length];

        //Rellenamos la primera parte del array
        for (int i = 0; i < a.length; i++) {
            
            c[i] = a[i];
        }

        int contador = a.length;
        for (int i = 0; i < b.length; i++) {
            
            c[contador] = b[i];
            contador++;

        }

        return c;
    }


    static double[] insert(double[] a, int index, double value){

        double[] c = a;
        c[index] = value;

        return c;
    }


	





}
