package lk.ijse.garment.dao.custom.impl;

import lk.ijse.garment.dao.custom.SupplierDao;
import lk.ijse.garment.dao.custom.impl.util.SqlUTIL;
import lk.ijse.garment.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDaoImpl implements SupplierDao {
    @Override
    public ArrayList<Supplier> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Supplier> allCustomers = new ArrayList<>();
        ResultSet rst = SqlUTIL.execute("SELECT * FROM suplier");
        while (rst.next()) {
            allCustomers.add(new Supplier(rst.getString(1), rst.getString(2), rst.getString(3),rst.getString(4),rst.getInt(5),rst.getInt(6),rst.getString(7)));
        }
        return allCustomers;
    }

    @Override
    public boolean save(Supplier dto) throws SQLException, ClassNotFoundException {
        return SqlUTIL.execute("INSERT INTO suplier(name, nic, gmail, address, conumber, banumber, id) VALUES(?, ?, ?, ?, ?, ?, ?)" ,dto.getName(),dto.getNic(),dto.getGmail(),dto.getAddress(),dto.getConumber(),dto.getBanumber(),dto.getId());
    }

    @Override
    public boolean update(Supplier dto) throws SQLException, ClassNotFoundException {
        return SqlUTIL.execute("UPDATE suplier SET name = ?, nic = ?, gmail = ?, address = ?, conumber = ?, banumber = ? WHERE id = ?" ,dto.getName(),dto.getNic(),dto.getGmail(),dto.getAddress(),dto.getConumber(),dto.getBanumber(),dto.getId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SqlUTIL.execute("DELETE FROM suplier WHERE id = ?",id);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUTIL.execute("SELECT * FROM suplier ORDER BY id DESC LIMIT 1");
        if(resultSet.next()){
            int id = Integer.valueOf(resultSet.getString(7));
            id+=1;
            return String.valueOf(id);
        }else{
            return "1";
        }
    }

    @Override
    public Supplier search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUTIL.execute("SELECT *FROM suplier WHERE id = ?", id);
        if(resultSet.next()){
            return new Supplier(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getInt(6),resultSet.getString(7));
        }else {
            return null;
        }
    }
}
