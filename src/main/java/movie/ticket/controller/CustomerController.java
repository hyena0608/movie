package movie.ticket.controller;

import movie.ticket.QueryContainer;
import movie.ticket.domain.customer.CustomerDtoGenerator;
import movie.ticket.domain.customer.Customer;
import movie.ticket.dto.customer.CustomersDto;
import movie.ticket.view.input.controller.CustomerControllerInputView;
import movie.ticket.view.output.controller.CustomerControllerOutputView;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerController {

    private final CustomerControllerInputView inputView = new CustomerControllerInputView();
    private final CustomerControllerOutputView outputView = new CustomerControllerOutputView();

    public void askCustomer() {
        QueryContainer.saveCustomerQuery(
                inputView.askCustomer()
        );
    }

    public void customerListUp() {
        List<CustomersDto> findAllCustomers = Customer.findAllCustomers()
                .stream()
                .map(CustomerDtoGenerator::toCustomersDto)
                .collect(Collectors.toUnmodifiableList());

        outputView.responseCustomerListUp(findAllCustomers);
    }

}
