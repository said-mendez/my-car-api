package com.mycar.mycarapi.car;

public class CarQueries {
    public static final String GET_ALL = """
            SELECT vin, brand, model, year, color
            FROM car
            ;
            """;
    public static final String GET_BY_VIN = """
            SELECT vin, brand, model, year, color
            FROM car
            WHERE vin = ?
            ;
            """;
    public static final String INSERT = """
            INSERT INTO car (vin, brand, model, year, color)
            VALUES (?, ?, ?, ?, ?)
            ;
            """;

    public static final String UPDATE = """
            UPDATE car
            SET brand = ?,
            model = ?,
            year = ?,
            color = ?
            WHERE vin = ?
            ;
            """;

    public static final String DELETE = """
            DELETE
            FROM car
            WHERE vin = ?
            ;
            """;
}
