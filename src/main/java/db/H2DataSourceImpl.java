package db;

import org.h2.tools.RunScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class H2DataSourceImpl implements DataSource {

    private static final String CONFIG_PATH = "/Users/a19187978/IdeaProjects/SberTask/BankApi/src/" +
            "main/resources/database/bank.properties";
    private static final String CLIENTS_DB = "/Users/a19187978/IdeaProjects/SberTask/BankApi/src/" +
            "main/resources/scripts/CLIENTS.sql";
    private static final String ACCOUNTS_DB = "/Users/a19187978/IdeaProjects/SberTask/BankApi/src/" +
            "main/resources/scripts/ACCOUNTS.sql";
    private static final String CARDS_DB = "/Users/a19187978/IdeaProjects/SberTask/BankApi/src/" +
            "main/resources/scripts/CARDS.sql";
    private static final String COUNTERPARTIES_DB = "/Users/a19187978/IdeaProjects/SberTask/BankApi/src/" +
            "main/resources/scripts/COUNTERPARTIES.sql";
    private static Logger log = Logger.getLogger(H2DataSourceImpl.class.getName());

    public static void initDb() {
        try (Connection connection = createConnection()) {
            RunScript.execute(connection, new FileReader(CLIENTS_DB));
            RunScript.execute(connection, new FileReader(ACCOUNTS_DB));
            RunScript.execute(connection, new FileReader(CARDS_DB));
            RunScript.execute(connection, new FileReader(COUNTERPARTIES_DB));
        } catch (SQLException | FileNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Connection createConnection() {
        Connection connection = null;
        Properties properties = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream(CONFIG_PATH);) {

            properties.load(fileInputStream);
            String DB_URL = properties.getProperty("db.host");
            String USER = properties.getProperty("db.login");
            String PASS = properties.getProperty("db.password");
            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            log.info("\nConnection to database established." +
                    "\n======================================");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
