package util.mapper;

import dto.ClientDto;
import domain.Client;

public interface ClientMapper {
    Client map(ClientDto clientDto);
    ClientDto map(Client client);
}
