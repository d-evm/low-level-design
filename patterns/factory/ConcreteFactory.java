public class ConcreteFactory extends IAnimalFactory{
    @Override
    public IAnimal GetAnimalType(String type) throws Exception{
        switch (type){
            case "Duck":
                return new Duck();
            case "Tiger":
                return new Tiger();
            default:
                throw new Exception("Animal Type: "+type+" cannot be instantiated.");
        }
    }
}
