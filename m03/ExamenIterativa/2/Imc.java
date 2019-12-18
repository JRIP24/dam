import java.util.Scanner;

//Ronald Intriago
//ronaldintriago52@gmail.com


public class Imc{

    static void mediaImcH(float s, float c){

        float mediah = s / c;

        System.out.println("IMC Hombres: " + mediah);
        
    }

    static void mediaImcD(float s, float c){

        float mediad = s / c;

        System.out.println("IMC Mujeres: " + mediad);
        
    }


    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);


        //Si la variable tiene una h al final, es para hombres
        //Si la variable tiene una d al final, es para mujeres

        boolean salir = false;
        int contadorh = 0;
        int contadord = 0;
        float masa_corporalh = 0;
        float masa_corporald = 0;
        float sumah = 0;
        float sumad = 0;

        String hombre = "H";
        String mujer = "D";

        while(salir == false){

            System.out.print("Introduce la edad: ");
            int edad = teclado.nextInt();

            if (edad == 0){

                salir = true;

                mediaImcH( sumah, contadorh);
                mediaImcD( sumad, contadord);



            } else {
                System.out.print("Introduce la estatura: ");
                float estatura = teclado.nextFloat();
    
                System.out.print("Introduce el peso: ");
                float peso = teclado.nextFloat();
    
                System.out.print("Introduce el sexo (H/D): ");
                String sexo = teclado.next();
    
    
                    if (sexo == hombre){
    
                        masa_corporalh = peso / (float)Math.pow(estatura, 2);
                        sumah = sumah + masa_corporalh;
    
                        contadorh++;
    
                    } else {
    
                        masa_corporald = peso / (float)Math.pow(estatura, 2);
                        sumad = sumad + masa_corporald;
    
                        contadord++;
                    }         
       
             
            }
   
        }


    }
}