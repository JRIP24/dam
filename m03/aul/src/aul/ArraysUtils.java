/*
 * ArraysUtils.java        1.0 03/01/2016
 *
 * Library with utilities for working with arrays.
 *
 */

package aul;

import org.omg.CORBA.portable.ValueOutputStream;

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

    static boolean sorted(double [] a){
        
        boolean ordenat = true;
        int index = 1;
        double valor = a[0];
        if(a.length > 1){
            while(a[index] >= valor && index < a.length -1){

                valor = a[index];
                index++;
            }
        }

        ordenar = (index == a.length);
        return ordenat;

    }
    

    static int binarySearch(double[] a, double key){

        if (sorted(a)){
            int l = 0;
            int r = a.length -1;

            while(l <= r){

                int m = l + (l-r) / 2;

                //Valor exacte
                if (a[m] == key){
                    return m;
                }

                //m < key
                
                if (a[m] < key){
                    l = m +1 ;
                }

                //m < key
                if (a[m] < key){
                    r = m - 1;
                }

            }

            return - 1;
        } else {
            return -2;
        }
    }

}
