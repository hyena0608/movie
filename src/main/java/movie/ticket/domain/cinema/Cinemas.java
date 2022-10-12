package movie.ticket.domain.cinema;

import movie.ticket.domain.movie.Movie;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public enum Cinemas {

    KANGNAM(1L, "강남", new Cinema()),
    KAGNBYEON(2L, "강변", new Cinema()),
    KYUNKUK(3L, "건국", new Cinema());

    private final Long cinemaId;
    private final String cinemaName;
    private final Cinema cinema;

    Cinemas(Long cinemaId, String cinemaName, Cinema cinema) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.cinema = cinema;
    }

    public static Collection<Cinemas> findAllCinemas() {
        return Arrays.stream(Cinemas.values())
                .collect(Collectors.toUnmodifiableList());
    }

    public Collection<Cinemas> findAllCinemasWhereMoviePlays(Movie movie) {
        return Cinemas.findAllCinemas()
                .stream()
                .filter(cinema -> cinema.checkMoviePlays(movie))
                .collect(Collectors.toUnmodifiableList());
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
