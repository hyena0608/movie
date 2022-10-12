package movie.ticket.domain.customer;

import movie.ticket.view.input.InputView;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static movie.ticket.exception.CustomerException.CUSTOMER_CAN_NOT_FIND_EXCEPTION;

public enum Customers {

    NORMAL(1L, "일반", (price -> price)),
    ADOLESCENT(2L, "청소년", (price -> price - 2000)),
    SENIOR(3L, "경로", (price -> price / 2)),
    PREFERENTIAL_TREATMENT(4L, "우대", (price -> price / 2));

    private final Long customerId;
    private final String customerName;
    private final Function<Integer, Integer> discount;

    Customers(Long customerId, String customerName, Function<Integer, Integer> discount) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.discount = discount;
    }

    public Integer discount(Integer price) {
        return this.discount.apply(price);
    }

    public static Collection<Customers> findAllCustomers() {
        return Arrays.stream(Customers.values())
                .collect(Collectors.toUnmodifiableList());
    }

    public static Customers findCustomerByNumber(Long customerId) {
        return Arrays.stream(Customers.values())
                .filter(customer -> Objects.equals(customer.customerId, customerId))
                .findFirst()
                .orElseThrow(() -> new NullPointerException(CUSTOMER_CAN_NOT_FIND_EXCEPTION.message));
    }

    Long getCustomerId() {
        return customerId;
    }

    String getCustomerName() {
        return customerName;
    }
}
