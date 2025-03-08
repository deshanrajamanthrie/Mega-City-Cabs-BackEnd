package lk.ijse.megacitycab.entity;

import jakarta.persistence.*;
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
public class Booking {
    @Id
    private String booking_Id;
    private String date;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Vehicle vehicle;
    private double price;
}
