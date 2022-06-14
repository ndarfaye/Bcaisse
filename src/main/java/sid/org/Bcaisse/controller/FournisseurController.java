package sid.org.Bcaisse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sid.org.Bcaisse.entites.Fournisseur;
import sid.org.Bcaisse.service.FournisseurService;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FournisseurController {
    @Autowired
    private FournisseurService fournisseurService;

    @GetMapping("fournisseurs")
    public List<Fournisseur> list(){
       return fournisseurService.getAll();
    }

    @GetMapping("/fournisseurs/{id}")
    public ResponseEntity<Fournisseur> post(@PathVariable int id){
        Optional<Fournisseur> compteur = fournisseurService.findByCode(id);
        return compteur.map(ResponseEntity::ok).orElseGet(
                ()->ResponseEntity.notFound().build()
        );
    }
    @PostMapping("/fournisseurs")
    public long save(@RequestBody Fournisseur fournisseur){
        return fournisseurService.save(fournisseur);
    }
    @PutMapping("/fournisseurs/{id}")
    public void update(int id, Fournisseur fournisseur){
        Optional<Fournisseur> four = fournisseurService.findByCode(id);
        if (four.isPresent()){
            fournisseurService.update(id,fournisseur);
        }
    }
    @DeleteMapping("/fournisseur/{id}")
    public void delete(int id){
        fournisseurService.delete(id);
    }
}
