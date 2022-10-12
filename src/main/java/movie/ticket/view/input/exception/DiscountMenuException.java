package movie.ticket.view.input.exception;

public enum DiscountMenuException {

    DISCOUNT_MENU_FORM_EXCEPTION("할인권 입력에서 오류가 발생하였습니다.");

    public final String message;

    DiscountMenuException(String message) {
        this.message = message;
    }
}
