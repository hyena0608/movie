package movie.ticket.domain.cinema;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public enum Cinemas {

    KANGNAM(1L, "강남"),
    KAGNBYEON(2L, "강변"),
    KYUNKUK(3L, "건국");

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
