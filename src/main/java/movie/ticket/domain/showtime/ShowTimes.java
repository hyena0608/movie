package movie.ticket.domain.showtime;

import java.sql.Time;

public enum ShowTimes {

    SHOW_TIME_09_30_MORNING(1L, new Time(9, 30, 00), "조조"),
    SHOW_TIME_10_30(2L,  new Time(10, 30, 00), ""),
    SHOW_TIME_24_00_NIGHT(3L, new Time(24, 00, 00), "");

    private final Long showTimeId;
    private final Time time;
    private final String showTimeName;

    ShowTimes(Long showTimeId, Time time, String showTimeName) {
        this.showTimeId = showTimeId;
        this.time = time;
        this.showTimeName = showTimeName;
    }
}
