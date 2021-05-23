package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.CardDao;
import dao.impl.CardDaoImpl;
import domain.Card;
import dto.CardDto;
import dto.CardOrderRequestDto;
import server.http.impl.LocalHttpServerImpl;
import services.CardService;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import services.impl.CardServiceImpl;
import util.mapper.json.RequestBodyToMapParser;
import java.io.*;
import java.util.Map;
import java.util.logging.Logger;

public class CardOrderHandler implements HttpHandler {
    private static final Logger log = Logger.getLogger(CardOrderHandler.class.getName());
    private final CardService cardService = new CardServiceImpl();
    private final CardDao cardDao = new CardDaoImpl();

    @Override
    public void handle(HttpExchange exchange) {

        if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {
            ObjectMapper objectMapper = new ObjectMapper();

            try {
                InputStreamReader inputStreamReader = new InputStreamReader(exchange.getRequestBody());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String body = bufferedReader.readLine();
                Map<String, String> map = RequestBodyToMapParser.requestBodyToMap(body);

                long clientId = Long.parseLong(map.get("clientID"));
                String accountNumber = map.get("accountNumber");
                CardOrderRequestDto cardOrderRequestDto = new CardOrderRequestDto(clientId, accountNumber);

                cardService.cardOrder(cardOrderRequestDto);
                Card card = cardDao.getCardByNumber(accountNumber);
                System.out.println(accountNumber);

                String jsonResponse = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(card);
                exchange.sendResponseHeaders(LocalHttpServerImpl.STATUS_OK, jsonResponse.length());
                OutputStream outputStream = exchange.getResponseBody();
                outputStream.write(jsonResponse.getBytes());
                log.info("POST request with payload " + map);
                exchange.close();

            } catch (Exception exception) {
//                System.out.println(exception.getMessage());
                exception.printStackTrace();
            }
        }
    }

}
