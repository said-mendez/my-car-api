package com.mycar.mycarapi.people_car;

public class PeopleCarQueries {
    public static final String INSERT = """
            INSERT INTO people_car (peopleid, carid)
            VALUES (?, ?)
            ;
            """;
    public static final String GET_ALL_PEOPLE_CARS = """
            SELECT peopleid, carid
            FROM people_car
            ;
            """;

    public static final String GET_ALL_PERSON_CARS = """
            SELECT c.vin, c.brand, c.model, c.year, c.color
            FROM people_car pc,
                 car        c
            WHERE peopleid = ?
            AND pc.carid = c.vin
            ;
            """;

    public static final String GET_ALL_CAR_PEOPLE = """
            SELECT p.guid, p.firstname, p.lastname, p.email, p.gender
            FROM people_car pc,
                 people     p
            WHERE carid = ?
            AND pc.peopleid = p.guid
            ;
            """;

    public static final String UPDATE = """
            UPDATE people_car
            SET peopleid = ?,
            carid = ?
            WHERE carid = ?
            AND peopleid = ?
            ;
            """;

    public static final String DELETE = """
            DELETE people_car
            WHERE carid = ?
            AND peopleid = ?
            ;
            """;

    public static final String COUNT_CAR_BELONGS_TO_N_PEOPLE = """
            SELECT COUNT(*)
            FROM people_car
            WHERE carid = ?
            ;
            """;
}
