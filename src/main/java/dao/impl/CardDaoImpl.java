package dao.impl;

import dao.CardDao;
import db.H2DataSourceImpl;
import domain.Card;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CardDaoImpl implements CardDao {

    Logger log = Logger.getLogger(CardDaoImpl.class.getName());

    private final String SQL_INSERT = "INSERT INTO CARDS (NUMBER, ACCOUNTNUMBER, CLIENTID) VALUES (?, ?, ?)";
    private final String SQL_GET_BY_NUMBER = "SELECT * FROM CARDS WHERE NUMBER = ?";
    private final String SQL_GET_BY_ACCOUNTNUMBER = "SELECT * FROM CARDS WHERE ACCOUNTNUMBER = ?";



    @Override
    public String insert(Card card) throws SQLException {
        try(Connection connection = H2DataSourceImpl.createConnection()) {
//            Savepoint savepoint = connection.setSavepoint("Card ready to be added.");
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {

                connection.setAutoCommit(false);

                preparedStatement.setString(1, card.getNumber());
                preparedStatement.setString(2, card.getAccountNumber());
                preparedStatement.setLong(3, card.getClientID());
                preparedStatement.executeUpdate();

                connection.commit();

                log.info("\nCard with number " + card.getNumber() + " added" +
                        "\n======================================");
                return card.getNumber();
            } catch (SQLException exception) {
//                connection.rollback(savepoint);
                exception.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new String();
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
                card.setValid(resultSet.getBoolean("IsValid"));

                resultSet.close();

                return card;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return new Card();
    }

    @Override
    public List<Card> getAllCardsByAccountNumber(String accountNumber) {
        try(Connection connection = H2DataSourceImpl.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_ACCOUNTNUMBER)){

            preparedStatement.setString(1, accountNumber);
            ArrayList<Card> allCards = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Card card = new Card();
                card.setNumber(resultSet.getString("Number"));
                card.setAccountNumber(resultSet.getString("AccountNumber"));
                card.setClientID(resultSet.getLong("ClientID"));
                card.setValid(resultSet.getBoolean("IsValid"));
                allCards.add(card);
            }
            return allCards;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void update(Card card) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

}
