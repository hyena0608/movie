package movie.ticket;

import movie.ticket.form.CustomerForm;
import movie.ticket.form.NumberForm;
import movie.ticket.form.SeatsForm;

public class QueryContainer {
    private static NumberForm movieQuery;
    private static NumberForm cinemaQuery;
    private static NumberForm screenQuery;
    private static NumberForm showTimeQuery;
    private static CustomerForm customerQuery;
    private static SeatsForm seatsQuery;

    public static NumberForm getMovieQuery() {
        return movieQuery;
    }

    public static void saveMovieQuery(NumberForm movieQuery) {
        QueryContainer.movieQuery = movieQuery;
    }

    public static NumberForm getCinemaQuery() {
        return cinemaQuery;
    }

    public static void saveCinemaQuery(NumberForm cinemaQuery) {
        QueryContainer.cinemaQuery = cinemaQuery;
    }

    public static NumberForm getScreenQuery() {
        return screenQuery;
    }

    public static void saveScreenQuery(NumberForm screenQuery) {
        QueryContainer.screenQuery = screenQuery;
    }

    public static NumberForm getShowTimeQuery() {
        return showTimeQuery;
    }

    public static void saveShowTimeQuery(NumberForm showTimeQuery) {
        QueryContainer.showTimeQuery = showTimeQuery;
    }

    public static CustomerForm getCustomerQuery() {
        return customerQuery;
    }

    public static void saveCustomerQuery(CustomerForm customerQuery) {
        QueryContainer.customerQuery = customerQuery;
    }

    public static SeatsForm getSeatsQuery() {
        return seatsQuery;
    }

    public static void saveSeatsQuery(SeatsForm seatsQuery) {
        QueryContainer.seatsQuery = seatsQuery;
    }
}
