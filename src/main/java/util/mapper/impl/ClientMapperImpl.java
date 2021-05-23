package util.mapper.impl;

import dto.ClientDto;
import domain.Client;
import util.mapper.ClientMapper;

public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client map(ClientDto clientDto) {
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setSurname(clientDto.getSurname());
        client.setName(clientDto.getName());
        client.setPatronymic(clientDto.getPatronymic());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        client.setAccounts(clientDto.getAccounts());
//        client.setCounterparties(clientDto.getCounterparties());
        return client;
    }

    @Override
    public ClientDto map(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setSurname(client.getSurname());
        clientDto.setName(client.getName());
        clientDto.setPatronymic(client.getPatronymic());
        clientDto.setPhoneNumber(client.getPhoneNumber());
        clientDto.setAccounts(client.getAccounts());
//        clientDto.setCounterparties(client.getCounterparties());
        return clientDto;
    }
}
