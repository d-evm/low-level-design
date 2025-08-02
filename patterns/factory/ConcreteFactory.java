class ConcreteFactory extends IAnimalFactory{
    @Override
    public IAnimal GetAnimalType(String type) throws Exception{
        return switch (type) {
            case "Duck" -> new Duck();
            case "Tiger" -> new Tiger();
            default -> throw new Exception("Animal Type: " + type + " cannot be instantiated.");
        };
    }
}
