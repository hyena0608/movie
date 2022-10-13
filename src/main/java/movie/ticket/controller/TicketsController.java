package movie.ticket.controller;

import movie.ticket.dto.ticket.TicketDto;
import movie.ticket.service.TicketsService;
import movie.ticket.ticket.Ticket;
import movie.ticket.ticket.TicketDtoGenerator;
import movie.ticket.view.output.controller.TicketControllerOutputView;

import java.util.List;
import java.util.stream.Collectors;

public class TicketsController {

    private final TicketControllerOutputView outputView = new TicketControllerOutputView();
    private final TicketsService ticketsService = new TicketsService();

    public void purchaseTickets() {
        List<Ticket> tickets = ticketsService.generateTickets();
        List<TicketDto> ticketDtos = tickets.stream()
                                            .map(TicketDtoGenerator::toTicketDto)
                                            .collect(Collectors.toUnmodifiableList());
        outputView.responseTicketsContext(ticketDtos);
    }
}
