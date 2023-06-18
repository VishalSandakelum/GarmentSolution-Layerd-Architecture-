package lk.ijse.garment.model;

import lk.ijse.garment.db.DBConnection;
import lk.ijse.garment.db.db;
import lk.ijse.garment.dto.tm.Customer;
import lk.ijse.garment.dto.tm.Notification;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotificationModel {
    public static List<Notification> getAll() throws SQLException {
        Connection con = db.getInstance().getConnection();
        String sql = "SELECT * FROM user";

        List<Notification> data = new ArrayList<>();

        ResultSet resultSet = con.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            data.add(new Notification(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            ) {
            });
        }

        return data;
    }
}
