package movie.ticket.view.output.controller;

import movie.ticket.dto.cinema.ScreenDto;

import java.util.List;

import static movie.ticket.view.output.OutputView.print;
import static movie.ticket.view.output.UnitMessage.*;

public class ScreenControllerOutputView {

    private static final String ANNOUNCE_SELECT_CINEMA = "영화관 선택";

    public void responseScreenListUp(List<ScreenDto> cinemaDtos) {
        String cinemaListUpResponse = cinemaListUpResponse(cinemaDtos);
        print(cinemaListUpResponse);
    }

    private String cinemaListUpResponse(List<ScreenDto> cinemaDtos) {
        StringBuilder textBuilder = new StringBuilder();

        textBuilder.append(ANNOUNCE_SELECT_CINEMA)
                .append(ENTER.unit);

        cinemaDtos.forEach(cinemaDto ->
                textBuilder.append(cinemaDto.getId())
                        .append(DOT.unit)
                        .append(SPACE.unit)
                        .append(cinemaDto.getName())
                        .append(ENTER.unit));

        return textBuilder.toString();
    }
}
