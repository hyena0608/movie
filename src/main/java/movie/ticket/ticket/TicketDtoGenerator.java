package movie.ticket.ticket;

import movie.ticket.domain.customer.CustomerDtoGenerator;
import movie.ticket.domain.movie.MovieDtoGenerator;
import movie.ticket.domain.screen.ScreenDtoGenerator;
import movie.ticket.domain.showtime.ShowTimeDtoGenerator;
import movie.ticket.dto.ticket.TicketDto;

public class TicketDtoGenerator {

    public static TicketDto toTicketDto(Ticket ticket) {
        return new TicketDto(
                CustomerDtoGenerator.toCustomersDto(ticket.getCustomer()),
                ScreenDtoGenerator.toScreenDto(ticket.getScreen()),
                MovieDtoGenerator.toMovieDto(ticket.getMovie()),
                ShowTimeDtoGenerator.toShowTimeDto(ticket.getShowTime()),
                ticket.getDiscount(),
                ticket.getPrice()
        );
    }
}
