package movie.ticket.ticket;

import java.util.HashMap;
import java.util.Map;

public class Tickets {

    private final Map<Long, Ticket> tickets;

    public Tickets() {
        this.tickets = new HashMap<>();
    }

    public void reflectTicket(Ticket ticket) {
        tickets.put((long) (tickets.size() + 1), ticket);
    }
}
