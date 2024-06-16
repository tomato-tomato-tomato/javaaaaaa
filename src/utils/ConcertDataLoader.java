package utils;

import model.Concert;

import exceptions.InvalidLineException;



public class ConcertDataLoader extends FileLoader<Object>{
    @Override
    protected Object validateLine(String line) throws InvalidLineException{
        String[] data = line.split(",");
        if (data.length !=8) {
            throw new InvalidLineException("concert is invalid " + line);
        }
        String concertId = data[0];
        String date = data[1];
        String time = data[2];
        String artist = data[3];
        String venue = data[4];
        String standing = data[5];
        String seating = data[6];
        String vip = data[7];

        String[] standingPrice = standing.split(":");
        int standingLeftPrice = Integer.parseInt(standingPrice[1]);
        int standingMiddlePrice = Integer.parseInt(standingPrice[2]);
        int standingRightPrice = Integer.parseInt(standingPrice[3]);

        String[] seatingPrice = seating.split(":");
        int seatingLeftPrice = Integer.parseInt(seatingPrice[1]);
        int seatingMiddlePrice = Integer.parseInt(seatingPrice[2]);
        int seatingRightPrice = Integer.parseInt(seatingPrice[3]);

        String[] vipPrice = vip.split(":");
        int vipLeftPrice = Integer.parseInt(vipPrice[1]);
        int vipMiddlePrice = Integer.parseInt(vipPrice[2]);
        int vipRightPrice = Integer.parseInt(vipPrice[3]);

        return new Concert(concertId, date, time, artist, venue, standing, seating, vip);

    }
}





