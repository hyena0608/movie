package movie.ticket.domain.discount;

import movie.ticket.dto.discount.DiscountDto;

public class DiscountDtoGenerator {

    public static DiscountDto toDiscountDto(Discounts discount) {
        return new DiscountDto(
                discount.getDiscountId(),
                discount.getDiscountName()
        );
    }
}
