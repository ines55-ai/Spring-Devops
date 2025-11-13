package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.restController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Adresse;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.services.IAdresseService;

import java.util.List;

@RestController
@RequestMapping("/adresses")
@AllArgsConstructor
@Tag(name = "📍 Adresses")
public class AdresseRestController {

    private final IAdresseService adresseService;

    @GetMapping
    public List<Adresse> getAllAdresses() {
        return adresseService.selectAllAdresses();
    }

    @PostMapping
    public Adresse addAdresse(@RequestBody Adresse adresse) {
        return adresseService.addAdresse(adresse);
    }

    @PostMapping("/addall")
    public List<Adresse> addAdresses(@RequestBody List<Adresse> adresses) {
        return adresseService.saveAdresses(adresses);
    }

    @GetMapping("/{id}")
    public Adresse getAdresseById(@PathVariable Long id) {
        return adresseService.selectAdresseById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteAdresseById(@PathVariable Long id) {
        adresseService.deleteAdresseById(id);
        return "Adresse with ID " + id + " deleted successfully";
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllAdresses() {
        adresseService.deleteAllAdresses();
        return "All adresses deleted successfully";
    }

    @GetMapping("/count")
    public long countAdresses() {
        return adresseService.countAdresses();
    }

    @GetMapping("/exists/{id}")
    public boolean verifAdresseById(@PathVariable Long id) {
        return adresseService.verifAdresseById(id);
    }
}
