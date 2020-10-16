
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ComprovacioRendiment comp = Waypoint.inicialitzarComprovacioRendiment();
		
		Waypoint.comprovarRendimentInicialitzacio(50000, comp);
		
		Waypoint.comprovarRendimentInsercio(comp);

	}

}
