package model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FoodsAndBeverage {
    private String itemCode;
    private String name;
    private Double price;
}
