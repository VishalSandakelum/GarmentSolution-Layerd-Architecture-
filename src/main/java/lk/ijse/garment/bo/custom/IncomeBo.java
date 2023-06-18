package lk.ijse.garment.bo.custom;

import lk.ijse.garment.bo.SuperBo;
import lk.ijse.garment.dto.tm.Incomedetails;

import java.sql.SQLException;

public interface IncomeBo extends SuperBo {
    public boolean saveIncome(Incomedetails dto)throws SQLException, ClassNotFoundException;
    public boolean getIncomeMonth(String Date)throws SQLException, ClassNotFoundException;
}
