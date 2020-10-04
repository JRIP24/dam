package model;

public abstract class CustomerWithOffer extends Customer {

	public CustomerWithOffer(String name, String dni, double priceMinute) {
		super(name, dni, priceMinute);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double billAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
