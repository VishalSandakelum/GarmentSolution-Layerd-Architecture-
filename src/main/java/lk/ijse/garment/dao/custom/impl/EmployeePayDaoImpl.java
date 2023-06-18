package lk.ijse.garment.dao.custom.impl;

import lk.ijse.garment.dao.custom.EmployeeDao;
import lk.ijse.garment.dao.custom.EmployeePayDao;
import lk.ijse.garment.dao.custom.impl.util.SqlUTIL;
import lk.ijse.garment.entity.EmployeePayment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeePayDaoImpl implements EmployeePayDao {
    @Override
    public ArrayList<EmployeePayment> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(EmployeePayment dto) throws SQLException, ClassNotFoundException {
        return SqlUTIL.execute("INSERT INTO employeepayment(Date, employee_id, payment_id, payment) VALUES(?, ?, ?, ?)",dto.getDate(),dto.getEmployee_id(),dto.getPayment_id(),dto.getPayment());
    }

    @Override
    public boolean update(EmployeePayment dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUTIL.execute("SELECT * FROM employeepayment ORDER BY payment_id DESC LIMIT 1;");
        if (rst.next()) {
            int id = rst.getInt(3);
            id+=1;
            return String.valueOf(id);
        }else{
            return "1";
        }
    }

    @Override
    public EmployeePayment search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet  = SqlUTIL.execute("SELECT * FROM employeepayment WHERE employee_id = ?",id);
        if (resultSet.next()) {
            return new EmployeePayment(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4));
        }else {
            return null;
        }
    }
}
