package lk.ijse.garment.bo.custom.impl;

import lk.ijse.garment.bo.BoFactory;
import lk.ijse.garment.bo.custom.SupplierBo;
import lk.ijse.garment.dao.DaoFactory;
import lk.ijse.garment.dao.custom.SupplierDao;
import lk.ijse.garment.dto.tm.Supplier;

import java.sql.SQLException;

public class SupplierBoImpl implements SupplierBo {

    SupplierDao supplierDao = DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.SUPPLIER);

    @Override
    public boolean saveSupplier(Supplier dto) throws SQLException, ClassNotFoundException {
        return supplierDao.save(new lk.ijse.garment.entity.Supplier(dto.getName(), dto.getNic(),dto.getGmail(),dto.getAddress(), dto.getConumber(), dto.getBanumber(), dto.getId()));
    }

    @Override
    public String getId() throws SQLException, ClassNotFoundException {
        return supplierDao.generateNewID();
    }

    @Override
    public boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException {
        return supplierDao.delete(id);
    }

    @Override
    public boolean updateSupplier(Supplier dto) throws SQLException, ClassNotFoundException {
        return supplierDao.update(new lk.ijse.garment.entity.Supplier(dto.getName(), dto.getNic(),dto.getGmail(),dto.getAddress(), dto.getConumber(), dto.getBanumber(), dto.getId()));
    }

    @Override
    public lk.ijse.garment.entity.Supplier searchSupplier(String id) throws SQLException, ClassNotFoundException {
        return supplierDao.search(id);
    }


}
