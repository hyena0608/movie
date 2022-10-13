package movie.ticket.domain.screen;

import movie.ticket.exception.ScreenException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import static movie.ticket.exception.ScreenException.*;

public enum Screen {

    TWO_DIMENSIONS(1L, "2D", 12000),
    THREE_DIMENSIONS(2L, "3D", 15000);

    private final Long screenId;
    private final String screenName;
    private final Integer price;

    Screen(Long screenId, String screenName, Integer price) {
        this.screenId = screenId;
        this.screenName = screenName;
        this.price = price;
    }

    public static Screen findScreenById(Long id) {
        return Arrays.stream(Screen.values())
                .filter(screen -> Objects.equals(screen.screenId, id))
                .findFirst()
                .orElseThrow(() -> new NullPointerException(SCREEN_CAN_NOT_FIND_EXCEPTION.message));
    }

    public boolean checkSame(Screen screen) {
        return Objects.equals(this.screenId, screen.screenId);
    }

    public Integer loadPrice() {
        return price;
    }

    Long getScreenId() {
        return screenId;
    }

    String getScreenName() {
        return screenName;
    }
}
