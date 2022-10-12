package movie.ticket.view.input.exception;

public enum SeatException {

    SEAT_INPUT_FORM_EXCEPTION("좌석 입력에서 오류가 발생하였습니다.");

    public final String message;

    SeatException(String message) {
        this.message = message;
    }
}
