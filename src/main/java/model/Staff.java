package model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Staff {
    private String id;
    private String name;
    private String category;
    private String unit;
    private double salary;
}
