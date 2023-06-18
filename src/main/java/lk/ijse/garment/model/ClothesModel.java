package lk.ijse.garment.model;

import lk.ijse.garment.db.DBConnection;
import lk.ijse.garment.dto.tm.Clothes;
import lk.ijse.garment.dto.tm.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClothesModel {
    public static List<Clothes> getAll() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM clothes";

        List<Clothes> data = new ArrayList<>();

        ResultSet resultSet = con.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            data.add(new Clothes(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDouble(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getDouble(8)
            ) {
            });
        }

        return data;
    }
}
