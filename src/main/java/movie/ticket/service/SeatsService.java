package movie.ticket.service;

import movie.ticket.QueryContainer;
import movie.ticket.domain.cinema.CinemaMovie;
import movie.ticket.domain.cinema.Cinemas;
import movie.ticket.domain.movie.Movie;
import movie.ticket.domain.seat.Seats;
import movie.ticket.domain.showtime.ShowTime;
import movie.ticket.form.SeatsForm;
import movie.ticket.repository.MovieRepository;

public class SeatsService {

    private final MovieRepository movieRepository = new MovieRepository();

    public Seats findPossibleSeats() {
        Long movieId = Long.parseLong(QueryContainer
                .getMovieQuery()
                .getSelectedMenu());
        Long cinemaId = Long.parseLong(QueryContainer
                .getCinemaQuery()
                .getSelectedMenu());
        Long showTimeId = Long.parseLong(QueryContainer
                .getShowTimeQuery()
                .getSelectedMenu());

        Movie findMovie = movieRepository.findMovieById(movieId);
        Cinemas findCinema = Cinemas.findCinemaById(cinemaId);
        CinemaMovie findCinemaMovie = findCinema.findCinemaMovieTypeByMovie(findMovie);
        ShowTime findShowTime = ShowTime.findShowTimeById(showTimeId);
        Seats findSeats = findCinemaMovie.loadSeatsByShowTime(findShowTime);

        return findSeats;
    }

    public void reflectSeats() {
        Long movieId = Long.parseLong(QueryContainer
                .getMovieQuery()
                .getSelectedMenu());
        Long cinemaId = Long.parseLong(QueryContainer
                .getCinemaQuery()
                .getSelectedMenu());
        Long showTimeId = Long.parseLong(QueryContainer
                .getShowTimeQuery()
                .getSelectedMenu());
        SeatsForm seatsForm = QueryContainer.getSeatsQuery();

        Movie findMovie = movieRepository.findMovieById(movieId);
        Cinemas findCinema = Cinemas.findCinemaById(cinemaId);
        CinemaMovie findCinemaMovie = findCinema.findCinemaMovieTypeByMovie(findMovie);
        ShowTime findShowTime = ShowTime.findShowTimeById(showTimeId);
        Seats findSeats = findCinemaMovie.loadSeatsByShowTime(findShowTime);

        seatsForm.getSeatNumbers()
                        .forEach(findSeats::reflectSeat);
    }
}
