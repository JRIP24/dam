package exercici_reforç_de_1r;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IKSRotarran {
	
	public static void main(String[] args) {
		
		//System.out.println("KLK");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		
		LocalDateTime altaCap = LocalDateTime.parse("15-08-1954 00:01", formatter);
		LocalDateTime altaMar = LocalDateTime.parse("26-12-1981 13:42", formatter);
		
		Oficial capita = new Oficial("001-A", "Martok", true, altaCap, 1, true, "Capitanear la nave");
		Mariner mariner_02_03 = new Mariner("758-J", "Kurak", true, altaMar, 3, true, "Mariner encarregat del timó i la navegació durant el 2n torn");
		
		
		System.out.println("Departamento del capitan: " + capita.departament); //Se puede acceder porque el atributo no es privado
		//System.out.println("Feina del capitan: " + capita.descripcioFeina); //No se puede acceder directamente porque el atributo es privado
		System.out.println("Feina del capita: " + capita.getDescripcioFeina());//Se puede acceder porque esta función es la que accede al atributo desde la clase, y no nosotros directamente
		
		capita.ImprimirDadesTripulant(); //Se puede acceder porque el atributo no es privado
		
		capita.departament = 10;
			
		
		
		
		
		

	}

}
