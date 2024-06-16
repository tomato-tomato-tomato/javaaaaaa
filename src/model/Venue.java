package model;

import java.util.List;

public class Venue {
    private final List<String> layout;

    public Venue() {
        this.layout = layout;
    }

    public List<String> getLayout() {
        return layout;
    }

    public void markBookedSeats(List<Booking> bookings) {
        for (Booking booking : bookings) {
            String row = layout.get(Integer.parseInt(booking.getAisleNumber()) - 1);
            String updatedRow = row.replace("[" + booking.getSeatNumber() + "]", "[X]");
            layout.set(booking.Integer.parseInt(booking.getAisleNumber()) - 1, updatedRow);
        }
    }

    public void bookSeats(String zone, int rowNumber, int seatNumber, int numSeats) {
        String row = layout.get(rowNumber - 1);
        for (int i = 0; i < numSeats; i++) {
            row = row.replace("[" + (seatNumber + i) + "]", "[X]");
        }
        layout.set(rowNumber - 1, row);
    }
}
