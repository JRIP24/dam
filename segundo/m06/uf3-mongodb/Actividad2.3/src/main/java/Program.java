import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {

    public static void pausar(){

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while(!exit) {

            System.out.println("Presione 'Enter' para continuar");
            String readString = scanner.nextLine();

            if (readString.isEmpty()) {
                System.out.println("\n \n");

                exit = true;

            }
        }

    }
    public static void main(String[] args){

        //En la shell de mongoDB
        /*
        db.createCollection("clientes")
         */
        //Cliente cliente = new Cliente("12345678X", "Pere Pons", 0);

        Mongo mongo = new Mongo();
        //mongo.deleteAll();

        //Para ocultar los logs
        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.SEVERE);

        boolean salir = false;
        while (!salir) {

            Scanner teclado = new Scanner(System.in);

            System.out.println("*************************");
            System.out.println("*                       *");
            System.out.println("*     ACTIVIDAD 2.3     *");
            System.out.println("*                       *");
            System.out.println("************************* \n");

            System.out.println("0 - Salir");
            System.out.println("1 - Dar de alta cliente");
            System.out.println("2 - Añadir pedidos a un cliente");
            System.out.println("3 - Buscar clientes por facturación");
            System.out.println("4 - Buscar clientes por cantidad de pedidos \n \n");

            System.out.print("Introduzca una opción: ");

            if (teclado.hasNextInt()) {

                int opcion = teclado.nextInt();

                switch (opcion) {
                    case 0:
                        salir = true;
                        break;

                    case 1:
                        Cliente cliente = new Cliente(true);
                        mongo.insertClient(cliente);
                        pausar();
                        break;

                    case 2:
                        mongo.insertOrder();
                        pausar();
                        break;

                    case 3:

                        int valorInt = getIntegerFromStr("Introdouzca el valor de la facturación a buscar (pulse 'Enter' para cancelar) :");

                        if (valorInt == -1){
                            System.out.println("Operación cancelada");
                        } else {
                            mongo.getClientsByBilling(valorInt);
                        }

                        pausar();
                        break;

                    case 4:

                        int valor = getIntegerFromStr("Introdouzca la cantidad de pedidos a buscar (pulse 'Enter' para cancelar) :");

                        if (valor == -1){
                            System.out.println("Operación cancelada");
                        } else {
                            mongo.getClientsByOrders(valor);
                        }
                        pausar();
                        break;


                    default:
                        System.out.println("Error: se debe introducir un número del 0 al 4");
                        pausar();
                        break;
                }

            } else {
                System.out.println("Error: No se ha introducido ningún número");
                pausar();

            }
        }






    }

    private static int getIntegerFromStr(String mensaje) {//Para recoger valores tipo Int con control de errores

        int valorInt = 0;
        boolean exitLoop = false;
        Scanner sc = new Scanner(System.in);
        while (!exitLoop) {
            System.out.print(mensaje);
            String valorStr = sc.nextLine();

            if(valorStr.equals("")){//Presiona enter
                exitLoop = true;
                valorInt = -1;//Devolvemos -1 dando a entender que el usuario no quiere introducir un número
            } else {
                try {
                    valorInt = Integer.parseInt(valorStr);
                    if(valorInt >= 0){//Comprobamos que no sea un número negativo
                        exitLoop = true;
                    }

                }catch (Exception e){
                    System.out.println("El dato introducido incorrecto");
                }
            }
        }

        return valorInt;

    }
}
