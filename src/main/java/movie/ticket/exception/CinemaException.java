package movie.ticket.exception;

public enum CinemaException {

    CINEMA_NOT_FOUND_EXCEPTION("존재하지 않는 영화관 번호 입니다.");

    public final String message;

    CinemaException(String message) {
        this.message = message;
    }
}
