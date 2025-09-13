package model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDetails {
    private String name;
    private String email;
    private String phone;
    private String address;
}
