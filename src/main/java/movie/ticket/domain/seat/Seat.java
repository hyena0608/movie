package movie.ticket.domain.seat;

public class Seat {

    private final String seat;

    public Seat(String seat) {
        this.seat = seat;
    }

    public String loadSeat() {
        return seat;
    }

    public boolean checkSame(Seat seat) {
        return this.seat.equals(seat.seat);
    }
}
