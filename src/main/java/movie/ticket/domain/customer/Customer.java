package movie.ticket.domain.customer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static movie.ticket.domain.discount.CustomerDiscount.*;
import static movie.ticket.exception.CustomerException.CUSTOMER_CAN_NOT_FIND_EXCEPTION;

public enum Customer {

    NORMAL(1L, "일반", NORMAL_DISCOUNT),
    ADOLESCENT(2L, "청소년", ADOLESCENT_DISCOUNT),
    SENIOR(3L, "경로", SENIOR_DISCOUNT),
    PREFERENTIAL_TREATMENT(4L, "우대", PREFERENTIAL_TREATMENT_DISCOUNT);

    private final Long customerId;
    private final String customerName;
    private final Function<Integer, Integer> customerDiscount;

    Customer(Long customerId, String customerName, Function<Integer, Integer> customerDiscount) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerDiscount = customerDiscount;
    }

    public static Collection<Customer> findAllCustomers() {
        return Arrays.stream(Customer.values())
                .collect(Collectors.toUnmodifiableList());
    }

    public static Customer findCustomerById(Long customerId) {
        return Arrays.stream(Customer.values())
                .filter(customer -> Objects.equals(customer.customerId, customerId))
                .findFirst()
                .orElseThrow(() -> new NullPointerException(CUSTOMER_CAN_NOT_FIND_EXCEPTION.message));
    }

    public Function<Integer, Integer> loadCustomerDiscountType() {
        return customerDiscount;
    }

    public boolean checkSameById(Long id) {
        return Objects.equals(this.customerId, id);
    }

    Long getCustomerId() {
        return customerId;
    }

    String getCustomerName() {
        return customerName;
    }
}
