package utils;

import model.Booking;
import model.Customer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileHandler {
    public static void saveCustomers(List<Object> customers, String filePath) throws IOException {
        for (Customer customer : customers) {
            String line = customer.toCSV() + System.lineSeparator();
            Files.write(Path.of(filePath), line.getBytes(), StandardOpenOption.APPEND);
        }
    }

    public static void saveBookings(List<Booking> bookings, String filePath) throws IOException {
        for (Booking booking : bookings) {
            String line = booking.toCSV() + System.lineSeparator();
            Files.write(Path.of(filePath), line.getBytes(), StandardOpenOption.APPEND);
        }
    }
}
