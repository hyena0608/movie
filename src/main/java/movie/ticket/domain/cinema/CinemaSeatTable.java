package movie.ticket.domain.cinema;

import movie.ticket.domain.seat.Seats;
import movie.ticket.domain.showtime.ShowTime;

import java.util.Map;

public class CinemaSeatTable {

    private final Map<ShowTime, Seats> seatTable;

    public CinemaSeatTable(Map<ShowTime, Seats> seatTable) {
        this.seatTable = seatTable;
    }

    public Seats findSeatsByShowTimes(ShowTime showTimes) {
        return seatTable.get(showTimes);
    }
}
