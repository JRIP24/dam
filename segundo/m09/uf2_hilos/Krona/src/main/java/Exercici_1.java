public class Exercici_1 {
    static long filID;			// Aquí guardarem el ID del fil del departament 'comandament'.


    static public void inicialitzarPrograma() throws InterruptedException {
        // Fem la variable de tipus magatzem que representarà al magatzem de la nau.
        // Aquest magatzem ha de ser compartit per tots els caps de departament.
        Magatzem magatzemTmp = new Magatzem();

        System.out.println("Inici del main de CapDeDepartament.");

        // Creem els objectes que representaran als cap de departaments:
        CapDeDepartament ojbCapDepartamentComandament = new CapDeDepartament(magatzemTmp, 100);
        CapDeDepartament ojbCapDepartamentArmes = new CapDeDepartament(magatzemTmp, 100);
        CapDeDepartament ojbCapDepartamentTimoINavegacio = new CapDeDepartament(magatzemTmp, 100);
        CapDeDepartament ojbCapDepartamentEnginyeria = new CapDeDepartament(magatzemTmp, 100);
        CapDeDepartament ojbCapDepartamentCiencia = new CapDeDepartament(magatzemTmp, 100);

        // Creem els fils que representaran als cap de departaments:
        Thread filCapDepartamentComandament = new Thread(ojbCapDepartamentComandament);
        filCapDepartamentComandament.setName("Fil del departament 'commandament'");
        filID = filCapDepartamentComandament.getId();

        Thread filCapDepartamentArmes = new Thread(ojbCapDepartamentArmes);
        filCapDepartamentArmes.setName("Fil del departament 'armes'");

        Thread filCapDepartamentTimoINavegacio = new Thread(ojbCapDepartamentTimoINavegacio);
        filCapDepartamentTimoINavegacio.setName("Fil del departament 'timó i navegació'");

        Thread filCapDepartamentEnginyeria = new Thread(ojbCapDepartamentEnginyeria);
        filCapDepartamentEnginyeria.setName("Fil del departament 'enginyeria'");

        Thread filCapDepartamentCiencia = new Thread(ojbCapDepartamentCiencia);
        filCapDepartamentCiencia.setName("Fil del departament 'ciència'");

        // Arranquem els fils que representaran als cap de departaments:
        filCapDepartamentComandament.start();
        filCapDepartamentArmes.start();
        filCapDepartamentTimoINavegacio.start();
        filCapDepartamentEnginyeria.start();
        filCapDepartamentCiencia.start();

        // El fil principal espera a que acabin els fills abans de continuar.
        filCapDepartamentComandament.join();
        filCapDepartamentArmes.join();
        filCapDepartamentTimoINavegacio.join();
        filCapDepartamentEnginyeria.join();
        filCapDepartamentCiencia.join();

        System.out.println("Saldo total (desde el main) = " + magatzemTmp.comprovarQuantitatRacions());
        System.out.println("Final Fil Principal");
    }
}
