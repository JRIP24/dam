import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {

    private String nif;
    private String nombre;
    private int total_facturacion;
    private int telefono;
    private String email;
    private List<Pedido> pedidos;

    public Cliente(){

    }

    public Cliente(String nif, String nombre, int total_facturacion) {
        this.nif = nif;
        this.nombre = nombre;
        this.total_facturacion = total_facturacion;
    }

    public Cliente(boolean pedirDatos) {
        if (pedirDatos){
            Scanner teclado = new Scanner(System.in);

            System.out.print("Introduce el NIF: ");
            this.nif = teclado.nextLine();

            System.out.print("Introduce el nombre: ");
            this.nombre = teclado.nextLine();

            boolean salirTotal_facturacion = false;
            while (!salirTotal_facturacion) {
                System.out.print("Introduce el total de facturación: ");
                String total = teclado.nextLine();

                try {
                    this.total_facturacion = Integer.parseInt(total);
                    if(this.total_facturacion >= 0){//Comprobamos que no sea un número negativo
                        salirTotal_facturacion = true;
                    }

                }catch (Exception e){
                    System.out.println("El dato introducido no se acepta como Total de facturación");
                }

            }

            boolean salirTelefono = false;
            while (!salirTelefono) {
                System.out.print("Introduce el teléfono (pulsa 'Enter' para omitir): ");
                String telefonoStr = teclado.nextLine();
                if(telefonoStr.equals("")){//Presiona enter
                    salirTelefono = true;
                } else {
                    try {
                        this.telefono = Integer.parseInt(telefonoStr);
                        if(this.telefono > 0){//Comprobamos que no sea un número negativo
                            salirTelefono = true;
                        }

                    }catch (Exception e){
                        System.out.println("El dato introducido no se acepta como número de teléfono");
                    }
                }
            }

            System.out.print("Introduce el email (pulsa 'Enter' para omitir): ");
            String emailStr = teclado.nextLine();
            if(!emailStr.equals("")){//Presiona enter
                this.email = emailStr;
            }

        }
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTotal_facturacion() {
        return total_facturacion;
    }

    public void setTotal_facturacion(int total_facturacion) {
        this.total_facturacion = total_facturacion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }


    @Override
    public String toString() {

        String str = this.nombre + "\n" +
                "-nif: " + nif  +
                "\n-total_facturacion: " + total_facturacion + "€";

        if (this.telefono != 0){
            str = str + "\n-telefono: " + telefono;
        }

        if (this.email != null){
            str = str + "\n-email: " + email;
        }

        if (this.pedidos != null){
            str = str + "\n-pedidos: \n" + pedidos;
        }

        str = str + "\n\n";

        return str;


    }
}
