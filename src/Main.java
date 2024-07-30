import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Destination {
    private String name;
    private String country;
    private String description;

    public Destination(String name, String country, String description) {
        this.name = name;
        this.country = country;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Destination{name='" + name + "', country='" + country + "', description='" + description + "'}";
    }
}

class Itinerary {
    private String tripName;
    private List<Destination> destinations;
    private String startDate;
    private String endDate;

    public Itinerary(String tripName, String startDate, String endDate) {
        this.tripName = tripName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.destinations = new ArrayList<>();
    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public void removeDestination(Destination destination) {
        destinations.remove(destination);
    }

    @Override
    public String toString() {
        return "Itinerary{tripName='" + tripName + "', startDate='" + startDate + "', endDate='" + endDate + "', destinations=" + destinations + "}";
    }
}

class TravelApp {
    private List<Destination> destinations;
    private List<Itinerary> itineraries;

    public TravelApp() {
        destinations = new ArrayList<>();
        itineraries = new ArrayList<>();
    }

    public void addDestination(String name, String country, String description) {
        Destination destination = new Destination(name, country, description);
        destinations.add(destination);
    }

    public void viewDestinations() {
        for (Destination destination : destinations) {
            System.out.println(destination);
        }
    }

    public void removeDestination(String name) {
        destinations.removeIf(destination -> destination.toString().contains(name));
    }

    public void createItinerary(String tripName, String startDate, String endDate) {
        Itinerary itinerary = new Itinerary(tripName, startDate, endDate);
        itineraries.add(itinerary);
    }

    public void viewItineraries() {
        for (Itinerary itinerary : itineraries) {
            System.out.println(itinerary);
        }
    }

    public void deleteItinerary(String tripName) {
        itineraries.removeIf(itinerary -> itinerary.toString().contains(tripName));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TravelApp travelApp = new TravelApp();

        while (true) {
            System.out.println("Travel App Menu:");
            System.out.println("1. Add Destination");
            System.out.println("2. View Destinations");
            System.out.println("3. Remove Destination");
            System.out.println("4. Create Itinerary");
            System.out.println("5. View Itineraries");
            System.out.println("6. Delete Itinerary");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter destination name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter country: ");
                    String country = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    travelApp.addDestination(name, country, description);
                    break;
                case 2:
                    travelApp.viewDestinations();
                    break;
                case 3:
                    System.out.print("Enter destination name to remove: ");
                    name = scanner.nextLine();
                    travelApp.removeDestination(name);
                    break;
                case 4:
                    System.out.print("Enter trip name: ");
                    String tripName = scanner.nextLine();
                    System.out.print("Enter start date: ");
                    String startDate = scanner.nextLine();
                    System.out.print("Enter end date: ");
                    String endDate = scanner.nextLine();
                    travelApp.createItinerary(tripName, startDate, endDate);
                    break;
                case 5:
                    travelApp.viewItineraries();
                    break;
                case 6:
                    System.out.print("Enter trip name to delete: ");
                    tripName = scanner.nextLine();
                    travelApp.deleteItinerary(tripName);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
