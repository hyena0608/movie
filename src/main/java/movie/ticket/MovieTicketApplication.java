package movie.ticket;

import movie.ticket.controller.CinemaController;
import movie.ticket.controller.ScreenController;
import movie.ticket.controller.MovieController;

public class MovieTicketApplication {

    private static final MovieController movieController = new MovieController();
    private static final CinemaController cinemaController = new CinemaController();
    private static final ScreenController screenController = new ScreenController();

    public static void main(String[] args) {
        movieController.movieListUp();
        cinemaController.cinemaListUp();
        screenController.screenListUp();
    }

}
