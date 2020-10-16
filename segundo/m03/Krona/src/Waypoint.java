import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
		
		
		
		end = System.nanoTime();
		
		
		
		
		
		//---------LinkedList
		int mitadLl = LlSize / 2;
		
		System.out.println("ArrayList size: " + AlSize);
		System.out.println("Tiempo para insertar 1 waypoint al principio de ArrayList: " + AlTime + "ns");
		System.out.println("Tiempo para insertar 1 waypoint al principio de LinkedList: " + LlTime + "ns");
		
		
		
		
	}
	
	

}
