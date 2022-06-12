package JDBC;

import java.sql.SQLException;

public class TestDbConnection {
    public static void main(String[] args) throws SQLException {
        jdbc.setMySqlconnection();
        System.out.println(jdbc.getMySqlQuery("select * from Country;"));
    }
}
