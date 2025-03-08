package lk.ijse.megacitycab.service;

import lk.ijse.megacitycab.dto.CustomerDTO;

import java.io.IOException;
import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customer) throws IOException;
    List<CustomerDTO> getAllCustomer() throws IOException;
    void updateCustomer(CustomerDTO customer) throws IOException;
    void deleteCustomer(String registration_number) throws IOException;
    CustomerDTO findCustomer(String registration_number) throws IOException;
}
