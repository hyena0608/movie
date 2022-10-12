package movie.ticket.domain.cinema;

import movie.ticket.dto.cinema.CinemaDto;

public class CinemaDtoGenerator {

    public static CinemaDto toCinemaDto(Cinemas cinema) {
        return new CinemaDto(cinema.getCinemaId(), cinema.getCinemaName());
    }
}
