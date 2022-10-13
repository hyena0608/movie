package movie.ticket.domain.cinema;

import movie.ticket.domain.seat.Seats;
import movie.ticket.domain.showtime.ShowTime;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CinemaSeatTable {

    private final Map<ShowTime, Seats> seatTable;

    public CinemaSeatTable() {
        this.seatTable = new HashMap<>();
        Arrays.stream(ShowTime.values())
                .forEach(showTime -> seatTable.put(showTime, new Seats()));
    }

    public Seats findSeatsByShowTimes(ShowTime showTimes) {
        return seatTable.get(showTimes);
    }
}
