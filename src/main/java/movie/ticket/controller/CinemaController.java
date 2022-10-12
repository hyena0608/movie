package movie.ticket.controller;

import movie.ticket.domain.cinema.CinemaDtoGenerator;
import movie.ticket.domain.cinema.Cinemas;
import movie.ticket.dto.cinema.CinemaDto;
import movie.ticket.view.input.controller.CinemaControllerInputView;
import movie.ticket.view.output.controller.CinemaControllerOutputView;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CinemaController {

    private final CinemaControllerInputView inputView = new CinemaControllerInputView();
    private final CinemaControllerOutputView outputView = new CinemaControllerOutputView();

    public void cinemaListUp() {
        Collection<Cinemas> findAllCinemas = Cinemas.findAllCinemas();
        List<CinemaDto> cinemaDtos = findAllCinemas.stream()
                .map(CinemaDtoGenerator::toCinemaDto)
                .collect(Collectors.toUnmodifiableList());

        outputView.responseCinemaListUp(cinemaDtos);
    }
}
