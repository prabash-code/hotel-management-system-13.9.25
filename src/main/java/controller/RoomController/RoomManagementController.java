package controller.RoomController;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.RoomDetails;

import java.sql.*;

public class RoomManagementController implements RoomManagementService {
    @Override
    public void addRoomDetails(RoomDetails roomDetails) {
        String SQL = "INSERT INTO rooms(room_number, room_type, price_per_night, description, room_status) VALUES(?,?,?,?,?);";

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setObject(1, roomDetails.getRoomNumber());
            preparedStatement.setObject(2, roomDetails.getRoomType());
            preparedStatement.setObject(3, roomDetails.getPricePerNight());
            preparedStatement.setObject(4, roomDetails.getDescription());
            preparedStatement.setObject(5, roomDetails.getRoomStatus());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateDetails(RoomDetails details) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Update rooms set room_type=?,price_per_night=?,description=?,room_status=? where room_number=?");
            preparedStatement.setObject(1, details.getRoomType());
            preparedStatement.setObject(2, details.getPricePerNight());
            preparedStatement.setObject(3, details.getDescription());
            preparedStatement.setObject(4, details.getRoomStatus());
            preparedStatement.setObject(5, details.getRoomNumber());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteRoomDetails(String id) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from rooms where room_number=?;");
            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ObservableList<RoomDetails> getAllRoomDetails() {

        ObservableList<RoomDetails> roomDetails = FXCollections.observableArrayList();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * FROM rooms;");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                roomDetails.add(new RoomDetails(
                                resultSet.getInt("room_number"),
                                resultSet.getString("room_type"),
                                resultSet.getDouble("price_per_night"),
                                resultSet.getString("description"),
                                resultSet.getString("room_status")
                        )
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roomDetails;
    }

}


