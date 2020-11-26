import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class ComprovacioRendiment {
	
	int[] coordenadesTmp = null;
	ArrayList<Waypoint_Dades> llistaArrayList;
	LinkedList<Waypoint_Dades> llistaLinkedList;
	Waypoint_Dades wtmp;
	public Deque<Waypoint_Dades> pilaWaypoints;
	public ArrayList<Ruta_Dades> llistaRutes;
	LinkedList<Waypoint_Dades> llistaWaypoints = new LinkedList<Waypoint_Dades>();
	LinkedHashMap<Integer, Waypoint_Dades> mapaWaypoints;
	
	
	public ComprovacioRendiment() {
		
		this.coordenadesTmp = new int[]{0, 0, 0};
		this.llistaArrayList = new ArrayList<Waypoint_Dades>();
		this.llistaLinkedList = new LinkedList<Waypoint_Dades>();
		this.wtmp = null;
		this.pilaWaypoints = new ArrayDeque<Waypoint_Dades>();
		this.llistaRutes = new ArrayList<Ruta_Dades>();
	}
	
	
	
}
