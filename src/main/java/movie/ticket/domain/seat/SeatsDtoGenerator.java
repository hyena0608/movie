package movie.ticket.domain.seat;

import movie.ticket.dto.seat.SeatsDto;

import java.util.Map;

public class SeatsDtoGenerator {

    public static SeatsDto toSeatsDto(Seats seats) {
        return new SeatsDto(
                seats.loadAllSeats()
        );
    }
}
