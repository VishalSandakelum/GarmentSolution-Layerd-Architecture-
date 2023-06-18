package lk.ijse.garment.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDao<T, Type> extends SuperDao {

    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    boolean save(T dto) throws SQLException, ClassNotFoundException;

    boolean update(T dto) throws SQLException, ClassNotFoundException;

    boolean delete(Type type) throws SQLException, ClassNotFoundException;

    String generateNewID() throws SQLException, ClassNotFoundException;

    T search(Type type) throws SQLException, ClassNotFoundException;

}
