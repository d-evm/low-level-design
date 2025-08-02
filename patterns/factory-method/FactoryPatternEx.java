public class FactoryPatternEx {
    public static void main(String[] args) throws Exception{
        System.out.println("***Factory Pattern Demo***\n");

        IAnimalFactory animalFactory = new ConcreteFactory();

        IAnimal DuckType = animalFactory.GetAnimalType("Duck");
        DuckType.speak();

        IAnimal TigerType = animalFactory.GetAnimalType("Tiger");
        TigerType.speak();

        // Following throws exception as there is no Animal type as "Lion"
//        IAnimal LionType = animalFactory.GetAnimalType("Lion");
//        LionType.speak();
    }
}
