package movie.ticket.domain.cinema;

import movie.ticket.domain.showtime.ShowTimes;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CinemaTimeTable {

    private final Map<ShowTimes, Boolean> cinemaShowTimes;

    public CinemaTimeTable(Map<ShowTimes, Boolean> cinemaShowTimes) {
        this.cinemaShowTimes = cinemaShowTimes;
    }

    public List<ShowTimes> loadPossibleShowTimes() {
        return cinemaShowTimes.entrySet()
                .stream()
                .filter(Map.Entry::getValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toUnmodifiableList());
    }
}
