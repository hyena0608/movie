package movie.ticket.domain.customer;

import java.util.Arrays;
import java.util.Objects;

import static movie.ticket.exception.CustomerException.CUSTOMER_CAN_NOT_FIND_EXCEPTION;

public enum Customers {

    NORMAL(1L, "일반"),
    ADOLESCENT(2L, "청소년"),
    SENIOR(3L, "경로"),
    PREFERENTIAL_TREATMENT(4L, "우대");

    private final Long customerId;
    private final String customerName;

    Customers(Long customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public static Customers findCustomerByNumber(Long customerId) {
        return Arrays.stream(Customers.values())
                .filter(customer -> Objects.equals(customer.customerId, customerId))
                .findFirst()
                .orElseThrow(() -> new NullPointerException(CUSTOMER_CAN_NOT_FIND_EXCEPTION.message));
    }
}
