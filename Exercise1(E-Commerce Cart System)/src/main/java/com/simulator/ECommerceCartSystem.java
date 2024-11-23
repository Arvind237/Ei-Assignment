import java.util.*;

public class ECommerceCartSystem {
    public static void main(String[] args) {
        // Product List
        List<Product> productList = new ArrayList<>();
        productList.add(new Electronics("Laptop", 1000, true));
        productList.add(new Accessories("Headphones", 50, true));
        productList.add(new Electronics("Smartphone", 800, true));
        productList.add(new Accessories("Mouse", 20, true));

        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the E-Commerce Store!");

        // Display Product List
        System.out.println("Available Products:");
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            System.out.println((i + 1) + ". " + product.getName() + " - $" + product.getPrice() + (product.isAvailable() ? " [In Stock]" : " [Out of Stock]"));
        }

        // Adding to Cart
        while (true) {
            System.out.print("Enter the product name to add to the cart (or type 'done' to finish adding): ");
            String productName = scanner.nextLine();
            if (productName.equalsIgnoreCase("done")) {
                break;
            }

            Product selectedProduct = productList.stream()
                    .filter(p -> p.getName().equalsIgnoreCase(productName))
                    .findFirst()
                    .orElse(null);

            if (selectedProduct != null && selectedProduct.isAvailable()) {
                System.out.print("Enter the quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                cart.addProduct(selectedProduct, quantity);
            } else {
                System.out.println("Product not found or unavailable.");
            }
        }

        // Optional: Remove Products from Cart
        System.out.print("Do you want to remove any items from the cart? (yes/no): ");
        String removeChoice = scanner.nextLine();
        if (removeChoice.equalsIgnoreCase("yes")) {
            while (true) {
                System.out.print("Enter the product name to remove (or type 'done' to finish): ");
                String productName = scanner.nextLine();
                if (productName.equalsIgnoreCase("done")) {
                    break;
                }
                cart.removeProduct(productName);
            }
        }

        // Display Final Cart and Total
        System.out.println("\nYour Cart:");
        cart.displayCart();
        System.out.println("Total Bill: $" + cart.calculateTotal());
        System.out.println("Thank you for shopping!");
    }
}

