package com.dxctraining;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

/**
 * Steps
 * 1) Register driver
 * 2)create connection (requirement is url, username, password)
 * 3)create statement
 * 4)execute query and fetch resultset
 * 5)consume resultset
 */
public class JdbcSatementExample {
    public static void main(String[] args) {
        JdbcSatementExample example = new JdbcSatementExample();
        example.runApp();

    }

    public void runApp()  {
        try {
            addEmployee(12, "khadar", 100.32, 22, 1);
            deleteById(4);
            System.out.println("********dislay employe with id=1**********");
            displayEmployee(1);
            System.out.println("***********Display all emplyees**********");
            displayAllEmployees();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("some problem occured");
        }

    }

    public void addEmployee(int id, String name, double balance, int age, int did) throws SQLException {
        Connection connection = null;
        try {
            connection = createConnection();
            Statement statement = connection.createStatement();
            String sql = "insert into employees(id,name,balance,age,did) values(%d,'%s',%f,%d,%d)";
            String formatted = String.format(sql, id, name, balance, age, did);
            int rows = statement.executeUpdate(formatted);
            System.out.println("rows inserted=" + rows);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public void deleteById(int id) throws SQLException {
        Connection connection = null;
        try {
            connection = createConnection();
            Statement statement = connection.createStatement();
            String sql = "delete from employees where id=" + id;
            int rows = statement.executeUpdate(sql);
            System.out.println("rows deleted=" + rows);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

    }

    public void displayEmployee(int id) throws SQLException {
        Connection connection = null;
        try {
            connection = createConnection();
            Statement statement = connection.createStatement();
            String sql = "select * from employees where id=" + id;
            ResultSet resultSet = statement.executeQuery(sql);
            //
            //-> record 1 id , name ,age , balance, did
            // record 2
            // record 3
            //
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double balance = resultSet.getDouble("balance");
                int did = resultSet.getInt("did");
                System.out.println("id=" + id + " name=" + name + " balance=" + balance + " department id=" + did);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }


    public void displayAllEmployees() throws SQLException {
        Connection connection = null;
        try {
            connection = createConnection();
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
                int did = resultSet.getInt("did");
                System.out.println("id=" + id + " name=" + name + " balance=" + balance + " department id=" + did);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }


    public Connection createConnection() throws SQLException {
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);
        //Class.forName("com.mysql.cj.jdbc.Driver");
        //http://google.com:port
        String url = "jdbc:mysql://localhost:3306/employeesdb";
        String user = "arshad", password = "scooby";
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
