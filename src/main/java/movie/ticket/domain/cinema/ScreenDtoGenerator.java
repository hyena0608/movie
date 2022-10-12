package movie.ticket.domain.cinema;

import movie.ticket.dto.cinema.ScreenDto;

public class ScreenDtoGenerator {

    public static ScreenDto toScreenDto(Screens screen) {
        return new ScreenDto(screen.getScreenId(), screen.getScreenName());
    }
}
