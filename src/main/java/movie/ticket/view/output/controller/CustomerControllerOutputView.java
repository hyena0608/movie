package movie.ticket.view.output.controller;

import movie.ticket.dto.customer.CustomerDto;

import java.util.List;

import static movie.ticket.view.output.OutputView.print;
import static movie.ticket.view.output.UnitMessage.*;

public class CustomerControllerOutputView {

    private static final String ANNOUNCE_SELECT_CUSTOMER_TYPE_AND_HEADCOUNT = "인원 선택 (번호, 명)";

    public void responseCustomerListUp(List<CustomerDto> customerDtos) {
        print(customerListUpResponse(customerDtos));
    }

    private String customerListUpResponse(List<CustomerDto> customerDtos) {
        StringBuilder textBuilder = new StringBuilder();

        textBuilder.append(ANNOUNCE_SELECT_CUSTOMER_TYPE_AND_HEADCOUNT)
                .append(ENTER.unit);

        customerDtos.forEach(customerDto ->
                textBuilder.append(customerDto.getId())
                        .append(DOT.unit)
                        .append(SPACE.unit)
                        .append(customerDto.getName())
                        .append(ENTER.unit)
        );

        return textBuilder.toString();
    }
}
