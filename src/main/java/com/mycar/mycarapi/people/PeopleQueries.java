package com.mycar.mycarapi.people;

class PeopleQueries {
    public static final String GET_ALL = """
        SELECT guid, firstname, lastname, email, gender
        FROM people;
    """;
    public static final String GET_BY_GUID = """
            SELECT guid, firstname, lastname, email, gender
            FROM people
            WHERE guid = ?
            """;
    public static final String INSERT = """
            INSERT INTO people(guid, firstname, lastname, email, gender)
            VALUES(?, ?, ?, ?, ?);
            """;
    public static final String UPDATE = "";
    public static final String DELETE = "";
}
