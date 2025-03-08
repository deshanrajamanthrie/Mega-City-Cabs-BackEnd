package lk.ijse.megacitycab.util.map;

import lk.ijse.megacitycab.dto.*;
import lk.ijse.megacitycab.entity.*;
import lk.ijse.megacitycab.repostory.CustomerRepotory;
import lk.ijse.megacitycab.repostory.impl.CustomerRepotoryImpl;
import lk.ijse.megacitycab.repostory.DriverRepostory;
import lk.ijse.megacitycab.repostory.impl.DriverRepotoryImpl;
import org.modelmapper.ModelMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Map {
    private ModelMapper modelMapper = new ModelMapper();
    private CustomerRepotory customerRepotory = new CustomerRepotoryImpl();

    private DriverRepostory driverRepostory = new DriverRepotoryImpl();
    public CustomerDTO toCustomerDto(Customer customer){
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public Customer toCustomer(CustomerDTO customer){
        return modelMapper.map(customer, Customer.class);
    }

    public List<CustomerDTO> toCustomerDtoList(List<Customer> customerList) {
        return customerList.stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    public BoockingDTO toBoockingDto(Booking booking){
        String regsraton_number = booking.getCustomer().getRegistration_number();
        BoockingDTO boockingDTO = modelMapper.map(booking, BoockingDTO.class);
        boockingDTO.setRegistration_number(regsraton_number);
        return boockingDTO;
    }

    public Booking toBoocking(BoockingDTO bookingDto) throws IOException {
        Customer customer = customerRepotory.findCustomer(bookingDto.getRegistration_number());
        Booking booking =  modelMapper.map(bookingDto, Booking.class);
        booking.setCustomer(customer);
        return booking;
    }

    public List<BoockingDTO> toBoockingDtoList(List<Booking> bookings){
        List<BoockingDTO> boockingDTOS = new ArrayList<>();
        for (Booking booking : bookings){
            boockingDTOS.add(toBoockingDto(booking));
        }
        return boockingDTOS;
    }

    public DriverDTO toDriverDto(Driver driver){
        return modelMapper.map(driver, DriverDTO.class);
    }

    public Driver toDriver(DriverDTO driver){
        return modelMapper.map(driver, Driver.class);
    }

    public List<DriverDTO> toDriverDtoList(List<Driver> driverList) {
        return driverList.stream()
                .map(driver -> modelMapper.map(driver, DriverDTO.class))
                .collect(Collectors.toList());
    }


    public VehicleDTO toVehicleDto(Vehicle vehicle){
        String driverId = vehicle.getDriver().getDriverId();
        VehicleDTO vehicleDTO = modelMapper.map(vehicle,VehicleDTO.class);
        vehicleDTO.setDriverId(driverId);
        return vehicleDTO;
    }

    public Vehicle toVehicle(VehicleDTO vehicle) throws IOException {
        Driver driver = driverRepostory.findDriver(vehicle.getDriverId());
        Vehicle vehicles = modelMapper.map(vehicle,Vehicle.class);
        vehicles.setDriver(driver);
        return vehicles;
    }

    public List<VehicleDTO> toVehicleDtoList(List<Vehicle> vehicles){
        List<VehicleDTO> vehicleDTOS = new ArrayList<>();

        for (Vehicle vehicle : vehicles){
            vehicleDTOS.add(toVehicleDto(vehicle));
        }
        return vehicleDTOS;
    }

    public User toUser(UserDTO user){
        return modelMapper.map(user, User.class);
    }



}
