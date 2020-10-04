/*
 * User.java        1.1 24/09/2013
 *   
 * Copyright 2011-2013 Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

package model;

import java.util.HashSet;

/**
 * This class modelizes a user of the company.
 * 
 * @author Mònica Ramírez Arceda
 * @version 1.0 24/09/2013
 */
public abstract class Customer {

    /** User's name */     private String name;
    /** User's dni */     private String dni;
    /** The price the user must pay for each minute of connectivity */     protected double priceMinute;
    /** User's connections */     protected HashSet<Connection> connections;

    /**
     * User constructor.
     * 
     * @param name the name of the user
     * @param dni the dni of the user
     * @param priceMinute the price per minute that the user has to pay
     */
    public Customer(String name, String dni, double priceMinute) {
        this.name = name;
        this.dni = dni;
        this.priceMinute = priceMinute;
        this.connections = new HashSet<Connection>();
    }

    /**
     * Add a connection to the user.
     * 
     * @param c a connection
     * @return true if the connection has been added, false otherwise
     */
    public boolean add(Connection c) {
        return this.connections.add(c);
    }

    /**
     * Calculates the number of minutes the user has been connected.
     * 
     * @return the number of minutes
     */
    public double totalMinutes() {
        long minutes = 0;
        for (Connection c : this.connections) {
            minutes += c.nMinutes();
        }
        return minutes;
    }

    /**
     * Reset connections of the user.
     */
    public void reset() {
        this.connections.clear();
    }

    /**
     * Calculates the bill amount.
     * 
     * @return the amount.
     */
    public abstract double billAmount();

	

    // Equals & hashCode
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
	
	// Getters & setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public HashSet<Connection> getConnections() {
		return connections;
	}

	public void setConnections(HashSet<Connection> connections) {
		this.connections = connections;
	}
    
    
	

}
