package lk.ijse.megacitycab.repostory;

import lk.ijse.megacitycab.dto.CustomerDTO;
import lk.ijse.megacitycab.entity.Customer;

import java.io.IOException;
import java.util.List;

public interface CustomerRepotory {
    void saveCustomer(Customer customer) throws IOException;
    List<Customer> getAllCustomer() throws IOException;
    void updateCustomer(Customer customer) throws IOException;
    void deleteCustomer(String registration_number) throws IOException;
    Customer findCustomer(String registration_number) throws IOException;
}
