package lk.ijse.garment.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.garment.bo.SuperBo;
import lk.ijse.garment.dto.tm.Clothes;
import lk.ijse.garment.dto.tm.Material;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ClothesBo extends SuperBo {
    boolean saveClothes(Clothes dto) throws SQLException, ClassNotFoundException;
    ObservableList getAllMaterId()throws SQLException, ClassNotFoundException;
}
