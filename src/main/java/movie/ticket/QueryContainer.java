package movie.ticket;

import movie.ticket.form.NumberForm;

public class QueryContainer {
    private static NumberForm movieQuery;
    private static NumberForm cinemaQuery;
    private static NumberForm screenQuery;
    private static NumberForm showTimeQuery;

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
}
