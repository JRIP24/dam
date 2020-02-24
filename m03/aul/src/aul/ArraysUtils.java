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
            
            if (i != 0){
                result += ", ";
            }
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


    static boolean equals(double[] n1, double[] n2){
		
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


    //Searches a range of the specified array of doubles for the specified value using the binary search algorithm.
    static int binarySearch(double[] a, int fromIndex, int toIndex, double key){


        if (sorted(a)){

            int mayor = toIndex;
            int menor = fromIndex;
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

        if (index > a.length - 1){

            double[] c = new double[1];
            c[0] = -1.0;
            return c;

        } else {
            a[index] = value;
        }

        return a;
    }


    //Returns an array with the same elements of a but without value in index.
    static double[] remove(double[] a, int index){
        
        if (index > a.length - 1){

            double[] c = new double[1];
            c[0] = -1.0;
            return c;

        } else {
            a[index] = 0;
        }

        return a;

    }


    //Assigns the specified double value to each element of the specified array of doubles.
    static void fill(double[] a, double val){
    

        for (int i = 0; i < a.length; i++) {
            a[i] = val;
        }

        System.out.println(toString(a));

    }

    
	//Assigns the specified double value to each element of the specified range of the specified array of doubles.
    static void fill(double[] a, int fromIndex, int toIndex, double val){
        
        String result = "";

        if (fromIndex > toIndex){
            
            result = "ERROR: El rango de inicio es mayor que el final";

        } else if(fromIndex >= a.length - 1 && toIndex != a.length - 1){
            result = "ERROR: El rango de inicio está al final del array";
        }

        else if(toIndex == a[0] && fromIndex != a[0]){
            result = "ERROR: El rango final está al principio del array";
        }

        else if(toIndex > a.length - 1){
            result = "ERROR: El índice final es mayor que la longitud del array";
        }

        else {

            for (int i = fromIndex; i <= toIndex; i++){
                a[i] = val;
            }

            result = toString(a);
        }

        System.out.println(result);

    }

    //Copies the specified array, truncating or padding with zeros (if necessary) so the copy has the specified length.
    static double[]	copyOf(double[] original, int newLength){

        double[] copy = new double[1];

        if (newLength > original.length){

            copy = new double[newLength];

            //Rellenamos con el array original
            for (int i = 0; i < original.length; i++) {
                copy[i] = original[i];
            }

            for (int i = original.length; i < copy.length; i++) {
                copy[i] = 0;
            }

        } else if(newLength < original.length){

        copy = new double[newLength];

        for (int i = 0; i < copy.length; i++) {
            
            copy[i] = original[i];
        }


        } else { //Tienen la misma longitud;
            copy = original;
        }

        return copy;



    }

    //Copies the specified range of the specified array into a new array.
    static double[]	copyOfRange(double[] original, int from, int to){

        double[] copy = new double[1];

        if (from > to){
            
            //El rango de inicio es mayor que el final
            copy[0] = -1;

        } else if(from >= original.length - 1 && to != original.length - 1){

            //El rango de inicio está al final del array
            copy[0] = -2;
        }

        else if(to == original[0] && from != original[0]){
            //El rango final está al principio del array
            copy[0] = -3;
        }

        else if(to > original.length - 1){
            
            //El índice final es mayor que la longitud del array
            copy[0] = -4;
        }

        else {

            copy = new double[(to - from) + 1];
            int counter = 0;

            for (int i = from; i <= to; i++){

                copy[counter] = original[i];
                counter++;
            }

        }

        return copy;


    }

    
    //Returns an array with the same elements of a but with value added to the beginning of the array.
    static double[] prepend(double[] a, double value){

        double[] newArray = ArraysUtils.create(a.length + 1);

        newArray[0] = value;

        for (int i = 0; i < a.length; i++) {
            newArray[i + 1] = a[i];
        }

        return newArray;

    }

    //Sorts the specified array into ascending numerical order.
    static void sort(double[] a){
        
        double aux = 0.0;
        boolean salir = false;
        int cont = 0;

        while(salir == false){

            cont = 0;

            for(int i = 0; i < a.length -1; i++){

                if (a[i] > a[i + 1]){

                    aux = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = aux;

                } else {
                    cont++;
                }

            }

            //Condición de salida
            if (cont >= a.length - 1){
                salir = true;
            }
        }

        System.out.println(toString(a));
    }

    //Sorts the specified range of the array into ascending order.
    static void sort(double[] a, int fromIndex, int toIndex){

        String result = "";

        if (fromIndex > toIndex){
            
            result = "ERROR: El rango de inicio es mayor que el final";

        } else if(fromIndex >= a.length - 1 && toIndex != a.length - 1){
            result = "ERROR: El rango de inicio está al final del array";
        }

        else if(toIndex == a[0] && fromIndex != a[0]){
            result = "ERROR: El rango final está al principio del array";
        }

        else if(toIndex > a.length - 1){
            result = "ERROR: El índice final es mayor que la longitud del array";
        }

        else {

            double aux = 0.0;
            boolean salir = false;
            int cont = 0;

            while(salir == false){

                for(int i = fromIndex; i < toIndex; i++){
                    
                    /*System.out.println(i);
                    System.out.println(a[i]);
                    System.out.println("contador = " + cont);*/

                    if (a[i] > a[i + 1]){

                        aux = a[i];
                        a[i] = a[i + 1];
                        a[i + 1] = aux;

                    } else {
                        cont++;
                    }

                }

                //Condición de salida
                if (cont >= toIndex){
                    salir = true;
                }
            }

            result = toString(a);
        }

        System.out.println(result);

    }
	
	
	
	
	





}
