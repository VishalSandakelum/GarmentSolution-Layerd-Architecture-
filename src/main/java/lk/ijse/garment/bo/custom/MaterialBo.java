package lk.ijse.garment.bo.custom;

import lk.ijse.garment.bo.SuperBo;
import lk.ijse.garment.entity.Material;

import java.sql.SQLException;
public interface MaterialBo extends SuperBo {
    boolean saveMaterial(lk.ijse.garment.dto.tm.Material dto) throws SQLException, ClassNotFoundException;
    String getId()throws SQLException, ClassNotFoundException;
    boolean deleteMaterial(String id)throws SQLException, ClassNotFoundException;
    boolean updateMaterial(lk.ijse.garment.dto.tm.Material dto)throws SQLException, ClassNotFoundException;
    Material searchMaterial(String id)throws SQLException, ClassNotFoundException;
}
