package movie.ticket.domain.cinema;

import movie.ticket.domain.movie.Movie;

import java.util.HashMap;
import java.util.Map;

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
}
