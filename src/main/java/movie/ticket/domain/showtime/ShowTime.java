package movie.ticket.domain.showtime;

import java.sql.Time;
import java.util.Arrays;
import java.util.Objects;

import static movie.ticket.exception.ShowTimeException.*;

public enum ShowTime {

    SHOW_TIME_09_30_MORNING(1L, new Time(9, 30, 0), "조조"),
    SHOW_TIME_10_30(2L, new Time(10, 30, 0), ""),
    SHOW_TIME_24_00_NIGHT(3L, new Time(24, 0, 0), "심야");

    private final Long showTimeId;
    private final Time time;
    private final String showTimeName;

    ShowTime(Long showTimeId, Time time, String showTimeName) {
        this.showTimeId = showTimeId;
        this.time = time;
        this.showTimeName = showTimeName;
    }

    public static ShowTime findShowTimeById(Long id) {
        return Arrays.stream(ShowTime.values())
                .filter(showTime -> Objects.equals(showTime.showTimeId, id))
                .findFirst()
                .orElseThrow(() -> new NullPointerException(SHOW_TIME_NOT_FOUND_EXCEPTION.message));
    }

//    public static String loadTimeByShowTime(ShowTime findShowTime) {
//        return Arrays.stream(ShowTime.values())
//                .filter(showTime -> showTime == findShowTime)
//                .findFirst()
//                .orElseThrow(() -> new NullPointerException(SHOW_TIME_NOT_FOUND_EXCEPTION.message));
//    }

    Long getShowTimeId() {
        return showTimeId;
    }

    Time getTime() {
        return time;
    }

    String getShowTimeName() {
        return showTimeName;
    }
}
