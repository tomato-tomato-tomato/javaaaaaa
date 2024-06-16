package utils;

import model.Booking;

import java.util.List;

public class BookingUtil {
    private static int nextId = -1;

    public static int getCurrentId(List<Booking> currentBookings) {
        if (nextId == -1) {
            nextId = generateBookingId(currentBookings);
        }
        int currentId = nextId;
        nextId = nextId + 1;
        return currentId;
    }

    private static int generateBookingId(List<Booking> currentBookings) {
        int maxId = 0;
        for (Booking booking : currentBookings) {
            int id = Integer.parseInt(booking.getBookingId());
            if (id > maxId) {
                maxId = id;
            }
        }
        return maxId + 1;
    }

}
