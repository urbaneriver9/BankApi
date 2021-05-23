package dao.impl;

import dao.CardDao;
import db.DataSource;
import db.H2DataSourceImpl;
import domain.Card;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class CardDaoImpl implements CardDao {

    private final String SQL_INSERT = "INSERT INTO CARDS (NUMBER, ACCOUNTNUMBER, CLIENTID) VALUES (?, ?, ?)";
    private final String SQL_GET_BY_NUMBER = "SELECT * FROM CARDS WHERE NUMBER = ?";
    Logger log = Logger.getLogger(CardDaoImpl.class.getName());

    @Override
    public void insert(Card card) throws SQLException {
//            Savepoint savepoint = connection.setSavepoint("Card ready to be added.");
        try (Connection connection = H2DataSourceImpl.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {

            connection.setAutoCommit(false);

            preparedStatement.setString(1, card.getNumber());
            preparedStatement.setString(2, card.getAccountNumber());
            preparedStatement.setLong(3, card.getClientID());
            preparedStatement.executeUpdate();

            connection.commit();

            log.info("\nCard with ID " + card.getNumber() + " added" +
                    "\n======================================");
        } catch (SQLException exception) {
//                connection.rollback(savepoint);
            exception.printStackTrace();
        }
    }


    @Override
    public List<Card> getAll() throws SQLException {
        return null;
    }

    @Override
    public Card getById(long ID) throws SQLException {
        return null;
    }

    @Override
    public Card getCardByNumber(String number) {
        try (Connection connection = H2DataSourceImpl.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_NUMBER)) {

            Card card = new Card();
            preparedStatement.setString(1, number);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                card.setNumber(resultSet.getString("Number"));
                card.setClientID(resultSet.getLong("ClientID"));
                card.setAccountNumber(resultSet.getString("AccountNumber"));
                card.setValid(resultSet.getBoolean("IsOpen"));

                resultSet.close();

                return card;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return new Card();
    }

    @Override
    public void update(Card card) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

}
