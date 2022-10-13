package movie.ticket.dto.ticket;

import movie.ticket.domain.discount.factory.Discount;
import movie.ticket.dto.customer.CustomersDto;
import movie.ticket.dto.movie.MovieDto;
import movie.ticket.dto.screen.ScreenDto;
import movie.ticket.dto.showtime.ShowTimeDto;

public class TicketDto {

    private final CustomersDto customer;
    private final ScreenDto screen;
    private final MovieDto movie;
    private final ShowTimeDto showTime;
    private final Discount discount;
    private final Integer price;

    public TicketDto(CustomersDto customer, ScreenDto screen, MovieDto movie, ShowTimeDto showTime, Discount discount, Integer price) {
        this.customer = customer;
        this.screen = screen;
        this.movie = movie;
        this.showTime = showTime;
        this.discount = discount;
        this.price = price;
    }

    public CustomersDto getCustomer() {
        return customer;
    }

    public ScreenDto getScreen() {
        return screen;
    }

    public MovieDto getMovie() {
        return movie;
    }

    public ShowTimeDto getShowTime() {
        return showTime;
    }

    public Discount getDiscount() {
        return discount;
    }

    public Integer getPrice() {
        return price;
    }
}
