package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.restController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.CarteFidelite;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.services.CarteFideliteService;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.services.ICarteFideliteService;

import java.util.List;

@RestController
@RequestMapping("cartes")
@AllArgsConstructor
@Tag(name = "💳 Carte Fidelite")
public class CarteFideliteRestController {

    private ICarteFideliteService carteFideliteService;

    @GetMapping
    public List<CarteFidelite> getAllCartes() {
        return carteFideliteService.selectAllCartesFidelite();
    }

    @PostMapping
    public CarteFidelite addCarte(@RequestBody CarteFidelite carte) {
        return carteFideliteService.addCarteFidelite(carte);
    }

    @PostMapping("addall")
    public List<CarteFidelite> addCartes(@RequestBody List<CarteFidelite> cartes) {
        return carteFideliteService.saveCartesFidelite(cartes);
    }

    @GetMapping("{id}")
    public CarteFidelite getCarteById(@PathVariable Long id) {
        return carteFideliteService.selectCarteFideliteById(id);
    }

    @DeleteMapping("{id}")
    public String deleteCarteById(@PathVariable Long id) {
        carteFideliteService.deleteCarteFideliteById(id);
        return "CarteFidelite with ID " + id + " deleted successfully";
    }

    @DeleteMapping("deleteAll")
    public String deleteAllCartes() {
        carteFideliteService.deleteAllCartesFidelite();
        return "All cartes deleted successfully";
    }

    @GetMapping("count")
    public long countCartes() {
        return carteFideliteService.countCartesFidelite();
    }

    @GetMapping("/exists/{id}")
    public boolean verifCarteById(@PathVariable Long id) {
        return carteFideliteService.verifCarteFideliteById(id);
    }
}
