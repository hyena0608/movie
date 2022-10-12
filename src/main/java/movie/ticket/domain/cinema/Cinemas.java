package movie.ticket.domain.cinema;

public enum Cinemas {

    TWO_DIMENSIONS(1L, "2D"),
    THREE_DIMENSIONS(2L, "3D");

    private final Long discountId;
    private final String cinemaName;

    Cinemas(Long discountId, String cinemaName) {
        this.discountId = discountId;
        this.cinemaName = cinemaName;
    }
}
