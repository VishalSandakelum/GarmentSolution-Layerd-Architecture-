package lk.ijse.garment.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import lk.ijse.garment.db.DBConnection;

import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

public class CustomerpaymentFormController implements Initializable {


    public Text orderidtxt;
    public Text skutxt;
    public Text unitpricetxt;
    public Text discounttxt;
    public Text totaltxt;
    public Button paymentgaranted;

    public void paymentgarantedbtnonaction(ActionEvent actionEvent) {
        int paymentid = 0;

        try  {
            Connection con = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM customerincome";
            PreparedStatement pstm = con.prepareStatement(sql);

            ResultSet resultSet = pstm.executeQuery();

            if (resultSet.next()) {
                int paytid = resultSet.getInt(3);
                paymentid  = paytid+1;
            }else{
                paymentid = 1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        double pay;
        double price  = 50000;
        Timestamp currentDate = new Timestamp(System.currentTimeMillis());
        String order_id = orderidtxt.getText();
        String payment_id = String.valueOf(paymentid);
        Double payment = Double.parseDouble(totaltxt.getText());


        try  {
            Connection con = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO customerincome(Date, order_id, payment_id, payment)" +
                    "VALUES(?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, String.valueOf(currentDate));
            pstm.setString(2, order_id);
            pstm.setString(3, payment_id);
            pstm.setDouble(4, payment);


            int affectedRows = pstm.executeUpdate();
            if (affectedRows > 0) {
                new Alert(Alert.AlertType.CONFIRMATION,
                        " Succesfully payed!")
                        .show();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION,
                        "oops)")
                        .show();
            }


        } catch (SQLException throwables) {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Date date = new Date();

        int month = date.getMonth() + 1;
        int day = date.getDate();

        System.out.println(month + " " + day);

        orderidtxt.setText(PlaceordertableFormController.ordrid);
        skutxt.setText(PlaceordertableFormController.skutext);
        unitpricetxt.setText(PlaceordertableFormController.unitpricetext);
        discounttxt.setText(String.valueOf(PlaceordertableFormController.discounttext));
        totaltxt.setText(String.valueOf(PlaceordertableFormController.totaltext));

        String order_id = PlaceordertableFormController.ordrid;
        //if (month == 4 && day == 18) {
            paymentgaranted.setDisable(false);

            try  {
                Connection con = DBConnection.getInstance().getConnection();
                String sql = "SELECT * FROM customerincome WHERE order_id = ?";
                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setString(1, order_id);

                ResultSet resultSet = pstm.executeQuery();
                if (resultSet.next()) {
                    //double payment = resultSet.getDouble(4);
                    paymentgaranted.setDisable(true);
                    System.out.println("ok");

                } else {
                    paymentgaranted.setDisable(false);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        /*}else {
            paymentgaranted.setDisable(true);
        }*/
    }
}
