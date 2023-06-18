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
import lk.ijse.garment.bo.custom.ClothesBo;
import lk.ijse.garment.db.DBConnection;
import lk.ijse.garment.dto.tm.Clothes;
import lk.ijse.garment.dto.tm.Material;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;

public class ManageclothesFormController implements Initializable {


    public Button checkmaterial;
    public Button menu;
    public Button homebtn;
    public JFXTextField clothestypetxt;
    public JFXTextField skutxt;
    public JFXTextField amounttxt;
    public JFXTextField colortxt;
    public JFXTextField pricetxt;
    public Button addclothesbtn;
    public JFXComboBox materialidcomboboxtxt;
    public JFXTextField discounttxt;

    ClothesBo clothesBo = BoFactory.getBoFactory().getBo(BoFactory.BoType.CLOTHES);

    public void btncheckmaterialbtnonaction(ActionEvent actionEvent) {

    }

    public void menubtnonAction(ActionEvent actionEvent) {

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

    public void addclothesbtnonaction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        Timestamp currentDate = new Timestamp(System.currentTimeMillis());
        String clothes_type = clothestypetxt.getText();
        String sku = skutxt.getText();
        String color = colortxt.getText();
        String amount = amounttxt.getText();
        Double price = Double.parseDouble(pricetxt.getText());
        String material_id = (String) materialidcomboboxtxt.getValue();
        int am = Integer.parseInt(amount);
        String curDate = String.valueOf(currentDate);
        Double Total;
        if(discounttxt.getText()!=null){
            double discount = ((price*am)/100)*2;
            double tot = (price*am);
            Total = tot-discount;
        }else{
            Total = (price*am);
        }

        Boolean bool = clothesBo.saveClothes(new Clothes(clothes_type,sku,color,amount,price,material_id,curDate,Total));
        if(bool){
            new Alert(Alert.AlertType.CONFIRMATION,"Clothes Added Successfully !").show();
            clothestypetxt.clear();
            skutxt.clear();
            colortxt.clear();
            amounttxt.clear();
            pricetxt.clear();
            discounttxt.clear();
        }else{
            new Alert(Alert.AlertType.WARNING,"Something Wrong !").show();
        }

    }

    @Override
    public void initialize(java.net.URL url, ResourceBundle resourceBundle) {

        try {
            ObservableList<String> itemsnew = clothesBo.getAllMaterId();

            materialidcomboboxtxt.setItems(itemsnew);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
