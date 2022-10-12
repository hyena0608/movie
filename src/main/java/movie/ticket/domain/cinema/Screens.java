package movie.ticket.domain.cinema;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public enum Screens {

    TWO_DIMENSIONS(1L, "2D"),
    THREE_DIMENSIONS(2L, "3D");

    private final Long screenId;
    private final String screenName;

    Screens(Long screenId, String screenName) {
        this.screenId = screenId;
        this.screenName = screenName;
    }

    public static Collection<Screens> findAllCinemas() {
        return Arrays.stream(Screens.values())
                .collect(Collectors.toUnmodifiableList());
    }

    Long getScreenId() {
        return screenId;
    }

    String getScreenName() {
        return screenName;
    }
}
