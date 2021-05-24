package server.http.impl;

import com.sun.net.httpserver.HttpServer;
import controllers.CardOrderRequestController;
import controllers.ClientInfoController;
import controllers.GetBalanceRequestController;
import controllers.TopUpController;
import server.http.LocalHttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class LocalHttpServerImpl implements LocalHttpServer { //TODO: close connection;
    private static final String CARD_ORDER_PATH = "/cardorder";
    private static final String GET_BALANCE_PATH = "/getbalance";
    private static final String CLIENT_INFO_PATH = "/allcards";
    private static final String TOP_UP_PATH = "/topup";


    static CardOrderRequestController cardOrderHandler = new CardOrderRequestController();
    static GetBalanceRequestController getBalanceRequestController = new GetBalanceRequestController();
    static ClientInfoController clientInfoController = new ClientInfoController();
    static TopUpController topUpController  = new TopUpController();

    private static Logger log = Logger.getLogger(LocalHttpServerImpl.class.getName());

    static {
        try{
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), BACKLOG);

            httpServer.createContext(CARD_ORDER_PATH, cardOrderHandler);
            httpServer.createContext(GET_BALANCE_PATH,getBalanceRequestController);
            httpServer.createContext(CLIENT_INFO_PATH, clientInfoController);
            httpServer.createContext(TOP_UP_PATH, topUpController);
            httpServer.setExecutor(Executors.newFixedThreadPool(10));
            httpServer.start();
            log.info("\nServer started on port 8000" +
                    "\n======================================");
        } catch (IOException e) {
            log.info("\nServer did not started on port 8000" +
                    "\n======================================");
            e.printStackTrace();

        }
    }
}
