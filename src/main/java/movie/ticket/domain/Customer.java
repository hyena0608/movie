package movie.ticket.domain;

import java.util.Arrays;

import static movie.ticket.exception.CustomerException.CUSTOMER_CAN_NOT_FIND_EXCEPTION;

public enum Customer {

    NORMAL("1", "일반"),
    ADOLESCENT("2", "청소년"),
    SENIOR("3", "경로"),
    PREFERENTIAL_TREATMENT("4", "우대");

    private final String customerNumber;
    private final String customerType;

    Customer(String customerNumber, String customerType) {
        this.customerNumber = customerNumber;
        this.customerType = customerType;
    }

    public static Customer findCustomerByNumber(String findNumber) {
        return Arrays.stream(Customer.values())
                .filter(customer -> customer.customerNumber.equals(findNumber))
                .findFirst()
                .orElseThrow(() -> new NullPointerException(CUSTOMER_CAN_NOT_FIND_EXCEPTION.message));
    }
}
