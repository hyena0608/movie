package movie.ticket;

import movie.ticket.controller.MovieController;

public class MovieTicketApplication {

    private static final MovieController movieController = new MovieController();

    public static void main(String[] args) {
        movieController.movieListUp();
    }

}
