package movie.ticket.controller;

import movie.ticket.QueryContainer;
import movie.ticket.domain.cinema.CinemaDtoGenerator;
import movie.ticket.dto.cinema.CinemaDto;
import movie.ticket.service.CinemaService;
import movie.ticket.view.input.controller.CinemaControllerInputView;
import movie.ticket.view.output.controller.CinemaControllerOutputView;

import java.util.List;
import java.util.stream.Collectors;

public class CinemaController {

    private final CinemaControllerInputView inputView = new CinemaControllerInputView();
    private final CinemaControllerOutputView outputView = new CinemaControllerOutputView();
    private final CinemaService cinemaService = new CinemaService();

    public void askCinema() {
        QueryContainer.saveCinemaQuery(
                inputView.askCinema()
        );
    }

    public void cinemaListUp() {
        List<CinemaDto> findAllCinemaDtos =
                cinemaService.findAllCinemasWhereMoviePlays()
                        .stream()
                        .map(CinemaDtoGenerator::toCinemaDto)
                        .collect(Collectors.toUnmodifiableList());

        outputView.responseCinemaListUp(findAllCinemaDtos);
    }
}
