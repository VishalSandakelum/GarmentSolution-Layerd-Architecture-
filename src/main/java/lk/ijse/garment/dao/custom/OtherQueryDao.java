package lk.ijse.garment.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.garment.dao.SuperDao;
import lk.ijse.garment.entity.IncomeDetails;
import lk.ijse.garment.entity.Material;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface OtherQueryDao extends SuperDao {
    public ArrayList<Material> searchOrderByOID() throws SQLException, ClassNotFoundException;
    public ObservableList getId()throws SQLException, ClassNotFoundException;
    public ObservableList getCustomerId()throws SQLException, ClassNotFoundException;
    public ObservableList getClothesku()throws SQLException, ClassNotFoundException;
    public boolean getIncomeMonth(String month)throws SQLException, ClassNotFoundException;
    public ObservableList getEmployeePayment()throws SQLException, ClassNotFoundException;
    public ObservableList getCustomerIncome()throws SQLException, ClassNotFoundException;
    public boolean saveIncomeDetails(IncomeDetails dto)throws SQLException, ClassNotFoundException;
}
