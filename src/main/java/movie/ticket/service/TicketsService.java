package movie.ticket.service;

import movie.ticket.QueryContainer;
import movie.ticket.domain.cinema.CinemaMovie;
import movie.ticket.domain.cinema.Cinemas;
import movie.ticket.domain.customer.Customer;
import movie.ticket.domain.discount.factory.Discount;
import movie.ticket.domain.discount.factory.DiscountFactory;
import movie.ticket.domain.movie.Movie;
import movie.ticket.domain.movie.Movies;
import movie.ticket.domain.screen.Screen;
import movie.ticket.domain.seat.Seat;
import movie.ticket.domain.showtime.ShowTime;
import movie.ticket.ticket.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TicketsService {

    public List<Ticket> generateTickets() {
        Long movieId = Long.parseLong(QueryContainer
                .getMovieQuery()
                .getSelectedMenu());
        Long cinemaId = Long.parseLong(QueryContainer
                .getCinemaQuery()
                .getSelectedMenu());
        Long screenId = Long.parseLong(QueryContainer
                .getScreenQuery()
                .getSelectedMenu());
        Long showTimeId = Long.parseLong(QueryContainer
                .getShowTimeQuery()
                .getSelectedMenu());
        Long discountId = Long.parseLong(QueryContainer
                .getDiscountQuery()
                .getSelectedMenu());
        List<Seat> queriedSeats = QueryContainer.getSeatsQuery()
                .getSeatNumbers();
        Map<Customer, Integer> queriedCustomers = QueryContainer.getCustomerQuery()
                .loadCustomerForms();

        Movie findMovie = Movies.findMovieById(movieId);
        Cinemas findCinema = Cinemas.findCinemaById(cinemaId);
        Screen findScreen = Screen.findScreenById(screenId);
        CinemaMovie findCinemaMovie = findCinema.findCinemaMovieTypeByMovie(findMovie);
        ShowTime findShowTime = ShowTime.findShowTimeById(showTimeId);
        Discount findDiscount = DiscountFactory.findCoupon(discountId);

        List<Seat> findSeats = loadCinemaMovieSeats(queriedSeats, findCinemaMovie, findShowTime);
        List<Customer> loadedCustomers = loadCustomers(queriedCustomers);
        List<Ticket> generatedTickets =
                IntStream.range(0, loadedCustomers.size())
                        .mapToObj(customerIndex -> {
                            return new Ticket(
                                    loadedCustomers.get(customerIndex),
                                    findCinema,
                                    findScreen,
                                    findMovie,
                                    findShowTime,
                                    findSeats.get(customerIndex),
                                    findDiscount
                            );
                        }).collect(Collectors.toUnmodifiableList());

        return generatedTickets;
    }

    public void generateTickets(List<Ticket> tickets) {
        Long cinemaId = Long.parseLong(QueryContainer
                .getCinemaQuery()
                .getSelectedMenu());
        Cinemas findCinema = Cinemas.findCinemaById(cinemaId);

        findCinema.reflectTickets(tickets);
    }

    private List<Customer> loadCustomers(Map<Customer, Integer> queriedCustomers) {
        List<Customer> customers = new ArrayList<>();
        queriedCustomers.forEach((key, value) ->
                IntStream.range(0, value)
                        .forEach(count -> customers.add(key)));

        return customers;
    }

    private List<Seat> loadCinemaMovieSeats(List<Seat> queriedSeats, CinemaMovie findCinemaMovie, ShowTime findShowTime) {
        return findCinemaMovie.loadSeatsByShowTime(findShowTime)
                .loadAllSeats()
                .keySet()
                .stream()
                .filter(seat ->
                        queriedSeats.stream()
                                .anyMatch(queriedSeat -> queriedSeat.checkSame(seat)))
                .collect(Collectors.toUnmodifiableList());
    }
}
