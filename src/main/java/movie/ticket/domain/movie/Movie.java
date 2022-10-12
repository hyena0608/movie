package movie.ticket.domain.movie;

import java.util.Objects;

public class Movie {

    private final Long id;
    private final String name;

    public Movie(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean checkSame(Long id) {
        return Objects.equals(this.id, id);
    }

    Long getId() {
        return id;
    }

    String getName() {
        return name;
    }
}
