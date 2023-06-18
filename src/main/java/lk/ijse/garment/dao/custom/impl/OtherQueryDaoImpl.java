package lk.ijse.garment.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.garment.dao.custom.OtherQueryDao;
import lk.ijse.garment.dao.custom.impl.util.SqlUTIL;
import lk.ijse.garment.entity.IncomeDetails;
import lk.ijse.garment.entity.Material;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OtherQueryDaoImpl implements OtherQueryDao {
    @Override
    public ArrayList<Material> searchOrderByOID() throws SQLException, ClassNotFoundException {
        ArrayList<Material> allmaterials = new ArrayList<>();
        ResultSet rst = SqlUTIL.execute("SELECT * FROM material");
        while (rst.next()) {
            allmaterials.add(new Material(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getDouble(5)));
        }
        return allmaterials;
    }

    @Override
    public ObservableList getId() throws SQLException, ClassNotFoundException {
        ObservableList<String> itemsid = FXCollections.observableArrayList();
        ResultSet resultSet = SqlUTIL.execute("SELECT * FROM material");
        while (resultSet.next()){
            String mid = resultSet.getString(2);
            itemsid.add(mid);
        }
        return itemsid;
    }

    @Override
    public ObservableList getCustomerId() throws SQLException, ClassNotFoundException {
        ObservableList<String> Customerid = FXCollections.observableArrayList();
        ResultSet resultSet = SqlUTIL.execute("SELECT * FROM customertable");
        while (resultSet.next()){
            String cusid = resultSet.getString(2);
            Customerid.add(cusid);
        }
        return Customerid;
    }

    @Override
    public ObservableList getClothesku() throws SQLException, ClassNotFoundException {
        ObservableList<String> clothesku = FXCollections.observableArrayList();
        ResultSet resultSet = SqlUTIL.execute("SELECT * FROM clothes");
        while (resultSet.next()){
            String cloid = resultSet.getString(1);
            clothesku.add(cloid);
        }
        return clothesku;
    }

    @Override
    public boolean getIncomeMonth(String month) throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUTIL.execute("SELECT *FROM incomedetails WHERE month = ?",month);
        return rst.next() ? true : false;
    }

    @Override
    public ObservableList getEmployeePayment() throws SQLException, ClassNotFoundException {
        ObservableList<Double> getEmPay = FXCollections.observableArrayList();
        ResultSet rst = SqlUTIL.execute("SELECT *FROM employeepayment");
        while (rst.next()) {
            double pay =  rst.getDouble(4);
            getEmPay.add(pay);
        }
        return getEmPay;
    }

    @Override
    public ObservableList getCustomerIncome() throws SQLException, ClassNotFoundException {
        ObservableList<Double> getCusIncome = FXCollections.observableArrayList();
        ResultSet rst = SqlUTIL.execute("SELECT *FROM customerincome");
        while (rst.next()) {
            double income =  rst.getDouble(4);
            getCusIncome.add(income);
        }
        return getCusIncome;
    }

    @Override
    public boolean saveIncomeDetails(IncomeDetails dto) throws SQLException, ClassNotFoundException {
        return SqlUTIL.execute("INSERT INTO incomedetails(month, empaymentotal, cuspaymentotal, proflose) VALUES (?, ?, ?, ?)",dto.getMonth(),dto.getEmpaymentotal(),dto.getCuspaymentotal(),dto.getProflose());
    }


}
