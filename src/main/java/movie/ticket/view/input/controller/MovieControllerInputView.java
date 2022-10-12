package movie.ticket.view.input.controller;

import movie.ticket.form.NumberForm;

import static movie.ticket.view.input.InputView.read;
import static movie.ticket.view.input.exception.MovieMenuException.*;
import static movie.ticket.view.input.util.RegexUtil.REGEX_NUMBER_FORM;
import static movie.ticket.view.input.util.RegexUtil.checkRegex;

public class MovieControllerInputView {

    public NumberForm askMovie() {
        String movieNumber = read();
        if (!checkMovieNumber(movieNumber)) {
            throw new NullPointerException(MOVIE_MENU_FORM_EXCEPTION.message);
        }
        return new NumberForm(movieNumber);
    }

    private boolean checkMovieNumber(String movieNumber) {
        return movieNumber.length() != 0 && checkRegex(REGEX_NUMBER_FORM, movieNumber);
    }
}
