package movie.ticket.domain.receipt;

import movie.ticket.domain.discount.DiscountHistory;
import movie.ticket.domain.movie.Movie;

import java.time.LocalDateTime;

public class Receipt {

    private final Movie movie;
    private final LocalDateTime localDateTime;
    private final DiscountHistory history;
    private final Integer totalPrice;

    public Receipt(Movie movie, LocalDateTime localDateTime, DiscountHistory history, Integer totalPrice) {
        this.movie = movie;
        this.localDateTime = localDateTime;
        this.history = history;
        this.totalPrice = totalPrice;
    }
}
