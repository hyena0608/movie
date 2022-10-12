package movie.ticket.domain.discount;

public enum Discounts {

    DISCOUNT_COUPON(1L, "할인 쿠폰"),
    TICKET(2L, "관람권"),
    POINT(3L, "포인트");

    private final Long discountId;
    private final String discountName;

    Discounts(Long discountId, String discountName) {
        this.discountId = discountId;
        this.discountName = discountName;
    }
}
