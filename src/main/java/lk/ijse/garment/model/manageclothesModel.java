package lk.ijse.garment.model;

import javafx.scene.control.Alert;
import lk.ijse.garment.db.DBConnection;

import java.sql.*;

public class manageclothesModel {

    public static void addclothes(String clothestypetxt,String skutxt,String colortxt, String amounttxt, double pricetxt,String materialidcomboboxtxt, String discounttxt){
        Timestamp currentDate = new Timestamp(System.currentTimeMillis());
        String clothes_type = clothestypetxt;
        String sku = skutxt;
        String color = colortxt;
        String amount = amounttxt;
        Double price = pricetxt;
        String material_id =  materialidcomboboxtxt;
        int am = Integer.parseInt(amount);
        Double Total;
        if(discounttxt!=null){
            double discount = ((price*am)/100)*2;
            double tot = (price*am);
            Total = tot-discount;
        }else{
            Total = (price*am);
        }

        try{
            Connection con = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO clothes(clothes_type, sku, color, amount, price, material_id, date, Total)" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, clothes_type);
            pstm.setString(2, sku);
            pstm.setString(3, color);
            pstm.setString(4, amount);
            pstm.setDouble(5, price);
            pstm.setString(6,material_id);
            pstm.setString(7, String.valueOf(currentDate));
            pstm.setDouble(8,Total);

            int affectedRows = pstm.executeUpdate();
            if (affectedRows > 0) {
                new Alert(Alert.AlertType.CONFIRMATION,
                        " Clothes added successfully")
                        .show();
            }else{
                new Alert(Alert.AlertType.CONFIRMATION,
                        "oops)")
                        .show();
            }


        } catch (SQLException throwables) {

        }
    }

}
