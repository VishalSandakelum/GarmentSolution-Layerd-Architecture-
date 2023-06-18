package lk.ijse.garment.bo.custom.impl;

import lk.ijse.garment.bo.custom.IncomeBo;
import lk.ijse.garment.dao.DaoFactory;
import lk.ijse.garment.dao.custom.OtherQueryDao;
import lk.ijse.garment.dto.tm.Incomedetails;
import lk.ijse.garment.entity.IncomeDetails;

import java.sql.SQLException;

public class IncomeBoImpl implements IncomeBo {

    OtherQueryDao otherQueryDao = DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.QUERY);

    @Override
    public boolean saveIncome(Incomedetails dto) throws SQLException, ClassNotFoundException {
        return otherQueryDao.saveIncomeDetails(new IncomeDetails(dto.getMonth(),dto.getEmpaymenttotal(),dto.getCuspaymentotal(),dto.getProflose()));
    }

    @Override
    public boolean getIncomeMonth(String Date) throws SQLException, ClassNotFoundException {
        return otherQueryDao.getIncomeMonth(Date);
    }
}
