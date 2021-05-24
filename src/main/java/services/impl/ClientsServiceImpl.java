package services.impl;

import domain.Client;
import services.AccountService;
import services.ClientService;
import dao.ClientDao;
import dao.impl.ClientDaoImpl;
import dto.ClientDto;
import util.mapper.ClientMapper;
import util.mapper.impl.ClientMapperImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class ClientsServiceImpl implements ClientService {

    Logger log = Logger.getLogger(ClientsServiceImpl.class.getName());
    ClientDao clientDao = new ClientDaoImpl();
    ClientMapper clientMapper = new ClientMapperImpl();
    AccountService accountService = new AccountServiceImpl();

    @Override
    public ClientDto getById(long id) {
        ClientDto clientDto = new ClientDto();

        try{
            Client client = clientDao.getById(id);
            client.setAccounts(accountService.getAllAccountByClientId(client.getId()));
            clientDto = clientMapper.map(client);
//            System.out.println(client.toString());
            return clientDto;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ClientDto> getAll() {
        return null;
    }
}
