package movie.ticket.exception;

public enum ScreenException {

    SCREEN_CAN_NOT_FIND_EXCEPTION("존재하지 않은 상영관입니다.");

    public final String message;

    ScreenException(String message) {
        this.message = message;
    }
}
