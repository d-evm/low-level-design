import java.util.ArrayList;
import java.util.List;

class Product {
    final private String name;
    final private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

interface Iterator {
    Product first();
    Product next();
    boolean hasNext();
}

// Concrete iterator
class ProductIterator implements Iterator{
    List<Product> products;
    int current;

    public ProductIterator(List<Product> products) {
        this.products = products;
        current = 0;
    }

    @Override
    public Product first(){
        if (products.isEmpty()){
            return null;
        }
        current = 0;
        return products.get(current);
    }

    @Override
    public Product next(){
        if (hasNext()){
            return products.get(++current);
        }
        return null;
    }

    @Override
    public boolean hasNext(){
        return current < products.size() - 1;
    }
}

// Aggregate class that stores products and provides an iterator
class Inventory{
    List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public Iterator getIterator(){
        return new ProductIterator(products);
    }
}

public class AmazonInventory {
    public static void main(String[] args) {

        Product p1 = new Product("Smartphone", 90_000);
        Product p2 = new Product("Laptop", 190_000);
        Product p3 = new Product("Headphones", 9_000);

        Inventory inventory = new Inventory();
        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);

        Iterator iterator = inventory.getIterator();

        Product currentProduct = iterator.first();

        while (currentProduct != null){
            System.out.println(currentProduct.toString());
            currentProduct = iterator.next();
        }
    }
}
