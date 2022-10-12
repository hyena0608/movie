package movie.ticket.controller;

import movie.ticket.QueryContainer;
import movie.ticket.domain.discount.DiscountDtoGenerator;
import movie.ticket.domain.discount.Discounts;
import movie.ticket.dto.discount.DiscountDto;
import movie.ticket.view.input.controller.DiscountControllerInputView;
import movie.ticket.view.output.controller.DiscountControllerOutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountController {

    private final DiscountControllerInputView inputView = new DiscountControllerInputView();
    private final DiscountControllerOutputView outputView = new DiscountControllerOutputView();

    public void askDiscount() {
        QueryContainer.saveDiscountQuery(
                inputView.askDiscount()
        );
    }

    public void discountListUp() {
        List<DiscountDto> discountDtos = Arrays.stream(Discounts.values())
                .map(DiscountDtoGenerator::toDiscountDto)
                .collect(Collectors.toUnmodifiableList());

        outputView.responseDiscountListUp(discountDtos);
    }
}
