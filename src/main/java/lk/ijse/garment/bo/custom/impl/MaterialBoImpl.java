package lk.ijse.garment.bo.custom.impl;

import lk.ijse.garment.bo.custom.MaterialBo;
import lk.ijse.garment.dao.DaoFactory;
import lk.ijse.garment.dao.custom.EmployeeDao;
import lk.ijse.garment.dao.custom.MaterialDao;
import lk.ijse.garment.dto.tm.Employee;
import lk.ijse.garment.dto.tm.Material;

import java.sql.SQLException;

public class MaterialBoImpl implements MaterialBo {

    MaterialDao materialDao = DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.MATERIAL);


    @Override
    public boolean saveMaterial(Material dto) throws SQLException, ClassNotFoundException {
        return materialDao.save(new lk.ijse.garment.entity.Material(dto.getMaterialname(), dto.getMaterial_id(), dto.getId(), dto.getAmount(), dto.getPrice()));
    }

    @Override
    public String getId() throws SQLException, ClassNotFoundException {
        return materialDao.generateNewID();
    }

    @Override
    public boolean deleteMaterial(String id) throws SQLException, ClassNotFoundException {
        return materialDao.delete(id);
    }

    @Override
    public boolean updateMaterial(Material dto) throws SQLException, ClassNotFoundException {
        return materialDao.update(new lk.ijse.garment.entity.Material(dto.getMaterialname(), dto.getId(), dto.getAmount(), dto.getPrice(), dto.getMaterial_id()));
    }

    @Override
    public lk.ijse.garment.entity.Material searchMaterial(String id) throws SQLException, ClassNotFoundException {
        return materialDao.search(id);
    }

}
