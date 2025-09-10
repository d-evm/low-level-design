// Subject Interface
interface Image {
    void display();
}

// RealSubject
// Represents the heavy object that takes time/resources to load
class RealImage implements Image {
    private String filename;

    RealImage(String filename) {
        this.filename = filename;
        loadFromDisk(); // Expensive operation
    }

    private void loadFromDisk() {
        System.out.println("Loading image from disk: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy
// Controls access to RealImage, loading it only when needed
class ProxyImage implements Image {
    private String filename;
    private RealImage realImage; // Will be created only when display() is called

    ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            // Lazy initialization
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Client
public class ImageViewer {
    public static void main(String[] args) {
        // Client interacts only with Proxy, not directly with RealImage

        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // At this point, images are not yet loaded (lazy loading)

        System.out.println("\nFirst time accessing image1:");
        image1.display(); // Loads + displays

        System.out.println("\nSecond time accessing image1:");
        image1.display(); // Already loaded, only displays

        System.out.println("\nAccessing image2:");
        image2.display(); // Loads + displays
    }
}
