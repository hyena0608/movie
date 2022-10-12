package movie.ticket.view.input.controller;

import movie.ticket.form.NumberForm;

import static movie.ticket.view.input.InputView.read;
import static movie.ticket.view.input.exception.ScreenMenuException.SCREEN_MENU_FORM_EXCEPTION;
import static movie.ticket.view.input.util.RegexUtil.REGEX_NUMBER_FORM;
import static movie.ticket.view.input.util.RegexUtil.checkRegex;

public class CinemaControllerInputView {
    
    public NumberForm askCinema() {
        String cinemaNumber = read();
        if (!checkCinemaNumber(cinemaNumber)) {
            throw new NullPointerException(SCREEN_MENU_FORM_EXCEPTION.message);
        }
        return new NumberForm(cinemaNumber);
    }

    private boolean checkCinemaNumber(String cinemaNumber) {
        return cinemaNumber.length() != 0 && checkRegex(REGEX_NUMBER_FORM, cinemaNumber);
    }
}
