package movie.ticket.domain.cinema;

import movie.ticket.domain.movie.Movie;
import movie.ticket.domain.screen.Screens;
import movie.ticket.domain.seat.Seats;
import movie.ticket.domain.showtime.ShowTimes;

import java.util.List;

public class CinemaMovie {

    private final Long id;
    private final Movie movie;
    private final List<Screens> screens;
    private final CinemaTimeTable timeTable;
    private final CinemaSeatTable seatTable;

    public CinemaMovie(Long id, Movie movie, List<Screens> screens, CinemaTimeTable timeTable, CinemaSeatTable seatTable) {
        this.id = id;
        this.movie = movie;
        this.screens = screens;
        this.timeTable = timeTable;
        this.seatTable = seatTable;
    }

    public List<ShowTimes> loadPossibleShowTimes() {
        return timeTable.loadPossibleShowTimes();
    }

    public List<Screens> loadScreens() {
        return screens;
    }

    public Seats loadSeatsByShowTime(ShowTimes showTime) {
        return seatTable.findSeatsByShowTimes(showTime);
    }

    public boolean checkSameMovie(Movie findMovie) {
        return movie.equals(findMovie);
    }
}
