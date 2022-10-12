package movie.ticket.controller;

import movie.ticket.repository.SeatRepository;
import movie.ticket.view.input.controller.SeatControllerInputView;
import movie.ticket.view.output.controller.SeatControllerOutputView;

public class SeatController {

    private final SeatControllerInputView inputView = new SeatControllerInputView();
    private final SeatControllerOutputView outputView = new SeatControllerOutputView();
    private final SeatRepository seatRepository = new SeatRepository();

    public void seatListUp() {
        seatRepository
        outputView.responseSeatListUp();
    }

}
