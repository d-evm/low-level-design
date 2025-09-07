// Component Interface
interface Coffee{
    String getDescription();
    double getCost();
}

// Concrete Component
class SimpleCoffee implements Coffee{
    @Override
    public String getDescription(){
        return "Simple Coffee";
    }

    @Override
    public double getCost(){
        return 100.0;
    }
}

// Base Decorator
abstract class CoffeeDecorator implements Coffee{
    Coffee coffee;

    CoffeeDecorator(Coffee c){
        coffee = c;
    }

    @Override
    public String getDescription(){
        return coffee.getDescription();
    }

    @Override
    public double getCost(){
        return coffee.getCost();
    }
}

// Concrete Decorator
class MilkDecorator extends CoffeeDecorator{
    MilkDecorator(Coffee c){
        super(c);
    }

    @Override
    public String getDescription(){
        return coffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost(){
        return coffee.getCost() + 80.0;
    }
}

class SugarDecorator extends CoffeeDecorator{
    SugarDecorator(Coffee c){
        super(c);
    }

    @Override
    public String getDescription(){
        return coffee.getDescription() + ", Sugar";
    }

    @Override
    public double getCost(){
        return coffee.getCost() + 15.0;
    }
}

class CaramelDecorator extends CoffeeDecorator{
    CaramelDecorator(Coffee c){
        super(c);
    }

    @Override
    public String getDescription(){
        return coffee.getDescription() + ", Caramel";
    }

    @Override
    public double getCost(){
        return coffee.getCost() + 50.0;
    }
}

public class CoffeeShop {
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println(simpleCoffee.getDescription());
        System.out.println(simpleCoffee.getCost());

        System.out.println();

        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println(milkCoffee.getDescription());
        System.out.println(milkCoffee.getCost());

        System.out.println();

        Coffee caramelCoffee = new CaramelDecorator(simpleCoffee);
        System.out.println(caramelCoffee.getDescription());
        System.out.println(caramelCoffee.getCost());

        System.out.println();

        Coffee milkSugarCoffee = new SugarDecorator(milkCoffee);
        System.out.println(milkSugarCoffee.getDescription());
        System.out.println(milkSugarCoffee.getCost());
    }
}
