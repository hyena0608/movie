package movie.ticket.view.input.menu;

import movie.ticket.form.NumberForm;

import static movie.ticket.view.input.InputView.read;
import static movie.ticket.view.input.exception.DiscountMenuException.*;
import static movie.ticket.view.input.util.RegexUtil.REGEX_NUMBER_FORM;
import static movie.ticket.view.input.util.RegexUtil.checkRegex;

public class DiscountMenuInView {

    public static NumberForm askDiscount() {
        String discountNumber = read();
        if (!checkDiscountNumber(discountNumber)) {
            throw new NullPointerException(DISCOUNT_MENU_FORM_EXCEPTION.message);
        }
        return new NumberForm(discountNumber);
    }

    private static boolean checkDiscountNumber(String discountNumber) {
        return discountNumber.length() != 0 && checkRegex(REGEX_NUMBER_FORM, discountNumber);
    }
}
