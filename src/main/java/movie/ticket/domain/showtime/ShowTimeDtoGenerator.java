package movie.ticket.domain.showtime;

import movie.ticket.dto.showtime.ShowTimeDto;

public class ShowTimeDtoGenerator {

    public static ShowTimeDto toShowTimeDto(ShowTimes showTime) {
        return new ShowTimeDto(
                showTime.getShowTimeId(),
                showTime.getTime(),
                showTime.getShowTimeName()
        );
    }
}
