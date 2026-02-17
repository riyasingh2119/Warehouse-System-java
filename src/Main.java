import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        WarehouseSystem warehouse = new WarehouseSystem();

        System.out.println("=== Warehouse Management System ===");

        while (true) {
            System.out.println("\nEnter command: add | view | search | exit");
            String command = sc.nextLine();

            switch (command.toLowerCase()) {
                case "add":
                    warehouse.addProduct(sc);
                    break;

                case "view":
                    warehouse.viewProducts();
                    break;

                case "search":
                    warehouse.searchProduct(sc);
                    break;

                case "exit":
                    System.out.println("System shutting down...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}
