package lk.ijse.garment.bo.custom;

import lk.ijse.garment.bo.SuperBo;
import lk.ijse.garment.dto.tm.Supplier;

import java.sql.SQLException;

public interface SupplierBo extends SuperBo {

    boolean saveSupplier(Supplier dto) throws SQLException, ClassNotFoundException;
    String getId()throws SQLException, ClassNotFoundException;
    boolean deleteSupplier(String id)throws SQLException, ClassNotFoundException;
    boolean updateSupplier(Supplier dto)throws SQLException, ClassNotFoundException;
    lk.ijse.garment.entity.Supplier searchSupplier(String id)throws SQLException, ClassNotFoundException;

}
