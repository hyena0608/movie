package movie.ticket.service;

import movie.ticket.QueryContainer;
import movie.ticket.domain.cinema.Cinemas;
import movie.ticket.domain.movie.Movie;
import movie.ticket.repository.MovieRepository;

import java.util.Collection;
import java.util.stream.Collectors;

public class CinemaService {

    private final MovieRepository movieRepository = new MovieRepository();

    public Collection<Cinemas> findAllCinemasWhereMoviePlays() {
        Long movieId = Long.parseLong(QueryContainer
                                        .getMovieQuery()
                                        .getSelectedMenu());

        Movie findMovie = movieRepository.findMovieById(movieId);

        return Cinemas.findAllCinemas()
                .stream()
                .filter(cinemas -> cinemas.checkMoviePlays(findMovie))
                .collect(Collectors.toUnmodifiableList());
    }
}
