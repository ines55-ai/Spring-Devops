package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.services;

import lombok.AllArgsConstructor;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Client;

import java.util.List;
@AllArgsConstructor

public class ClientService implements IClientService {


    @Override
    public Client addClient(Client c) {
        return null;
    }

    @Override
    public List<Client> saveClients(List<Client> clients) {
        return List.of();
    }

    @Override
    public Client selectClientById(long id) {
        return null;
    }

    @Override
    public List<Client> selectAllClients() {
        return List.of();
    }

    @Override
    public void deleteClient(Client c) {

    }

    @Override
    public void deleteAllClients() {

    }

    @Override
    public void deleteClientById(long id) {

    }

    @Override
    public long countingClients() {
        return 0;
    }

    @Override
    public boolean verifClientById(long id) {
        return false;
    }
}
