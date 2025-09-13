package controller.customerController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CustomerDetails;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerManagementFormController implements Initializable {
    ObservableList<CustomerDetails> observableList = FXCollections.observableArrayList();
    CustomerManagemetService customerManagemetService=new CustomerManagementController();
    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCustomerName;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private TableView<CustomerDetails> tblRoomDetails;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtPhoneNumber;

    @FXML
    void btnAddOnAction(ActionEvent event) {
//        String name = txtName.getText();
//        String email = txtEmail.getText();
//        String phone = txtPhoneNumber.getText();
//        String address = txtAddress.getText();

        CustomerDetails customerDetails=new CustomerDetails(
                txtName.getText(),
                txtEmail.getText(),
                txtPhoneNumber.getText(),
                txtAddress.getText()

        );

        customerManagemetService.addCustomer(customerDetails);
        tblRoomDetails.setItems(loadData());
        btnClearOnAction(event);

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtEmail.setText(null);
        txtAddress.setText(null);
        txtPhoneNumber.setText(null);
        txtName.setText(null);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        String name = txtName.getText();
        customerManagemetService.deleteCustomer(name);
        tblRoomDetails.setItems(loadData());
        btnClearOnAction(event);

    }
    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        CustomerDetails customerDetails = new CustomerDetails(
                txtName.getText(),
                txtEmail.getText(),
                txtPhoneNumber.getText(),
                txtAddress.getText()
        );
        customerManagemetService.updateCustomer(customerDetails);
        tblRoomDetails.setItems(loadData());
        btnClearOnAction(event);

    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

        tblRoomDetails.setItems(loadData());
    }

    public ObservableList<CustomerDetails> loadData() {
        observableList.clear();
        ObservableList<CustomerDetails> observableList1 = customerManagemetService.loadData();

        tblRoomDetails.setItems(observableList1);
        return observableList1;
    }


}
