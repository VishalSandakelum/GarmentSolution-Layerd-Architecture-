package lk.ijse.garment.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.garment.bo.BoFactory;
import lk.ijse.garment.bo.custom.EmployeeBo;
import lk.ijse.garment.bo.custom.MaterialBo;
import lk.ijse.garment.db.DBConnection;
import lk.ijse.garment.dto.tm.Material;
import lk.ijse.garment.model.ManagematerialModel;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagematerialFormController implements Initializable {



    public Button menu;
    public Button managesupplierbtn11;
    public Button checkmaterial;
    public Button homebtn;
    public JFXTextField nametxt;
    public JFXTextField idtxt;
    public JFXTextField sidtxt;
    public JFXTextField amounttxt;
    public JFXTextField pricetxt;
    public Button addmaterialbtn;
    public Button updatebtn;
    public Button deletebtn;
    public Button searchbtn;
    public TextField searchtxt;

    MaterialBo materialBo = BoFactory.getBoFactory().getBo(BoFactory.BoType.MATERIAL);

    public void menubtnonAction(ActionEvent actionEvent) {

    }


    public void btncheckmaterialbtnonaction(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/materialtable_form.fxml"));
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

    public void homebtnonAction(ActionEvent actionEvent) {
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

    public void savematerialonaction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String materialname = nametxt.getText();
        String material_id = idtxt.getText();
        String id = sidtxt.getText();
        String amount = amounttxt.getText();
        double price = Double.parseDouble(pricetxt.getText());


        Boolean bool = materialBo.saveMaterial(new Material(materialname,material_id,id,amount,price));

        if(bool==true){
            setDefault();
            new Alert(Alert.AlertType.CONFIRMATION,"Material added Successfully !").show();
        }

            idtxt.setText(materialBo.getId());


    }

    @Override
    public void initialize(java.net.URL url, ResourceBundle resourceBundle) {
        try {
            idtxt.setText(materialBo.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updatebtnonaction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String materialname = nametxt.getText();
        String material_id = idtxt.getText();
        String id = sidtxt.getText();
        String amount = amounttxt.getText();
        double price = Double.parseDouble(pricetxt.getText());

        if(isname(materialname) & isint(material_id) & isint(id) ){
            Boolean bool = materialBo.updateMaterial(new Material(materialname,id,amount,price,material_id));

            if(bool == true){
                setDefault();
                new Alert(Alert.AlertType.CONFIRMATION, "Material Updated Successfully !").show();
            }

        }else {
            new Alert(Alert.AlertType.WARNING, "Please enter valide value !").show();
        }

    }

    public void deletebtnonaction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String mat_id = idtxt.getText();
        Boolean bool = materialBo.deleteMaterial(mat_id);

        if(bool == true){
            setDefault();
            new Alert(Alert.AlertType.CONFIRMATION, "Material Deleted Successfully !").show();
        }

    }

    public static boolean isname(String name) {
        String regex = "^[a-z]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    public static boolean isint(String intnum) {
        String regex = "^[0-9]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(intnum);
        return matcher.matches();
    }

    public void searchbtnonaction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String material_id = searchtxt.getText();

        lk.ijse.garment.entity.Material material = materialBo.searchMaterial(material_id);

        if(material!=null){
            nametxt.setText(material.getMaterialname());
            idtxt.setText(material.getMaterial_id());
            sidtxt.setText(material.getId());
            amounttxt.setText(material.getAmount());
            pricetxt.setText(String.valueOf(material.getPrice()));

            searchtxt.setText("");

        }else {
            setDefault();
            idtxt.setText(materialBo.getId());
            new Alert(Alert.AlertType.WARNING, "Can't find this material id ! , Please check & enter the correct id.").show();
        }

    }

    private void setDefault(){
        nametxt.clear();
        idtxt.clear();
        sidtxt.clear();
        amounttxt.clear();
        pricetxt.clear();
        searchtxt.clear();
    }

}
