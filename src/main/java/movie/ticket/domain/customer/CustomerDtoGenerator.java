package movie.ticket.domain.customer;

import movie.ticket.dto.customer.CustomersDto;

public class CustomerDtoGenerator {

    public static CustomersDto toCustomersDto(Customers customer) {
        return new CustomersDto(
                customer.getCustomerId(),
                customer.getCustomerName()
        );
    }
}
