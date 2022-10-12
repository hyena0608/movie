package movie.ticket.form;

import java.util.List;

public class SeatsForm {

    private final List<String> seatNumbers;

    public SeatsForm(List<String> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public List<String> getSeatNumbers() {
        return seatNumbers;
    }
}
