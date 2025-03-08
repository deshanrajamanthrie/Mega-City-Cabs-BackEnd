package lk.ijse.megacitycab.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String registration_number;
    private String name;
    private String phone;
    private String address;
    private String email;
}
