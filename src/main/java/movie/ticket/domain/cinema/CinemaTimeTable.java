package movie.ticket.domain.cinema;

import movie.ticket.domain.showtime.ShowTime;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CinemaTimeTable {

    private final Map<ShowTime, Boolean> cinemaShowTimes;

    public CinemaTimeTable() {
        this.cinemaShowTimes = new HashMap<>();
        Arrays.stream(ShowTime.values())
                .forEach(showTime -> cinemaShowTimes.put(showTime, true));
    }

    public List<ShowTime> loadPossibleShowTimes() {
        return cinemaShowTimes.entrySet()
                .stream()
                .filter(Map.Entry::getValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toUnmodifiableList());
    }
}
