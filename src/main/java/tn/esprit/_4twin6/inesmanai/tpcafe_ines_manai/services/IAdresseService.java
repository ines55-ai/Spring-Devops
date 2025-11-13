package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.services;

import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Adresse;
import java.util.List;

public interface IAdresseService {
    Adresse addAdresse(Adresse a);
    List<Adresse> saveAdresses(List<Adresse> adresses);
    Adresse selectAdresseById(Long id);
    List<Adresse> selectAllAdresses();
    void deleteAdresseById(Long id);
    void deleteAllAdresses();
    long countAdresses();
    boolean verifAdresseById(Long id);
}