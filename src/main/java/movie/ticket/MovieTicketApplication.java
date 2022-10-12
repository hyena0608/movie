package movie.ticket;

import movie.ticket.controller.*;

public class MovieTicketApplication {

    private static final MovieController movieController = new MovieController();
    private static final CinemaController cinemaController = new CinemaController();
    private static final ScreenController screenController = new ScreenController();
    private static final ShowTimeController showTimeController = new ShowTimeController();
    private static final CustomerController customerController = new CustomerController();

    public static void main(String[] args) {
        movieController.movieListUp();
        movieController.askMovie();

        cinemaController.cinemaListUp();
        cinemaController.askCinema();

        screenController.screenListUp();
        screenController.askScreen();

        showTimeController.showTimeListUp();
        showTimeController.askShowTime();

        customerController.customerListUp();
    }

}

