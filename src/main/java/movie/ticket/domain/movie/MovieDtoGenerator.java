package movie.ticket.domain.movie;

import movie.ticket.dto.movie.MovieDto;

public class MovieDtoGenerator {

    public static MovieDto toMovieDto(Movie movie) {
        return new MovieDto(
                movie.getId(),
                movie.getName()
        );
    }
}
