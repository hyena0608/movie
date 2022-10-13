package movie.ticket.domain.discount.factory;

public interface Discount {

    Double discount(Integer price);

    boolean checkType(Long discountId);

    String loadDiscountName();

    Double loadDiscountValue();
}
