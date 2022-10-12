package movie.ticket.service;

import movie.ticket.QueryContainer;
import movie.ticket.domain.cinema.CinemaMovie;
import movie.ticket.domain.cinema.Cinemas;
import movie.ticket.domain.movie.Movie;
import movie.ticket.domain.screen.Screens;
import movie.ticket.repository.MovieRepository;

import java.util.Collection;

public class ScreenService {

    private final MovieRepository movieRepository = new MovieRepository();

    public Collection<Screens> findAllScreensWhereCinemaPlays() {
        Long movieId = Long.parseLong(QueryContainer
                                        .getMovieQuery()
                                        .getSelectedMenu());
        Long cinemaId = Long.parseLong(QueryContainer
                                        .getCinemaQuery()
                                        .getSelectedMenu());

        Movie findMovie = movieRepository.findMovieById(movieId);
        Cinemas findCinema = Cinemas.findCinemaById(cinemaId);
        CinemaMovie findCinemaMovie = findCinema.findCinemaMovieTypeByMovie(findMovie);

        return findCinemaMovie.loadScreens();
    }
}
