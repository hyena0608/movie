package movie.ticket.view.input.controller;

import movie.ticket.form.CustomerForm;

import static movie.ticket.view.input.InputView.read;
import static movie.ticket.view.input.exception.ShowTimeMenuException.SHOWTIME_MENU_FORM_EXCEPTION;

public class CustomerControllerInputView {

    private static final int CUSTOMER_NUMBER_PARSE_INDEX = 0;
    private static final int HEADCOUNT_PARSE_INDEX = 1;

    public CustomerForm askCustomer() {
        CustomerForm customerForm = new CustomerForm();

        while (true) {

            String customerInput = read();

            if (customerInput.length() == 0) {
                break;
            }

            String[] commands = splitCommand(customerInput);
            String customerNumber = parseCommand(commands[CUSTOMER_NUMBER_PARSE_INDEX]);
            String headCount = parseCommand(commands[HEADCOUNT_PARSE_INDEX]);

            customerForm.reflectCustomer(customerNumber, headCount);
        }

        if (!customerForm.checkForm()) {
            throw new NullPointerException(SHOWTIME_MENU_FORM_EXCEPTION.message);
        }

        return customerForm;
    }

    private String[] splitCommand(String commands) {
        return commands.split(" ");
    }

    private String parseCommand(String command) {
        return command.replace(",", " ").trim();
    }
}
