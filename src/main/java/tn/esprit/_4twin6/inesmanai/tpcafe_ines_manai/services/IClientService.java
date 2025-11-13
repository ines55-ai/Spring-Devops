package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.services;

import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Client;

import java.util.List;

public interface IClientService {
    Client addClient(Client c);
    List<Client> saveClients(List<Client> clients);
    Client selectClientById(long id);
    List<Client> selectAllClients();
    void deleteClient(Client c);
    void deleteAllClients();
    void deleteClientById(long id);
    long countingClients();
    boolean verifClientById(long id);
}
