package controller.RoomController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import model.RoomDetails;

import java.net.URL;
import java.util.ResourceBundle;

public class RoomManagementFormController implements Initializable {

    ObservableList <RoomDetails> roomDetails = FXCollections.observableArrayList();
    //RoomManagementController roomManagementController=new RoomManagementController();
    RoomManagementService roomManagementService=new RoomManagementController();

    @FXML
    private JFXRadioButton availableRadio;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colPricePerNight;

    @FXML
    private TableColumn<?, ?> colRoomNumber;

    @FXML
    private TableColumn<?, ?> colRoomStatus;

    @FXML
    private TableColumn<?, ?> colRoomType;

    @FXML
    private JFXComboBox<String> roomTypeCombo;

    @FXML
    private TableView<RoomDetails> tblRoomDetails;

    @FXML
    private JFXTextArea txtDescription;

    @FXML
    private JFXTextField txtPricePerNight;

    @FXML
    private JFXTextField txtRoomNumber;

    @FXML
    public JFXRadioButton maintenanceRadio;

    @FXML
    private JFXRadioButton unavailableRadio;

    @FXML
    void btnAddOnAction(ActionEvent event) {

        RoomDetails details=new RoomDetails(
                Integer.parseInt(txtRoomNumber.getText()),
                roomTypeCombo.getValue(),
                Double.parseDouble(txtPricePerNight.getText()),
                txtDescription.getText(),
                checkRoomStatus()

        );


        roomManagementService.addRoomDetails(details);

        loadRoomDetails();
        btnClearOnAction(event);

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtRoomNumber.setText(null);
        roomTypeCombo.getSelectionModel().clearSelection();
        txtPricePerNight.setText(null);
        txtDescription.setText(null);
        availableRadio.setSelected(false);
        unavailableRadio.setSelected(false);
        maintenanceRadio.setSelected(false);

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id=txtRoomNumber.getText();
        RoomManagementController roomManagementController=new RoomManagementController();
        roomManagementController.deleteRoomDetails(id);

        loadRoomDetails();
        btnClearOnAction(event);

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        RoomDetails details=new RoomDetails(
                Integer.parseInt(txtRoomNumber.getText()),
                roomTypeCombo.getValue(),
                Double.parseDouble(txtPricePerNight.getText()),
                txtDescription.getText(),
                checkRoomStatus()

        );


        roomManagementService.updateDetails(details);


        loadRoomDetails();
        btnClearOnAction(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        ------initialize roomTypeCombo-------
        ObservableList<String> roomTypes = FXCollections.observableArrayList(
                "Single",
                "Double",
                "Suite"
        );
        roomTypeCombo.setItems(roomTypes);
//        ----------------------------------------

//        ------set toggleGroup for radiobuttons------
        ToggleGroup roomStstusToggleGroup = new ToggleGroup();

        availableRadio.setToggleGroup(roomStstusToggleGroup);
        unavailableRadio.setToggleGroup(roomStstusToggleGroup);
        maintenanceRadio.setToggleGroup(roomStstusToggleGroup);
//        --------------------------------------------

//        ------set table details----------
        colRoomNumber.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        colPricePerNight.setCellValueFactory(new PropertyValueFactory<>("pricePerNight"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colRoomStatus.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));

        loadRoomDetails();
        tblRoomDetails.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if(newValue!=null){
                    setSelectedValue(newValue);

            }
        });

    }

    private void loadRoomDetails(){
        roomDetails.clear();

        ObservableList roomDetails=roomManagementService.getAllRoomDetails();
        tblRoomDetails.setItems(roomDetails);
    }

    private String checkRoomStatus(){
        if(availableRadio.isSelected()){
            return "Available";
        }else if(maintenanceRadio.isSelected()){
            return "Maintenance";
        }
        return "UnAvailable";
    }

    public void setSelectedValue(RoomDetails selectedValue){
        txtRoomNumber.setText(String.valueOf(selectedValue.getRoomNumber()));
        txtDescription.setText(selectedValue.getDescription());
        txtPricePerNight.setText(String.valueOf(selectedValue.getPricePerNight()));
        roomTypeCombo.setValue(selectedValue.getRoomType());

        if(selectedValue.getRoomStatus().equals("Available")){
            availableRadio.setSelected(true);
        }
        if(selectedValue.getRoomStatus().equals("Booked")){
           unavailableRadio.setSelected(true);
        }
        if(selectedValue.getRoomStatus().equals("Maintenance")){
            maintenanceRadio.setSelected(true);
        }

    }
}
