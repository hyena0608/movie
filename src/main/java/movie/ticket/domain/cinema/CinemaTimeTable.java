package movie.ticket.domain.cinema;

import movie.ticket.domain.showtime.ShowTime;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CinemaTimeTable {

    private final Map<ShowTime, Boolean> cinemaShowTimes;

    public CinemaTimeTable(Map<ShowTime, Boolean> cinemaShowTimes) {
        this.cinemaShowTimes = cinemaShowTimes;
    }

    public List<ShowTime> loadPossibleShowTimes() {
        return cinemaShowTimes.entrySet()
                .stream()
                .filter(Map.Entry::getValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toUnmodifiableList());
    }
}
