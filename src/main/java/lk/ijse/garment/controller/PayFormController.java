package lk.ijse.garment.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import lk.ijse.garment.bo.BoFactory;
import lk.ijse.garment.bo.custom.EmployeePayBo;
import lk.ijse.garment.dto.tm.EmployeePay;
import lk.ijse.garment.entity.EmployeePayment;

import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

public class PayFormController implements Initializable {

    public Text idtxt;
    public Text nametxt;
    public Text nictxt;
    public Text gmailtxt;
    public Text banknumbertxt;
    public Button paymentgaranted;

    EmployeePayBo employeePayBo = BoFactory.getBoFactory().getBo(BoFactory.BoType.EMPLOYEEPAY);

    public void paymentgarantedbtnonaction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        int paymentid = 0;

        paymentid = Integer.parseInt(employeePayBo.getId());

        double price  = 50000;
        Timestamp currentDate = new Timestamp(System.currentTimeMillis());
        String employee_id = idtxt.getText();
        String payment_id = String.valueOf(paymentid);
        Double payment = Double.parseDouble(String.valueOf(price));
        String Date = String.valueOf(currentDate);

            boolean bool = employeePayBo.saveEmployeePay(new EmployeePay(Date,employee_id,payment_id,payment));

            if (bool) {
                new Alert(Alert.AlertType.CONFIRMATION, " Succesfully payed!").show();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "oops)").show();
            }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Date date = new Date();

        int month = date.getMonth() + 1;
        int day = date.getDate();

        System.out.println(month + " " + day);

        idtxt.setText(EmployeepaymenttableController.Id);
        nametxt.setText(EmployeepaymenttableController.Namee);
        nictxt.setText(EmployeepaymenttableController.Nic);
        gmailtxt.setText(EmployeepaymenttableController.Gmaiil);
        banknumbertxt.setText(String.valueOf(EmployeepaymenttableController.Bannumber));

        String employee_id = EmployeepaymenttableController.Id;
        if (month == 4 && day == 30) {
            paymentgaranted.setDisable(false);

            try {
                EmployeePayment employeePayment = employeePayBo.searchEmployeePay(employee_id);
                if (employeePayment.getPayment_id()!=null) {
                    double payment = employeePayment.getPayment();
                    paymentgaranted.setDisable(true);

                } else {
                    paymentgaranted.setDisable(false);
                }

            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }else{
            paymentgaranted.setDisable(true);
        }
    }
}

