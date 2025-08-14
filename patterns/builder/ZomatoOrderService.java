class FoodOrder {
    private final String restaurant;
    private final String cuisine;
    private final int deliveryTime;
    private final boolean isVeg;
    private final String specialInstructions;

    private FoodOrder(FoodOrderBuilder builder){
        this.restaurant = builder.restaurant;
        this.cuisine = builder.cuisine;
        this.deliveryTime = builder.deliveryTime;
        this.isVeg = builder.isVeg;
        this.specialInstructions = builder.specialInstructions;
    }

    @Override
    public String toString() {
        return "FoodOrder{" +
                "restaurant='" + restaurant + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", deliveryTime=" + deliveryTime +
                ", isVeg=" + isVeg +
                ", specialInstructions='" + specialInstructions + '\'' +
                '}';
    }

    static FoodOrderBuilder builder(){
        return new FoodOrderBuilder();
    }

    static class FoodOrderBuilder {
        private String restaurant;
        private String cuisine;
        private int deliveryTime;
        private boolean isVeg;
        private String specialInstructions;


        public FoodOrderBuilder setRestaurant(String restaurant) {
            this.restaurant = restaurant;
            return this;
        }

        public FoodOrderBuilder setCuisine(String cuisine) {
            this.cuisine = cuisine;
            return this;
        }

        public FoodOrderBuilder setDeliveryTime(int deliveryTime) {
            this.deliveryTime = deliveryTime;
            return this;
        }

        public FoodOrderBuilder setIsVeg(boolean isVeg) {
            this.isVeg = isVeg;
            return this;
        }

        public FoodOrderBuilder setSpecialInstructions(String specialInstructions) {
            this.specialInstructions = specialInstructions;
            return this;
        }

        public FoodOrder build(){
            return new FoodOrder(this);
        }
    }
}

class FoodOrderDirector{
    public void constructIndianVegMeal (FoodOrder.FoodOrderBuilder builder){
        builder.setRestaurant("The Great Dhaba")
                .setCuisine("Kadai Paneer with Kulcha")
                .setIsVeg(true)
                .setDeliveryTime(30);
    }

    public void constructGourmetMeal (FoodOrder.FoodOrderBuilder builder){
        builder.setRestaurant("Cavioli's place")
                .setCuisine("Chicken Empandas with French 75")
                .setIsVeg(false)
                .setDeliveryTime(40);
    }
}

public class ZomatoOrderService {
    public static void main(String[] args) {

        // creation using a Builder
        FoodOrder customOrder = FoodOrder.builder()
                .setRestaurant("La pizzeria")
                .setCuisine("Pepperoni Pizza")
                .setIsVeg(false)
                .setDeliveryTime(20)
                .setSpecialInstructions("More cheese!")
                .build();
        System.out.println("Custom order: " + customOrder.toString());

        // creating FoodOrder object using a Director
        // used when a template can be followed for creation of objects
        FoodOrderDirector director = new FoodOrderDirector();

        FoodOrder.FoodOrderBuilder vegMealBuilder = new FoodOrder.FoodOrderBuilder();
        director.constructIndianVegMeal(vegMealBuilder);
        FoodOrder vegMealOrder = vegMealBuilder.build();
        System.out.println("Veg Meal:" + vegMealOrder.toString());

        FoodOrder.FoodOrderBuilder gourmetBuilder = new FoodOrder.FoodOrderBuilder();
        director.constructGourmetMeal(gourmetBuilder);
        FoodOrder gourmetMealOrder = gourmetBuilder.build();
        System.out.println("Gourmet Meal: " + gourmetMealOrder.toString());
    }
}
