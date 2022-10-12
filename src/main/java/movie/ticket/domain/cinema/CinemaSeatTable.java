package movie.ticket.domain.cinema;

import movie.ticket.domain.seat.Seats;
import movie.ticket.domain.showtime.ShowTimes;

import java.util.Map;

public class CinemaSeatTable {

    private final Map<ShowTimes, Seats> seatTable;

    public CinemaSeatTable(Map<ShowTimes, Seats> seatTable) {
        this.seatTable = seatTable;
    }

    public Seats findSeatsByShowTimes(ShowTimes showTimes) {
        return seatTable.get(showTimes);
    }
}
