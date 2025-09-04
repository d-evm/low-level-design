class PaymentStrategyFactory{
    public static PaymentStrategy getPaymentStrategy(String input){
        return switch (input) {
            case "UPI" -> new UPIPayment();
            case "CreditCard" -> new CreditCardPayment();
            case "Crypto" -> new CryptoPayment();
            default -> null;
        };
    }
}

class PaymentProcessorWithFactory{
    private PaymentStrategy strategy;

    PaymentProcessorWithFactory(){
        strategy = null;
    }

    // Takes responsibility of PaymentStrategy creation using Factory
    public void setStrategy(String paymentMethod) {
        this.strategy = PaymentStrategyFactory.getPaymentStrategy(paymentMethod);

        System.out.println("Payment method: " + strategy);
    }

    public void processPayment(double amount){
        if (strategy == null){
            System.err.println("Payment method not set.");
            return;
        }

        strategy.processPayment(amount);
    }
}

public class PaymentServiceWithFactory {
    public static void main(String[] args) {
        // better abstraction than PaymentService

        PaymentProcessorWithFactory processor = new PaymentProcessorWithFactory();

        processor.setStrategy("UPI");
        processor.processPayment(130.0);

        processor.setStrategy("Crypto");
        processor.processPayment(12.0);

    }
}
