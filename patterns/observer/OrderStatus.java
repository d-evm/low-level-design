import java.util.ArrayList;
import java.util.List;

class Order {
    private int id;
    private String status;
    private List<Observer> observers;

    public Order(int id) {
        this.id = id;
        this.status = "Order placed";
        this.observers = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status){
        this.status = status;
        notifyObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
        System.out.println(observer.getName() + " attached successfully.");
    }

    public void detach(Observer observer){
        observers.remove(observer);
        System.out.println(observer.getName() + " detached successfully.");
    }

    public void notifyObservers(){
        for (Observer observer : observers){
            observer.update(this);
        }
    }

}

interface Observer {
    void update(Order order);
    String getName();
}

class Restaurant implements Observer{
    String name;

    public Restaurant(String name) {
        this.name = name;
    }

    @Override
    public void update(Order order){
        System.out.println("Restaurant: " + order.getId() + " - " + order.getStatus());
    }

    @Override
    public String getName(){
        return this.name;
    }
}

class Customer implements Observer{
    String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(Order order){
        System.out.println("Customer: " + order.getId() + " - " + order.getStatus());
    }

    @Override
    public String getName(){
        return this.name;
    }
}

class CallCenter implements Observer{
    String name;

    public CallCenter(String name) {
        this.name = name;
    }

    @Override
    public void update(Order order){
        System.out.println("Call Center: " + order.getId() + " - " + order.getStatus());
    }

    @Override
    public String getName(){
        return this.name;
    }
}

class DeliveryPartner implements Observer{
    String name;

    public DeliveryPartner(String name) {
        this.name = name;
    }

    @Override
    public void update(Order order){
        System.out.println("Delivery Partner: " + order.getId() + " - " + order.getStatus());
    }

    @Override
    public String getName(){
        return this.name;
    }
}

public class OrderStatus {
    public static void main(String[] args) {
        // create an order
        Order order1 = new Order(1022);

        // create restaurant, customer, callCenter, deliveryPartner to notify
        Restaurant restaurant = new Restaurant("Bistro");
        Customer customer = new Customer("John Doe");
        CallCenter callCenter = new CallCenter("Andheri west");
        DeliveryPartner deliveryPartner = new DeliveryPartner("Manoj");

        // add observers with order1
        order1.attach(restaurant);
        order1.attach(customer);
        order1.attach(callCenter);
        order1.attach(deliveryPartner);
        System.out.println("--------------------------------------------");

        // simulate order updates
        order1.setStatus("Out for delivery");
        System.out.println("--------------------------------------------");

        // detach an observer when not needed
        order1.detach(callCenter);
        System.out.println("--------------------------------------------");

        // simulate order updates
        order1.setStatus("Delivered");
        System.out.println("--------------------------------------------");
    }


}
