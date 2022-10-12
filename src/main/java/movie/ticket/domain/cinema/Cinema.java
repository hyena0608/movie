package movie.ticket.domain.cinema;

import movie.ticket.domain.movie.Movie;

import java.util.HashMap;
import java.util.Map;

import static movie.ticket.exception.CinemaException.CINEMA_NOT_FOUND_EXCEPTION;

public class Cinema {

    private final Map<Long, CinemaMovie> movies;

    public Cinema() {
        this.movies = new HashMap<>();
    }

    public boolean checkMoviePlays(Movie findMovie) {
        return movies.values()
                .stream()
                .anyMatch(movie -> movie.equals(findMovie));
    }

    public CinemaMovie findCinemaMovieByMovie(Movie findMovie) {
        return movies.values()
                .stream()
                .filter(movie -> movie.checkSameMovie(findMovie))
                .findFirst()
                .orElseThrow(() -> new NullPointerException(CINEMA_NOT_FOUND_EXCEPTION.message));
    }
}
