package movie.ticket;

import movie.ticket.controller.ScreenController;
import movie.ticket.controller.MovieController;

public class MovieTicketApplication {

    private static final MovieController movieController = new MovieController();
    private static final ScreenController screenController = new ScreenController();

    public static void main(String[] args) {
        movieController.movieListUp();
        screenController.cinemaListUp();
    }

}
