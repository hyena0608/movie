package movie.ticket.domain.seat;

public class Seat {

    private final String seat;

    public Seat(String seat) {
        this.seat = seat;
    }

    public boolean checkSame(Seat findSeat) {
        return this.seat.equals(findSeat.seat);
    }
}
