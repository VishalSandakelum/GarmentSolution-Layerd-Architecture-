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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lk.ijse.garment.bo.BoFactory;
import lk.ijse.garment.bo.custom.EmployeeBo;
import lk.ijse.garment.bo.custom.SupplierBo;
import lk.ijse.garment.dto.tm.Employee;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManageemployeeFormController implements Initializable {

    public TextField searchbar;
    public Button manageemployeebtn;
    public ImageView searchimg;
    public Pane chooselist;
    public Button managesupplierbtn;
    public Button backbtn;
    public Button homebtn;
    public Button Addemployeebtn;
    public JFXTextField Nametxt;
    public JFXTextField Nictxt;
    public JFXTextField Gmailtxt;
    public JFXTextField Monumbertxt;
    public JFXTextField Addresstxt;
    public JFXTextField Idtxt;
    public JFXTextField Banumbertxt;
    public Button deletebtn;
    public Button updatebtn;
    public Button searchbtn;

    EmployeeBo employeeBo = BoFactory.getBoFactory().getBo(BoFactory.BoType.EMPLOYEE);

    public void mouseclickedinsearchbar(MouseEvent mouseEvent) {
    }

    public void manageemployeebtnonaction(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/employeetable_from.fxml"));
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
        chooselist.setVisible(true);
    }

    public void mousedarggedformsearchbar(MouseEvent mouseEvent) {
        searchimg.setVisible(true);
    }

    public void btnbackbtnonacction(ActionEvent actionEvent) {
        chooselist.setVisible(false);
    }

    public void managesupplierbtnonaction(ActionEvent actionEvent) {
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

    public void Addemployeebtnonaction(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {

        String mail = Gmailtxt.getText();
        String checknum = Nametxt.getText();
        String checkid  = Idtxt.getText();
        String checknumber = Monumbertxt.getText();

        boolean bool = isboolean(mail);

        System.out.println(bool);
        if (bool==true & checknum.matches("^[a-z]*$") & checkid.matches("^[0-9]*$") & checknumber.matches("^[0-9]*$")) {
            Timestamp currentDate = new Timestamp(System.currentTimeMillis());
            String name = Nametxt.getText();
            String nic = Nictxt.getText();
            String gmail = Gmailtxt.getText();
            Integer conumber = Integer.parseInt(Monumbertxt.getText());
            String address = Addresstxt.getText();
            String id = Idtxt.getText();
            Integer banumber = Integer.parseInt(Banumbertxt.getText());
            String curDate = String.valueOf(currentDate);


                String massge = "Dear "+name+", welcome to our intexvog agency. You are our employee from now on and you appear here (id :" + id + ").";

                Boolean booll = employeeBo.saveEmployee(new Employee(name,nic,gmail,conumber,address,id,banumber,curDate));
                if (booll) {
                    new Alert(Alert.AlertType.CONFIRMATION,
                            " Employee added successfully")
                            .show();
                    JavaEmailSender j1 = new JavaEmailSender();
                    j1.send(name, massge, gmail);
                } else {
                    new Alert(Alert.AlertType.CONFIRMATION,
                            "oops)")
                            .show();
                }

                setDefault();

        }else {
            new Alert(Alert.AlertType.ERROR,
                    "Please enter the correct mail !")
                    .show();
        }

        Idtxt.setText(employeeBo.getId());
    }

    @Override
    public void initialize(java.net.URL url, ResourceBundle resourceBundle) {

        try {
            Idtxt.setText(employeeBo.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static boolean isboolean(String email){
        String regex = "\\b[A-Za-z0-9._%+-]+@gmail\\.com\\b";
        Pattern ptn = Pattern.compile(regex);
        Matcher match = ptn.matcher(email);

        return match.matches();
    }

    public void deletebtnonaction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String search = Idtxt.getText();
            Boolean bool = employeeBo.deleteEmployee(search);

            if (bool) {
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully employee deleted !").show();
            }

            setDefault();
        Idtxt.setText(employeeBo.getId());
    }

    public void updatebtnonaction(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        String mail = Gmailtxt.getText();
        String checknum = Nametxt.getText();
        String checkid  = Idtxt.getText();
        String checknumber = Monumbertxt.getText();

        boolean bool = isboolean(mail);

        if (bool==true & checknum.matches("^[a-z]*$") & checkid.matches("^[0-9]*$") & checknumber.matches("^[0-9]*$")) {
            String name = Nametxt.getText();
            String nic = Nictxt.getText();
            String gmail = Gmailtxt.getText();
            Integer conumber = Integer.parseInt(Monumbertxt.getText());
            String address = Addresstxt.getText();
            String id = Idtxt.getText();
            Integer banumber = Integer.parseInt(Banumbertxt.getText());


                Boolean booll = employeeBo.updateEmployee(new Employee(name,nic,gmail,conumber,address,banumber,id));
                if (booll) {
                    new Alert(Alert.AlertType.CONFIRMATION,
                            " Employee updated successfully")
                            .show();
                } else {
                    new Alert(Alert.AlertType.CONFIRMATION,
                            "oops)")
                            .show();
                }

                setDefault();

            Idtxt.setText(employeeBo.getId());

        }else {
            new Alert(Alert.AlertType.ERROR,
                    "Please enter the correct mail !")
                    .show();
        }

    }

    public void searchbtnonaction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String search = searchbar.getText();

                lk.ijse.garment.entity.Employee emp = employeeBo.searchEmployee(search);

                if(emp!=null) {
                    Nametxt.setText(emp.getName());
                    Nictxt.setText(emp.getNic());
                    Gmailtxt.setText(emp.getGmail());
                    Monumbertxt.setText(String.valueOf(emp.getConumber()));
                    Addresstxt.setText(emp.getAddress());
                    Idtxt.setText(emp.getId());
                    Banumbertxt.setText(String.valueOf(emp.getBanumber()));
                }else{new Alert(Alert.AlertType.WARNING , "Can't find this id !, Please check & enter the correct id.").show();}

    }

    private void setDefault(){
        Nametxt.clear();
        Nictxt.clear();
        Gmailtxt.clear();
        Monumbertxt.clear();
        Addresstxt.clear();
        Idtxt.clear();
        Banumbertxt.clear();

        searchbar.clear();
    }

}
