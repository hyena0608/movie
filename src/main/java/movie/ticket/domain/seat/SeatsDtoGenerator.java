package movie.ticket.domain.seat;

import movie.ticket.dto.seat.SeatsDto;

import java.util.Map;

public class SeatsDtoGenerator {

    public static SeatsDto toSeatsDto(Map<String, Boolean> seats) {
        return new SeatsDto(seats);
    }
}
