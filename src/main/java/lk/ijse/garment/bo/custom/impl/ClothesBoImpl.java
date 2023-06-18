package lk.ijse.garment.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.garment.bo.custom.ClothesBo;
import lk.ijse.garment.dao.DaoFactory;
import lk.ijse.garment.dao.custom.ClothesDao;
import lk.ijse.garment.dao.custom.OtherQueryDao;
import lk.ijse.garment.dto.tm.Clothes;

import java.sql.SQLException;

public class ClothesBoImpl implements ClothesBo  {

    ClothesDao clothesDao = DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.CLOTHES);
    OtherQueryDao otherQueryDao = DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.QUERY);

    @Override
    public boolean saveClothes(Clothes dto) throws SQLException, ClassNotFoundException {
        return clothesDao.save(new lk.ijse.garment.entity.Clothes(dto.getType(), dto.getSku(), dto.getColor(), dto.getAmount(),dto.getPrice(),dto.getMat_id(),dto.getDate(),dto.getTotal()));
    }

    @Override
    public ObservableList getAllMaterId() throws SQLException, ClassNotFoundException {
        return otherQueryDao.getId();
    }

}
