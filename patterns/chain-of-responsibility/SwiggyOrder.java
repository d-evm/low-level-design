// Abstract base class
abstract class OrderHandler{
    protected OrderHandler nextHandler;

    OrderHandler(OrderHandler next){
        nextHandler = next;
    }

    abstract void processOrder(String order);
}

// Concrete Handlers
class OrderValidationHandler extends OrderHandler{
    OrderValidationHandler(OrderHandler next){
        super(next);
    }

    @Override
    void processOrder(String order){

        if (order == null || order.isEmpty()) {
            System.out.println("Invalid order. Stopping process.");
            return; // break the chain
        }


        System.out.println("Validating order: " + order);

        // order validation logic

        if (nextHandler != null){
            nextHandler.processOrder(order);
        }
    }
}

class PaymentProcessingHandler extends OrderHandler{
    PaymentProcessingHandler(OrderHandler next){
        super(next);
    }

    @Override
    void processOrder(String order){
        System.out.println("Processing payment for order: " + order);

        // payment processing logic

        if (nextHandler != null){
            nextHandler.processOrder(order);
        }
    }
}

class OrderPreparationHandler extends OrderHandler{
    OrderPreparationHandler(OrderHandler next){
        super(next);
    }

    @Override
    void processOrder(String order){
        System.out.println("Processing order: " + order);

        // order processing logic

        if (nextHandler != null){
            nextHandler.processOrder(order);
        }
    }
}

class DeliveryAssignmentHandler extends OrderHandler{
    DeliveryAssignmentHandler(OrderHandler next){
        super(next);
    }

    @Override
    void processOrder(String order){
        System.out.println("Delivering order: " + order);

        // order processing logic

        if (nextHandler != null){
            nextHandler.processOrder(order);
        }
    }
}

class OrderTrackingHandler extends OrderHandler{
    OrderTrackingHandler(OrderHandler next){
        super(next);
    }

    @Override
    void processOrder(String order){
        System.out.println("Tracking order: " + order);

        // order processing logic

        if (nextHandler != null){
            nextHandler.processOrder(order);
        }
    }
}

class OrderHandlerChainBuilder{
    private OrderHandler head;
    private OrderHandler tail;

    public OrderHandlerChainBuilder addHandler(OrderHandler handler){
        if (head == null){
            head = handler;
            tail = handler;
        } else {
            tail.nextHandler = handler;
            tail = handler;
        }
        return this;
    }

    public OrderHandler build(){
        return head;
    }
}

public class SwiggyOrder {
    public static void main(String[] args) {
        String order = "Pizza";

        // Approach-1: Easier approach but not very flexible or usable
//        OrderHandler orderProcessingChain = new OrderValidationHandler(
//                new PaymentProcessingHandler(
//                        new OrderPreparationHandler(
//                                new DeliveryAssignmentHandler(
//                                        new OrderTrackingHandler(null)))));


        // Approach 2: Making it reusable and dynamic
        OrderHandler orderProcessingChain = new OrderHandlerChainBuilder()
                .addHandler(new OrderValidationHandler(null))
                .addHandler(new PaymentProcessingHandler(null))
                .addHandler(new OrderPreparationHandler(null))
                .addHandler(new DeliveryAssignmentHandler(null))
                .addHandler(new OrderTrackingHandler(null))
                .build();

        orderProcessingChain.processOrder(order);
    }
}
