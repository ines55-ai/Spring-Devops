package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Adresse;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.repositeries.AdresseRepository;

import java.util.List;

@Service
@AllArgsConstructor
class AdresseService implements IAdresseService {

    private final AdresseRepository adresseRepository;

    @Override
    public Adresse addAdresse(Adresse a) {
        return adresseRepository.save(a);
    }

    @Override
    public List<Adresse> saveAdresses(List<Adresse> adresses) {
        return adresseRepository.saveAll(adresses);
    }

    @Override
    public Adresse selectAdresseById(Long id) {
        return adresseRepository.findById(id).orElse(null);
    }

    @Override
    public List<Adresse> selectAllAdresses() {
        return adresseRepository.findAll();
    }

    @Override
    public void deleteAdresseById(Long id) {
        adresseRepository.deleteById(id);
    }

    @Override
    public void deleteAllAdresses() {
        adresseRepository.deleteAll();
    }

    @Override
    public long countAdresses() {
        return adresseRepository.count();
    }

    @Override
    public boolean verifAdresseById(Long id) {
        return adresseRepository.existsById(id);
    }
}
