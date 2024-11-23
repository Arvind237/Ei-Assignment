package Structural;

// Subject Interface
interface Image {
    void display();
}

// Real Subject Class
class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

// Proxy Class
class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

// Client Class
public class ProxyPattern {
    public static void main(String[] args) {
        Image image = new ProxyImage("test.jpg");
        image.display(); // First time: Loads and displays
        System.out.println();
        image.display(); // Second time: Only displays
    }
}
