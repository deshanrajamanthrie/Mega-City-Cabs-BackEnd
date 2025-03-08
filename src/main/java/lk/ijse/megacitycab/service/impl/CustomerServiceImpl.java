package lk.ijse.megacitycab.service.impl;

import lk.ijse.megacitycab.dto.CustomerDTO;
import lk.ijse.megacitycab.service.CustomerService;
import lk.ijse.megacitycab.util.map.Map;
import lk.ijse.megacitycab.repostory.CustomerRepotory;
import lk.ijse.megacitycab.repostory.impl.CustomerRepotoryImpl;

import java.io.IOException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private Map map = new Map();
    private CustomerRepotory customerRepotory = new CustomerRepotoryImpl();

    @Override
    public void saveCustomer(CustomerDTO customer) throws IOException {
        customerRepotory.saveCustomer(map.toCustomer(customer));
    }

    @Override
    public List<CustomerDTO> getAllCustomer() throws IOException {
        return map.toCustomerDtoList(customerRepotory.getAllCustomer());
    }

    @Override
    public void updateCustomer(CustomerDTO customer) throws IOException {
        customerRepotory.updateCustomer(map.toCustomer(customer));
    }

    @Override
    public void deleteCustomer(String registration_number) throws IOException {
        customerRepotory.deleteCustomer(registration_number);
    }

    @Override
    public CustomerDTO findCustomer(String registration_number) throws IOException {
        return map.toCustomerDto(customerRepotory.findCustomer(registration_number));
    }
}
