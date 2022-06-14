package sid.org.Bcaisse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sid.org.Bcaisse.entites.Compteur;
import sid.org.Bcaisse.service.CompteurService;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CompteurController {
    @Autowired
    private CompteurService compteurService;

    @GetMapping("/compteurs/{annee}")
    public ResponseEntity<Compteur> nbre(@PathVariable int annee){
        int x = compteurService.nbre(annee);
        if(x==0){
            compteurService.create(annee);
        }
        Optional<Compteur> compteur = compteurService.findByAnnee(annee);
        return compteur.map(ResponseEntity::ok).orElseGet(()->
                ResponseEntity.notFound().build());
    }
}
