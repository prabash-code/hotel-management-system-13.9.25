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
    public void add(Staff staff){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into staff values(?,?,?,?,?);");
            preparedStatement.setObject(1,staff.getId());
            preparedStatement.setObject(2,staff.getName());
            preparedStatement.setObject(3,staff.getCategory());
            preparedStatement.setObject(4,staff.getUnit());
            preparedStatement.setObject(5,staff.getSalary());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update(Staff staff){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update staff set Name=?,Category=?,Unit=?,Salary=? where id=?");
            preparedStatement.setObject(1,staff.getName());
            preparedStatement.setObject(2,staff.getCategory());
            preparedStatement.setObject(3,staff.getUnit());
            preparedStatement.setObject(4,staff.getSalary());
            preparedStatement.setObject(5,staff.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(String id){}
}
