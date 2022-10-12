package movie.ticket.domain.cinema;

import movie.ticket.domain.showtime.ShowTimes;

import java.util.Map;

public class CinemaTimeTable {

    private final Map<ShowTimes, Boolean> seats;

    public CinemaTimeTable(Map<ShowTimes, Boolean> seats) {
        this.seats = seats;
    }
}
