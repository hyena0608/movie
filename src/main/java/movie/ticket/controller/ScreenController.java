package movie.ticket.controller;

import movie.ticket.QueryContainer;
import movie.ticket.domain.screen.ScreenDtoGenerator;
import movie.ticket.dto.screen.ScreenDto;
import movie.ticket.service.ScreenService;
import movie.ticket.view.input.controller.ScreenControllerInputView;
import movie.ticket.view.output.controller.ScreenControllerOutputView;

import java.util.List;
import java.util.stream.Collectors;

public class ScreenController {

    private final ScreenControllerInputView inputView = new ScreenControllerInputView();
    private final ScreenControllerOutputView outputView = new ScreenControllerOutputView();
    private final ScreenService screenService = new ScreenService();

    public void askScreen() {
        QueryContainer.saveScreenQuery(
                inputView.askScreen()
        );
    }

    public void screenListUp() {
        List<ScreenDto> screenDtos = screenService.findAllScreensWhereCinemaPlays()
                .stream()
                .map(ScreenDtoGenerator::toScreenDto)
                .collect(Collectors.toUnmodifiableList());

        outputView.responseScreenListUp(screenDtos);
    }
}
