package utils;

import exceptions.InvalidLineException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public abstract class FileLoader<O> {

    public List<Object> load(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        return parse(lines);
    }

    public List<Object> parse(List<String> lines) {
        List<Object> items = new ArrayList<>();
        for (String line : lines) {
            Object item = null;
            try {
                item = validateLine(line);
            } catch (InvalidLineException e) {
                System.out.println(e.getMessage());
            }
            items.add(item);
            // Parse each line to create Booking objects and add them to the list
//            bookings.add(new Booking(line)); // Assuming Booking has a constructor that takes a line of string
        }
        return items;
    }

    protected abstract Object validateLine(String line) throws InvalidLineException;
}

