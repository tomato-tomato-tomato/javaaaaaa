package user;

import model.*;
import utils.*;
import java.io.Console;
import java.util.*;

public class CustomerMode {
    private List<Booking> currentBookings;

    public void run(String[] filePaths) {
        String customerFilePath, concertFilePath, bookingFilePath;
        String[] venueFilePaths;
        String customerId = null;
        String password = null;
        int startIdx = 0;

        // Check if customer ID and password are provided
        if (filePaths.length > 3 && !filePaths[0].startsWith("/")) {
            customerId = filePaths[0];
            password = filePaths[1];
            startIdx = 2;
        }

        // Adjust file paths based on whether ID and password were provided
        customerFilePath = filePaths[startIdx];
        concertFilePath = filePaths[startIdx + 1];
        bookingFilePath = filePaths[startIdx + 2];
        venueFilePaths = Arrays.copyOfRange(filePaths, startIdx + 3, filePaths.length);

        try {

            // Read customer data
//            DataLoader dataLoader = new DataLoader();
            CustomerDataLoader customerDataLoader = new CustomerDataLoader();
            List<Object> customers = customerDataLoader.load(customerFilePath);

            // Read concert data
//            List<Concert> concerts = dataLoader.loadConcerts(concertFilePath);
            ConcertDataLoader concertDataLoader = new ConcertDataLoader();
            List<Object> concerts = concertDataLoader.load(concertFilePath);


            // Read booking data
//            List<Booking> bookings = dataLoader.loadBookings(bookingFilePath);
            BookingDataLoader bookingDataLoader = new BookingDataLoader();
//            currentBookings = new ArrayList<>(bookings);
            List<Object> bookings = bookingDataLoader.load(bookingFilePath);


            // Load venue layout
            VenueDataLoader venueDataLoader = new VenueDataLoader();
            for (String i:venueFilePaths){
                List<Venue> venues = venueDataLoader.loadData(i);
            }

            if (customerId != null && password != null) {
                // Cross reference the provided ID and password with the customer file
                boolean validCustomer = false;
                String customerName = "";
                for (Object i : customers)
                    if (Customer.getId().equals(customerId) && Customer.getPassword().equals(password)) {
                        validCustomer = true;
                        customerName = Customer.getName();
                        break;
                    }

                if (!validCustomer) {
                    System.out.println("Invalid customer ID or password. Please try again.");
                    return;
                } else {
                    System.out.println("Welcome, " + Customer.getName());
                    //selectConcert(concerts, venue, customerId, customerName);
                }
            } else {
                // Prompt for customer ID and password
                Console console = System.console();
                if (console == null) {
                    System.out.println("No console available. Please run the program in an interactive environment.");
                    return;
                }
                String customerName = console.readLine("Enter your name: ");
                password = new String(console.readPassword("Enter your password: "));

                // Add new customer to the customer file
                Customer newCustomer = new Customer(null, customerName, password);
                customers.add(newCustomer);
                FileHandler.saveCustomers(List.of(newCustomer), customerFilePath);

                System.out.println("Welcome " + customerName + " to Ticket Management System");
                Venue venue = new Venue();
                selectConcert(concerts, venue,"5", customerName);
            }

            // Save any changes back to files if needed
            FileHandler.saveCustomers(customers, customerFilePath);
//            FileHandler.saveBookings(currentBookings, bookingFilePath);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private int generateNewCustomerId(List<Customer> customers) {
        int maxId = 0;
        for (Customer customer : customers) {
            int id = Integer.parseInt(Customer.getId());
            if (id > maxId) {
                maxId = id;
            }
        }
        return maxId + 1;
    }

    private void selectConcert(List<Object> concerts, Venue venue, String customerId, String customerName) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            ConcertDisplay.displayConcerts(concerts);
            System.out.print("Select a concert or 0 to exit: ");
            int concertChoice = scanner.nextInt();
            if (concertChoice == 0) {
                System.out.println("Exiting program.");
                return;
            } else if (concertChoice > 0 && concertChoice <= concerts.size()) {
                Concert selectedConcert = (Concert) concerts.get(concertChoice - 1);
                performCustomerActions((List<Concert>) selectedConcert, venue, customerId, customerName);
            } else {
                System.out.println("Invalid Input. Please try again.");
            }
        }
    }

    private void performCustomerActions(List<Concert> concerts, Venue venue, String customerId, String customerName) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select an action:");
            System.out.println("1. View Concerts");
            System.out.println("2. View Seats Layout");
            System.out.println ("3. Book Seats");
            System.out.println("4. View Booking Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                Concert concert = new Concert();
                case 1:
                    // Display concerts
                    //TODO: create concert.util
                    ConcertDisplay.displayConcerts(Collections.singletonList(concerts));
                    break;
                case 2:
                    // Display venue layout
                    displayVenueLayout(venue);
                    break;
                case 3:
                    // Book seats
                    bookSeats(concert, venue, customerId, customerName);
                    break;
                case 4:
                    // View booking details
                    viewBookingDetails(concert, customerId);
                    break;
                case 5:
                    System.out.println("Exiting this concert");
                    return;
                default:
                    System.out.println("Invalid Input. Please try again.");
            }
        }
    }

    private void displayVenueLayout(Venue venue) {
        for (String row : venue.getLayout()) {
            System.out.println(row);
        }
    }

    private void bookSeats(Concert concert, Venue venue, String customerId, String customerName) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the aisle number: ");
        String aisle = scanner.next();
        System.out.print("Enter the seat number: ");
        int seatNumber = scanner.nextInt();
        System.out.print("Enter the number of seats to be booked: ");
        int numSeats = scanner.nextInt();

        // Mark seats as booked in the venue layout
        venue.bookSeats(aisle.substring(0, 1), Integer.parseInt(aisle.substring(1)), seatNumber, numSeats);

        // Create booking entries
//        Booking newBooking = new Booking();
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < numSeats; i++) {
            int bookingId = BookingUtil.getCurrentId(currentBookings);
            Ticket ticket = ....
            tickets.add(ticket);
        }
        Booking newBooking = new Booking(String.valueOf(bookingId), customerId, customerName, concert.getId(), seatNumber + i, Integer.parseInt(aisle.substring(1)), seatNumber + i, aisle.substring(0, 1), getPrice(concert, aisle.substring(0, 1))))
        currentBookings.addAll(newBookings);

        System.out.println("Seats successfully booked.");
    }

    private double getPrice(Concert concert, String zoneType) {
        switch (zoneType) {
            case "V":
                return concert.getVipLeft(); // Assuming left price for simplicity
            case "S":
                return concert.getSeatingLeft(); // Assuming left price for simplicity
            case "T":
                return concert.getStandingLeft(); // Assuming left price for simplicity
            default:
                return 0.0;
        }
    }

    private void viewBookingDetails(Concert concert, String customerId) {
        List<Booking> customerConcertBookings = Booking.filterByConcertAndCustomer(currentBookings, concert.getId(), customerId);

        if (customerConcertBookings.isEmpty()) {
            System.out.println("No Bookings found for this concert");
            return;
        }

        // Print bookings summary
        String bookingSummary = Booking.formatBookingSummary(customerConcertBookings, concert);
        System.out.println(bookingSummary);

        // Print ticket info for each booking
        String ticketInfo = Booking.formatTicketInfo(customerConcertBookings);
        System.out.println(ticketInfo);
    }
}
