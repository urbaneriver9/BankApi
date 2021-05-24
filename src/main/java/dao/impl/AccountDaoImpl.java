package dao.impl;

import dao.AccountDao;
import db.H2DataSourceImpl;
import domain.Account;


import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AccountDaoImpl implements AccountDao {

    Logger log = Logger.getLogger(AccountDaoImpl.class.getName());

    private final String SQL_GET_BY_CLIENTSID = "SELECT * FROM ACCOUNTS WHERE CLIENTID = ?";
    private final String SQL_GET_BY_NUMBER = "SELECT * FROM ACCOUNTS WHERE NUMBER = ?";
    private final String SQL_UPDATE_BALANCE = "UPDATE ACCOUNTS SET BALANCE = ? WHERE NUMBER = ?";


    @Override
    public String insert(Account account) throws SQLException, IOException {
        return null;
    }

    @Override
    public List<Account> getAll() throws SQLException {
        return null;
    }

    @Override
    public Account getById(long ID) throws SQLException {
        return null;
    }

    @Override
    public List<Account> getByClientId(long clientId) {
        try(Connection connection = H2DataSourceImpl.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_CLIENTSID)){

            connection.setAutoCommit(false);

            preparedStatement.setLong(1, clientId);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Account> allAccounts = new ArrayList<>();

            while(resultSet.next()){
                Account account = new Account();

                account.setNumber(resultSet.getString("Number"));
                account.setBalance(resultSet.getBigDecimal("Balance"));
                account.setOpen(resultSet.getBoolean("IsOpen"));
                allAccounts.add(account);
            }
            return allAccounts;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public Account getByNumber(String accountNumber) {
        try(Connection connection = H2DataSourceImpl.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_NUMBER)) {
            Account account = new Account();
            preparedStatement.setString(1, accountNumber);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                account.setNumber(resultSet.getString("Number"));
                account.setBalance(resultSet.getBigDecimal("Balance"));
            }
            return account;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return new Account();
    }

    @Override
    public void updateBalance(String accountNumber, BigDecimal topUpSum) {
        try(Connection connection = H2DataSourceImpl.createConnection()){
            Savepoint savepoint = connection.setSavepoint();
            try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_BALANCE)){
                Account account = getByNumber(accountNumber);
                connection.setAutoCommit(false);
                BigDecimal newBalance = account.getBalance().add(topUpSum);
                preparedStatement.setBigDecimal(1, newBalance);
                preparedStatement.setString(2,accountNumber);
                preparedStatement.executeUpdate();

                connection.commit();
            } catch (SQLException exception) {
                connection.rollback(savepoint);
                exception.printStackTrace();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Account account) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
