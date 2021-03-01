import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Pedido {

    private Date fecha_pedido;
    private int importe;
    private boolean pagado;

    public Pedido(){

    }

    public Pedido(Date fecha_pedido, int importe, boolean pagado) {
        this.fecha_pedido = fecha_pedido;
        this.importe = importe;
        this.pagado = pagado;
    }

    public Pedido(boolean pedirDatos) {

        if (pedirDatos){
            Scanner teclado = new Scanner(System.in);

            boolean fechaCorrecta = false;
            while (!fechaCorrecta) {
                System.out.print("Introduce la fecha de pedido (dia/mes/any): ");
                String fecha = teclado.nextLine();

                try {
                    this.fecha_pedido = java.sql.Date.valueOf(LocalDate.parse(fecha, DateTimeFormatter.ofPattern("d/MM/yyyy")));
                    fechaCorrecta = true;
                }catch (Exception e){
                    System.out.println("Fecha incorrecta");
                }

            }

            boolean importeCorrecto = false;
            while (!importeCorrecto) {
                System.out.print("Introduce el importe del pedido: ");
                String total = teclado.nextLine();

                try {
                    this.importe = Integer.parseInt(total);
                    if(this.importe >= 0){//Comprobamos que no sea un número negativo
                        importeCorrecto = true;
                    }

                }catch (Exception e){
                    System.out.println("El dato introducido no se acepta como importe");
                }

            }

            boolean valorCorrecte = false;
            while (!valorCorrecte) {
                System.out.println("El pedido está pagado? (s/n):");
                String valor = teclado.nextLine();
                if (valor.equals("s") || valor.equals("n")) {

                    if (valor.equals("s")){
                        this.pagado = true;
                    } else {
                        this.pagado = false;
                    }
                    valorCorrecte = true;
                }
            }

        }

    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    @Override
    public String toString() {
        return "\n  Pedido{ \n" +
                "  -fecha_pedido: " + fecha_pedido +
                "\n  -importe: " + importe + "€" +
                "\n  -pagado: " + pagado +
                "\n  }";
    }
}
