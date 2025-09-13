package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {

    Stage roomManagement = new Stage();
    Stage customerManagement = new Stage();
    Stage staffManagement = new Stage();
    Stage foodManagement = new Stage();

    @FXML
    private JFXButton btnRoomManagement;

    @FXML
    void btnRoomManagementOnAction(ActionEvent event) {
        try {
            roomManagement.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/RoomManagement.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        roomManagement.setResizable(false);
        roomManagement.show();
    }

    public void btnCustomerManagementOnAction(ActionEvent actionEvent) {
        try {
            customerManagement.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/CustomerManagement.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        customerManagement.setResizable(false);
        customerManagement.show();
    }

    public void btnStaffOnAction(ActionEvent actionEvent) {
        try {
            staffManagement.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/StaffManagement.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        staffManagement.setResizable(false);
        staffManagement.show();
    }

    public void foodManagementOnAction(ActionEvent actionEvent) {
        try {
            foodManagement.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/FoodAndBeverageManagement.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        foodManagement.setResizable(false);
        foodManagement.show();
    }
}