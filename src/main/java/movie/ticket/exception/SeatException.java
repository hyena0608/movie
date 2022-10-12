package movie.ticket.exception;

public enum SeatException {

    SEAT_ALREADY_FILLED_EXCEPTION("이 좌석은 선택할 수 없습니다.");

    public final String message;

    SeatException(String message) {
        this.message = message;
    }
}
