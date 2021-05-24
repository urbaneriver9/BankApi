package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import dto.BalanceRequestDto;
import server.http.impl.LocalHttpServerImpl;
import services.AccountService;
import services.impl.AccountServiceImpl;
import util.mapper.json.QueryToMap;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

public class GetBalanceRequestController implements HttpHandler {
    AccountService accountService = new AccountServiceImpl();
    AccountDao accountDao = new AccountDaoImpl();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String query = exchange.getRequestURI().getQuery();
        String accountNumber = QueryToMap.queryToMap(query).get("accountNumber");

        BalanceRequestDto balanceRequestDto = accountService.getBalanceRequest(accountNumber);

        String jsonResponse = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(balanceRequestDto);
        exchange.sendResponseHeaders(LocalHttpServerImpl.STATUS_OK, jsonResponse.getBytes().length);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(jsonResponse.getBytes());
    }
}
