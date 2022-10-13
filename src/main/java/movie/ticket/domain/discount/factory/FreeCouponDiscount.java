package movie.ticket.domain.discount.factory;

public class FreeCouponDiscount implements Discount {

    private static final Long DISCOUNT_ID = 2L;
    private static final String DISCOUNT_NAME = "관람권";
    private static final Double DISCOUNT_VALUE = 0.0;

    @Override
    public Double discount(Integer price) {
        return DISCOUNT_VALUE;
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
