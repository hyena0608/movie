package movie.ticket.dto.showtime;

import java.sql.Time;

public class ShowTimeDto {

    private final Long id;
    private final Time time;
    private final String name;

    public ShowTimeDto(Long id, Time time, String name) {
        this.id = id;
        this.time = time;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Time getTime() {
        return time;
    }

    public String getName() {
        return name;
    }
}
