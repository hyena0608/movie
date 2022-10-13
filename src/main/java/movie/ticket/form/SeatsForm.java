package movie.ticket.form;

import movie.ticket.domain.seat.Seat;

import java.util.List;
import java.util.stream.Collectors;

public class SeatsForm {

    private final List<Seat> seatNumbers;

    public SeatsForm(List<String> seatNumbers) {
        this.seatNumbers = seatNumbers.stream()
                .map(Seat::new)
                .collect(Collectors.toList());
    }

    public List<Seat> getSeatNumbers() {
        return seatNumbers;
    }
}
