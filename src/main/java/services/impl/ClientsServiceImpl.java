package services.impl;

import domain.Client;
import services.ClientService;
import dao.ClientDao;
import dao.impl.ClientDaoImpl;
import dto.ClientDto;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class ClientsServiceImpl implements ClientService {

    Logger log = Logger.getLogger(ClientsServiceImpl.class.getName());
    ClientDao clientDao = new ClientDaoImpl();

    @Override
    public ClientDto getById(long id) {
        ClientDto clientDto = new ClientDto();

        try{
            Client client = clientDao.getById(id);
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
