package lk.ijse.garment.controller;

import com.google.zxing.WriterException;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class PlaceorderFormController implements Initializable {

    private static final String URL = "jdbc:mysql://localhost:3306/garment";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
    }

    public JFXComboBox orderidcombotxt;
    public JFXComboBox quantitycombotxt;
    public JFXComboBox unitpricecombotxt;
    public JFXComboBox skucombotxt;
    public Button placeorderbtn;
    public JFXTextField quantitytxt;
    public JFXTextField discounttxt;
    static double disc;
    static double totl;
    static String ordID;

    public void placeorderbtnonaction(ActionEvent actionEvent) {
        if (orderidcombotxt != null || skucombotxt != null) {
            Timestamp currentDate = new Timestamp(System.currentTimeMillis());
            String order_id = (String) orderidcombotxt.getValue();
            String sku = (String) skucombotxt.getValue();
            String quqntity = quantitytxt.getText();
            String unitprice = (String) unitpricecombotxt.getValue();
            double discount = Double.parseDouble(discounttxt.getText());
            double total;

            if(discounttxt.getText()!=null){
                double qunt = Double.parseDouble(quqntity);
                double unitpr = Double.parseDouble(unitprice);
                double tl = ((unitpr*qunt)/100)*discount;
                total = (unitpr*qunt)-tl;
            }else{
                double qunt = Double.parseDouble(quqntity);
                double unitpr = Double.parseDouble(unitprice);
                total = (unitpr*qunt);
            }

            disc = discount;
            totl = total;
            ordID = order_id;

            try (Connection con = DriverManager.getConnection(URL, props)) {
                String sql = "INSERT INTO placeordertable(order_id, sku, quantity, unitprice, date, discount, total)" +
                        "VALUES(?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setString(1, order_id);
                pstm.setString(2, sku);
                pstm.setString(3, quqntity);
                pstm.setString(4, unitprice);
                pstm.setString(5, String.valueOf(currentDate));
                pstm.setDouble(6, discount);
                pstm.setDouble(7,total);

                int affectedRows = pstm.executeUpdate();
                if (affectedRows > 0) {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/acceptorderdetail_form.fxml"));
                    Parent root1 = null;
                    try {
                        root1 = (Parent) fxmlLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.show();

                    Qrgenrator.generateQRCodeImage("INTEXVOG"+"\n"+"Order id :"+order_id+"\n"+"Sku :"+sku+"\n"+"Quantity :"+quqntity+"\n"+"Unit price :"+unitprice+"\n"+"Date :"+String.valueOf(currentDate)+"\n"+"Discount :"+discount+"\n"+"Total :"+total,450, 350,"src/main/resources/imgs/qrnewone.png");

                    String mail = getmail(order_id);

                    qrsender q1 = new qrsender();
                    q1.send("PLace Order", "Successfully Order Placement",mail,"D:\\Garmentsolution(s.f.w)\\src\\main\\resources\\imgs\\qrnewone.png");

                } else {
                    new Alert(Alert.AlertType.CONFIRMATION,
                            "oops)")
                            .show();
                }

                orderidcombotxt.setValue(null);
                skucombotxt.setValue(null);
                quantitytxt.setText("");
                unitpricecombotxt.setValue(null);
                discounttxt.setText("");

            } catch (SQLException throwables) {

            } catch (IOException e) {
                e.printStackTrace();
            } catch (WriterException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> id = FXCollections.observableArrayList();
        ObservableList<String> sku = FXCollections.observableArrayList();
        ObservableList<String> price = FXCollections.observableArrayList();

        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "SELECT * FROM ordertable";
            PreparedStatement pstm = con.prepareStatement(sql);

            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                String oid = resultSet.getString(5);
                id.add(oid);
            }

            orderidcombotxt .setItems(id);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "SELECT * FROM clothes ";
            PreparedStatement pstm = con.prepareStatement(sql);

            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                String pr = resultSet.getString(5);
                price.add(pr);
            }

            unitpricecombotxt .setItems(price);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "SELECT * FROM clothes ";
            PreparedStatement pstm = con.prepareStatement(sql);

            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                String sk = resultSet.getString(2);
                sku.add(sk);
            }

            skucombotxt .setItems(sku);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private String getmail(String order_id) throws SQLException {

        String id = order_id;
        String gmail = null;

        try(Connection conn = DriverManager.getConnection(URL,props)){
            String sqll = "SELECT *FROM ordertable WHERE order_id = ?";

            PreparedStatement pstm = conn.prepareStatement(sqll);
            pstm.setString(1, id);
            ResultSet resultSet = pstm.executeQuery();
            if(resultSet.next()){
                String cusid = resultSet.getString(1);

                try (Connection connection = DriverManager.getConnection(URL,props)){
                    String sql = "SELECT *FROM customertable WHERE customer_id = ?";

                    PreparedStatement pst = connection.prepareStatement(sql);
                    pst.setString(1,cusid);
                    ResultSet resultSet1 = pst.executeQuery();
                    if(resultSet1.next()){
                        String mail = resultSet1.getString(7);
                        gmail = mail;
                    }

                }
            }
        }
        return gmail;
    }

}
