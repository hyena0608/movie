package movie.ticket.view.output.controller;

import movie.ticket.dto.discount.DiscountDto;

import java.util.List;

import static movie.ticket.view.output.OutputView.print;
import static movie.ticket.view.output.UnitMessage.*;

public class DiscountControllerOutputView {

    private static final String ANNOUNCE_SELECT_DISCOUNT = "할인 선택";

    public void responseDiscountListUp(List<DiscountDto> discountDtos) {
        print(discountListUpResponse(discountDtos));
    }

    private String discountListUpResponse(List<DiscountDto> discountDtos) {
        StringBuilder textBuilder = new StringBuilder();

        textBuilder.append(ANNOUNCE_SELECT_DISCOUNT)
                .append(ENTER.unit);

        discountDtos.stream()
                .forEach(discountDto ->
                        textBuilder.append(discountDto.getId())
                                .append(DOT.unit)
                                .append(SPACE.unit)
                                .append(discountDto.getName())
                                .append(ENTER.unit));

        return textBuilder.toString();
    }
}
