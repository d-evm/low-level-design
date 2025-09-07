// Implementor
interface Device{
    void turnOff();
    void turnOn();
}

// Concrete Implementor 1
class TV implements Device{
    @Override
    public void turnOff(){
        System.out.println("TV: OFF");
    }

    @Override
    public void turnOn() {
        System.out.println("TV: ON");
    }
}

// Concrete Implementor 2
class Radio implements Device{
    @Override
    public void turnOff(){
        System.out.println("Radio: OFF");
    }

    @Override
    public void turnOn(){
        System.out.println("Radio: ON");
    }
}

// Abstraction Layer
abstract class Remote{
    protected Device device;

    public Remote(Device device){
        this.device = device;
    }

    abstract void turnOff();
    abstract void turnOn();
}

// Refined Abtraction
class BasicRemote extends Remote{
    public BasicRemote(Device d){
        super(d);
    }

    @Override
    public void turnOff(){
        device.turnOff();
    }

    @Override
    public void turnOn(){
        device.turnOn();
    }
}

public class RemoteAndDevices {
    public static void main(String[] args) {
        Device tv = new TV();
        Device radio = new Radio();

        Remote basicRemoteTV = new BasicRemote(tv);
        Remote basicRemoteRadio = new BasicRemote(radio);

        // Turning TV ON/OFF
        basicRemoteTV.turnOn();
        basicRemoteTV.turnOff();

        // Turning Radio ON/OFF
        basicRemoteRadio.turnOn();
        basicRemoteRadio.turnOff();

    }
}
