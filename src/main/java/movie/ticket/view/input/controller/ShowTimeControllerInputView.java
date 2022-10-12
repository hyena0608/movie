package movie.ticket.view.input.controller;

import movie.ticket.form.NumberForm;

import static movie.ticket.view.input.InputView.read;
import static movie.ticket.view.input.exception.ShowTimeMenuException.*;
import static movie.ticket.view.input.util.RegexUtil.REGEX_NUMBER_FORM;
import static movie.ticket.view.input.util.RegexUtil.checkRegex;

public class ShowTimeControllerInputView {

    public NumberForm askShowTime() {
        String showTimeNumber = read();
        if (!checkShowTimeNumber(showTimeNumber)) {
            throw new NullPointerException(SHOWTIME_MENU_FORM_EXCEPTION.message);
        }
        return new NumberForm(showTimeNumber);
    }

    private boolean checkShowTimeNumber(String showTimeNumber) {
        return showTimeNumber.length() != 0 && checkRegex(REGEX_NUMBER_FORM, showTimeNumber);
    }
}
