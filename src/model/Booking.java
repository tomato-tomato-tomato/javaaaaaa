package model;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private final String bookingId;
    private final String customerId;
    private final String customerName;
    private final String concertId;
    private String AisleNumber;
    private int seatNumber;

    public Booking(String bookingId, String customerId, String customerName, String concertId, List<Ticket> tickets) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.concertId = concertId;
        this.tickets = tickets;
    }


    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    private List<Ticket> tickets;


    public String getBookingId() {
        return bookingId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getConcertId() {
        return concertId;
    }

    public String getAisleNumber(){
        return AisleNumber;
    }


    public static List<Booking> filterByConcert(List<Booking> bookings, String concertId) {
        List<Booking> concertBookings = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getConcertId().equals(concertId)) {
                concertBookings.add(booking);
            }
        }
        return concertBookings;
    }

    public static List<Booking> filterByConcertAndCustomer(List<Booking> bookings, String concertId, String customerId) {
        List<Booking> customerConcertBookings = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getConcertId().equals(concertId) && booking.getCustomerId().equals(customerId)) {
                customerConcertBookings.add(booking);
            }
        }
        return customerConcertBookings;
    }

    public static String formatBookingSummary(List<Booking> bookings, Concert concert) {
        StringBuilder sb = new StringBuilder();
        String format = "%-5s%-15s%-15s%-10s%-15s%-15s%-10s%n";
        sb.append("Bookings\n");
        sb.append("---------------------------------------------------------------------------------------------------------------------------\n");
        sb.append(String.format(format, "Id", "Concert Date", "Artist Name", "Timing", "Venue Name", "Seats Booked", "Total Price"));
        sb.append("---------------------------------------------------------------------------------------------------------------------------\n");

        for (Booking booking : bookings) {
            sb.append(String.format(format,
                    booking.getBookingId(),
                    concert.getDate(),
                    concert.getArtistName(),
                    concert.getTiming(),
                    concert.getVenueName(),
                    //TODO: format ticket print summary
                    Ticket.getSeatNumber(),
                    Ticket.getPrice()));
        }
        sb.append("---------------------------------------------------------------------------------------------------------------------------\n");
        return sb.toString();
    }

    public static String formatTicketInfo(List<Booking> bookings) {
        StringBuilder sb = new StringBuilder();
        String format = "%-5s%-15s%-15s%-10s%-10s%n";
        for (Booking booking : bookings) {
            sb.append("############### Booking Id: ").append(booking.getBookingId()).append(" ####################\n");
            sb.append(String.format(format, "Id", "Aisle Number", "Seat Number", "Seat Type", "Price"));
            sb.append("##################################################\n");
            sb.append(String.format(format,
                    Ticket.getTicketId(),
                    booking.getAisleNumber(),
                    Ticket.getSeatNumber(),
                    Ticket.getZoneType(),
                    Ticket.getPrice()));
            sb.append("##################################################\n");
        }
        return sb.toString();
    }


    // TODO: call tickets.toCSV and create a toCSV method in ticket
    public String toCSV() {
        return String.join(",",
                bookingId,
                customerId,
                customerName,
                concertId
        )+Ticket.toCsv();
    }

}
