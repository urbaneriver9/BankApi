package server.http.impl;

import com.sun.net.httpserver.HttpServer;
import controllers.CardOrderHandler;
import server.http.LocalHttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class LocalHttpServerImpl implements LocalHttpServer {
    static CardOrderHandler cardOrderHandler = new CardOrderHandler();

    private static Logger log = Logger.getLogger(LocalHttpServerImpl.class.getName());

    static {
        try{
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), BACKLOG);
            httpServer.createContext("/test", cardOrderHandler);
            httpServer.setExecutor(Executors.newFixedThreadPool(10));
            httpServer.start();
            log.info("\nServer started on port 8000" +
                    "\n======================================");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
