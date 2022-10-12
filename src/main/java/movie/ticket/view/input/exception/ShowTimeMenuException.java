package movie.ticket.view.input.exception;

public enum ShowTimeMenuException {

    SHOWTIME_MENU_FORM_EXCEPTION("상영 시간 입력에서 오류가 발생하였습니다.");

    public final String message;

    ShowTimeMenuException(String message) {
        this.message = message;
    }
}
