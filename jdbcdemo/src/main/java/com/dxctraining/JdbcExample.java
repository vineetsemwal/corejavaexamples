package com.dxctraining;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * Steps
 * 1) Register driver
 * 2)create connection (requirement is url, username, password)
 * 3)create statement
 * 4)execute query and fetch resultset
 * 5)consume resultset
 */
public class JdbcExample {
    public static void main(String[] args) throws Exception {


        Driver driver = new Driver();
        DriverManager.registerDriver(driver);
        //Class.forName("com.mysql.cj.jdbc.Driver");
        //http://google.com:port
        String url = "jdbc:mysql://localhost:3306/employeesdb";
        String user = "arshad", password = "scooby";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        String sql = "select * from employees";
        ResultSet resultSet = statement.executeQuery(sql);
        //
        //-> record 1 id , name ,age , balance, did
        // record 2
        // record 3
        //
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double balance = resultSet.getDouble("balance");
            int did=resultSet.getInt("did");
            System.out.println("id=" + id + " name=" + name + " balance=" + balance+" department id="+did);
        }
    }
}
