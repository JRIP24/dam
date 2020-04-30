public class Program{

    public static void main(String[] args){

        
        Contract c1 = new Contract(12, "30/04/2020", "19/06/2020");
        Company compa1 = new Company(01, "Microsoft", "Informática");
        c1.setCompany(compa1);

        Contract c2 = new Contract(13, "01/04/2021", "05/11/2021");
        Company compa2 = new Company(02, "Apple", "Informática");
        c2.setCompany(compa2);

        Contract c3 = new Contract(14, "09/01/2022", "19/06/2022");

        Company compa3 = new Company(03, "McDonals", "Comida");
        c3.setCompany(compa3);

        Contract c4 = new Contract(15, "09/08/2022", "25/11/2022");
        c4.setCompany(compa1);

        Contract c5 = new Contract(16, "04/11/2021", "05/12/2021");
        c5.setCompany(compa2);//No se firmará, ya que se solapa con la fecha del sugundo contato

        Person p = new Person(2671090, "Ronald");

        p.signContract(c1);
        p.signContract(c2);
        p.signContract(c3);
        p.signContract(c4);
        p.signContract(c5);

        System.out.println("Días trabajados de "  + p.getName() + ": " + p.workedTime());
        System.out.println("Número de empresas en las que ha trabajado: " + p.nCompanies());


    }
}