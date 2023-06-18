package lk.ijse.garment.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.garment.bo.SuperBo;
import lk.ijse.garment.dto.tm.Supplier;
import lk.ijse.garment.entity.Customer;

import java.sql.SQLException;

public interface CustomerBo extends SuperBo {

    boolean saveCustomer(lk.ijse.garment.dto.tm.Customer dto) throws SQLException, ClassNotFoundException;
    String getId()throws SQLException, ClassNotFoundException;
    boolean deleteCustomer(String id)throws SQLException, ClassNotFoundException;
    boolean updateCustomer(lk.ijse.garment.dto.tm.Customer dto)throws SQLException, ClassNotFoundException;
    Customer searchCustomerr(String id)throws SQLException, ClassNotFoundException;
    ObservableList getAllCustomerIncome()throws SQLException, ClassNotFoundException;

}
