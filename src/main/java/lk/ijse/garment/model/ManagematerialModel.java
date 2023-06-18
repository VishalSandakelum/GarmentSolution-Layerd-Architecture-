package lk.ijse.garment.model;

import javafx.scene.control.Alert;
import lk.ijse.garment.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagematerialModel {

    static Boolean bool;

    public static String materialname;
    public static String materialid;
    public static String ID;
    public static String Amount;
    public static String PRICE;


    public static  Boolean savematerialbtnAction(String materialname, String material_id, String id, String amount, double price){
        try {
            Connection con = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO material(materialname, material_id, id, amount, price)" +
                    "VALUES(?, ?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, materialname);
            pstm.setString(2, material_id);
            pstm.setString(3, id);
            pstm.setString(4, amount);
            pstm.setDouble(5, price);


            int affectedRows = pstm.executeUpdate();
            if (affectedRows > 0) {
                new Alert(Alert.AlertType.CONFIRMATION,
                        " Material added successfully")
                        .show();
                bool = true;
            }else{
                new Alert(Alert.AlertType.CONFIRMATION,
                        "oops)")
                        .show();
                bool = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  bool;
    }

    public static Boolean updatebtnAction(String materialname, String material_id, String id, String amount, double price){

        try {
            Connection con = DBConnection.getInstance().getConnection();
            String sql = "UPDATE material SET materialname = ?, id = ?, amount = ?, price = ? WHERE material_id = ?";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, materialname);
            pstm.setString(2, id);
            pstm.setString(3, amount);
            pstm.setDouble(4, price);
            pstm.setString(5, material_id);

            if(pstm.executeUpdate() > 0){
                new Alert(Alert.AlertType.CONFIRMATION, "Material details updated successfully !").show();
                bool = true;
            }else{
                new Alert(Alert.AlertType.WARNING, "Something wrong !").show();
                bool = false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return bool;
    }

    public static  Boolean deletebtnAction(String material_id){
        try {
            Connection con = DBConnection.getInstance().getConnection();
            String sql = "DELETE FROM material WHERE material_id = ?";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, material_id);

            if(pstm.executeUpdate() > 0){
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully material delete !").show();
                bool = true;
            }else {
                new Alert(Alert.AlertType.WARNING, "Something wrong !").show();
                bool = false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  bool;
    }

    public static Boolean searchbtnAction(String material_id){

        try {
            Connection con = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM material WHERE material_id = ?";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, material_id);

            ResultSet resultSet = pstm.executeQuery();

            if(resultSet.next()){
                materialname = resultSet.getString(1);
                materialid = resultSet.getString(2);
                ID = resultSet.getString(3);
                Amount = resultSet.getString(4);
                PRICE = resultSet.getString(5);

                bool = true;
            }else {
                new Alert(Alert.AlertType.WARNING, "Something wrong !").show();

                bool = false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return bool;

    }
}
