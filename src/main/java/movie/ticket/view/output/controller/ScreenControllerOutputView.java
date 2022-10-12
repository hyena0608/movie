package movie.ticket.view.output.controller;

import movie.ticket.dto.screen.ScreenDto;

import java.util.List;

import static movie.ticket.view.output.OutputView.print;
import static movie.ticket.view.output.UnitMessage.*;

public class ScreenControllerOutputView {

    private static final String ANNOUNCE_SELECT_SCREEN = "상영관 선택";

    public void responseScreenListUp(List<ScreenDto> screenDtos) {
        String screenListUpResponse = screenListUpResponse(screenDtos);
        print(screenListUpResponse);
    }

    private String screenListUpResponse(List<ScreenDto> screenDtos) {
        StringBuilder textBuilder = new StringBuilder();

        textBuilder.append(ANNOUNCE_SELECT_SCREEN)
                .append(ENTER.unit);

        screenDtos.forEach(screenDto ->
                textBuilder.append(screenDto.getId())
                        .append(DOT.unit)
                        .append(SPACE.unit)
                        .append(screenDto.getName())
                        .append(ENTER.unit));

        return textBuilder.toString();
    }
}
