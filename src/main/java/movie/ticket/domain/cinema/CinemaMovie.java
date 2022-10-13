package movie.ticket.domain.cinema;

import movie.ticket.domain.movie.Movie;
import movie.ticket.domain.screen.Screen;
import movie.ticket.domain.seat.Seats;
import movie.ticket.domain.showtime.ShowTime;

import java.util.List;

public class CinemaMovie {

    private final Long id;
    private final Movie movie;
    private final List<Screen> screens;
    private final CinemaTimeTable timeTable;
    private final CinemaSeatTable seatTable;

    public CinemaMovie(Long id, Movie movie, List<Screen> screens, CinemaTimeTable timeTable, CinemaSeatTable seatTable) {
        this.id = id;
        this.movie = movie;
        this.screens = screens;
        this.timeTable = timeTable;
        this.seatTable = seatTable;
    }

    public List<ShowTime> loadPossibleShowTimes() {
        return timeTable.loadPossibleShowTimes();
    }

    public List<Screen> loadScreens() {
        return screens;
    }

    public Seats loadSeatsByShowTime(ShowTime showTime) {
        return seatTable.findSeatsByShowTimes(showTime);
    }

    public boolean checkSameMovie(Movie findMovie) {
        return movie.loadMovieName().equals(findMovie.loadMovieName());
    }

}
