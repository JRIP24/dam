public class Program {
    
    public static void main(String[] args) {

        System.out.println("OFICINA \n");
        Office oficina = new Office("OF1", 102.0, true, 9130.0);
        oficina.setNTables(3);
        oficina.setCoffeeMachine(true);
        System.out.println("Código: " + oficina.getCode());
        System.out.println("Superfície: " + oficina.getSurfaceArea() + "m²");
        System.out.println("Tiene luz natural?: " + oficina.getNaturalLight());
        System.out.println("Consumo eléctrico: " + oficina.getConsuption() + "Kwh");
        System.out.println("Consumo eléctrico por m²: " + oficina.consuptionM2());
        System.out.println("Nº de mesas: " + oficina.getNTables());
        System.out.println("Tiene máquina de café?: " + oficina.isCoffeeMachine());
        System.out.println("---------------------------- \n");

        System.out.println("CLASE \n");
        Classroom clase = new Classroom("CL1", 90.0, true, 5100.0, 30);
        clase.setNComputers(1);
        clase.setTableChair(true);
        clase.setNetworkConn(true);
        System.out.println("Código: " + clase.getCode());
        System.out.println("Superfície: " + clase.getSurfaceArea() + "m²");
        System.out.println("Tiene luz natural?: " + clase.getNaturalLight());
        System.out.println("Consumo eléctrico: " + clase.getConsuption() + "Kwh");
        System.out.println("Consumo eléctrico por m²: " + clase.consuptionM2());
        System.out.println("Capacidad máxima: " + clase.getCapacity());
        System.out.println("m² por estudiante: " + clase.surfaceAreaStudent());
        System.out.println("Tiene mesas y sillas?: " + clase.isTableChair());
        System.out.println("Nº de Ordenadores: " + clase.getNComputers());
        System.out.println("Tiene conexión de red?: " + clase.isNetworkConn());
        System.out.println("---------------------------- \n");

        System.out.println("LABORATORIO \n");
        Laboratory lab = new Laboratory("CL2", 75.0, true, 5100.0, 25);
        lab.setNComputers(0);
        lab.setTableChair(true);
        lab.setNetworkConn(false);
        lab.setnBunsen(24);
        System.out.println("Código: " + lab.getCode());
        System.out.println("Superfície: " + lab.getSurfaceArea() + "m²");
        System.out.println("Tiene luz natural?: " + lab.getNaturalLight());
        System.out.println("Consumo eléctrico: " + lab.getConsuption() + "Kwh");
        System.out.println("Consumo eléctrico por m²: " + lab.consuptionM2());
        System.out.println("Capacidad máxima: " + lab.getCapacity());
        System.out.println("m² por estudiante: " + lab.surfaceAreaStudent());
        System.out.println("Tiene mesas y sillas?: " + lab.isTableChair());
        System.out.println("Nº de Ordenadores: " + lab.getNComputers());
        System.out.println("Tiene conexión de red?: " + lab.isNetworkConn());
        System.out.println("Número de encendedores Bunsen: " + lab.getnBunsen());
        System.out.println("---------------------------- \n");

        System.out.println("IFORMÁTICA \n");
        Computing info = new Computing("CL3", 105.0, true, 9500.0, 30);
        info.setNComputers(30);
        info.setTableChair(true);
        info.setNetworkConn(true);
        info.setNPrinters(1);
        System.out.println("Código: " + info.getCode());
        System.out.println("Superfície: " + info.getSurfaceArea() + "m²");
        System.out.println("Tiene luz natural?: " + info.getNaturalLight());
        System.out.println("Consumo eléctrico: " + info.getConsuption() + "Kwh");
        System.out.println("Consumo eléctrico por m²: " + info.consuptionM2());
        System.out.println("Capacidad máxima: " + info.getCapacity());
        System.out.println("m² por estudiante: " + info.surfaceAreaStudent());
        System.out.println("Tiene mesas y sillas?: " + info.isTableChair());
        System.out.println("Nº de Ordenadores: " + info.getNComputers());
        System.out.println("Tiene conexión de red?: " + info.isNetworkConn());
        System.out.println("Nº de impresoras: " + info.getNPrinters());
        System.out.println("---------------------------- \n");

        System.out.println("GYM \n");
        Gym gim = new Gym("CL4", 200.0, true, 5000.0, 50);
        gim.setNComputers(0);
        gim.setTableChair(true);
        gim.setNetworkConn(false);
        gim.setNStands(3);
        System.out.println("Código: " + gim.getCode());
        System.out.println("Superfície: " + gim.getSurfaceArea() + "m²");
        System.out.println("Tiene luz natural?: " + gim.getNaturalLight());
        System.out.println("Consumo eléctrico: " + gim.getConsuption() + "Kwh");
        System.out.println("Consumo eléctrico por m²: " + gim.consuptionM2());
        System.out.println("Capacidad máxima: " + gim.getCapacity());
        System.out.println("m² por estudiante: " + gim.surfaceAreaStudent());
        System.out.println("Tiene mesas y sillas?: " + gim.isTableChair());
        System.out.println("Nº de Ordenadores: " + gim.getNComputers());
        System.out.println("Tiene conexión de red?: " + gim.isNetworkConn());
        System.out.println("Tiene duchas?: " + gim.isShower());
        System.out.println("Nº de gradas: " + gim.getNStands());
        System.out.println("---------------------------- \n");






    }
}