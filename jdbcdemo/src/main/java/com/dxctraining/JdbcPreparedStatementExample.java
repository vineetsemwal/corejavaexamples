package com.dxctraining;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.jdbc.JdbcPreparedStatement;

import java.sql.*;

public class JdbcPreparedStatementExample {

    public static void main(String[] args)  {
        JdbcPreparedStatementExample example = new JdbcPreparedStatementExample();
        example.runApp();

    }

    public void runApp() {
        try {
            addEmployee(17, "anuj", 700.32, 22, 2);
            deleteById(4);
            System.out.println("********dislay employe with id=1**********");
            displayEmployee(1);
            System.out.println("***********Display all emplyees**********");
            displayAllEmployees();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("something went wrong");
        }

    }

    public void addEmployee(int id, String name, double balance, int age, int did) throws SQLException {
        Connection connection = null;
        try {
            connection = createConnection();
            String sql = "insert into employees(id,name,balance,age,did) values(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setDouble(3, balance);
            statement.setInt(4, age);
            statement.setInt(5, did);
            int rows = statement.executeUpdate();
            System.out.println("rows inserted=" + rows);
        }
         catch (Exception e){
            e.printStackTrace();
         }
        finally {
            connection.close();
        }
    }

    public void deleteById(int id) throws SQLException {
        Connection connection = null;
        try {
            connection = createConnection();
            String sql = "delete from employees where id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int rows = statement.executeUpdate();
            System.out.println("rows deleted=" + rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
        }

    }

    public void displayEmployee(int id) throws SQLException {
        Connection connection = null;
        try {
            connection = createConnection();
            String sql = "select * from employees where id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
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
            String sql = "select * from employees";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
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

    public Connection createConnection() throws Exception {
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
