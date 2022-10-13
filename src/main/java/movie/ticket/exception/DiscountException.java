package movie.ticket.exception;

public enum DiscountException {

    DISCOUNT_NOT_FOUND_EXCEPTION("존재하지 않는 할인 번호 입니다.");

    public final String message;

    DiscountException(String message) {
        this.message = message;
    }
}
