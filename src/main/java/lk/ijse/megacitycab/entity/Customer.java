package lk.ijse.megacitycab.entity;

import jakarta.persistence.*;
import lk.ijse.megacitycab.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class Customer{
    @Id
    private String registration_number;
    private String name;
    private String phone;
    private String address;
    @Column(unique = true)
    private String email;
    @OneToMany(mappedBy = "customer")
    private List<Booking> bookings;
}
