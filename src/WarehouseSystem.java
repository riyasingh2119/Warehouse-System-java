import java.util.Scanner;

class Product {
    String name;
    int quantity;
    double price;

    Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    void display() {
        System.out.println("Product Name: " + name);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: $" + price);
        System.out.println("------------------------");
    }
}

public class WarehouseSystem {

    static Product[] products = new Product[100];
    static int count = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String command;

        System.out.println("=== Warehouse Management System ===");

        while (true) {
            System.out.println("\nType command: add | view | exit");
            command = sc.nextLine();

            if (command.equalsIgnoreCase("add")) {
                addProduct(sc);
            }
            else if (command.equalsIgnoreCase("view")) {
                viewProducts();
            }
            else if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting system...");
                break;
            }
            else {
                System.out.println("Invalid command!");
            }
        }

        sc.close();
    }

    static void addProduct(Scanner sc) {
        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();
        sc.nextLine(); // consume newline

        products[count] = new Product(name, quantity, price);
        count++;

        System.out.println("Product added successfully!");
    }

    static void viewProducts() {
        if (count == 0) {
            System.out.println("No products in warehouse.");
            return;
        }

        for (int i = 0; i < count; i++) {
            products[i].display();
        }
    }
}

