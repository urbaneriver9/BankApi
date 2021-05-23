package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    void insert(T t) throws SQLException, IOException;

    List<T> getAll() throws SQLException;

    T getById(long ID) throws SQLException;

    void update(T t) throws SQLException;

    void delete(int id) throws SQLException;
}
