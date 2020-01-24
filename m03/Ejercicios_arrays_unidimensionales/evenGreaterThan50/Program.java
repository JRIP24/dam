import java.util.Arrays;


public class Program{

    static void evenGreaterThan50(int[] nums){

        int contador = 0;

        for (int i = 0; i < nums.length; i++){
            
            if (nums[i]%2 == 0 && nums[i] > 50){
                contador++;
            }
        }

        int[] n = new int[contador];
        contador = 0;

        for(int i = 0; i < nums.length; i++){

            if (nums[i]%2 == 0 && nums[i] > 50){
                n[i] = nums[i];
                contador++;
            }
        }


    }

    public static void main(String[] args){

        int[] numeros={1,4,10,32,60,91,34,56,73,88,86};

        evenGreaterThan50(numeros);



    }
}