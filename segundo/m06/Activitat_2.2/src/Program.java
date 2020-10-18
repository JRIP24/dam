import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;




public class Program {

	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		Scanner teclado = new Scanner(System.in);
		
		String archivo = "/home/ronald/dam/segundo/m06/Activitat_2.2/enteros.txt";
		
		System.out.println("****************************");
		System.out.println("*     Que desea hacer?     *");
		System.out.println("*                          *");
		System.out.println("*                          *");
		System.out.println("*  1) Escribir enteros     *");
		System.out.println("*  2) Leer enteros         *");
		System.out.println("*                          *");
		System.out.println("****************************");
		
		
		System.out.print("Introduzca 1 o 2: ");
		int opcion = teclado.nextInt();
		
		System.out.println("Ha escogido la opción " + opcion);
		
		if (opcion != 1 && opcion != 2) {
			
			System.out.println("Error: " + opcion + " no válido, se debe introducir 1 o 2.");
			
		} else {//Podemos continuar
			
			
			if (opcion == 1) {
				
				System.out.print("Introduzca la cantidad de enteros que va a introducir: ");
				
				int cantidad = teclado.nextInt();
				int[] numeros = new int[cantidad];
				
				System.out.println("Va a introducir " + cantidad + " entero(s)" );
				
				for (int i = 0; i < cantidad; i++) {
					
					System.out.print("Introduzca un número: ");
					
					if (teclado.hasNextInt()) {
						
						int n = teclado.nextInt();
						
						numeros[i]= n;
						
					} else {
						System.out.println("Valor incorrecto");
						i--;
						teclado.next();
					}
					
					
					//numeros[i] = teclado.nextInt();
					
				}				
				
				
				
				DataOutputStream salida = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(archivo)));

				
				try {
						
						salida.writeInt(cantidad);
						
						for (int i = 0; i < numeros.length; i++) {
							salida.writeInt(numeros[i]);
						}
						
						System.out.println("Se han escrito los enteros exitosamente");
						
						
					
					} catch (IOException e) {
						
						System.out.println("Error al escribir: " + e);
						
					} finally {
						salida.close();
					}
				 
			}
			
			if (opcion == 2) {//Leer
				//System.out.print("Introduzca el archivo con los enteros a leer");
				
				Reader lector = new Reader();
				
				lector.leer(archivo);
				
				/*
				try {
					
					int[] salida = lector.leer(archivo);
					
					for (int i = 0; i < salida.length; i++) {
						
						System.out.println(salida[i]);
					}
					
				} catch (Exception e) {
					// 
					System.out.println("Error: " + e);
				}*/
				
				
				
				
				
			}
		}
		

	}

}
