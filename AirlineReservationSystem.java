import java.util.Scanner;

class Flight {
    String flightNumber;
    String destination;
    int availableSeats;

    Flight(String flightNumber, String destination, int availableSeats) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }
}

public class AirlineReservationSystem {
    public static void main(String[] args) {
        Flight[] flights = {
                new Flight("F001", "New York", 100),
                new Flight("F002", "Los Angeles", 150)
        };

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. View Flights");
            System.out.println("2. Book a Flight");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayFlights(flights);
                    break;
                case 2:
                    bookFlight(scanner, flights);
                    break;
                case 3:
                    System.out.println("Exiting the Airline Reservation System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayFlights(Flight[] flights) {
        System.out.println("Available Flights:");
        for (Flight flight : flights) {
            System.out.println(flight.flightNumber + " - Destination: " +
                    flight.destination + ", Available Seats: " + flight.availableSeats);
        }
        System.out.println();
    }

    private static void bookFlight(Scanner scanner, Flight[] flights) {
        displayFlights(flights);

        System.out.print("Enter the flight number you want to book: ");
        String flightNumber = scanner.next();

        for (Flight flight : flights) {
            if (flight.flightNumber.equals(flightNumber)) {
                if (flight.availableSeats > 0) {
                    flight.availableSeats--;
                    System.out.println("Seat booked successfully for flight " + flight.flightNumber);
                } else {
                    System.out.println("Sorry, no available seats for flight " + flight.flightNumber);
                }
                return;
            }
        }

        System.out.println("Invalid flight number. Please try again.");
    }
}
