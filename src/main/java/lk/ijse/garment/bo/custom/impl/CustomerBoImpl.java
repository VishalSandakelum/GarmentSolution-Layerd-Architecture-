package lk.ijse.garment.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.garment.bo.custom.CustomerBo;
import lk.ijse.garment.dao.DaoFactory;
import lk.ijse.garment.dao.custom.CustomerDao;
import lk.ijse.garment.dao.custom.OtherQueryDao;
import lk.ijse.garment.dto.tm.Customer;

import java.sql.SQLException;

public class CustomerBoImpl implements CustomerBo {

    CustomerDao customerDao = DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.CUSTOMER);
    OtherQueryDao otherQueryDao = DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.QUERY);

    @Override
    public boolean saveCustomer(Customer dto) throws SQLException, ClassNotFoundException {
        return customerDao.save(new lk.ijse.garment.entity.Customer(dto.getName(),dto.getCustomer_id(),dto.getNic_number(),dto.getContact_number(),dto.getAddress(), dto.getBank_number(), dto.getGmail(), dto.getDate()));
    }

    @Override
    public String getId() throws SQLException, ClassNotFoundException {
        return customerDao.generateNewID();
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDao.delete(id);
    }

    @Override
    public boolean updateCustomer(Customer dto) throws SQLException, ClassNotFoundException {
        return customerDao.update(new lk.ijse.garment.entity.Customer(dto.getName(),dto.getNic_number(),dto.getContact_number(),dto.getAddress(), dto.getBank_number(), dto.getGmail(),dto.getCustomer_id()));
    }

    @Override
    public lk.ijse.garment.entity.Customer searchCustomerr(String id) throws SQLException, ClassNotFoundException {
        return customerDao.search(id);
    }

    @Override
    public ObservableList getAllCustomerIncome() throws SQLException, ClassNotFoundException {
        return otherQueryDao.getCustomerIncome();
    }

}
