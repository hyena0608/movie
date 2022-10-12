package movie.ticket.view.input.controller;

import movie.ticket.form.NumberForm;

import static movie.ticket.view.input.InputView.read;
import static movie.ticket.view.input.exception.ScreenMenuException.SCREEN_MENU_FORM_EXCEPTION;
import static movie.ticket.view.input.util.RegexUtil.REGEX_NUMBER_FORM;
import static movie.ticket.view.input.util.RegexUtil.checkRegex;

public class ScreenControllerInputView {
    
    public NumberForm askScreen() {
        String screenNumber = read();
        if (!checkScreenNumber(screenNumber)) {
            throw new NullPointerException(SCREEN_MENU_FORM_EXCEPTION.message);
        }
        return new NumberForm(screenNumber);
    }

    private boolean checkScreenNumber(String screenNumber) {
        return screenNumber.length() != 0 && checkRegex(REGEX_NUMBER_FORM, screenNumber);
    }
}
