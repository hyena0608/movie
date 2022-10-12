package movie.ticket.domain.cinema;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public enum Cinemas {

    TWO_DIMENSIONS(1L, "2D"),
    THREE_DIMENSIONS(2L, "3D");

    private final Long cinemaId;
    private final String cinemaName;

    Cinemas(Long cinemaId, String cinemaName) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
    }

    public static Collection<Cinemas> findAllCinemas() {
        return Arrays.stream(Cinemas.values())
                .collect(Collectors.toUnmodifiableList());
    }

    Long getCinemaId() {
        return cinemaId;
    }

    String getCinemaName() {
        return cinemaName;
    }
}
