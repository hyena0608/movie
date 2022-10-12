package movie.ticket.domain.seat;

import movie.ticket.exception.SeatException;

import java.util.Map;

import static movie.ticket.exception.SeatException.*;

public class Seat {

    private final static int SEAT_ROW_SIZE = 10;
    private final static int SEAR_COL_SIZE = 4;
    private final static int ASCII_A = 65;

    private final Map<String, Boolean> seats;

    public Seat(Map<String, Boolean> seats) {
        this.seats = seats;
        initSeat();
    }

    private void initSeat() {
        for (int row = 1; row <= SEAT_ROW_SIZE; row++) {
            for (int col = ASCII_A; col <= ASCII_A + SEAR_COL_SIZE; col++) {
                seats.put(createSeatName(row, col), false);
            }
        }
    }

    private String createSeatName(int row, int col) {
        return String.valueOf(row) + (char) col;
    }

    public void reflectSeat(String seatName) {
        if (checkSeat(seatName)) {
            throw new IllegalArgumentException(SEAT_ALREADY_FILLED_EXCEPTION.message);
        }
        seats.put(seatName, true);
    }

    private boolean checkSeat(String seatName) {
        return seats.get(seatName);
    }
}
