package movie.ticket.view.input.controller;

import movie.ticket.form.NumberForm;

import static movie.ticket.view.input.InputView.read;
import static movie.ticket.view.input.exception.DiscountMenuException.DISCOUNT_MENU_FORM_EXCEPTION;
import static movie.ticket.view.input.util.RegexUtil.REGEX_NUMBER_FORM;
import static movie.ticket.view.input.util.RegexUtil.checkRegex;

public class DiscountControllerInputView {

    public NumberForm askDiscount() {
        String discountNumber = read();
        if (!checkDiscountNumber(discountNumber)) {
            throw new NullPointerException(DISCOUNT_MENU_FORM_EXCEPTION.message);
        }
        return new NumberForm(discountNumber);
    }

    private boolean checkDiscountNumber(String discountNumber) {
        return discountNumber.length() != 0 && checkRegex(REGEX_NUMBER_FORM, discountNumber);
    }
}
