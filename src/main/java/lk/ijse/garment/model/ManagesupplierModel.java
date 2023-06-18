package lk.ijse.garment.model;

import javafx.scene.control.Alert;
import lk.ijse.garment.bo.BoFactory;
import lk.ijse.garment.bo.custom.SupplierBo;
import lk.ijse.garment.dao.DaoFactory;
import lk.ijse.garment.db.DBConnection;
import lk.ijse.garment.entity.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ManagesupplierModel {

    public  static String name;
    public static String nic;
    public static String gmail;
    public static String address;
    public static String number;
    public static String banknumber;
    public static String id;
    public static boolean bool;


    public static Boolean searchbtnAction(String search){

        try {
            Connection con = DBConnection.getInstance().getConnection();
            String sql = "SELECT *FROM suplier WHERE id = ?";
            PreparedStatement pstm  = con.prepareStatement(sql);

            pstm.setString(1, search);
            ResultSet resultSet = pstm.executeQuery();
            if(resultSet.next()){
                name = resultSet.getString(1);
                nic = resultSet.getString(2);
                gmail = resultSet.getString(3);
                address = resultSet.getString(4);
                number = resultSet.getString(5);
                banknumber = resultSet.getString(6);
                id = resultSet.getString(7);
                bool = true;
            }else {
                bool = false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return bool;
    }

    public static Boolean deletebtnAction(String search){
        try{
            Connection con = DBConnection.getInstance().getConnection();
            String sql = "DELETE FROM suplier WHERE id = ?";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, search);

            if(pstm.executeUpdate() > 0){
                new Alert(Alert.AlertType.CONFIRMATION, "Supplier delete successfully !").show();
                bool = true;
            }else{
                bool = false;
            }

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        return bool;
    }

    public static Boolean updatebtnAction(String nme, String nc, String gmil, String addrss, int numer, int banknmber, String Id){
        try {
            Connection con = DBConnection.getInstance().getConnection();
            String sql = "UPDATE suplier SET name = ?, nic = ?, gmail = ?, address = ?, conumber = ?, banumber = ? WHERE id = ?";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, nme);
            pstm.setString(2, nc);
            pstm.setString(3, gmil);
            pstm.setString(4, addrss);
            pstm.setInt(5, numer);
            pstm.setInt(6, banknmber);
            pstm.setString(7, Id);

            if(pstm.executeUpdate() > 0){
                new Alert(Alert.AlertType.CONFIRMATION, "Supplier updated successfully !").show();
                bool = true;
            }else {
                new Alert(Alert.AlertType.CONFIRMATION, "Something wrong !").show();
                bool = false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bool;
    }

    public static Boolean savebtnAction(String nme, String nc, String gmil, String addrss, int numer, int banknmber, String Id){
        try  {
            Connection con = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO suplier(name, nic, gmail, address, conumber, banumber, id)" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, nme);
            pstm.setString(2, nc);
            pstm.setString(3, gmil);
            pstm.setString(4, addrss);
            pstm.setInt(5, numer);
            pstm.setInt(6, banknmber);
            pstm.setString(7, Id);


            int affectedRows = pstm.executeUpdate();
            if (affectedRows > 0) {
                new Alert(Alert.AlertType.CONFIRMATION,
                        " Supplier added successfully").show();
                bool = true;
            } else {
                new Alert(Alert.AlertType.CONFIRMATION,
                        "Something wrong !").show();
                bool = false;
            }

        } catch (SQLException throwables) {

        }
        return bool;
    }

}
