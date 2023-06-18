package lk.ijse.garment.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.garment.bo.SuperBo;
import lk.ijse.garment.dto.tm.Order;

import java.sql.SQLException;

public interface OrderBo extends SuperBo {
    boolean saveOrder(Order dto) throws SQLException, ClassNotFoundException;
    String getId()throws SQLException, ClassNotFoundException;
    ObservableList getAllCustomerId()throws SQLException, ClassNotFoundException;
    ObservableList getAllClothesku()throws SQLException, ClassNotFoundException;
}
