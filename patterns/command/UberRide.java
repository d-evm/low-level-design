import java.util.ArrayList;
import java.util.List;

// Receiver
class RideService {
    public void requestRide(String from, String to, String passenger){
        System.out.println("Requesting a ride for the passenger: " + passenger);
        System.out.println("From: " + from);
        System.out.println("To: " + to);
    }

    public void cancelRide(String passenger){
        System.out.println("Cancelling ride for passenger: " + passenger);
    }
}

// Command Interface
interface ICommand{
    void execute();
}

// Concrete Command
class RideRequestCommand implements ICommand{
    final private String from;
    final private String to;
    final private String passenger;
    final private RideService rideService;

    RideRequestCommand(RideService service, String f, String t, String p){
        from = f;
        to = t;
        passenger = p;
        rideService = service;
    }

    @Override
    public void execute(){
        rideService.requestRide(from, to, passenger);
    }
}

// Concrete Command
class RideCancelCommand implements ICommand{
    final private String passenger;
    final private RideService rideService;

    RideCancelCommand(RideService service,String p){
        passenger = p;
        rideService = service;
    }

    @Override
    public void execute(){
        rideService.cancelRide(passenger);
    }
}

// Invoker
class RideInvoker{
    List<ICommand> commandHistory = new ArrayList<>();

    public void executeCommand(ICommand command){
        commandHistory.add(command);
        command.execute();
    }
}

public class UberRide {
    public static void main(String[] args) {
        RideService rideService = new RideService();
        ICommand request1 = new RideRequestCommand(rideService, "Electronic City", "Indiranagar", "Ankur");
        ICommand request2 = new RideRequestCommand(rideService, "Whitefield", "Hosur", "Preeti");

        ICommand cancel1 = new RideCancelCommand(rideService, "Ankur");

        RideInvoker rideInvoker = new RideInvoker();

        rideInvoker.executeCommand(request1);
        rideInvoker.executeCommand(request2);
        rideInvoker.executeCommand(cancel1);
    }
}
