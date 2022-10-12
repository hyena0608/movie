package movie.ticket.controller;

import movie.ticket.domain.cinema.ScreenDtoGenerator;
import movie.ticket.domain.cinema.Screens;
import movie.ticket.dto.cinema.ScreenDto;
import movie.ticket.view.input.controller.ScreenControllerInputView;
import movie.ticket.view.output.controller.ScreenControllerOutputView;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ScreenController {

    private final ScreenControllerInputView inputView = new ScreenControllerInputView();
    private final ScreenControllerOutputView outputView = new ScreenControllerOutputView();

    public void cinemaListUp() {
        Collection<Screens> findAllScreens = Screens.findAllCinemas();
        List<ScreenDto> screenDtos = findAllScreens.stream()
                .map(ScreenDtoGenerator::toScreenDto)
                .collect(Collectors.toUnmodifiableList());

        outputView.responseScreenListUp(screenDtos);
    }
}
