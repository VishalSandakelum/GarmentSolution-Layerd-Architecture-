package lk.ijse.garment.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.garment.dto.tm.Material;
import lk.ijse.garment.dto.tm.Supplier;
import lk.ijse.garment.dto.tm.tm.MaterialTM;
import lk.ijse.garment.dto.tm.tm.SupplierTM;
import lk.ijse.garment.model.MaterialModel;
import lk.ijse.garment.model.SupplierModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

public class SuppliertableFromController implements Initializable {

    private static final String URL = "jdbc:mysql://localhost:3306/garment";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
    }

    public TableView tableview;
    public TableColumn suppliername;
    public TableColumn nicnumber;
    public TableColumn gmail;
    public TableColumn mobilenumber;
    public TableColumn Address;
    public TableColumn id;
    public TableColumn Banknumber;
    public TextField searchbar;
    public Button searchbtn;

    public void tableviewmouseclickaction(MouseEvent mouseEvent) {

    }

    public void searchbtnonaction(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(java.net.URL url, ResourceBundle resourceBundle) {
        getAll(); setCellValueFactory();
    }

    private void setCellValueFactory() {
        suppliername.setCellValueFactory(new PropertyValueFactory<>("name"));
        nicnumber.setCellValueFactory(new PropertyValueFactory<>("nic"));
        gmail.setCellValueFactory(new PropertyValueFactory<>("gmail"));
        mobilenumber.setCellValueFactory(new PropertyValueFactory<>("conumber"));
        Address.setCellValueFactory(new PropertyValueFactory<>("address"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        Banknumber.setCellValueFactory(new PropertyValueFactory<>("banumber"));
    }

    private void getAll() {
        try {
            ObservableList<SupplierTM> obList = FXCollections.observableArrayList();
            List<Supplier> supList = SupplierModel.getAll();

            for (Supplier supplier : supList) {
                obList.add(new SupplierTM(
                        supplier.getName(),
                        supplier.getNic(),
                        supplier.getGmail(),
                        supplier.getAddress(),
                        supplier.getConumber(),
                        supplier.getBanumber(),
                        supplier.getId()
                ));
            }
            tableview.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }

}
