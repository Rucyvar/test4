package com.pu;
import java.sql.*;

public class EmployeeDao {
	public int registerEmployee(Employee employee) throws Exception {
        String query = "INSERT INTO employee1" +
            "  (id, first_name, last_name, username, password, address, contact) VALUES " +
            " (?, ?, ?, ?, ?,?,?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/god?characterEncoding=latin1","root","Root");

            // Step 2:Create a statement using connection object
PreparedStatement preparedStatement = connection.prepareStatement(query)) {
preparedStatement.setInt(1, employee.getId());
preparedStatement.setString(2, employee.getFirstName());
preparedStatement.setString(3, employee.getLastName());
preparedStatement.setString(4, employee.getUsername());
preparedStatement.setString(5, employee.getPassword());
preparedStatement.setString(6, employee.getAddress());
preparedStatement.setString(7, employee.getContact());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            System.err.println(e);
        }
        return result;
    }

    
}
