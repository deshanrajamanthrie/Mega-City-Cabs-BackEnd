package lk.ijse.megacitycab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
public class Driver {
    @Id
    private String driverId;
    private String name;
    private String phone;
    private String address;
    @OneToMany(mappedBy = "driver")
    private List<Vehicle> vehicles;
}
