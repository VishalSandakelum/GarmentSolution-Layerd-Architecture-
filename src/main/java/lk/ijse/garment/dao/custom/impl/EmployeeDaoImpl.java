package lk.ijse.garment.dao.custom.impl;

import lk.ijse.garment.dao.custom.EmployeeDao;
import lk.ijse.garment.dao.custom.impl.util.SqlUTIL;
import lk.ijse.garment.entity.Employee;
import lk.ijse.garment.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public ArrayList<Employee> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Employee> allCustomers = new ArrayList<>();
        ResultSet rst = SqlUTIL.execute("SELECT * FROM employee");
        while (rst.next()) {
            allCustomers.add(new Employee(rst.getString(1), rst.getString(2), rst.getString(3),rst.getInt(4),rst.getString(5),rst.getString(6),rst.getInt(7),rst.getString(8)));
        }
        return allCustomers;
    }

    @Override
    public boolean save(Employee dto) throws SQLException, ClassNotFoundException {
        return SqlUTIL.execute("INSERT INTO employee(name, nic, gmail, conumber, address, id, banumber, Date)VALUES(?, ?, ?, ?, ?, ?, ?, ?)",dto.getName(),dto.getNic(),dto.getGmail(),dto.getConumber(),dto.getAddress(),dto.getId(),dto.getBanumber(),dto.getDate());
    }

    @Override
    public boolean update(Employee dto) throws SQLException, ClassNotFoundException {
        return SqlUTIL.execute("UPDATE employee SET name = ?, nic = ?, gmail = ?, conumber = ?, address = ?, banumber = ? WHERE id = ?",dto.getName(),dto.getNic(),dto.getGmail(),dto.getConumber(),dto.getAddress(),dto.getBanumber(),dto.getId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SqlUTIL.execute("DELETE FROM employee WHERE id = ?",id);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUTIL.execute("SELECT * FROM employee ORDER BY id DESC LIMIT 1;");
        if(resultSet.next()){
            int id = Integer.parseInt(resultSet.getString(6));
            id +=1;
            return String.valueOf(id);
        }else {
            return "1";
        }
    }

    @Override
    public Employee search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUTIL.execute("SELECT *FROM employee WHERE id = ?",id);
        if(resultSet.next()){
            return new Employee(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7),resultSet.getString(8));
        }else {
            return null;
        }
    }

}
