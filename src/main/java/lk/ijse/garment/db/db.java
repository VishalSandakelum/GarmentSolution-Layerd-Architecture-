
package lk.ijse.garment.db;

import java.sql.*;

public class db {
    private static db dbConnection;
    private Connection con;

    private db() throws SQLException {
        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/customer",
                "root",
                "1234"
        );
    }

    public static db getInstance() throws SQLException {

        return (null == dbConnection) ? dbConnection = new db()
                : dbConnection;
    }
    public Connection getConnection() {
        return con;
    }

}

