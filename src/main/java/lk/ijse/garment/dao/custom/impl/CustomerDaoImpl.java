package lk.ijse.garment.dao.custom.impl;

import lk.ijse.garment.dao.custom.CustomerDao;
import lk.ijse.garment.dao.custom.impl.util.SqlUTIL;
import lk.ijse.garment.entity.Customer;
import lk.ijse.garment.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Customer dto) throws SQLException, ClassNotFoundException {
        return SqlUTIL.execute("INSERT INTO customertable(name, customer_id, nic_number, contact_number, address, bank_number, gmail, Date) VALUES(?, ?, ?, ?, ?, ?, ?, ?)", dto.getName(),dto.getCustomer_id(),dto.getNic_number(),dto.getContact_number(),dto.getAddress(),dto.getBank_number(),dto.getGmail(),dto.getDate());
    }

    @Override
    public boolean update(Customer dto) throws SQLException, ClassNotFoundException {
        return SqlUTIL.execute("UPDATE customertable SET name = ?, nic_number = ?, contact_number = ?, address = ?, bank_number = ?, gmail = ? WHERE customer_id = ?", dto.getName(),dto.getNic_number(),dto.getContact_number(),dto.getAddress(),dto.getBank_number(),dto.getGmail(),dto.getCustomer_id());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SqlUTIL.execute("DELETE FROM customertable WHERE customer_id = ?",id);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUTIL.execute("SELECT * FROM customertable ORDER BY customer_id DESC LIMIT 1;");
        if(resultSet.next()){
            int id = Integer.parseInt(resultSet.getString(2));
            id+=1;
            return String.valueOf(id);
        }else {
            return "1";
        }
    }

    @Override
    public Customer search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUTIL.execute("SELECT *FROM customertable WHERE customer_id = ?", id);
        if(resultSet.next()){
            return new Customer(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getInt(6),resultSet.getString(7),resultSet.getString(8));
        }else {
            return null;
        }
    }
}
