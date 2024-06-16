package model;

import java.util.List;

public class Concert {
    private String id;
    private String date;
    private String artistName;
    private String timing;
    private String venueName;
    private int totalSeats;
    private int seatsBooked;
    private int seatsLeft;
    private double vipLeft;
    private double vipCenter;
    private double vipRight;
    private double seatingLeft;
    private double seatingCenter;
    private double seatingRight;
    private double standingLeft;
    private double standingCenter;
    private double standingRight;

    // Primary constructor
    public Concert(String id, String date, String artistName, String timing, String venueName, int totalSeats, int seatsBooked) {
        this.id = id;
        this.date = date;
        this.artistName = artistName;
        this.timing = timing;
        this.venueName = venueName;
        this.totalSeats = totalSeats;
        this.seatsBooked = seatsBooked;
        this.seatsLeft = totalSeats - seatsBooked;
    }

    // Secondary constructor
    public Concert(String concertId, String date, String time, String artist, String venue, String standing, String seating, String vip) {
        this.id = concertId;
        this.date = date;
        this.artistName = artist;
        this.timing = time;
        this.venueName = venue;

        String[] standingPrices = standing.split(":");
        this.standingLeft = Double.parseDouble(standingPrices[1]);
        this.standingCenter = Double.parseDouble(standingPrices[2]);
        this.standingRight = Double.parseDouble(standingPrices[3]);

        String[] seatingPrices = seating.split(":");
        this.seatingLeft = Double.parseDouble(seatingPrices[1]);
        this.seatingCenter = Double.parseDouble(seatingPrices[2]);
        this.seatingRight = Double.parseDouble(seatingPrices[3]);

        String[] vipPrices = vip.split(":");
        this.vipLeft = Double.parseDouble(vipPrices[1]);
        this.vipCenter = Double.parseDouble(vipPrices[2]);
        this.vipRight = Double.parseDouble(vipPrices[3]);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getTiming() {
        return timing;
    }

    public String getVenueName() {
        return venueName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public int getSeatsLeft() {
        return totalSeats - seatsBooked;
    }

    public double getVipLeft() {
        return vipLeft;
    }

    public double getVipCenter() {
        return vipCenter;
    }

    public double getVipRight() {
        return vipRight;
    }

    public double getSeatingLeft() {
        return seatingLeft;
    }

    public double getSeatingCenter() {
        return seatingCenter;
    }

    public double getSeatingRight() {
        return seatingRight;
    }

    public double getStandingLeft() {
        return standingLeft;
    }

    public double getStandingCenter() {
        return standingCenter;
    }

    public double getStandingRight() {
        return standingRight;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
        this.seatsLeft = totalSeats - this.seatsBooked;
    }

    public void setSeatsBooked(int seatsBooked) {
        this.seatsBooked = seatsBooked;
        this.seatsLeft = this.totalSeats - seatsBooked;
    }

    public void setVipLeft(double vipLeft) {
        this.vipLeft = vipLeft;
    }

    public void setVipCenter(double vipCenter) {
        this.vipCenter = vipCenter;
    }

    public void setVipRight(double vipRight) {
        this.vipRight = vipRight;
    }

    public void setSeatingLeft(double seatingLeft) {
        this.seatingLeft = seatingLeft;
    }

    public void setSeatingCenter(double seatingCenter) {
        this.seatingCenter = seatingCenter;
    }

    public void setSeatingRight(double seatingRight) {
        this.seatingRight = seatingRight;
    }

    public void setStandingLeft(double standingLeft) {
        this.standingLeft = standingLeft;
    }

    public void setStandingCenter(double standingCenter) {
        this.standingCenter = standingCenter;
    }

    public void setStandingRight(double standingRight) {
        this.standingRight = standingRight;
    }


}
