package org.github.ronald.obd;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import Varies.Data;

public class Ruta {
	
	public static List<Waypoint_Dades> crearRutaInicial() {
		
		List<Waypoint_Dades> llistaWaypointLinkedList = null;
		
		
		llistaWaypointLinkedList = new LinkedList<Waypoint_Dades>();
		
		llistaWaypointLinkedList.add(new Waypoint_Dades(0, "Òrbita de la Terra", new int[] {0,0,0}, true, LocalDateTime.parse("21-10-2020 01:10", Data.formatter), null, LocalDateTime.parse("22-10-2020 23:55", Data.formatter)));
		llistaWaypointLinkedList.add(new Waypoint_Dades(1, "Punt Lagrange Terra-LLuna", new int[] {1,1,1}, true, LocalDateTime.parse("21-10-2020 01:00", Data.formatter), null, LocalDateTime.parse("22-10-2020 23:55", Data.formatter)));
		llistaWaypointLinkedList.add(new Waypoint_Dades(2, "Òrbita de la LLuna", new int[] {2,2,2}, true, LocalDateTime.parse("21-10-2020 00:50", Data.formatter), null, LocalDateTime.parse("22-10-2020 23:55", Data.formatter)));
		llistaWaypointLinkedList.add(new Waypoint_Dades(3, "Òrbita de Mart", new int[] {3,3,3}, true, LocalDateTime.parse("21-10-2020 00:40", Data.formatter), null, LocalDateTime.parse("22-10-2020 23:55", Data.formatter)));
		llistaWaypointLinkedList.add(new Waypoint_Dades(4, "Òrbita de Júpiter", new int[] {4,4,4}, true, LocalDateTime.parse("21-10-2020 00:30", Data.formatter), null, LocalDateTime.parse("22-10-2020 23:55", Data.formatter)));
		llistaWaypointLinkedList.add(new Waypoint_Dades(5, "Punt Lagrange Júpiter-Europa", new int[] {5,5,5}, true, LocalDateTime.parse("21-10-2020 00:20", Data.formatter), null, LocalDateTime.parse("22-10-2020 23:55", Data.formatter)));
		llistaWaypointLinkedList.add(new Waypoint_Dades(6, "Òrbita de Europa", new int[] {6,6,6}, true, LocalDateTime.parse("21-10-2020 00:10", Data.formatter), null, LocalDateTime.parse("22-10-2020 23:55", Data.formatter)));
		llistaWaypointLinkedList.add(new Waypoint_Dades(7, "Òrbita de Venus", new int[] {7,7,7}, true, LocalDateTime.parse("21-10-2020 00:01", Data.formatter), null, LocalDateTime.parse("22-10-2020 23:55", Data.formatter)));
		
		return llistaWaypointLinkedList;
	}
	
	public static ComprovacioRendiment inicialitzarRuta(ComprovacioRendiment comprovacioRendimentTmp) {
		
		List<Waypoint_Dades>llistaLinkedList = crearRutaInicial();
		
		for (Waypoint_Dades waypoint_Dades : llistaLinkedList) {
			comprovacioRendimentTmp.pilaWaypoints.push(waypoint_Dades);
		}
		
		Waypoint_Dades wayPoint = new Waypoint_Dades(4, "Òrbita de Júpiter REPETIDA", new int[] {4,4,4}, true,LocalDateTime.parse("21-10-2020 00:30", Data.formatter), null, LocalDateTime.parse("22-10-2020 23:55", Data.formatter));
		comprovacioRendimentTmp.pilaWaypoints.addFirst(wayPoint);
		comprovacioRendimentTmp.wtmp = wayPoint;
		
		
		
		return comprovacioRendimentTmp;
		
	}
	
	
	
	public static void visualitzarRuta(ComprovacioRendiment comprovacioRendimentTmp){
		
		
		for (Waypoint_Dades waypoint : comprovacioRendimentTmp.pilaWaypoints) {
			
			System.out.println(waypoint.toString());
			
		}
	}
	
	
	public static void invertirRuta(ComprovacioRendiment comprovacioRendimentTmp) {
		
		Deque<Waypoint_Dades> pilaWaypointsInversa = new ArrayDeque<Waypoint_Dades>();
		
		for (Waypoint_Dades waypoint : comprovacioRendimentTmp.pilaWaypoints) {
			pilaWaypointsInversa.push(waypoint);
		}
		
		for (Waypoint_Dades waypoint_Dades : pilaWaypointsInversa) {
			System.out.println(waypoint_Dades.toString());
		}
		
		
	}
	
	
	public static void existeixWaypointEnRuta(ComprovacioRendiment comprovacioRendimentTmp) {
		
		if (comprovacioRendimentTmp.pilaWaypoints.contains(comprovacioRendimentTmp.wtmp)) {
			System.out.println("SI hem trobat el waypoint " + comprovacioRendimentTmp.wtmp.getName() + " emmagatzemat en comprovacioRendimentTmp.wtmp, en la llista.");
		} else {
			System.out.println("NO hem trobat el waypoint " + comprovacioRendimentTmp.wtmp.getName() + " emmagatzemat en comprovacioRendimentTmp.wtmp, en la llista.");
		}
		
		Waypoint_Dades waypoint = new Waypoint_Dades(4, "Òrbita de Júpiter REPETIDA", new int[] {4,4,4}, true,
				LocalDateTime.parse("21-10-2020 00:30", Data.formatter), null,
				LocalDateTime.parse("22-10-2020 23:55", Data.formatter));
		
		if (comprovacioRendimentTmp.pilaWaypoints.contains(waypoint)) {
			System.out.println("SI hem trobat el waypoint " + waypoint.getName() + " creat ara mateix, en la llista.");
		} else {
			System.out.println("NO hem trobat el waypoint " + waypoint.getName() + " creat ara mateix, en la llista.");
		}
		
		
	}
	
	
	public static ComprovacioRendiment inicialitzaLListaRutes(ComprovacioRendiment comprovacioRendimentTmp) {
		
		Ruta_Dades ruta_0 = new Ruta_Dades(0, "ruta 0: Terra --> Punt Lagrange Júpiter-Europa", new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5)), true, LocalDateTime.parse("28-10-2020 16:30", Data.formatter), null, LocalDateTime.parse("28-10-2020 16:30", Data.formatter));
		Ruta_Dades ruta_1 = new Ruta_Dades(1, "ruta 1: Terra --> Òrbita de Mart (directe)", new ArrayList<Integer>(Arrays.asList(0, 3)), true, LocalDateTime.parse("28-10-2020 16:31", Data.formatter), null, LocalDateTime.parse("28-10-2020 16:31", Data.formatter));
		Ruta_Dades ruta_2 = new Ruta_Dades(2, "ruta 2.1: Terra --> Òrbita de Venus", new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7)), true, LocalDateTime.parse("28-10-2020 16:32", Data.formatter), null, LocalDateTime.parse("28-10-2020 16:32", Data.formatter));
		Ruta_Dades ruta_3 = new Ruta_Dades(3, "ruta 3: Terra --> Mart (directe) --> Òrbita de Júpiter ", new ArrayList<Integer>(Arrays.asList(0, 3, 4)), true, LocalDateTime.parse("28-10-2020 16:33", Data.formatter), null, LocalDateTime.parse("28-10-2020 16:33", Data.formatter));
		Ruta_Dades ruta_4 = new Ruta_Dades(4, "ruta 2.2: Terra --> Òrbita de Venus (REPETIDA)", new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7)), true, LocalDateTime.parse("28-10-2020 16:32", Data.formatter), null, LocalDateTime.parse("30-10-2020 19:49", Data.formatter));
		
		
		comprovacioRendimentTmp.llistaRutes.add(ruta_0);
		comprovacioRendimentTmp.llistaRutes.add(ruta_1);
		comprovacioRendimentTmp.llistaRutes.add(ruta_2);
		comprovacioRendimentTmp.llistaRutes.add(ruta_3);
		comprovacioRendimentTmp.llistaRutes.add(ruta_4);
		
		
		for (Ruta_Dades ruta : comprovacioRendimentTmp.llistaRutes) {
			
			System.out.println(ruta.toString());
			
		}
		
		return comprovacioRendimentTmp;
	}
	
	
	public static void setUnio(ComprovacioRendiment comprovacioRendimentTmp) {
		
		Set<Integer> hs = new HashSet<Integer>();
	
		for (Ruta_Dades ruta : comprovacioRendimentTmp.llistaRutes) {
			hs.addAll(ruta.getWaypoints());
		}
		
		System.out.println("ID dels waypoints ficats en el set: " + hs);	
		
		
	}
	
	
	public static void setInterseccio(ComprovacioRendiment comprovacioRendimentTmp){
		
		Set<Integer> hs = new HashSet<Integer>();
		
		for(Ruta_Dades ruta : comprovacioRendimentTmp.llistaRutes) {
			hs.addAll(ruta.getWaypoints());
		}
		
		for(Ruta_Dades ruta : comprovacioRendimentTmp.llistaRutes) {
			hs.retainAll(ruta.getWaypoints());			
		}
		
		System.out.println("ID dels waypoints en totes les rutes: " + hs);
	}
	
	
	
	
	
	
}
