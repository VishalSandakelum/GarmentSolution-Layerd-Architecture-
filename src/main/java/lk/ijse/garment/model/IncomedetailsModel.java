package lk.ijse.garment.model;

import lk.ijse.garment.db.DBConnection;
import lk.ijse.garment.dto.tm.Customer;
import lk.ijse.garment.dto.tm.Incomedetails;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IncomedetailsModel {
    public static List<Incomedetails> getAll() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM incomedetails";

        List<Incomedetails> data = new ArrayList<>();

        ResultSet resultSet = con.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            data.add(new Incomedetails(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getDouble(4),
                    resultSet.getDouble(5)
            ) {
            });
        }

        return data;
    }
}
