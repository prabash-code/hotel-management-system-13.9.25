package controller.staffController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Staff;

import java.net.URL;
import java.util.ResourceBundle;

public class StaffManagementFormController implements Initializable {

    StaffManagementService staffManagementService=new StaffManagementController();

        @FXML
        private JFXButton Search;

        @FXML
        private JFXButton btnAdd;

        @FXML
        private JFXButton btnClean;

        @FXML
        private JFXButton btnDelete;

        @FXML
        private JFXButton btnUpdate;

        @FXML
        private JFXButton btnView;

        @FXML
        private JFXComboBox<String> cmbCategory;

        @FXML
        private JFXComboBox<String> cmbUnit;

        @FXML
        private TableColumn<?, ?> colCategory;

        @FXML
        private TableColumn<?, ?> colId;

        @FXML
        private TableColumn<?, ?> colName;

        @FXML
        private TableColumn<?, ?> colSalary;

        @FXML
        private TableColumn<?, ?> colUnit;

        @FXML
        private TableView<Staff> tblStaff;

        @FXML
        private JFXTextField txtId;

        @FXML
        private JFXTextField txtName;

        @FXML
        private JFXTextField txtSalary;

        @FXML
        void AddOnAction(ActionEvent event) {

        }

        @FXML
        void CleanOnAction(ActionEvent event) {
        txtId.setText(null);
        txtName.setText(null);
        txtSalary.setText(null);
        cmbUnit.setValue(null);
        cmbCategory.setValue(null);
        }

        @FXML
        void deleteOnAction(ActionEvent event) {

        }

        @FXML
        void searchOnAction(ActionEvent event) {

        }

        @FXML
        void updateOnAction(ActionEvent event) {

        }

        @FXML
        void viewOnAction(ActionEvent event) {
            tblStaff.setItems(staffManagementService.view());
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colUnit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        ObservableList<String> categoryList= FXCollections.observableArrayList(
                "Chef",
                "Helper",
                "Reception",
                "RoomService"
        );
        cmbCategory.setItems(categoryList);

        ObservableList<String> unitList=FXCollections.observableArrayList(
                "Kitchen",
                "Hall",
                "Rooms"

        );
        cmbUnit.setItems(unitList);
    }
}


