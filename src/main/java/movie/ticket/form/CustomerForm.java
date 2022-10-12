package movie.ticket.form;

import movie.ticket.domain.customer.Customers;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Long.*;
import static movie.ticket.domain.customer.Customers.*;

public class CustomerForm {

    private final Map<Customers, Integer> customerForms;

    public CustomerForm() {
        this.customerForms = new HashMap<>();
    }

    public void reflectCustomer(String customerNumber, String headCount) {
        Customers findCustomer = findCustomerByNumber(parseLong(customerNumber));

        customerForms.put(
                findCustomer,
                Integer.parseInt(
                        customerForms.getOrDefault(findCustomer, 0) + headCount)
        );
    }

    public boolean checkForm() {
        return customerForms.size() != 0;
    }
}
