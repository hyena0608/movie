package movie.ticket.view.input.exception;

public enum MovieMenuException {

    MOVIE_MENU_FORM_EXCEPTION("영화 입력에서 오류가 발생하였습니다.");

    public final String message;

    MovieMenuException(String message) {
        this.message = message;
    }
}
