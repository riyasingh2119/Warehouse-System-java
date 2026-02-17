import java.util.ArrayList;
import java.util.Scanner;

// Item class
class Item {
    String name;
    double price;
    String category;

    Item(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}

// CartItem class (to store item + quantity)
class CartItem {
    Item item;
    int quantity;

    CartItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}

// ShoppingCart class
class ShoppingCart {
    ArrayList<CartItem> items = new ArrayList<>();

    void addItem(Item item, int quantity) {
        items.add(new CartItem(item, quantity));
    }

    double calculateTotal() {
        double total = 0;
        for (CartItem cartItem : items) {
            total += cartItem.item.price * cartItem.quantity;
        }
        return total + total * 0.05; // 5% GST
    }

    void showItems() {
        if (items.isEmpty()) {
            System.out.println("\nYour cart is empty!\n");
            return;
        }

        System.out.println("\nYour Cart:");
        System.out.println("----------");

        for (CartItem cartItem : items) {
            double subtotal = cartItem.item.price * cartItem.quantity;
            System.out.println(cartItem.item.name + " x "
                    + cartItem.quantity + " = ₹" + subtotal);
        }

        System.out.println("GST: \t 5%");
        System.out.println("----------");
        System.out.println("Total: ₹" + calculateTotal());
        System.out.println();
    }
}

// Main class
class ShoppingMart {

    static ArrayList<Item> storeItems = new ArrayList<>();

    static void showMenu() {
        System.out.println("Welcome to Shopping Mart!");
        System.out.println("\n1. Show available items");
        System.out.println("2. Add item to cart");
        System.out.println("3. View cart");
        System.out.println("4. Checkout");
        System.out.println("5. Exit");
    }

    static void showStoreItems() {
        System.out.println("\nAvailable Items:");
        System.out.println("---------------");
        for (int i = 0; i < storeItems.size(); i++) {
            Item item = storeItems.get(i);
            System.out.println((i + 1) + ". " + item.name +
                    " - ₹" + item.price + " (" + item.category + ")");
        }
        System.out.println("---------------");
    }

    public static void main(String[] args) {

        // Create store items
        storeItems.add(new Item("Apple", 50, "Fruit"));
        storeItems.add(new Item("Banana", 30, "Fruit"));
        storeItems.add(new Item("Milk", 55, "Dairy"));
        storeItems.add(new Item("Bread", 40, "Bakery"));

        ShoppingCart cart = new ShoppingCart();
        Scanner sc = new Scanner(System.in);

        while (true) {
            showMenu();
            System.out.print("\nEnter your choice (1-5): ");
            String choice = sc.nextLine();

            switch (choice) {

                case "1":
                    showStoreItems();
                    break;

                case "2":
                    showStoreItems();
                    try {
                        System.out.print("Enter item number: ");
                        int itemNum = Integer.parseInt(sc.nextLine());

                        if (itemNum >= 1 && itemNum <= storeItems.size()) {

                            System.out.print("Enter quantity: ");
                            int quantity = Integer.parseInt(sc.nextLine());

                            cart.addItem(storeItems.get(itemNum - 1), quantity);

                            System.out.println("\n" + quantity + " " +
                                    storeItems.get(itemNum - 1).name +
                                    "(s) added to cart!");

                        } else {
                            System.out.println("Invalid item number!");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Please enter numbers only!");
                    }
                    break;

                case "3":
                    cart.showItems();
                    break;

                case "4":
                    System.out.println("\n===== YOUR BILL =====");
                    System.out.println("Your cashier:\tRIYA");
                    cart.showItems();
                    System.out.println("Thank you for shopping with us!");
                    sc.close();
                    return;

                case "5":
                    System.out.println("\nThank you! Visit again!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
