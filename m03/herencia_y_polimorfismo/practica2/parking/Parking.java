package parking;

public class Parking {
    
    private int nSpaces;
    private Vehicle[] spaces;

    public Parking(int n){
        
        this.nSpaces = n;
        this.spaces = new Vehicle[this.nSpaces];
    }

    public boolean add(Vehicle v, int ns){

        if (ns < 1 || ns > this.nSpaces){
            return false;
        } else {
            
            ns = ns -1;//Restamos 1 para que esté igualado a la indexación del array
            
            if (this.spaces[ns] == null){

                this.spaces[ns] = v;
                return true;
            } else {
                return false;
            }
        }
    }

    public Vehicle remove(int ns){

        if (ns > 1 && ns < this.nSpaces){

            ns = ns -1;//Restamos 1 para que esté igualado a la indexación del array

            if (this.spaces[ns] != null){

                Vehicle cocheEliminado = this.spaces[ns];

                this.spaces[ns] = null;
                return cocheEliminado;

            } else {

                return null;
            }

        } else {
            return null;
        }
    }

    public double calculateFee(int ns){

        if (ns > 1 && ns < this.nSpaces){

            ns = ns -1;//Restamos 1 para que esté igualado a la indexación del array

            if (this.spaces[ns] != null){
                
                Vehicle vehiculo = this.spaces[ns];

                return vehiculo.calculateFee();

            } else {

                return 0.0;
            }
            
            
        } else {

            return 0.0;
        }
    }

    public double calculateTotal(){

        double suma = 0;

        for (int i = 0; i < this.spaces.length; i++) {
            
            if (this.spaces[i] != null){ //Nos aseguramos que la plaza esté ocupada

                Vehicle vehiculo = this.spaces[i];

                suma = suma + vehiculo.calculateFee();

            }

        }

        return suma;
    }

    public void reportTotal(String pathReport){
        
        Writer escritor = new Writer(pathReport);

        for (int i = 0; i < this.spaces.length; i++) {
            
            if (this.spaces[i] != null){ //Nos aseguramos que la plaza esté ocupada

                Vehicle vehiculo = this.spaces[i];
                String tipo_vehiculo = "";

                escritor.println("Plaza num. " + (i+1));
                
                if (vehiculo instanceof Car){
                    
                    tipo_vehiculo = "Coche";

                } else if (vehiculo instanceof Motorbike){

                    tipo_vehiculo = "Moto";
                }

                escritor.println("Tipo de vehículo: " + tipo_vehiculo);
                escritor.println("Matrícula: " + vehiculo.getRegPlate());
                escritor.println("Cuota mensual: " + vehiculo.calculateFee() + "€");
                escritor.println("====================\n");

            }

        }

        escritor.close();
    }

}