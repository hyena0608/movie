package movie.ticket.domain.screen;

import movie.ticket.dto.screen.ScreenDto;

public class ScreenDtoGenerator {

    public static ScreenDto toScreenDto(Screen screen) {
        return new ScreenDto(screen.getScreenId(), screen.getScreenName());
    }
}
