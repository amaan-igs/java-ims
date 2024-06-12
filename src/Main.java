import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Inventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Delete Product");
            System.out.println("3. Display Products");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();

                    Product product = new Product(name, quantity, price);
                    manager.addProduct(product);
                    break;

                case 2:
                    System.out.print("Enter product ID to delete: ");
                    int productId = scanner.nextInt();
                    manager.deleteProduct(productId);
                    break;

                case 3:
                    List<Product> products = manager.getAllProducts();
                    System.out.println("Product List:");
                    for (Product p : products) {
                        System.out.println("ID: " + p.getId() + ", Name: " + p.getName() + ", Quantity: " + p.getQuantity() + ", Price: " + p.getPrice());
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
