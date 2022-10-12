package movie.ticket.view.input.exception;

public enum CinemaMenuException {

    CINEMA_MENU_FORM_EXCEPTION("상영관 입력에서 오류가 발생하였습니다.");

    public final String message;

    CinemaMenuException(String message) {
        this.message = message;
    }
}
