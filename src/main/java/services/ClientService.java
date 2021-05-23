package services;

import dto.ClientDto;

import java.util.List;

public interface ClientService {

    ClientDto getById(long id);
    List<ClientDto> getAll();

}
