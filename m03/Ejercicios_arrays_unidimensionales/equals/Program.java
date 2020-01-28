import java.util.Scanner;
import java.util.Arrays;


public class Program{
	
	
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
	
	
	
	
	public static void main(String[] args){
		
		Scanner teclado = new Scanner(System.in);
		
		int[] nums1 = new int[6];
		int[] nums2 = new int[6];
		
		for (int i = 0; i < nums1.length; i++){
			
			System.out.print("Número para la primera tabla: ");
			nums1[i] = teclado.nextInt();
		}
		
		System.out.println("");//Salto de línea
		
		for (int i = 0; i < nums2.length; i++){
			
			System.out.print("Número para la segunda tabla: ");
			nums2[i] = teclado.nextInt();
		}
		
		System.out.println("");//Salto de línea
		
		//Mostramos las tablas numéricas
		System.out.println("Primera tabla numérica: ");
		System.out.println(Arrays.toString(nums1));
		
		System.out.println("");//Salto de línea
		
		System.out.println("Segunda tabla numérica: ");
		System.out.println(Arrays.toString(nums2));
		
		System.out.println("");//Salto de línea
		
		
		if(nums1.length != nums2.length){
			System.out.println("Las tablas númericas NO son iguales");
		} else {
			
			boolean iguales = equals(nums1, nums2);
			
			if(iguales == true){
				System.out.println("Las tablas son iguales");
			} else {
				System.out.println("Las tablas son son diferentes");
			}
		}
		
		System.out.println("");//Salto de línea
		
		
		
		
		
		
	}


}
