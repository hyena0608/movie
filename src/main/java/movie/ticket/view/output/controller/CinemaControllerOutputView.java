package movie.ticket.view.output.controller;

import movie.ticket.dto.cinema.CinemaDto;

import java.util.List;

import static movie.ticket.view.output.OutputView.print;
import static movie.ticket.view.output.UnitMessage.*;

public class CinemaControllerOutputView {

    private static final String ANNOUNCE_SELECT_CINEMA = "영화관 선택";

    public void responseCinemaListUp(List<CinemaDto> cinemaDtos) {
        print(cinemaListUpResponse(cinemaDtos));
    }

    private String cinemaListUpResponse(List<CinemaDto> cinemaDtos) {
        StringBuilder textBuilder = new StringBuilder();

        textBuilder.append(ANNOUNCE_SELECT_CINEMA)
                .append(ENTER.unit);

        cinemaDtos.forEach(cinemaDto ->
                textBuilder.append(cinemaDto.getId())
                        .append(DOT.unit)
                        .append(SPACE.unit)
                        .append(cinemaDto.getName())
                        .append(ENTER.unit)
        );

        return textBuilder.toString();
    }
}
