package lk.ijse.garment.dao.custom.impl;

import lk.ijse.garment.dao.custom.ClothesDao;
import lk.ijse.garment.dao.custom.impl.util.SqlUTIL;
import lk.ijse.garment.entity.Clothes;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClothesDaoImpl implements ClothesDao {
    @Override
    public ArrayList<Clothes> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Clothes dto) throws SQLException, ClassNotFoundException {
        return SqlUTIL.execute("INSERT INTO clothes(clothes_type, sku, color, amount, price, material_id, date, Total) VALUES(?, ?, ?, ?, ?, ?, ?, ?)",dto.getClothes_type(),dto.getSku(),dto.getColor(),dto.getAmount(),dto.getPrice(),dto.getMaterial_id(),dto.getDate(),dto.getTotal());
    }

    @Override
    public boolean update(Clothes dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Clothes search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }
}
