package movie.ticket.controller;

import movie.ticket.QueryContainer;
import movie.ticket.domain.movie.Movie;
import movie.ticket.domain.movie.MovieDtoGenerator;
import movie.ticket.dto.movie.MovieDto;
import movie.ticket.repository.MovieRepository;
import movie.ticket.view.input.controller.MovieControllerInputView;
import movie.ticket.view.output.controller.MovieControllerOutputView;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MovieController {

    private final MovieControllerInputView inputView = new MovieControllerInputView();
    private final MovieControllerOutputView outputView = new MovieControllerOutputView();
    private final MovieRepository movieRepository = new MovieRepository();

    public void askMovie() {
        QueryContainer.saveMovieQuery(
                inputView.askMovie()
        );
    }

    public void movieListUp() {
        Collection<Movie> findAllMovies = movieRepository.findAllMovies();
        List<MovieDto> movieDtos = findAllMovies.stream()
                .map(MovieDtoGenerator::toMovieDto)
                .collect(Collectors.toUnmodifiableList());

        outputView.responseMovieListUp(movieDtos);
    }
}
