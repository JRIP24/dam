public class ExerciciMaxim{

	public static void main(String[] args) {
	
		ExerciciMaxim ex = new ExerciciMaxim();
		int[] nombres = {100, 500, 300,200, 1000, 600,700, 800, 400, 900};
	
		int maxim = ex.trobarMaxim(nombres);
		System.out.println(maxim);
	}

	public int trobarMaxim(int[] nombres) {
		int maxim= nombres[0]; 
		for (int i=1;i < nombres.length;i++){
			if (nombres[i]>maxim){
			       maxim = nombres[i];
			}
		}
	return maxim;
	}
}