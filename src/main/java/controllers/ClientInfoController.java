package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import db.DataSource;
import db.H2DataSourceImpl;
import domain.Card;
import dto.BalanceRequestDto;
import dto.CardDto;
import dto.ClientDto;
import server.http.impl.LocalHttpServerImpl;
import services.CardService;
import services.ClientService;
import services.impl.CardServiceImpl;
import services.impl.ClientsServiceImpl;
import util.mapper.json.QueryToMap;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;


public class ClientInfoController implements HttpHandler {
    ClientService clientService = new ClientsServiceImpl();
    CardService cardService = new CardServiceImpl();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String query = exchange.getRequestURI().getQuery();
        long clientID = Long.parseLong(QueryToMap.queryToMap(query).get("id"));

        ClientDto clientDto = clientService.getById(clientID);

        String jsonResponse = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(clientDto);
        exchange.sendResponseHeaders(LocalHttpServerImpl.STATUS_OK, jsonResponse.getBytes().length);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(jsonResponse.getBytes());
    }
}
