package movie.ticket.domain.discount;

import java.util.function.Function;

public class CustomerDiscount {

    private static final Integer NORMAL_DISCOUNT_VALUE = 0;
    private static final Integer ADOLESCENT_DISCOUNT_VALUE = -2000;
    private static final Integer SENIOR_DISCOUNT_VALUE = 2;
    private static final Integer PREFERENTIAL_TREATMENT_DISCOUNT_VALUE = 2;
    public static final Function<Integer, Integer> NORMAL_DISCOUNT = price -> price + NORMAL_DISCOUNT_VALUE;
    public static final Function<Integer, Integer> ADOLESCENT_DISCOUNT = price -> price + ADOLESCENT_DISCOUNT_VALUE;
    public static final Function<Integer, Integer> SENIOR_DISCOUNT = price -> price / SENIOR_DISCOUNT_VALUE;
    public static final Function<Integer, Integer> PREFERENTIAL_TREATMENT_DISCOUNT = price -> price / PREFERENTIAL_TREATMENT_DISCOUNT_VALUE;

    private final Function<Integer, Integer> customerDiscount;

    public CustomerDiscount(Function<Integer, Integer> customerDiscount) {
        this.customerDiscount = customerDiscount;
    }

    public static Integer discount(Function<Integer, Integer> discountType, Integer price) {
        return discountType.apply(price);
    }
}
