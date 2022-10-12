package movie.ticket.domain.cinema;

import movie.ticket.domain.movie.Movie;
import movie.ticket.domain.screen.Screens;

public class CinemaMovie {

    private final Long id;
    private final Movie movie;
    private final Screens screen;
    private final CinemaTimeTable timeTable;

    public CinemaMovie(Long id, Movie movie, Screens screen, CinemaTimeTable timeTable) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.timeTable = timeTable;
    }
}
