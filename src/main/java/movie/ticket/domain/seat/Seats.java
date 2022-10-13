package movie.ticket.domain.seat;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static movie.ticket.exception.SeatException.SEAT_ALREADY_FILLED_EXCEPTION;

public class Seats {

    public static final int SEAT_ROW_SIZE = 10;
    public static final int SEAR_COL_SIZE = 4;
    public static final int ASCII_A = 65;

    private final Map<Seat, Boolean> seats;
    private final Map<String, Seat> seatFinder;

    public Seats() {
        this.seats = new HashMap<>();
        initSeat();
        this.seatFinder = createSeatFinder();
    }

    private Map<String, Seat> createSeatFinder() {
        return seats.keySet()
                .stream()
                .collect(Collectors.toUnmodifiableMap(
                        Seat::loadSeat,
                        seat -> seat));
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
                (char) col + String.valueOf(row)
        );
    }

    public void reflectSeat(Seat seat) {
        Seat findSeat = seatFinder.get(seat.loadSeat());
        if (!checkSeat(findSeat)) {
            throw new IllegalArgumentException(SEAT_ALREADY_FILLED_EXCEPTION.message);
        }
        seats.put(findSeat, true);
    }

    private boolean checkSeat(Seat seat) {
        Seat findSeat = seatFinder.get(seat.loadSeat());
        return seats.containsKey(findSeat);
    }

    Map<Seat, Boolean> getSeats() {
        return seats;
    }

}
