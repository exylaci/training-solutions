package meetingrooms;

import java.util.Scanner;

public class Controller {
    private Office office;

    public void readOffice() {
        Office office = new Office();
        this.office = office;

        System.out.println("Add meg a tárgyalók adatait! (Üres név, bevitel vége.)");
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Tárgyaló neve: ");
            String name = scanner.nextLine();
            if (name.length() == 0) {
                break;
            }
            System.out.print("Hossza: ");
            int length = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Szélessége: ");
            int width = scanner.nextInt();
            scanner.nextLine();
            office.addMeetingRoom(new MeetingRoom(name, length, width));
        } while (true);
        // office.printAreas();
    }

    public void printMenu() {
        System.out.println();
        System.out.println("\n" +
                "1. Tárgyalók sorrendben\n" +
                "2. Tárgyalók visszafelé sorrendben\n" +
                "3. Minden második tárgyaló\n" +
                "4. Területek\n" +
                "5. Keresés pontos név alapján\n" +
                "6. Keresés névtöredék alapján\n" +
                "7. Keresés terület alapján\n" +
                "8. Kilépés\n" +
                "Válassz egyet!");
    }

    public boolean runMenu() {
        Scanner scanner = new Scanner(System.in);

        int selection;
        try {
            selection = scanner.nextInt();
        } catch (Exception e) {
            selection = 0;
        }
        scanner.nextLine();

        switch (selection) {
            case 1:
                office.printNames();
                break;
            case 2:
                office.printNamesReverse();
                break;
            case 3:
                office.printEvenNames();
                break;
            case 4:
                office.printAreas();
                break;
            case 5:
                System.out.println("Mi a meeting room neve?");
                office.printMeetingRoomsWithName(scanner.nextLine());
                break;
            case 6:
                System.out.println("Adj meg egy részletet a meeting room nevéből!");
                office.printMeetingRoomsContains(scanner.nextLine());
                break;
            case 7:
                System.out.println("Mennyinél nagyobb területű meeting roomot keresel?");
                int size = scanner.nextInt();
                scanner.nextLine();
                office.printAreasLargerThan(size);
                break;
        }
        return selection != 8;
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.readOffice();
        do {
            controller.printMenu();
        } while (controller.runMenu());
    }
}
