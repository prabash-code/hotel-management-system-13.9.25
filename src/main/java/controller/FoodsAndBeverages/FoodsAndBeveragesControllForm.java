package controller.FoodsAndBeverages;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class FoodsAndBeveragesControllForm implements Initializable {

    @FXML
    private JFXButton Search;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnClean;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSort;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnView;

    @FXML
    private TableColumn<?, ?> colCategory;

    @FXML
    private TableColumn<?, ?> colFoodname;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colItem;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colUnit;

    @FXML
    private TableView<?> tblFood;

    @FXML
    private TableView<?> tblStaff;

    @FXML
    private JFXTextField txtItemCode;

    @FXML
    private JFXTextField txtNameFood;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    void AddOnAction(ActionEvent event) {

    }

    @FXML
    void CleanOnAction(ActionEvent event) {

    }

    @FXML
    void btnSortOnAction(ActionEvent event) {

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

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colItem.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colFoodname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}
