package movie.ticket.view.output.controller;

import movie.ticket.dto.movie.MovieDto;
import movie.ticket.view.output.OutputView;

import java.util.List;

import static movie.ticket.view.output.OutputView.*;
import static movie.ticket.view.output.UnitMessage.*;

public class MovieControllerOutputView {

    private static final String ANNOUNCE_SELECT_MOVIE = "영화 선택";

    public void responseMovieListUp(List<MovieDto> movieDtos) {
        String movieListUpResponse = movieListUpResponse(movieDtos);
        print(movieListUpResponse);
    }

    private String movieListUpResponse(List<MovieDto> movieDtos) {
        StringBuilder textBuilder = new StringBuilder();

        textBuilder.append(ANNOUNCE_SELECT_MOVIE)
                .append(ENTER.unit);

        movieDtos.forEach(movieDto ->
                textBuilder.append(movieDto.getId())
                        .append(DOT.unit)
                        .append(SPACE.unit)
                        .append(movieDto.getName())
                        .append(ENTER.unit));

        return textBuilder.toString();
    }
}
