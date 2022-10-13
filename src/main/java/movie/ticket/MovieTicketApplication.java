package movie.ticket;

import movie.ticket.controller.*;

public class MovieTicketApplication {

    private static final MovieController movieController = new MovieController();
    private static final CinemaController cinemaController = new CinemaController();
    private static final ScreenController screenController = new ScreenController();
    private static final ShowTimeController showTimeController = new ShowTimeController();
    private static final CustomerController customerController = new CustomerController();
    private static final SeatController seatController = new SeatController();
    private static final DiscountController discountController = new DiscountController();
    private static final TicketsController ticketsController = new TicketsController();

    public static void main(String[] args) {
        movieController.movieListUp();
        movieController.askMovie();

        cinemaController.cinemaListUp();
        cinemaController.askCinema();

        screenController.screenListUp();
        screenController.askScreen();

        showTimeController.showTimeListUp();
        showTimeController.askShowTime();

        customerController.customerListUp();
        customerController.askCustomer();

        seatController.seatListUp();
        seatController.askSeats();

        discountController.discountListUp();
        discountController.askDiscount();

        ticketsController.purchaseTickets();
    }

}

