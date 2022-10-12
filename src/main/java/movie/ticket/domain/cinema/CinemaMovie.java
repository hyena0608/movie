package movie.ticket.domain.cinema;

import movie.ticket.domain.movie.Movie;
import movie.ticket.domain.screen.Screens;

import java.util.List;

public class CinemaMovie {

    private final Long id;
    private final Movie movie;
    private final List<Screens> screens;
    private final CinemaTimeTable timeTable;

    public CinemaMovie(Long id, Movie movie, List<Screens> screens, CinemaTimeTable timeTable) {
        this.id = id;
        this.movie = movie;
        this.screens = screens;
        this.timeTable = timeTable;
    }

    public List<Screens> loadScreens() {
        return screens;
    }

    public boolean checkSameMovie(Movie findMovie) {
        return movie.equals(findMovie);
    }
}
