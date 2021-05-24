package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import domain.Card;
import dto.CardOrderRequestDto;
import dto.TopUpBalanceDto;
import server.http.impl.LocalHttpServerImpl;
import services.AccountService;
import services.impl.AccountServiceImpl;
import util.mapper.json.RequestBodyToMapParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Map;

public class TopUpController implements HttpHandler {

    AccountService accountService = new AccountServiceImpl();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {
            ObjectMapper objectMapper = new ObjectMapper();

            try {
                InputStreamReader inputStreamReader = new InputStreamReader(exchange.getRequestBody());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String body = bufferedReader.readLine();
                Map<String, String> map = RequestBodyToMapParser.requestBodyToMap(body);


                String accountNumber = map.get("accountNumber");
                BigDecimal topUpSum = BigDecimal.valueOf(Double.parseDouble(map.get("topUpSum")));
                TopUpBalanceDto topUpBalanceDto = new TopUpBalanceDto(accountNumber, topUpSum);

                accountService.topUp(topUpBalanceDto);

                String jsonResponse = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(topUpBalanceDto);
                exchange.sendResponseHeaders(LocalHttpServerImpl.STATUS_OK, jsonResponse.getBytes().length);
                OutputStream outputStream = exchange.getResponseBody();
                outputStream.write(jsonResponse.getBytes());
                exchange.close();

            } catch (Exception exception) {
//                System.out.println(exception.getMessage());
                exception.printStackTrace();
            }
        }

    }
}
