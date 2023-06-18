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
import lk.ijse.garment.dto.tm.Place;
import lk.ijse.garment.dto.tm.Supplier;
import lk.ijse.garment.dto.tm.tm.EmployeeTM;
import lk.ijse.garment.dto.tm.tm.PlaceTM;
import lk.ijse.garment.dto.tm.tm.SupplierTM;
import lk.ijse.garment.model.PlaceModel;
import lk.ijse.garment.model.SupplierModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class PlaceordertableFormController implements Initializable {

    static String ordrid;
    static String skutext;
    static String quantitytext;
    static String  unitpricetext;
    static String datetext;
    static double discounttext;
    static double totaltext;


    public TableView tableview;
    public TableColumn orderid;
    public TableColumn sku;
    public TableColumn quantity;
    public TableColumn unitprice;
    public TableColumn date;
    public TableColumn discount;
    public TableColumn total;

    public void tableviewmouseclickaction(MouseEvent mouseEvent) {
        Integer index;

        if (mouseEvent.getClickCount() == 1) {
            PlaceTM selectesuplier = (PlaceTM) tableview.getSelectionModel().getSelectedItem();
            if (selectesuplier != null) {
                ordrid = selectesuplier.getOrder_id();
                skutext = selectesuplier.getSku();
                quantitytext = selectesuplier.getQuantity();
                unitpricetext = selectesuplier.getUnitprice();
                datetext = selectesuplier.getDate();
                discounttext = selectesuplier.getDiscount();
                totaltext = selectesuplier.getTotal();
                System.out.println("Clicked Id: " + ordrid);

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/customerpayment_form.fxml"));
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
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAll(); setCellValueFactory();
    }

    private void setCellValueFactory() {
        orderid.setCellValueFactory(new PropertyValueFactory<>("order_id"));
        sku.setCellValueFactory(new PropertyValueFactory<>("sku"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unitprice.setCellValueFactory(new PropertyValueFactory<>("unitprice"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        discount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));
    }

    private void getAll() {
        try {
            ObservableList<PlaceTM> obList = FXCollections.observableArrayList();
            List<Place> places = PlaceModel.getAll();

            for (Place place : places) {
                obList.add(new PlaceTM(
                        place.getOrder_id(),
                        place.getSku(),
                        place.getQuantity(),
                        place.getUnitprice(),
                        place.getDate(),
                        place.getDiscount(),
                        place.getTotal()
                ));
            }
            tableview.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }

}
