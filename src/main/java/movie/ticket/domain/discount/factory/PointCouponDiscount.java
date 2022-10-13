package movie.ticket.domain.discount.factory;

import static java.lang.String.*;

public class PointCouponDiscount implements Discount {

    private static final Long DISCOUNT_ID = 3L;
    private static final String DISCOUNT_NAME = "포인트";
    private static final Double DISCOUNT_VALUE = 500.0;

    @Override
    public Double discount(Integer price) {
        return Double.valueOf(valueOf(price - DISCOUNT_VALUE));
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
