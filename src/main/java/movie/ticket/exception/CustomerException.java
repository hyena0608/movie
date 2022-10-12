package movie.ticket.exception;

public enum CustomerException {

    CUSTOMER_CAN_NOT_FIND_EXCEPTION("존재하지 않은 고객 타입입니다.");

    public final String message;

    CustomerException(String message) {
        this.message = message;
    }
}
