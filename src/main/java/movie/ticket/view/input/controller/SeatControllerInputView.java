package movie.ticket.view.input.controller;

import movie.ticket.form.SeatsForm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static movie.ticket.view.input.InputView.read;
import static movie.ticket.view.input.exception.SeatException.SEAT_INPUT_FORM_EXCEPTION;

public class SeatControllerInputView {

    public SeatsForm askSeats() {
        String seatsNumber = read();
        if (!checkSeatsNumber(seatsNumber)) {
            throw new NullPointerException(SEAT_INPUT_FORM_EXCEPTION.message);
        }

        String[] seats = splitCommand(seatsNumber);

        List<String> seatNumbers = Arrays.stream(seats)
                .map(this::parseCommand)
                .collect(Collectors.toUnmodifiableList());

        return new SeatsForm(seatNumbers);
    }

    private boolean checkSeatsNumber(String seatsNumber) {
        return seatsNumber.length() != 0;
    }

    private String[] splitCommand(String commands) {
        return commands.split(" ");
    }

    private String parseCommand(String command) {
        return command.replace(",", " ").trim();
    }
}
