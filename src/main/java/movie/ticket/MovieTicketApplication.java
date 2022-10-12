package movie.ticket;

import movie.ticket.controller.*;
import movie.ticket.form.NumberForm;

public class MovieTicketApplication {

    private static final MovieController movieController = new MovieController();
    private static final CinemaController cinemaController = new CinemaController();
    private static final ScreenController screenController = new ScreenController();
    private static final ShowTimeController showTimeController = new ShowTimeController();
    private static final CustomerController customerController = new CustomerController();

    public static void main(String[] args) {
        movieController.askMovie();
        movieController.movieListUp();
        cinemaController.askCinema();
        cinemaController.cinemaListUp();
        screenController.screenListUp();
        showTimeController.showTimeListUp();
        customerController.customerListUp();
    }

}

