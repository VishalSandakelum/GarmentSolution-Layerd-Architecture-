package lk.ijse.garment.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.garment.bo.custom.OrderBo;
import lk.ijse.garment.dao.DaoFactory;
import lk.ijse.garment.dao.custom.OrderDao;
import lk.ijse.garment.dao.custom.OtherQueryDao;
import lk.ijse.garment.dto.tm.Order;

import java.sql.SQLException;

public class OrderBoImpl implements OrderBo {

    OrderDao orderDao = DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.ORDER);
    OtherQueryDao otherQueryDao = DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.QUERY);

    @Override
    public boolean saveOrder(Order dto) throws SQLException, ClassNotFoundException {
        return orderDao.save(new lk.ijse.garment.entity.Order(dto.getCustomer_id(), dto.getType(), dto.getOrder_date(), dto.getDead_date(), dto.getOrder_id()));
    }

    @Override
    public String getId() throws SQLException, ClassNotFoundException {
        return orderDao.generateNewID();
    }

    @Override
    public ObservableList getAllCustomerId() throws SQLException, ClassNotFoundException {
        return otherQueryDao.getCustomerId();
    }

    @Override
    public ObservableList getAllClothesku() throws SQLException, ClassNotFoundException {
        return otherQueryDao.getClothesku();
    }
}
