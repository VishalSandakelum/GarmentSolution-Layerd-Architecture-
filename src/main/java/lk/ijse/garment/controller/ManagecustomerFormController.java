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
import lk.ijse.garment.bo.custom.CustomerBo;
import lk.ijse.garment.db.DBConnection;
import lk.ijse.garment.dto.tm.Customer;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagecustomerFormController implements Initializable {


    public Button manageemployeebtn;
    public Button menu;
    public Button homebtn;
    public Button savecustomerbtn;
    public JFXTextField fullnametext;
    public JFXTextField nicnumbertext;
    public JFXTextField gmailtext;
    public JFXTextField numbertext;
    public JFXTextField addresstext;
    public JFXTextField idtext;
    public JFXTextField banknumbertext;
    public Button deletebtn;
    public Button updatebtn;
    public Button searchbtn;
    public TextField searchtxt;

    CustomerBo customerBo = BoFactory.getBoFactory().getBo(BoFactory.BoType.CUSTOMER);

    public void manageemployeebtnonaction(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/customertable_from.fxml"));
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

        FirstpageFormController.bool = false;


    }

    public void savecustomerbtnonaction(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {

        String checknum = fullnametext.getText();
        String id  = idtext.getText();
        String number = numbertext.getText();
        String checkgmail = gmailtext.getText();

        if(isGmail(checkgmail) & isname(checknum)) {
            if(isint(id) & isint(number)) {
                try {
                    Timestamp Date = new Timestamp(System.currentTimeMillis());
                    String name = fullnametext.getText();
                    String customer_id = idtext.getText();
                    String nic_number = nicnumbertext.getText();
                    Integer contact_number = Integer.parseInt(numbertext.getText());
                    String address = addresstext.getText();
                    Integer bank_number = Integer.parseInt(banknumbertext.getText());
                    String gmail = gmailtext.getText();
                    String curDate = String.valueOf(Date);

                        String massge = "Dear customer, welcome to our intexvog agency. You are our user from now on and you appear here (id :" + customer_id + ").";

                        Boolean bool = customerBo.saveCustomer(new Customer(name,customer_id,nic_number,contact_number,address,bank_number,gmail,curDate));
                        if (bool) {
                            new Alert(Alert.AlertType.CONFIRMATION, " Customer added successfully").show();
                            JavaEmailSender j1 = new JavaEmailSender();
                            j1.send("Dear Customer ", massge, gmail);
                        } else {
                            new Alert(Alert.AlertType.CONFIRMATION, "oops)").show();
                        }

                        setDefault();

                        idtext.setText(customerBo.getId());

                } catch (NumberFormatException e) {
                    new Alert(Alert.AlertType.WARNING,
                            "Enter correct value !")
                            .show();
                }
            }else {
                new Alert(Alert.AlertType.ERROR, "Please enter valide value").show();
            }
        }else {
            new Alert(Alert.AlertType.ERROR, "Please enter valide value").show();
        }
    }

    public void deletebtnonaction(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {

        String search = idtext.getText();

            Boolean bool = customerBo.deleteCustomer(search);
            if(bool){
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully customer deleted !").show();
            }
            setDefault();
    }

    public void updatebtnonaction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String name = fullnametext.getText();
        String customer_id = idtext.getText();
        String nic_number = nicnumbertext.getText();
        Integer contact_number = Integer.parseInt(numbertext.getText());
        String address = addresstext.getText();
        Integer bank_number = Integer.parseInt(banknumbertext.getText());
        String gmail = gmailtext.getText();

            Boolean bool = customerBo.updateCustomer(new Customer(name,nic_number,contact_number,address,bank_number,gmail,customer_id));
            if(bool){
                new Alert(Alert.AlertType.CONFIRMATION, "Customer updated successfully !").show();
            }else{
                new Alert(Alert.AlertType.ERROR, "Please check and enter the correct value !").show();
            }

            setDefault();


    }

    public void searchbtnonaction(ActionEvent actionEvent) throws ClassNotFoundException,SQLException {
        String search = searchtxt.getText();

                lk.ijse.garment.entity.Customer customer = customerBo.searchCustomerr(search);

                fullnametext.setText(customer.getName());
                idtext.setText(customer.getCustomer_id());
                nicnumbertext.setText(customer.getNic_number());
                numbertext.setText(String.valueOf(customer.getContact_number()));
                addresstext.setText(customer.getAddress());
                banknumbertext.setText(String.valueOf(customer.getBank_number()));
                gmailtext.setText(customer.getGmail());

                searchtxt.setText("");

    }

    public void searchtxt(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String search = searchtxt.getText();

        lk.ijse.garment.entity.Customer customer = customerBo.searchCustomerr(search);

        fullnametext.setText(customer.getName());
        idtext.setText(customer.getCustomer_id());
        nicnumbertext.setText(customer.getNic_number());
        numbertext.setText(String.valueOf(customer.getContact_number()));
        addresstext.setText(customer.getAddress());
        banknumbertext.setText(String.valueOf(customer.getBank_number()));
        gmailtext.setText(customer.getGmail());

        searchtxt.setText("");

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
    private static boolean isint(String intnum) {
        String regex = "^[0-9]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(intnum);
        return matcher.matches();
    }

    @Override
    public void initialize(java.net.URL url, ResourceBundle resourceBundle) {
        try {
            idtext.setText(customerBo.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setDefault(){
        fullnametext.clear();
        idtext.clear();
        nicnumbertext.clear();
        numbertext.clear();
        addresstext.clear();
        banknumbertext.clear();
        gmailtext.clear();
    }

}
