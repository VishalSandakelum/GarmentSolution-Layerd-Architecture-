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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lk.ijse.garment.bo.BoFactory;
import lk.ijse.garment.bo.custom.SupplierBo;
import lk.ijse.garment.db.DBConnection;
import lk.ijse.garment.dto.tm.Supplier;
import lk.ijse.garment.model.ManagesupplierModel;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagesupplierFormController implements Initializable {


    public Pane chooselist;
    public Button backbtn;
    public Pane cottonpane;
    public Pane wollpane;
    public Button homebtn;
    public Button savesupplierbtn;
    public JFXTextField nametxt;
    public JFXTextField nictext;
    public JFXTextField gmailtext;
    public JFXTextField monumbertext;
    public JFXTextField addresstxt;
    public JFXTextField banknumbtxt;
    public JFXTextField idtext;
    public Button managesupplierbtn1;
    public Button searchbtn;
    public Button deletesupplierbtn;
    public Button updatesupplier;
    public TextField searchtxt;
    public Button checkbtn;

    SupplierBo supplierBo = BoFactory.getBoFactory().getBo(BoFactory.BoType.SUPPLIER);

    public void menubtnonAction(ActionEvent actionEvent) {
        chooselist.setVisible(true);
    }

    public void btnbackbtnonacction(ActionEvent actionEvent) {
        chooselist.setVisible(false);
    }

    public void managesupplierbtnonaction(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/suppliertable_from.fxml"));
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

    public void woolmouseenter(MouseEvent mouseEvent) {
        wollpane.setVisible(true);
    }

    public void woolmouseexite(MouseEvent mouseEvent) {
        wollpane.setVisible(false);
    }

    public void cottonmouseenter(MouseEvent mouseEvent) {
        cottonpane.setVisible(true);
    }

    public void cottonmouseexite(MouseEvent mouseEvent) {
        cottonpane.setVisible(false);
    }

    public void btnseemorepanebtnonaction(ActionEvent actionEvent) {

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

    public void savesupplierbtnonaction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        int Id;
        String name = nametxt.getText();
        String nic = nictext.getText();
        String gmail = gmailtext.getText();
        String address = addresstxt.getText();
        Integer conumber = Integer.parseInt(monumbertext.getText());
        Integer banumber = Integer.parseInt(banknumbtxt.getText());
        String id = idtext.getText();
        if (isGmail(gmail) & isname(name) & isint(String.valueOf(conumber), "Mobile Number") & isint(String.valueOf(banumber), "Bank Number") & isint(id, "Id")) {
            Boolean bool = supplierBo.saveSupplier(new Supplier(name,nic,gmail,address,conumber,banumber,id));

            if(bool==true){
                setDefault();

               idtext.setText(supplierBo.getId());
            }

        }else {
            new Alert(Alert.AlertType.WARNING,
                    "Please enter valide value !")
                    .show();
        }
    }

    public void searchbtnonaction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String search = searchtxt.getText();
        setDefault();

        lk.ijse.garment.entity.Supplier sup = supplierBo.searchSupplier(search);

        if(sup.getId()!=null){
            nametxt.setText(sup.getName());
            idtext.setText(sup.getId());
            nictext.setText(sup.getNic());
            monumbertext.setText(String.valueOf(sup.getConumber()));
            banknumbtxt.setText(String.valueOf(sup.getBanumber()));
            addresstxt.setText(sup.getAddress());
            gmailtext.setText(sup.getGmail());
        }else {
            new Alert(Alert.AlertType.WARNING, "Please check and enter correct id !").show();
        }

        searchtxt.setText("");
    }

    public void deletesupplierbtnonaction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id = idtext.getText();
        Boolean bool = supplierBo.deleteSupplier(id);
        if(bool != true){
            new Alert(Alert.AlertType.WARNING, "Something wrong !").show();
        }else{
            setDefault();
        }
    }

    public void updatesupplierbtn(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String name = nametxt.getText();
        String nic = nictext.getText();
        String gmail = gmailtext.getText();
        String address = addresstxt.getText();
        Integer conumber = Integer.parseInt(monumbertext.getText());
        Integer banumber = Integer.parseInt(banknumbtxt.getText());
        String id = idtext.getText();

        if(isGmail(gmail) & isname(name) & isint(String.valueOf(conumber), "Mobile Number") & isint(String.valueOf(banumber), "Bank Number") & isint(id, "Id")){
            Boolean bool = supplierBo.updateSupplier(new Supplier(name,nic,gmail,address,conumber,banumber,id));
            if(bool==true){
                setDefault();
                new Alert(Alert.AlertType.CONFIRMATION,"Supplier Updated Successfully !").show();
                idtext.setText(supplierBo.getId());
            }
        }else{
            new Alert(Alert.AlertType.WARNING, "Please enter valide value !").show();
        }

    }

    private static boolean isGmail(String email) {
        String regex = "\\b[A-Za-z0-9._%+-]+@gmail\\.com\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private static boolean isname(String name) {
        String regex = "^[a-z]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    private static boolean isint(String intnum,String Type) {
        String regex = "^[0-9]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(intnum);
        if(matcher.matches()){
        }else{new Alert(Alert.AlertType.WARNING,"Invaliude "+Type).show();}
        return matcher.matches();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            idtext.setText(supplierBo.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void checkbtnonaction(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/suppliertable_from.fxml"));
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

    public void setDefault(){
        nametxt.clear();
        idtext.clear();
        nictext.clear();
        monumbertext.clear();
        banknumbtxt.clear();
        addresstxt.clear();
        gmailtext.clear();
    }


}
