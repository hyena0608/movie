package movie.ticket.controller;

import movie.ticket.QueryContainer;
import movie.ticket.domain.seat.Seats;
import movie.ticket.domain.seat.SeatsDtoGenerator;
import movie.ticket.dto.seat.SeatsDto;
import movie.ticket.service.SeatsService;
import movie.ticket.view.input.controller.SeatControllerInputView;
import movie.ticket.view.output.controller.SeatControllerOutputView;

public class SeatController {

    private final SeatControllerInputView inputView = new SeatControllerInputView();
    private final SeatControllerOutputView outputView = new SeatControllerOutputView();
    private final SeatsService seatsService = new SeatsService();

    public void askSeats() {
        QueryContainer.saveSeatsQuery(
                inputView.askSeats()
        );
        seatsService.reflectSeats();
    }

    public void seatListUp() {
        Seats findSeats = seatsService.findPossibleSeats();
        SeatsDto seatsDto = SeatsDtoGenerator.toSeatsDto(findSeats.loadAllSeats());
        outputView.responseSeatListUp(seatsDto);
    }

}
