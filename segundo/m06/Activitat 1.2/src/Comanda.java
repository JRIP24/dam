import java.util.Date;

public class Comanda {
	
	private int num_comanda;
	private double preu_total;
	private Date data;
	private Client client;
	
	
	public Comanda() {
		
	}
	
	
	public Comanda(int num_comanda, double preu_total, Date data, Client client) {
		this.num_comanda = num_comanda;
		this.preu_total = preu_total;
		this.data = data;
		this.client = client;
	}
	
	public int getNum_comanda() {
		return num_comanda;
	}
	public void setNum_comanda(int num_comanda) {
		this.num_comanda = num_comanda;
	}
	public double getPreu_total() {
		return preu_total;
	}
	public void setPreu_total(double preu_total) {
		this.preu_total = preu_total;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public int getClientDni() {
		return this.client.getDni();
	}
	
	public void setClientDni(int dni) {
		this.client.setDni(dni);
	}
	
	

}
