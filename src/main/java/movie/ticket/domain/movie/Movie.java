package movie.ticket.domain.movie;

public class Movie {

    private final Long id;
    private final String name;

    public Movie(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    Long getId() {
        return id;
    }

    String getName() {
        return name;
    }
}
