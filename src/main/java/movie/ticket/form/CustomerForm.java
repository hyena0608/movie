package movie.ticket.form;

import movie.ticket.domain.Customer;

import java.util.HashMap;
import java.util.Map;

import static movie.ticket.domain.Customer.*;

public class CustomerForm {

    private final Map<Customer, Integer> customerForms;

    public CustomerForm() {
        this.customerForms = new HashMap<>();
    }

    public void reflectCustomer(String customerNumber, String headCount) {
        Customer findCustomer = findCustomerByNumber(customerNumber);

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
