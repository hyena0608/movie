package movie.ticket.repository;

import movie.ticket.domain.seat.Seats;

import java.util.HashMap;
import java.util.Map;

public class SeatRepository {

    public static final Map<Long, Seats> seats = new HashMap<>();

    public Seats findSeatsById(Long id) {
        return seats.get(id);
    }
}
