package lk.ijse.garment.dao.custom.impl;

import lk.ijse.garment.dao.custom.MaterialDao;
import lk.ijse.garment.dao.custom.impl.util.SqlUTIL;
import lk.ijse.garment.entity.Material;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaterialDaoImpl implements MaterialDao {

    @Override
    public ArrayList<Material> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Material> allmaterials = new ArrayList<>();
        ResultSet rst = SqlUTIL.execute("SELECT * FROM material");
        while (rst.next()) {
            allmaterials.add(new Material(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getDouble(5)));
        }
        return allmaterials;
    }

    @Override
    public boolean save(Material dto) throws SQLException, ClassNotFoundException {
        return SqlUTIL.execute("INSERT INTO material(materialname, material_id, id, amount, price) VALUES(?, ?, ?, ?, ?)",dto.getMaterialname(),dto.getMaterial_id(),dto.getId(),dto.getAmount(),dto.getPrice());
    }

    @Override
    public boolean update(Material dto) throws SQLException, ClassNotFoundException {
        return SqlUTIL.execute("UPDATE material SET materialname = ?, id = ?, amount = ?, price = ? WHERE material_id = ?",dto.getMaterialname(),dto.getId(),dto.getAmount(),dto.getPrice(),dto.getMaterial_id());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SqlUTIL.execute("DELETE FROM material WHERE material_id = ?",id);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUTIL.execute("SELECT * FROM material ORDER BY material_id DESC LIMIT 1");
        if(resultSet.next()){
            int id = Integer.parseInt(resultSet.getString(2));
            id+=1;
            return String.valueOf(id);
        }else {
            return "1";
        }
    }

    @Override
    public Material search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUTIL.execute("SELECT * FROM material WHERE material_id = ?",id);
        if(resultSet.next()){
            return new Material(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getDouble(5));
        }else {
            return null;
        }
    }

}
