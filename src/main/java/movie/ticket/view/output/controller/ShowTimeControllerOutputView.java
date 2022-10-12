package movie.ticket.view.output.controller;

import movie.ticket.dto.showtime.ShowTimeDto;

import java.util.List;

import static movie.ticket.view.output.OutputView.print;
import static movie.ticket.view.output.UnitMessage.*;

public class ShowTimeControllerOutputView {

    private static final String ANNOUNCE_SELECT_SHOWTIME = "시간 선택";

    public void responseShowTimeListUp(List<ShowTimeDto> showTimeDtos) {
        print(showTimeListUpResponse(showTimeDtos));
    }

    private String showTimeListUpResponse(List<ShowTimeDto> showTimeDtos) {
        StringBuilder textBuilder = new StringBuilder();

        textBuilder.append(ANNOUNCE_SELECT_SHOWTIME)
                .append(ENTER.unit);

        showTimeDtos.forEach(showTimeDto -> {
            textBuilder.append(showTimeDto.getId())
                    .append(DOT.unit)
                    .append(SPACE.unit)
                    .append(showTimeDto.getTime().toLocalTime())
                    .append(SPACE.unit);

            if (showTimeDto.getName().length() != 0) {
                textBuilder.append(LEFT_BRACKET.unit)
                        .append(showTimeDto.getName())
                        .append(RIGHT_BRACKET.unit);
            }

            textBuilder.append(ENTER.unit);
        });

        return textBuilder.toString();
    }
}
