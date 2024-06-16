package utils;

import model.Concert;

import java.util.List;


public class ConcertDisplay {
    public static void displayConcerts(List<Object> concerts) {
        System.out.println("Select a concert or 0 to exit");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("#    Date           Artist Name    Timing         Venue Name                    Total Seats    Seats Booked   Seats Left     ");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");

        for (Concert concert : concerts) {
            System.out.printf("%-5%-15s%-15s%-15%-30s%-15d%-15d%-15d%n",
                    concert.getId(),
                    concert.getDate(),
                    concert.getArtistName(),
                    concert.getTiming(),
                    concert.getVenueName(),
                    concert.getTotalSeats(),
                    concert.getSeatsBooked(),
                    concert.getSeatsLeft());
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.print("> ");
    }

}

