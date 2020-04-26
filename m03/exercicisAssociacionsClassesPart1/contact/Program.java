
public class Program {

    public static void main(String[] args){

        Contact c1 = new Contact(2671090, "Ronald", "617029704");
        Contact c2 = new Contact(2671061, "Manolo", "639029705");
        Contact c3 = new Contact(2471089, "María", "699024704");
        Contact c4 = new Contact(2471090, "Ana", "632029704");
        Contact c5 = new Contact(2672090, "Yatu", "634029704");


        c1.add(c1);
        c1.add(c2);
        c1.add(c3);
        c1.add(c4);
        c1.add(c5);


        //Prueba de eliminar un conracto
        System.out.println("Eliminación de un contacto \n");
        System.out.println("Lista de contactos de " + c1.getName() + "\n");
        c1.listContacts();
        c1.remove(c3);
        System.out.println("\n Nueva lista de contactos de " + c1.getName() + "\n");
        c1.listContacts();
        System.out.println("---------------------");


        //Buscar un contacto
        System.out.println("Búsqueada de un contacto \n");
        Contact b = c1.search(2672090);
        System.out.println("Contacto encontrado: " + b.getName());
        System.out.println("---------------------");



    }
}