package utils;

import exceptions.InvalidLineException;
import model.Booking;
import model.Ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookingDataLoader extends FileLoader<Object> {

    @Override
    protected Object validateLine(String line) throws InvalidLineException {
        String[] data = line.split(",");
        if (data.length < 9 || (data.length - 5) % 5 != 0) {
            throw new InvalidLineException("Invalid line format: " + line);
        }

        String bookingId = data[0];
        String customerId = data[1];
        String customerName = data[2];
        String concertId = data[3];
        int totalTickets = Integer.parseInt(data[4]);


        int index = 5;
        List<Ticket> tickets = new ArrayList<Ticket>();
        for (int i = 0; i < totalTickets; i++) {
            int ticketId = Integer.parseInt(data[index++]);
            int rowNumber = Integer.parseInt(data[index++]);
            int seatNumber = Integer.parseInt(data[index++]);
            String zoneType = data[index++];
            double price = Double.parseDouble(data[index++]);

            Ticket ticket = new Ticket(ticketId, rowNumber, seatNumber, zoneType, price);
            tickets.add(ticket);
        }
        return new Booking(bookingId, customerId, customerName, concertId, Collections.singletonList((Ticket) tickets));
    }
}
