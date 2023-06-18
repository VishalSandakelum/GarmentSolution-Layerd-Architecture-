package lk.ijse.garment.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import lk.ijse.garment.bo.BoFactory;
import lk.ijse.garment.bo.custom.OrderBo;
import lk.ijse.garment.dto.tm.Order;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class ManageorderFormController implements Initializable {

    public Button menu;
    public Button manageemployeebtn;
    public Button homebtn;
    public JFXTextField orderid;
    public JFXTextField yreartxt;
    public JFXTextField monthtxt;
    public JFXTextField datetxt;
    public JFXComboBox comoboboxid;
    public JFXComboBox comoboboxtype;
    public Button addorder;
    public Button placeorder;

    OrderBo orderBo = BoFactory.getBoFactory().getBo(BoFactory.BoType.ORDER);

    public void menubtnonAction(ActionEvent actionEvent) {

    }

    public void manageemployeebtnonaction(ActionEvent actionEvent) {

    }

    public void homebtnonaction(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/firstpage_form.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();

        Stage currentStage = (Stage) homebtn.getScene().getWindow();
        currentStage.close();
    }

    public void addorderbtnonaction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        if (comoboboxid!=null||comoboboxtype!=null) {
            Timestamp currentDate = new Timestamp(System.currentTimeMillis());
            String customer_id = (String) comoboboxid.getValue();
            String type = (String) comoboboxtype.getValue();
            String year = yreartxt.getText();
            String month = monthtxt.getText();
            String date = datetxt.getText();
            String CurDate = String.valueOf(currentDate);
            String dead_date = year + "-" + month + "-" + date;
            String order_id = orderid.getText();

                Boolean bool = orderBo.saveOrder(new Order(customer_id,type,CurDate,dead_date,order_id));
                if (bool) {
                    new Alert(Alert.AlertType.CONFIRMATION,
                            " Clothes added successfully")
                            .show();
                } else {
                    new Alert(Alert.AlertType.CONFIRMATION,
                            "oops)")
                            .show();
                }

                datetxt.setText("");
                monthtxt.setText("");
                yreartxt.setText("");
                orderid.setText("");
                comoboboxid.setValue(null);
                comoboboxtype.setValue(null);

            orderid.setText(orderBo.getId());


        }
    }

    public void checkorderbtnonaction(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> id = null;
        try {
            id = orderBo.getAllCustomerId();
            comoboboxid.setItems(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ObservableList<String> type = null;
        try {
            type = orderBo.getAllClothesku();
            comoboboxtype.setItems(type);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            orderid.setText(orderBo.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void placeorderbtnonaction(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/placeorder_form.fxml"));
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
