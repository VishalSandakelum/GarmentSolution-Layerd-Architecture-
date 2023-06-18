package lk.ijse.garment.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.garment.bo.custom.EmployeePayBo;
import lk.ijse.garment.dao.DaoFactory;
import lk.ijse.garment.dao.custom.EmployeePayDao;
import lk.ijse.garment.dao.custom.OtherQueryDao;
import lk.ijse.garment.dto.tm.EmployeePay;
import lk.ijse.garment.entity.EmployeePayment;

import java.sql.SQLException;

public class EmployeePayBoImpl implements EmployeePayBo {

    EmployeePayDao employeePayDao = DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.EMPLOYEEPAY);
    OtherQueryDao otherQueryDao = DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.QUERY);

    @Override
    public boolean saveEmployeePay(EmployeePay dto) throws SQLException, ClassNotFoundException {
        return employeePayDao.save(new EmployeePayment(dto.getDate(),dto.getEmployee_id(),dto.getPayment_id(),dto.getPayment()));
    }

    @Override
    public String getId() throws SQLException, ClassNotFoundException {
        return employeePayDao.generateNewID();
    }

    @Override
    public EmployeePayment searchEmployeePay(String id) throws SQLException, ClassNotFoundException {
        return employeePayDao.search(id);
    }

    @Override
    public ObservableList getAllEmployeePay() throws SQLException, ClassNotFoundException {
        return otherQueryDao.getEmployeePayment();
    }
}
