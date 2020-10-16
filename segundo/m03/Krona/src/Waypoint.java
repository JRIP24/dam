import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Waypoint {
	
	
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	
	public static ComprovacioRendiment inicialitzarComprovacioRendiment() {
		
		ComprovacioRendiment comprovacioRendimentTmp = new ComprovacioRendiment();
		
		return comprovacioRendimentTmp;
		
	}
	
	
	public static void comprovarRendimentInicialitzacio(int numObjACrear, ComprovacioRendiment comprovacioRendimentTmp) {
		
		
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
		
		
		//return comprovacioRendimentTmp;
		
	}
	
	// originalmente devuelve ComprovacioRendiment
	public static void comprovarRendimentInsercio(ComprovacioRendiment comprovacioRendimentTmp) {
		
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
		
		
		
		
	}
	
	
	
	//Método 4
	//originalmente devuelve ComprovacioRendiment
	public static void modificarWaypoints(ComprovacioRendiment comprovacioRendimentTmp) {
		
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
		
		
	}
	
	

}
