package org.github.ronald.obd;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashSet;

import Varies.Data;

public class Ruta_Dades {
	private int id;
	private String nom;
	private ArrayList<Integer> waypoints;
	private boolean actiu;
	private LocalDateTime dataCreacio;
	private LocalDateTime dataAnulacio;
	private LocalDateTime dataModificacio;
	private LinkedHashSet<Waypoint_Dades> setWaypointsA;
	private LinkedHashSet<Waypoint_Dades> setWaypointsB;
    
    
	public Ruta_Dades(int id, String nom, ArrayList<Integer> waypoints, boolean actiu, LocalDateTime dataCreacio, LocalDateTime dataAnulacio, LocalDateTime dataModificacio) {
		this.id = id;
		this.nom = nom;
		this.waypoints = waypoints;
		this.actiu = actiu;
		this.dataCreacio = dataCreacio;
		this.dataAnulacio = dataAnulacio;
		this.dataModificacio = dataModificacio;
		this.setWaypointsA = new LinkedHashSet<Waypoint_Dades>();
		this.setWaypointsB = new LinkedHashSet<Waypoint_Dades>();
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<Integer> getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(ArrayList<Integer> waypoints) {
		this.waypoints = waypoints;
	}

	public boolean isActiu() {
		return actiu;
	}

	public void setActiu(boolean actiu) {
		this.actiu = actiu;
	}

	public LocalDateTime getDataCreacio() {
		return dataCreacio;
	}

	public void setDataCreacio(LocalDateTime dataCreacio) {
		this.dataCreacio = dataCreacio;
	}

	public LocalDateTime getDataAnulacio() {
		return dataAnulacio;
	}

	public void setDataAnulacio(LocalDateTime dataAnulacio) {
		this.dataAnulacio = dataAnulacio;
	}

	public LocalDateTime getDataModificacio() {
		return dataModificacio;
	}

	public void setDataModificacio(LocalDateTime dataModificacio) {
		this.dataModificacio = dataModificacio;
	}
	
	public LinkedHashSet<Waypoint_Dades> getSetWaypointsA() {
		return setWaypointsA;
	}

	public void setSetWaypointsA(LinkedHashSet<Waypoint_Dades> setWaypointsA) {
		this.setWaypointsA = setWaypointsA;
	}

	public LinkedHashSet<Waypoint_Dades> getSetWaypointsB() {
		return setWaypointsB;
	}


	public void setSetWaypointsB(LinkedHashSet<Waypoint_Dades> setWaypointsB) {
		this.setWaypointsB = setWaypointsB;
	}




	@Override
    public String toString() {
        
        return "RUTA " + this.id + ":" + 
                "\n   nom = " + this.nom +
                "\n   actiu = " + this.actiu +
                "\n   dataCreacio = " + Data.imprimirData(this.dataCreacio) +
                "\n   dataAnulacio = " + Data.imprimirData(this.dataAnulacio) +
                "\n   dataModificació = " + Data.imprimirData(this.dataModificacio) + 
                "\n   waypoints: = " + this.waypoints ;
    }
    
}
