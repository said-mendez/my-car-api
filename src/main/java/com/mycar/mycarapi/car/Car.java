package com.mycar.mycarapi.car;

public record Car(
        String vin,
        String brand,
        String model,
        int year
) {
}
