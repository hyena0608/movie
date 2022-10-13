package movie.ticket.domain.discount.factory;

import static movie.ticket.exception.DiscountException.DISCOUNT_NOT_FOUND_EXCEPTION;

public class DiscountFactory {

    private static final Discount eventCoupon = new EventCouponDiscount();
    private static final Discount freeCoupon = new FreeCouponDiscount();
    private static final Discount pointCoupon = new PointCouponDiscount();

    public static Discount findCoupon(Long discountType) {
        if (eventCoupon.checkType(discountType)) {
            return eventCoupon;
        }
        if (freeCoupon.checkType(discountType)) {
            return freeCoupon;
        }
        if (pointCoupon.checkType(discountType)) {
            return pointCoupon;
        }
        throw new NullPointerException(DISCOUNT_NOT_FOUND_EXCEPTION.message);
    }
}
