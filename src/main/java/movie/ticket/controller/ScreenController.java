package movie.ticket.controller;

import movie.ticket.domain.screen.ScreenDtoGenerator;
import movie.ticket.domain.screen.Screens;
import movie.ticket.dto.screen.ScreenDto;
import movie.ticket.view.input.controller.ScreenControllerInputView;
import movie.ticket.view.output.controller.ScreenControllerOutputView;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ScreenController {

    private final ScreenControllerInputView inputView = new ScreenControllerInputView();
    private final ScreenControllerOutputView outputView = new ScreenControllerOutputView();

    public void screenListUp() {
        List<ScreenDto> screenDtos =
                Screens.findAllCinemas()
                        .stream()
                        .map(ScreenDtoGenerator::toScreenDto)
                        .collect(Collectors.toUnmodifiableList());

        outputView.responseScreenListUp(screenDtos);
    }
}
