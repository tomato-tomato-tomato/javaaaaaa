package model;

public class Ticket {
    private int ticketId;
    private int rowNumber;
    private int seatNumber;
    private String zoneType;
    private double price;

    public Ticket(int ticketId, int rowNumber, int seatNumber, String zoneType, double price) {
        this.ticketId = ticketId;
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.zoneType = zoneType;
        this.price = price;
    }

    public static int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public static int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public static String getZoneType() {
        return zoneType;
    }

    public void setZoneType(String zoneType) {
        this.zoneType = zoneType;
    }

    public static double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static String toCsv() {
        return String.join(",",
                String.valueOf(ticketId),
                String.valueOf(rowNumber),
                String.valueOf(seatNumber),
                zoneType,
                String.valueOf(price));
    }
}
