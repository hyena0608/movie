package movie.ticket.exception;

public enum ShowTimeException {

    SHOW_TIME_NOT_FOUND_EXCEPTION("존재하지 않는 영화 상영 시간 입니다.");

    public final String message;

    ShowTimeException(String message) {
        this.message = message;
    }
}
