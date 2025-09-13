package controller.staffController;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffManagementController implements StaffManagementService {

    Connection connection;

    {
        try {
            connection = DBConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Staff> view(){
        ObservableList<Staff> staffList= FXCollections.observableArrayList();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from staff");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
               staffList.add(new Staff( resultSet.getString("Id"),
                resultSet.getString("Name"),
                resultSet.getString("Category"),
                resultSet.getString("Unit"),
                resultSet.getDouble("Salary")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return staffList;
    }
}
