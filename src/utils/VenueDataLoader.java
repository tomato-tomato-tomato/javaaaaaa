package utils;

import model.Venue;
import exceptions.InvalidFormatException;
import exceptions.InvalidLineException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class VenueDataLoader {


    public List<Venue> loadData(String filePath) throws IOException {
        List<Venue> venues = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        return venues;
    }

    public List<Venue> loadDefaultVenue(String venueName) throws IOException {
        String defaultFilePath = "venue_default.txt";
        String venueFilePath = "venue_" + venueName.toLowerCase() + ".txt";
        if (Files.exists(Paths.get(venueFilePath))) {
            return loadData(venueFilePath);
        } else {
            return loadData(defaultFilePath);
        }
    }
}



