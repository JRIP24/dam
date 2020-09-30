package shop;

public abstract class Product{

    private String code;
    private String description;
    private int units;
    private float basePricepreuBase;


    public Product(String c, String d, int u, float b){
        
        this.code = c;
        this.description = d;
        this.units = u;
        this.basePricepreuBase = b;

    }

    public abstract float price();

    public String getCode(){
        return this.code;
    }

    public String getDescription(){
        return this.description;
    }

    public float getBasePrice(){
        return this.basePricepreuBase;
    }

    public int getUnits(){
        return this.units;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		Product other = (Product) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}


}