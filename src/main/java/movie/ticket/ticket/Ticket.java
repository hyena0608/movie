package movie.ticket.ticket;

import movie.ticket.domain.cinema.Cinemas;
import movie.ticket.domain.customer.Customer;
import movie.ticket.domain.discount.CustomerDiscount;
import movie.ticket.domain.discount.factory.Discount;
import movie.ticket.domain.movie.Movie;
import movie.ticket.domain.screen.Screen;
import movie.ticket.domain.seat.Seat;
import movie.ticket.domain.showtime.ShowTime;

import java.util.function.Function;

public class Ticket {

    private final Customer customer;
    private final Cinemas cinema;
    private final Screen screen;
    private final Movie movie;
    private final ShowTime showTime;
    private final Seat seat;
    private final Discount discount;
    private final Integer price;

    public Ticket(Customer customer, Cinemas cinema, Screen screen, Movie movie, ShowTime showTime, Seat seat, Discount discount) {
        this.customer = customer;
        this.cinema = cinema;
        this.screen = screen;
        this.movie = movie;
        this.showTime = showTime;
        this.seat = seat;
        this.discount = discount;
        this.price = screen.loadPrice();
    }

    private void reflectPrice() {
        Function<Integer, Integer> discountType = customer.loadCustomerDiscountType();
        CustomerDiscount.discount(discountType, this.price);
        discount.discount(this.price);
    }

    public Integer loadPrice() {
        reflectPrice();
        return price;
    }

    Customer getCustomer() {
        return customer;
    }

    Screen getScreen() {
        return screen;
    }

    Movie getMovie() {
        return movie;
    }

    ShowTime getShowTime() {
        return showTime;
    }

    Discount getDiscount() {
        return discount;
    }

    Integer getPrice() {
        return price;
    }
}
