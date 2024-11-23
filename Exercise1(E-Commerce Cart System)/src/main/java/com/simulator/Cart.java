import java.util.*;

public class Cart {
    private Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        if (product.isAvailable()) {
            items.put(product.clone(), items.getOrDefault(product, 0) + quantity);
        } else {
            System.out.println(product.getName() + " is not available.");
        }
    }

    public void removeProduct(String productName) {
        Product toRemove = null;
        for (Product product : items.keySet()) {
            if (product.getName().equalsIgnoreCase(productName)) {
                toRemove = product;
                break;
            }
        }
        if (toRemove != null) {
            items.remove(toRemove);
            System.out.println(productName + " removed from cart.");
        } else {
            System.out.println(productName + " is not in the cart.");
        }
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("Cart Items:");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            System.out.println(entry.getValue() + " x " + entry.getKey().getName() + " @ $" + entry.getKey().getPrice() + " each");
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
}
