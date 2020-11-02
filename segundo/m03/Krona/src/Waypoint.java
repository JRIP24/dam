import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;


public class Waypoint {
	
	
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	
	public static ComprovacioRendiment inicialitzarComprovacioRendiment() {
		
		ComprovacioRendiment comprovacioRendimentTmp = new ComprovacioRendiment();
		
		return comprovacioRendimentTmp;
		
	}
	
	
	public static ComprovacioRendiment comprovarRendimentInicialitzacio(int numObjACrear, ComprovacioRendiment comprovacioRendimentTmp) {
		
		
		long startTimeAr = System.currentTimeMillis();
		
		for (int i = 0; i < numObjACrear; i++) {
			
			comprovacioRendimentTmp.llistaArrayList.add(new Waypoint_Dades(0, "Òrbita de la Terra", new int[] {0,0,0}, true, LocalDateTime.parse("15/08/1954 00:01", formatter), null, null));
			
		}
		
		long endTimeAr = System.currentTimeMillis(); //comentario pa gitHub
		long execTimeAr = endTimeAr - startTimeAr;
		
		
		
		long startTimeLi = System.currentTimeMillis();
		
		for (int i = 0; i < numObjACrear; i++) {
			
			comprovacioRendimentTmp.llistaLinkedList.add(new Waypoint_Dades(0, "Òrbita de la Terra", new int[] {0,0,0}, true, LocalDateTime.parse("15/08/1954 00:01", formatter), null, null));
			
		}
		
		long endTimeLi = System.currentTimeMillis();
		
		long execTimeLi = endTimeLi - startTimeLi;
		
		
		
		
		System.out.println("Tiempo para insertar " + numObjACrear + " waypoints en el ArrayList: " + execTimeAr + "ms");
		System.out.println("Tiempo para insertar " + numObjACrear + " waypoints en el LinkedList: "+ execTimeLi + "ms");
		
		
		return comprovacioRendimentTmp;
		
	}
	
	
	public static ComprovacioRendiment comprovarRendimentInsercio(ComprovacioRendiment comprovacioRendimentTmp) {
		
		long start;
		long end;
		
		int AlSize = comprovacioRendimentTmp.llistaArrayList.size();
		int LlSize = comprovacioRendimentTmp.llistaLinkedList.size();
		
		//Al principio
		
		//--------ArrayList
		
		start = System.nanoTime();
		
		comprovacioRendimentTmp.llistaArrayList.add(0,new Waypoint_Dades(0, "Òrbita de la Terra", new int[] {0,0,0}, true, LocalDateTime.parse("15/08/1954 00:01", formatter), null, null));
		
		end = System.nanoTime();
		long AlTime = end - start;
		
		//---------LinkedList
		start = System.nanoTime();
		
		comprovacioRendimentTmp.llistaLinkedList.addFirst(new Waypoint_Dades(0, "Òrbita de la Terra", new int[] {0,0,0}, true, LocalDateTime.parse("15/08/1954 00:01", formatter), null, null));
		
		end = System.nanoTime();
		long LlTime = end - start;
		
		
		
		
		//Al medio
		
		//---------ArrayList
		int mitadAl = AlSize / 2;
		
		start = System.nanoTime();
		
		comprovacioRendimentTmp.llistaArrayList.add(mitadAl, new Waypoint_Dades(0, "Òrbita de la Terra", new int[] {0,0,0}, true, LocalDateTime.parse("15/08/1954 00:01", formatter), null, null));
				
		
		end = System.nanoTime();
		
		long AlTimeMiddle = end - start;
		
		
		
		
		
		//---------LinkedList
		int mitadLl = LlSize / 2;
		start = System.nanoTime();
		
		comprovacioRendimentTmp.llistaLinkedList.add(mitadLl, new Waypoint_Dades(0, "Òrbita de la Terra", new int[] {0,0,0}, true, LocalDateTime.parse("15/08/1954 00:01", formatter), null, null));
		
		end = System.nanoTime();
		long LlTimeMiddle = end - start;
		
		
		
		//Final
		//---------ArrayList
		
		start = System.nanoTime();
		
		comprovacioRendimentTmp.llistaArrayList.add(comprovacioRendimentTmp.llistaArrayList.size() - 1, new Waypoint_Dades(0, "Òrbita de la Terra", new int[] {0,0,0}, true, LocalDateTime.parse("15/08/1954 00:01", formatter), null, null));
		
		end = System.nanoTime();
		
		long AlTimeEnd = end - start;
		
		
		
		
		//---------LinkedList
		start = System.nanoTime();
		
		comprovacioRendimentTmp.llistaLinkedList.addLast(new Waypoint_Dades(0, "Òrbita de la Terra", new int[] {0,0,0}, true, LocalDateTime.parse("15/08/1954 00:01", formatter), null, null));
		
		end = System.nanoTime();
		
		long LlTimeEnd = end - start;
		
		
		System.out.println("ArrayList size: " + AlSize);
		System.out.println("Tiempo para insertar 1 waypoint al principio de ArrayList: " + AlTime + "ns");
		System.out.println("Tiempo para insertar 1 waypoint al principio de LinkedList: " + LlTime + "ns");
		System.out.println("----------");
		
		System.out.println("Tiempo para insertar 1 waypoint en el medio ( " + AlSize/2 + " ) de ArrayList: " + AlTimeMiddle + "ns");
		System.out.println("Tiempo para insertar 1 waypoint en el medio ( " + LlSize/2 + " ) LinkedList: " + LlTimeMiddle + "ns");
		System.out.println("----------");
		
		System.out.println("Tiempo para insertar 1 waypoint al final de ArrayList: " + AlTimeEnd + "ns");
		System.out.println("Tiempo para insertar 1 waypoint al final de LinkedList: " + LlTimeEnd + "ns");
		
		
		
		return comprovacioRendimentTmp;
		
		
		
		
	}
	
	
	
	//Método 4
	public static ComprovacioRendiment modificarWaypoints(ComprovacioRendiment comprovacioRendimentTmp) {
		
		int AlSize = comprovacioRendimentTmp.llistaArrayList.size();
		System.out.println("------ APARTAT 1------\n");
		List<Integer> idsPerArrayList = new ArrayList<Integer>();
		
		for (int i = 0; i < AlSize; i++) {
			idsPerArrayList.add(i, i);
		}
		
		System.out.println("Se ha inicializado la lista idsPerArrayList con " + AlSize + " elementos");	
		System.out.println("El primero tiene el valor: " + idsPerArrayList.get(0));
		System.out.println("El último tiene el valor: " + idsPerArrayList.get(AlSize - 1));
		
		
		System.out.println("\n------ APARTAT 2------");
		
		for (int i = 0; i < AlSize; i++) {
			
			int valorId = comprovacioRendimentTmp.llistaArrayList.get(i).getId();
			
			System.out.println("ANTES DEL CAMBIO: comprovacioRendimentTmp.llistaArrayList.get(" + i + ").getId(): " + valorId);
			
			comprovacioRendimentTmp.llistaArrayList.get(i).setId(idsPerArrayList.get(i));
			
			valorId = comprovacioRendimentTmp.llistaArrayList.get(i).getId();
			
			System.out.println("DESPUÉS DEL CAMBIO: comprovacioRendimentTmp.llistaArrayList.get(" + i + ").getId(): " + valorId + "\n");
			
		}
		
		
		
		
		//Apartado 3
		System.out.println("---APARTADO 3.1 (bucle for)-----");
		for (Waypoint_Dades waypoint : comprovacioRendimentTmp.llistaArrayList) {
			System.out.println("ID = " + waypoint.getId() + ", nom = " + waypoint.getName());
			
		}
		
		
		System.out.println("\n---APARTADO 3.2 (Iterator)-----");
		Iterator<Waypoint_Dades> iter = comprovacioRendimentTmp.llistaArrayList.iterator();
		
		while (iter.hasNext()) {
			
			Waypoint_Dades waypoint = iter.next();
			
            System.out.println("ID = " + waypoint.getId() + ", nom = " + waypoint.getName());
        }
		
		
		//Apartado 4
		System.out.println("\n----APARTADO 4 -----");
		System.out.println("Preparado para borrar el contenido de la llistaLinkedList que tiene " + comprovacioRendimentTmp.llistaLinkedList.size() + " elementos");
		comprovacioRendimentTmp.llistaLinkedList.clear();
		System.out.println("Borrada. Ahora la llistaLinkedList tiene " + comprovacioRendimentTmp.llistaLinkedList.size() + " elementos");
		
		for (Waypoint_Dades waypoint : comprovacioRendimentTmp.llistaArrayList) {
			
			comprovacioRendimentTmp.llistaLinkedList.add(waypoint);
			
		}
		
		System.out.println("Copiados los elementos de llistaArrayList en llistaLinkedList que ahora tiene " + comprovacioRendimentTmp.llistaLinkedList.size() + " elementos");
		
		
		
		
		
		//Apartado 5
		System.out.println("\n----APARTADO 5.1 (bucle for) -----");
		for (Waypoint_Dades waypoint : comprovacioRendimentTmp.llistaArrayList) {
			
			if (waypoint.getId() > 5) {
				waypoint.setName("Òrbita de Mart");
				System.out.println("Modificat el waypoint amb id: " + waypoint.getId());
			}
		}
		
		System.out.println("\n----APARTADO 5.1 (Comprobación) -----");
		for (int i = 0; i < AlSize; i++) {
			System.out.println("El waypoint amb id = " + comprovacioRendimentTmp.llistaArrayList.get(i).getId()  + " té el nom " + comprovacioRendimentTmp.llistaArrayList.get(i).getName());
		}
		
		
		
		System.out.println(" ---- APARTAT 5.2 (Iterator) -----");
		
		Iterator<Waypoint_Dades> iterator = comprovacioRendimentTmp.llistaLinkedList.iterator();
		
		while (iterator.hasNext()) {
			
			Waypoint_Dades waypoint = iterator.next();
			
			int num = waypoint.getId();
						
			if ( num < 5) {
				
				waypoint.setName("Punt Lagrange entre la Terra i la LLuna");
				
				System.out.println("Modificat el waypoint amb id = " + num);
			}
            
        }
		
		System.out.println("\n ---- APARTAT 5.2 (comprovació) -----");
		
		for (int i = 0; i < comprovacioRendimentTmp.llistaLinkedList.size(); i++) {
			
			System.out.println("El waypoint amb id = " + comprovacioRendimentTmp.llistaArrayList.get(i).getId()  + " té el nom " + comprovacioRendimentTmp.llistaArrayList.get(i).getName());
			
		}
		
		
		
		
		
		return comprovacioRendimentTmp;
		
	}
	
	
	
	//Método 5
	public static ComprovacioRendiment esborrarWaypoints(ComprovacioRendiment comprovacioRendimentTmp) {
		
		//Apartat 1
		
		//No funciona, nos lanza una excepción de tipo java.util.ConcurrentModificationException, porque intentamos modificar la lista
		//mediante el iterador que usamos para recorrerla
		
		/*
		System.out.println("----- APARTAT 1 -------");
		
		for(Waypoint_Dades waypoint: comprovacioRendimentTmp.llistaArrayList) {
			
			if(waypoint.getId() < 6) {
				comprovacioRendimentTmp.llistaArrayList.remove(waypoint.getId());
			}
			
			
		}*/
		
		
		//Apartat 2
		
		
		System.out.println(" ---- APARTAT 2 (Iterator) -----");
		
		Iterator<Waypoint_Dades> iter = comprovacioRendimentTmp.llistaLinkedList.iterator();
		
		while (iter.hasNext()) {
			
			Waypoint_Dades waypoint = iter.next();
			
			int num = waypoint.getId();
			
			if ( num > 4) {
				
				iter.remove();
				
				System.out.println("Esborrat el waypoint amb id = " + num);
			}
            
        }
		
		System.out.println("\n ---- APARTAT 2 (comprovació) -----");
		
		for (int i = 0; i < comprovacioRendimentTmp.llistaLinkedList.size(); i++) {
			
			System.out.println("El waypoint amb id = " + comprovacioRendimentTmp.llistaLinkedList.get(i).getId()  + " té el nom " + comprovacioRendimentTmp.llistaLinkedList.get(i).getName());
			
		}
		
		
		
		System.out.println(" \n---- APARTAT 3 (ListIterator) -----");
		
		ListIterator<Waypoint_Dades> iterador = comprovacioRendimentTmp.llistaLinkedList.listIterator();
		
		while (iterador.hasNext()) {
			
			Waypoint_Dades waypoint = iterador.next();
			
			int num = waypoint.getId();
			
			if ( num == 2) {
				
				iterador.remove();
				
				System.out.println("Esborrat el waypoint amb id = " + num);
			}
            
        }
		
		System.out.println("\n---- APARTAT 3 (Comprobacion) -----");
		
		while (iterador.hasPrevious()) {
			
			Waypoint_Dades waypoint = iterador.previous();
			
			
			System.out.println("El waypoint amb id = " + waypoint.getId()  + " té el nom " + waypoint.getName());
			
            
        }
		
		
		
		
		
		
		
		
		
		return comprovacioRendimentTmp;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
