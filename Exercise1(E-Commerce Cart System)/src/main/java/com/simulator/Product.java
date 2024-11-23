public abstract class Product implements Cloneable {
    protected String name;
    protected double price;
    protected boolean available;

    public Product(String name, double price, boolean available) {
        this.name = name;
        this.price = price;
        this.available = available;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return available; }

    @Override
    public Product clone() {
        try {
            return (Product) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }
}
