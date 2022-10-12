package movie.ticket.dto.movie;

public class MovieDto {

    private final Long id;
    private final String name;

    public MovieDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
