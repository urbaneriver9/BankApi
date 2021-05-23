package dao.impl;

import dao.ClientDao;
import db.DataSource;
import db.H2DataSourceImpl;
import domain.Client;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClientDaoImpl implements ClientDao {

    private final String SQL_GET_BY_ID = "SELECT * FROM CLIENTS WHERE CLIENTID = ?";

    @Override
    public void insert(Client client) throws SQLException, IOException {
    }

    @Override
    public List<Client> getAll() throws SQLException {
        return null;
    }

    @Override
    public Client getById(long ID) throws SQLException {
        try(Connection connection = H2DataSourceImpl.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_ID);){

            Client client = new Client();
            preparedStatement.setLong(1, ID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                client.setId(resultSet.getLong("ID"));
                client.setSurname(resultSet.getString("Surname"));
                client.setName(resultSet.getString("Name"));
                client.setPatronymic(resultSet.getString("Patronymic"));
                client.setPhoneNumber(resultSet.getNString("PhoneNumber"));

                resultSet.close();

                return client;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return new Client();
    }

    @Override
    public void update(Client client) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
