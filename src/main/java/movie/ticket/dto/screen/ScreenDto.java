package movie.ticket.dto.screen;

public class ScreenDto {

    private final Long id;
    private final String name;

    public ScreenDto(Long id, String name) {
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
