package classstructuremethods;

public class ClientMain {
    public static void main(String[] args) {
        Client client=new Client();
        client.setName("Gábor Áron");
        client.setYear(1844);
        client.setAddress("Világos, Rézágyú utca 1.");

        System.out.println("Name:" + client.getName());
        System.out.println("Birth:" + client.getYear());
        System.out.println("Address:" + client.getAddress());

        client.migrate("Arad, Hősök tere");
        System.out.println("New address:" + client.getAddress());

    }
}
