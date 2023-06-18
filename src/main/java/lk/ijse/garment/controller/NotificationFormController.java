package lk.ijse.garment.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.garment.dto.tm.Notification;
import lk.ijse.garment.dto.tm.Supplier;
import lk.ijse.garment.dto.tm.tm.NotificationTM;
import lk.ijse.garment.dto.tm.tm.SupplierTM;
import lk.ijse.garment.model.NotificationModel;
import lk.ijse.garment.model.SupplierModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class NotificationFormController implements Initializable {
    public TableView tableview;
    public TableColumn usernametxt;
    public TableColumn addresstxt;
    public TableColumn nictxt;
    public TableColumn contacttxt;
    public TableColumn banknumbertxt;
    public TableColumn gmailtxt;

    public void tableviewmouseclickaction(MouseEvent mouseEvent) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAll();setCellValueFactory();
    }

    private void setCellValueFactory() {
        usernametxt.setCellValueFactory(new PropertyValueFactory<>("username"));
        addresstxt.setCellValueFactory(new PropertyValueFactory<>("address"));
        nictxt.setCellValueFactory(new PropertyValueFactory<>("nicnumber"));
        contacttxt.setCellValueFactory(new PropertyValueFactory<>("contactnumber"));
        banknumbertxt.setCellValueFactory(new PropertyValueFactory<>("gmail"));
        gmailtxt.setCellValueFactory(new PropertyValueFactory<>("banknumber"));
    }

    private void getAll() {
        try {
            ObservableList<NotificationTM> obList = FXCollections.observableArrayList();
            List<Notification> notify = NotificationModel.getAll();

            for (Notification notification : notify) {
                obList.add(new NotificationTM(
                        notification.getUsername(),
                        notification.getAddress(),
                        notification.getNicnumber(),
                        notification.getContactnumber(),
                        notification.getBanknumber(),
                        notification.getGmail()
                ));
            }
            tableview.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }
}
