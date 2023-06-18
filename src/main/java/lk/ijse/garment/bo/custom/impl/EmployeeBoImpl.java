package lk.ijse.garment.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.garment.bo.custom.EmployeeBo;
import lk.ijse.garment.dao.DaoFactory;
import lk.ijse.garment.dao.custom.EmployeeDao;
import lk.ijse.garment.dao.custom.OtherQueryDao;
import lk.ijse.garment.dto.tm.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBoImpl implements EmployeeBo {

    EmployeeDao employeeDao = DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.EMPLOYEE);
    OtherQueryDao otherQueryDao = DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.QUERY);

    @Override
    public boolean saveEmployee(Employee dto) throws SQLException, ClassNotFoundException {
        return employeeDao.save(new lk.ijse.garment.entity.Employee(dto.getName(), dto.getNic(), dto.getGmail(), dto.getConumber(), dto.getAddress(),dto.getId(), dto.getBanumber(), dto.getDate()));
    }

    @Override
    public String getId() throws SQLException, ClassNotFoundException {
        return employeeDao.generateNewID();
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDao.delete(id);
    }

    @Override
    public boolean updateEmployee(Employee dto) throws SQLException, ClassNotFoundException {
        return employeeDao.update(new lk.ijse.garment.entity.Employee(dto.getName(),dto.getNic(),dto.getGmail(),dto.getConumber(),dto.getAddress(),dto.getBanumber(),dto.getId()));
    }

    @Override
    public lk.ijse.garment.entity.Employee searchEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDao.search(id);
    }

    @Override
    public ObservableList getAllEmplyoeePay() throws SQLException, ClassNotFoundException {
        return otherQueryDao.getEmployeePayment();
    }

    @Override
    public ArrayList<lk.ijse.garment.entity.Employee> getAll() throws SQLException, ClassNotFoundException {
        return employeeDao.getAll();
    }
}
