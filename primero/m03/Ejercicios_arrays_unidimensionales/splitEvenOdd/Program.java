import java.util.Scanner;
import java.util.Arrays;

public class Program{
	
	
	static void splitEvenOdd(int[] nums){
		
		int cont_par = 0;
		int cont_sen = 0;
		
		for(int i = 0; i < nums.length; i++){
			
			if(nums[i]%2 == 0){
				
				cont_par++;
				
			} else {
				cont_sen++;
			}
		}
		
		int[] pares = new int[cont_par];
		int[] senares = new int[cont_sen];
		
		//Reiniciamos los contadores
		cont_par = 0;
		cont_sen = 0;
		
		for(int i = 0; i < nums.length; i++){
			
			if(nums[i]%2 == 0){
				
				pares[cont_par] = nums[i];
				cont_par++;
				
			} else {
				senares[cont_sen] = nums[i];
				cont_sen++;
			}
		}
		
		
		System.out.println("Tabla numérica introducida: ");
		System.out.println(Arrays.toString(nums));
		
		System.out.println(""); // Salto de línea
		
		System.out.println("Números pares encontrados: ");
		System.out.println(Arrays.toString(pares));
		
		System.out.println(""); // Salto de línea
		
		System.out.println("Números senares encontrados: ");
		System.out.println(Arrays.toString(senares));
		
	}
	
	
	public static void main(String[] args){
		
		Scanner teclado = new Scanner(System.in);
	
		int[] numeros = new int[9];
		
		for(int i = 0; i < numeros.length; i++){
			
			System.out.print("Introduzca un número: ");
			numeros[i] = teclado.nextInt();
		}
		
		splitEvenOdd(numeros);
		
	}
	
	
}
