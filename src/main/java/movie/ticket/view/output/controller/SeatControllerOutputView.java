package movie.ticket.view.output.controller;

import movie.ticket.domain.seat.Seat;
import movie.ticket.dto.seat.SeatsDto;

import java.util.Map;

import static movie.ticket.view.output.OutputView.print;
import static movie.ticket.view.output.UnitMessage.ENTER;
import static movie.ticket.view.output.UnitMessage.SPACE;

public class SeatControllerOutputView {

    private static final String ANNOUNCE_SELECT_SEATS = "좌석 선택";
    private static final String SEATED_VIEW = "X";

    public void responseSeatListUp(SeatsDto seatsDto) {
        print(seatListUpResponse(seatsDto));
    }

    private String seatListUpResponse(SeatsDto seatsDto) {
        StringBuilder textBuilder = new StringBuilder();

        textBuilder.append(ANNOUNCE_SELECT_SEATS)
                .append(ENTER.unit);

        Map<Seat, Boolean> seats = seatsDto.getSeats();

        for (int col = 1; col <= seatsDto.getColSize(); col++) {
            char colType = getColSeatType(seatsDto, col);

            textBuilder.append(colType)
                    .append(SPACE.unit);

            for (int row = 1; row <= seatsDto.getRowSize(); row++) {
                Seat currentSeatKey = getSeatKey(colType, row);
                if (checkAlreadyFilled(seats, currentSeatKey)) {
                    textBuilder.append(SEATED_VIEW)
                            .append(SPACE.unit);
                }

                if (!checkAlreadyFilled(seats, currentSeatKey)) {
                    textBuilder.append(row)
                            .append(SPACE.unit);
                }
            }

            textBuilder.append(ENTER.unit);
        }

        return textBuilder.toString();
    }

    private char getColSeatType(SeatsDto seatsDto, int col) {
        return (char) (seatsDto.getAsciiA() + col - 1);
    }

    private Seat getSeatKey(char colType, int row) {
        return new Seat(String.valueOf(colType + row));
    }

    private Boolean checkAlreadyFilled(Map<Seat, Boolean> seats, Seat currentSeatType) {
        return seats.get(currentSeatType);
    }
}
