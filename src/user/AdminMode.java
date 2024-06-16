package user;

import model.Booking;
import model.Concert;
import model.Customer;
import utils.DataLoader;


import java.util.*;

public class AdminMode {
    public void run(String[] filePaths) {
        try {
            DataLoader dataLoader = new DataLoader();
            List<Customer> customers = dataLoader.loadCustomers(filePaths[0]);
            List<Concert> concerts = dataLoader.loadConcerts(filePaths[1]);
            List<Booking> bookings = dataLoader.loadBookings(filePaths[2]);
            dataLoader.loadVenues(filePaths);

            System.out.println("Welcome to Ticket Management System Admin Mode.");

            Scanner scanner = new Scanner(System.in);
            boolean running = true;
            while (running) {
                System.out.println("Select an option to get started!");
                System.out.println("Press 1 to view all the concert details");
                System.out.println("Press 2 to update the ticket costs");
                System.out.println("Press 3 to view booking details");
                System.out.println("Press 4 to view total payment received for a concert");
                System.out.println("Press 5 to exit");
                System.out.print("> ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        DataLoader.displayConcerts(concerts);
                        break;
                    case 2:
                        DataLoader.updateTicketCosts(concerts, scanner);
                        break;
                    case 3:
                        // Implement logic to view booking details
                        break;
                    case 4:
                        // Implement logic to view total payment received
                        break;
                    case 5:
                        running = false;
                        System.out.println("Exiting program.");
                        break;
                    default:
                        System.out.println("Invalid Input. Please try again.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
