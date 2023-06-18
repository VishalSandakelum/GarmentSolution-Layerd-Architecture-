package lk.ijse.garment.dao.custom.impl;

import lk.ijse.garment.dao.custom.OrderDao;
import lk.ijse.garment.dao.custom.impl.util.SqlUTIL;
import lk.ijse.garment.entity.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDaoImpl implements OrderDao {
    @Override
    public ArrayList<Order> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Order dto) throws SQLException, ClassNotFoundException {
        return SqlUTIL.execute("INSERT INTO ordertable(customer_id, type, order_date, dead_date, order_id) VALUES(?, ?, ?, ?, ?)",dto.getCustomer_id(),dto.getType(),dto.getOrder_date(),dto.getDead_date(),dto.getOrder_id());
    }

    @Override
    public boolean update(Order dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUTIL.execute("SELECT * FROM ordertable ORDER BY order_id DESC LIMIT 1;");
        if (rst.next()) {
            int id = Integer.parseInt(rst.getString(5));
            id+=1;
            return String.valueOf(id);
        }else{
            return "1";
        }
    }

    @Override
    public Order search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }
}
