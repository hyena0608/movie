package movie.ticket.controller;

import movie.ticket.QueryContainer;
import movie.ticket.domain.showtime.ShowTimeDtoGenerator;
import movie.ticket.domain.showtime.ShowTimes;
import movie.ticket.dto.showtime.ShowTimeDto;
import movie.ticket.view.input.controller.ShowTimeControllerInputView;
import movie.ticket.view.output.controller.ShowTimeControllerOutputView;

import java.util.List;
import java.util.stream.Collectors;

public class ShowTimeController {

    private final ShowTimeControllerInputView inputView = new ShowTimeControllerInputView();
    private final ShowTimeControllerOutputView outputView = new ShowTimeControllerOutputView();

    public void askShowTime() {
        QueryContainer.saveShowTimeQuery(
                inputView.askShowTime()
        );
    }

    public void showTimeListUp() {
        List<ShowTimeDto> findAllShowTimeDtos = ShowTimes.findAllShowTimes()
                .stream()
                .map(ShowTimeDtoGenerator::toShowTimeDto)
                .collect(Collectors.toUnmodifiableList());

        outputView.responseShowTimeListUp(findAllShowTimeDtos);
    }
}
