package controller.customerController;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CustomerDetails;

import java.sql.*;

public class CustomerManagementController implements CustomerManagemetService {

    @Override
    public void addCustomer(@org.jetbrains.annotations.NotNull CustomerDetails customerDetails) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into customers(name,email,phone,address) values(?,?,?,?);");
            preparedStatement.setObject(1, customerDetails.getName());
            preparedStatement.setObject(2, customerDetails.getEmail());
            preparedStatement.setObject(3, customerDetails.getPhone());
            preparedStatement.setObject(4, customerDetails.getAddress());
            preparedStatement.executeUpdate();

        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void deleteCustomer(String name) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_reservation", "root", "1234");
            PreparedStatement preparedStatement = connection.prepareStatement("delete from customers where name=?;");
            preparedStatement.setObject(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCustomer(CustomerDetails customerDetails) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update customers set email=?,phone=?,address=?where name=?;");
            preparedStatement.setObject(1, customerDetails.getEmail());
            preparedStatement.setObject(2, customerDetails.getPhone());
            preparedStatement.setObject(3, customerDetails.getAddress());
            preparedStatement.setObject(4, customerDetails.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<CustomerDetails> loadData(){
        ObservableList<CustomerDetails> observableList= FXCollections.observableArrayList();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from customers; ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                observableList.add(new CustomerDetails(resultSet.getString("name"),
                                resultSet.getString("email"),
                                resultSet.getString("phone"),
                                resultSet.getString("address")
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return observableList;
    }
}


