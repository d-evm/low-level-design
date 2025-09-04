// Template
abstract class OrderProcessingTemplate {
    // Concrete method - Sequence of steps (must not vary)
    final public void processOrder(){
        verifyPayment();
        assignDeliveryPartner();
        trackOrder();
    }

    // Abstract methods - Implemented by the classes individually
    abstract protected void verifyPayment();
    abstract protected void assignDeliveryPartner();
    abstract protected void trackOrder();
}

// Concrete subclasses - for amazon.com
class AmazonInternational extends OrderProcessingTemplate{
    @Override
    protected void verifyPayment() {
        System.out.println("[amazon.com] Verifying payment for international order.");
    }

    @Override
    protected void assignDeliveryPartner() {
        System.out.println("[amazon.com] Assigning delivery partner for international order.");
    }

    @Override
    protected void trackOrder() {
        System.out.println("[amazon.com] Tracking international order.");
    }
}

// Concrete subclasses - for amazon.in
class AmazonIndia extends OrderProcessingTemplate{
    @Override
    protected void verifyPayment() {
        System.out.println("[amazon.in] Verifying payment for Indian order.");
    }

    @Override
    protected void assignDeliveryPartner() {
        System.out.println("[amazon.in] Assigning delivery partner for Indian order.");
    }

    @Override
    protected void trackOrder() {
        System.out.println("[amazon.in] Tracking Indian order.");
    }
}

public class AmazonOrderProcessor {
    public static void main(String[] args) {
        // Place order on amazon.com
        OrderProcessingTemplate internationalOrder = new AmazonInternational();
        internationalOrder.processOrder();

        // Place order on amazon.in
        OrderProcessingTemplate indianOrder = new AmazonIndia();
        indianOrder.processOrder();
    }
}
