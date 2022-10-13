package movie.ticket.service;

import movie.ticket.QueryContainer;
import movie.ticket.domain.cinema.CinemaMovie;
import movie.ticket.domain.cinema.Cinemas;
import movie.ticket.domain.movie.Movie;
import movie.ticket.domain.showtime.ShowTime;
import movie.ticket.repository.MovieRepository;

import java.util.Collection;

public class ShowTimeService {

    private final MovieRepository movieRepository = new MovieRepository();

    public Collection<ShowTime> findAllPossibleShowTimes() {
        Long movieId = Long.parseLong(QueryContainer
                                        .getMovieQuery()
                                        .getSelectedMenu());
        Long cinemaId = Long.parseLong(QueryContainer
                                        .getCinemaQuery()
                                        .getSelectedMenu());

        Movie findMovie = movieRepository.findMovieById(movieId);
        Cinemas findCinema = Cinemas.findCinemaById(cinemaId);
        CinemaMovie findCinemaMovie = findCinema.findCinemaMovieTypeByMovie(findMovie);

        return findCinemaMovie.loadPossibleShowTimes();
    }
}
