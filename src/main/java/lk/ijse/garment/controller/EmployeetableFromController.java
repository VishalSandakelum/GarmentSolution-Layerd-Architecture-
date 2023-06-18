package lk.ijse.garment.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.garment.bo.BoFactory;
import lk.ijse.garment.bo.custom.EmployeeBo;
import lk.ijse.garment.dto.tm.Employee;
import lk.ijse.garment.dto.tm.Supplier;
import lk.ijse.garment.dto.tm.tm.EmployeeTM;
import lk.ijse.garment.dto.tm.tm.SupplierTM;
import lk.ijse.garment.model.EmployeeModel;
import lk.ijse.garment.model.SupplierModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;


public class EmployeetableFromController implements Initializable {

    private static final String URL = "jdbc:mysql://localhost:3306/garment";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
    }

    static String Id ;
    static String Nic;
    static String Gmaiil;
    static String Addresss ;
    static String Namee;
    static int Cunumber ;
    static int Bannumber;

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
    public TableColumn Delete;

    EmployeeBo employeeBo = BoFactory.getBoFactory().getBo(BoFactory.BoType.EMPLOYEE);

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
        Delete.setCellValueFactory(new PropertyValueFactory<>("Date"));
    }

    private void getAll() {

        try {
            ObservableList<EmployeeTM> obList = FXCollections.observableArrayList();
            List<lk.ijse.garment.entity.Employee> empList = employeeBo.getAll();

            for (lk.ijse.garment.entity.Employee employee : empList) {
                obList.add(new EmployeeTM(
                        employee.getName(),
                        employee.getNic(),
                        employee.getGmail(),
                        employee.getConumber(),
                        employee.getAddress(),
                        employee.getId(),
                        employee.getBanumber(),
                        employee.getDate()
                ));

            }

            tableview.setItems(obList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }

    public void tableviewmouseclickaction(MouseEvent mouseEvent) {
        Integer index;

        if (mouseEvent.getClickCount() == 1) {
            EmployeeTM selectedEmployee = (EmployeeTM) tableview.getSelectionModel().getSelectedItem();
            if (selectedEmployee != null) {
                 Id = selectedEmployee.getId();
                 Nic = selectedEmployee.getNic();
                 Gmaiil = selectedEmployee.getGmail();
                 Addresss = selectedEmployee.getAddress();
                 Namee = selectedEmployee.getName();
                 Cunumber = selectedEmployee.getConumber();
                 Bannumber = selectedEmployee.getBanumber();
                System.out.println("Clicked Id: " + Nic);

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/update_form.fxml"));
                Parent root1 = null;
                try {
                    root1 = (Parent) fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();

            }
        }

    }
}
