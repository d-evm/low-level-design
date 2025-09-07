// --------- Implementor ---------
// This is the interface for navigation apps (the "implementation" part of the bridge)
interface NavigationApp {
    void navigateTo(String destination);
}

// --------- Concrete Implementors ---------
// These are the actual navigation apps
class AppleMaps implements NavigationApp {
    @Override
    public void navigateTo(String destination) {
        System.out.println("Apple Maps: Navigating to " + destination);
    }
}

class GoogleMaps implements NavigationApp {
    @Override
    public void navigateTo(String destination) {
        System.out.println("Google Maps: Navigating to " + destination);
    }
}

// --------- Abstraction ---------
// This represents the service that uses a navigation app
abstract class UberService {
    protected NavigationApp navigationApp;

    public UberService(NavigationApp app) {
        this.navigationApp = app;
    }

    abstract void navigate(String destination);
}

// --------- Refined Abstractions ---------
// Different Uber services using the navigation apps
class UberRide extends UberService {
    public UberRide(NavigationApp app) {
        super(app);
    }

    @Override
    void navigate(String destination) {
        // Delegates the navigation task to the navigation app
        navigationApp.navigateTo(destination);
    }
}

class UberEats extends UberService {
    public UberEats(NavigationApp app) {
        super(app);
    }

    @Override
    void navigate(String destination) {
        // Delegates the navigation task to the navigation app
        navigationApp.navigateTo(destination);
    }
}

// --------- Client ---------
public class UberAndMaps {
    public static void main(String[] args) {
        // Create concrete navigation apps
        NavigationApp appleMaps = new AppleMaps();
        NavigationApp googleMaps = new GoogleMaps();

        // Connect Uber services with different navigation apps
        UberService rideService = new UberRide(appleMaps);
        UberService foodService = new UberEats(googleMaps);

        // Both services can navigate using different apps without changing the service code
        rideService.navigate("Bandra");   // Output: Apple Maps: Navigating to Bandra
        foodService.navigate("Worli");    // Output: Google Maps: Navigating to Worli
    }
}
