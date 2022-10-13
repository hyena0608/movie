package movie.ticket.dto.seat;

import movie.ticket.domain.seat.Seat;

import java.util.Map;

import static movie.ticket.domain.seat.Seats.*;

public class SeatsDto {

    private final Map<Seat, Boolean> seats;
    private final int rowSize = SEAT_ROW_SIZE;
    private final int colSize = SEAR_COL_SIZE;
    private final int asciiA = ASCII_A;

    public SeatsDto(Map<Seat, Boolean> seats) {
        this.seats = seats;
    }

    public Map<Seat, Boolean> getSeats() {
        return seats;
    }

    public int getRowSize() {
        return rowSize;
    }

    public int getColSize() {
        return colSize;
    }

    public int getAsciiA() {
        return asciiA;
    }
}
