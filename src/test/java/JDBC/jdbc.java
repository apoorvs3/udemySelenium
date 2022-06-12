package JDBC;

import org.bouncycastle.util.test.Test;
import updates.TestConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbc {
    static Connection con = null;
    public static void setMySqlconnection() {
        try{
            Class.forName(TestConfig.mysqldriver);
            con = DriverManager.getConnection(TestConfig.mysqlurl, TestConfig.mysqluserName,TestConfig.mysqlpassword);
            if(!con.isClosed()){
                System.out.println("Successfully connected");

            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static List<String> getMySqlQuery(String query) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<String> values1 = new ArrayList<String>();
        while(rs.next()){
            values1.add(rs.getString(1));
        }
        return values1;
    }
}
