package lk.ijse.garment.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.garment.bo.SuperBo;
import lk.ijse.garment.dto.tm.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBo extends SuperBo {
    boolean saveEmployee(Employee dto) throws SQLException, ClassNotFoundException;
    String getId()throws SQLException, ClassNotFoundException;
    boolean deleteEmployee(String id)throws SQLException, ClassNotFoundException;
    boolean updateEmployee(Employee dto)throws SQLException, ClassNotFoundException;
    lk.ijse.garment.entity.Employee searchEmployee(String id)throws SQLException, ClassNotFoundException;
    ObservableList getAllEmplyoeePay()throws SQLException, ClassNotFoundException;
    ArrayList<lk.ijse.garment.entity.Employee> getAll() throws SQLException, ClassNotFoundException;
}
