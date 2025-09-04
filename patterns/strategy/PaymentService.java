// Strategy Interface
interface PaymentStrategy {
    void processPayment(double amount);
}

// Concrete strategies
class UPIPayment implements PaymentStrategy{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment through UPI of amount: " + amount);
    }
}

class CreditCardPayment implements PaymentStrategy{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment through credit card of amount: " + amount);
    }
}

class CryptoPayment implements PaymentStrategy{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment through crypto of amount: " + amount);
    }
}

class PaymentProcessor{
    private PaymentStrategy strategy;

    PaymentProcessor(){
        strategy = null;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;

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

public class PaymentService {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        // select and set a strategy at runtime
        PaymentStrategy strategy = new CreditCardPayment();
        paymentProcessor.setStrategy(strategy);

        // process the payment
        paymentProcessor.processPayment(500.0);

        // change the strategy
        strategy = new UPIPayment();
        paymentProcessor.setStrategy(strategy);

        paymentProcessor.processPayment(250.0);
    }
}
