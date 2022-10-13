package movie.ticket.domain.seat;

import java.util.Map;

import static movie.ticket.exception.SeatException.*;

public class Seats {

    public static final int SEAT_ROW_SIZE = 10;
    public static final int SEAR_COL_SIZE = 4;
    public static final int ASCII_A = 65;

    private final Map<Seat, Boolean> seats;

    public Seats(Map<Seat, Boolean> seats) {
        this.seats = seats;
    }

    private void initSeat() {
        for (int row = 1; row <= SEAT_ROW_SIZE; row++) {
            for (int col = ASCII_A; col <= ASCII_A + SEAR_COL_SIZE; col++) {
                seats.put(createSeatName(row, col), false);
            }
        }
    }

    public Map<Seat, Boolean> loadAllSeats() {
        return seats;
    }

    private Seat createSeatName(int row, int col) {
        return new Seat(
                String.valueOf(row) + (char) col
        );
    }

    public void reflectSeat(Seat seat) {
        if (checkSeat(seat)) {
            throw new IllegalArgumentException(SEAT_ALREADY_FILLED_EXCEPTION.message);
        }
        seats.put(seat, true);
    }

    private boolean checkSeat(Seat seat) {
        return seats.get(seat);
    }

     Map<Seat, Boolean> getSeats() {
        return seats;
    }

}
