package movie.ticket.domain.discount.factory;

import static java.lang.Integer.*;
import static java.lang.String.*;

public class EventCouponDiscount implements Discount {

    private static final Long DISCOUNT_ID = 1L;
    private static final String DISCOUNT_NAME = "할인 쿠폰";
    private static final Double DISCOUNT_VALUE = 0.8;

    @Override
    public Double discount(Integer price) {
        return Double.valueOf(valueOf(price * DISCOUNT_VALUE));
    }

    @Override
    public boolean checkType(Long discountId) {
        return DISCOUNT_ID.equals(discountId);
    }

    @Override
    public String loadDiscountName() {
        return DISCOUNT_NAME;
    }

    @Override
    public Double loadDiscountValue() {
        return DISCOUNT_VALUE;
    }
}
