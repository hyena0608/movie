package movie.ticket.domain.cinema;

import movie.ticket.domain.movie.Movie;
import movie.ticket.exception.CinemaException;
import movie.ticket.ticket.Ticket;
import movie.ticket.ticket.Tickets;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static movie.ticket.exception.CinemaException.*;

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

    public Collection<Cinemas> findAllCinemasWhereMoviePlays(Movie movie) {
        return Cinemas.findAllCinemas()
                .stream()
                .filter(cinema -> cinema.checkMoviePlays(movie))
                .collect(Collectors.toUnmodifiableList());
    }

    public CinemaMovie findCinemaMovieTypeByMovie(Movie findMovie) {
        return cinema.findCinemaMovieByMovie(findMovie);
    }

    public void reflectTickets(List<Ticket> purchasedTickets) {
        purchasedTickets.forEach(this.tickets::reflectTicket);
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
