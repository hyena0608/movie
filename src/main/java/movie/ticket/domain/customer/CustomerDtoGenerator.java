package movie.ticket.domain.customer;

import movie.ticket.dto.customer.CustomerDto;

public class CustomerDtoGenerator {

    public static CustomerDto toCustomerDto(Customers customer) {
        return new CustomerDto(
                customer.getCustomerId(),
                customer.getCustomerName()
        );
    }
}
