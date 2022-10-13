package movie.ticket.domain.movie;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static movie.ticket.exception.MovieException.MOVIE_NOT_FOUND_EXCEPTION;

public enum Movies {

    MOVIES();

    private final Map<Long, Movie> movies;

    Movies() {
        this.movies = new HashMap<>();

        MovieDatabase database = new MovieDatabase();
        List<Movie> generatedMovies = database.generateMovies();

        generatedMovies.forEach(this::reflectMovie);
    }

    public static Collection<Movie> findAllMovies() {
        return MOVIES.movies.values()
                .stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public static Movie findMovieById(Long id) {
        return MOVIES.movies.values()
                .stream()
                .filter(movie -> movie.checkSame(id))
                .findFirst()
                .orElseThrow(() -> new NullPointerException(MOVIE_NOT_FOUND_EXCEPTION.message));
    }

    public void reflectMovie(Movie movie) {
        movies.put((long) (movies.size() + 1), movie);
    }
}

class MovieDatabase {
    private static final Long MOVIE_MAX_ID = 10L;
    private static final List<String> movieTitles = new ArrayList<>(List.of(
            "공조1", "범죄도시1", "알라딘1",
            "공조2", "범죄도시2", "알라딘2",
            "공조3", "범죄도시3", "알라딘3", "공조4")
    );
    private static final List<Movie> movies = new ArrayList<>(
            IntStream.range(0, MOVIE_MAX_ID.intValue())
                    .mapToObj(movieId ->
                            new Movie(
                                    (long) movieId,
                                    movieTitles.get(movieId)
                            ))
                    .collect(Collectors.toList())
    );

    public List<Movie> generateMovies() {
        List<Movie> movies = IntStream.range(0, MOVIE_MAX_ID.intValue())
                .mapToObj(movieId ->
                        new Movie(
                                (long) movieId,
                                movieTitles.get(movieId)
                        ))
                .collect(Collectors.toList());

        return movies;
    }
}
