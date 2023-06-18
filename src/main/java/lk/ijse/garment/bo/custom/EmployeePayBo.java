package lk.ijse.garment.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.garment.dto.tm.EmployeePay;
import lk.ijse.garment.dto.tm.Supplier;
import lk.ijse.garment.entity.EmployeePayment;

import java.sql.SQLException;

public interface EmployeePayBo {
    boolean saveEmployeePay(EmployeePay dto) throws SQLException, ClassNotFoundException;
    String getId()throws SQLException, ClassNotFoundException;
    EmployeePayment searchEmployeePay(String id)throws SQLException, ClassNotFoundException;
    ObservableList getAllEmployeePay()throws SQLException, ClassNotFoundException;
}
