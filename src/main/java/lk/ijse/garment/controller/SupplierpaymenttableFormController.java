package lk.ijse.garment.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.garment.dto.tm.Supplier;
import lk.ijse.garment.dto.tm.tm.EmployeeTM;
import lk.ijse.garment.dto.tm.tm.SupplierTM;
import lk.ijse.garment.model.SupplierModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

public class SupplierpaymenttableFormController implements Initializable {

    private static final String URL = "jdbc:mysql://localhost:3306/garment";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
    }

    static String Id ;
    static String Nic;
    static String Gmaiil;
    static String Namee;
    static int Bannumber;

    public TableView tableview;
    public TableColumn suppliername;
    public TableColumn nicnumber;
    public TableColumn gmail;
    public TableColumn mobilenumber;
    public TableColumn Address;
    public TableColumn id;
    public TableColumn Banknumber;
    public TableColumn Payment;

    public void tableviewmouseclickaction(MouseEvent mouseEvent) {
        Integer index;

        if (mouseEvent.getClickCount() == 1) {
            SupplierTM selectesuplier = (SupplierTM) tableview.getSelectionModel().getSelectedItem();
            if (selectesuplier != null) {
                Id = selectesuplier.getId();
                Nic = selectesuplier.getNic();
                Gmaiil = selectesuplier.getGmail();
                Namee = selectesuplier.getName();
                Bannumber = selectesuplier.getBanumber();
                System.out.println("Clicked Id: " + Nic);

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Pay_form.fxml"));
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
