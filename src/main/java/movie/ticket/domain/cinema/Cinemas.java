package movie.ticket.domain.cinema;

import movie.ticket.domain.movie.Movie;
import movie.ticket.domain.movie.Movies;
import movie.ticket.domain.screen.Screen;
import movie.ticket.ticket.Ticket;
import movie.ticket.ticket.Tickets;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static movie.ticket.exception.CinemaException.CINEMA_NOT_FOUND_EXCEPTION;

public enum Cinemas {

    KANGNAM(1L, "강남", new Cinema(), new Tickets()),
    KAGNBYEON(2L, "강변", new Cinema(), new Tickets()),
    KYUNKUK(3L, "건국", new Cinema(), new Tickets());

    private final Long cinemaId;
    private final String cinemaName;
    private final Cinema cinema;

    private final Tickets tickets;

    Cinemas(Long cinemaId, String cinemaName, Cinema cinema, Tickets tickets) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.cinema = cinema;
        this.tickets = tickets;

        CinemaDatabase database = new CinemaDatabase();
        List<CinemaMovie> cinemaMovies = database.generateCinemaMovies();

        this.reflectCinemaMovies(cinemaMovies);
    }

    public static Collection<Cinemas> findAllCinemas() {
        return Arrays.stream(Cinemas.values())
                .collect(Collectors.toUnmodifiableList());
    }

    public static Cinemas findCinemaById(Long id) {
        return Arrays.stream(Cinemas.values())
                .filter(cinema -> Objects.equals(cinema.cinemaId, id))
                .findFirst()
                .orElseThrow(() -> new NullPointerException(CINEMA_NOT_FOUND_EXCEPTION.message));
    }

    public CinemaMovie findCinemaMovieTypeByMovie(Movie findMovie) {
        return cinema.findCinemaMovieByMovie(findMovie);
    }

    public void reflectTickets(List<Ticket> purchasedTickets) {
        purchasedTickets.forEach(this.tickets::reflectTicket);
    }

    public void reflectCinemaMovies(List<CinemaMovie> cinemaMovies) {
        cinemaMovies.forEach(cinema::reflectCinemaMovie);
    }

    public boolean checkMoviePlays(Movie movie) {
        return cinema.checkMoviePlays(movie);
    }

    Long getCinemaId() {
        return cinemaId;
    }

    String getCinemaName() {
        return cinemaName;
    }
}

class CinemaDatabase {

    private static final Long CINEMA_MOVIE_MAX_ID = 10L;

    public List<CinemaMovie> generateCinemaMovies() {
        List<Movie> movies = new ArrayList<>(Movies.findAllMovies());
        List<CinemaMovie> cinemaMovies =
                IntStream.range(0, CINEMA_MOVIE_MAX_ID.intValue())
                        .mapToObj(movieId ->
                                new CinemaMovie(
                                        (long) movieId,
                                        movies.get(movieId),
                                        loadScreens(),
                                        new CinemaTimeTable(),
                                        new CinemaSeatTable()
                                ))
                        .collect(Collectors.toList());

        return cinemaMovies;
    }

    private List<Screen> loadScreens() {
        return Arrays.stream(Screen.values())
                .collect(Collectors.toList());
    }
}
