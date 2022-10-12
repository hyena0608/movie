package movie.ticket.exception;

public enum MovieException {

    MOVIE_NOT_FOUND_EXCEPTION("존재하지 않는 영화 번호 입니다.");

    public final String message;

    MovieException(String message) {
        this.message = message;
    }
}
