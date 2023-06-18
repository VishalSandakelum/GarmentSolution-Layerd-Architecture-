package lk.ijse.garment.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.garment.dto.tm.Customer;
import lk.ijse.garment.dto.tm.Employee;
import lk.ijse.garment.dto.tm.tm.CustomerTM;
import lk.ijse.garment.dto.tm.tm.EmployeeTM;
import lk.ijse.garment.model.CustomerModel;
import lk.ijse.garment.model.EmployeeModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

public class CustomertableFromController implements Initializable {

    private static final String URL = "jdbc:mysql://localhost:3306/garment";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
    }

    public TextField searchbar;
    public Button searchbtn;
    public TableView tableview;
    public TableColumn suppliername;
    public TableColumn nicnumber;
    public TableColumn gmail;
    public TableColumn mobilenumber;
    public TableColumn Address;
    public TableColumn id;
    public TableColumn Banknumber;
    public TableColumn Date;

    public void searchbtnonaction(ActionEvent actionEvent) {

    }

    public void tableviewmouseclickaction(MouseEvent mouseEvent) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAll(); setCellValueFactory();
    }

    private void setCellValueFactory() {
        suppliername.setCellValueFactory(new PropertyValueFactory<>("name"));
        id.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        nicnumber.setCellValueFactory(new PropertyValueFactory<>("nic_number"));
        mobilenumber.setCellValueFactory(new PropertyValueFactory<>("contact_number"));
        Address.setCellValueFactory(new PropertyValueFactory<>("address"));
        Banknumber.setCellValueFactory(new PropertyValueFactory<>("bank_number"));
        gmail.setCellValueFactory(new PropertyValueFactory<>("gmail"));
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
    }

    private void getAll() {
        try {
            ObservableList<CustomerTM> obList = FXCollections.observableArrayList();
            List<Customer> cusList = CustomerModel.getAll();

            for (Customer customer : cusList) {
                obList.add(new CustomerTM(
                        customer.getName(),
                        customer.getCustomer_id(),
                        customer.getNic_number(),
                        customer.getContact_number(),
                        customer.getAddress(),
                        customer.getBank_number(),
                        customer.getGmail(),
                        customer.getDate()

                ));
            }
            tableview.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }

}
