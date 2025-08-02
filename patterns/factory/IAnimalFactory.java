abstract class IAnimalFactory {
    IAnimalFactory () {}

    public abstract IAnimal GetAnimalType(String type) throws Exception;
}
