package sid.org.Bcaisse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sid.org.Bcaisse.entites.Categorie;
import sid.org.Bcaisse.service.CategorieService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CategorieController {


    @Autowired
    private CategorieService categorieService;

    /*@Autowired
    private CategorieRepository categorieRepository;
    @GetMapping("/categories/7")
    public int getCode(@PathVariable String code){
        int x = categorieRepository.nbre();
        if(x==0){
            return 0;
        }else {
            return categorieRepository.max();
        }
    }
    @GetMapping("/categories")
     public List<Categorie> categorieList(){
        return  categorieRepository.findAll();
     }

    @GetMapping("/categories/{id}")
     public ResponseEntity<Categorie> post(@PathVariable Long id) {
         Optional<Categorie> cat = categorieRepository.findById(id);
         return cat.map(ResponseEntity::ok

         ).orElseGet(()->ResponseEntity.notFound().build());
     }
     @PostMapping("/categories")
     public Categorie save(@Validated @RequestBody Categorie categorie){

         return  categorieRepository.save(categorie);
     }

    @PutMapping("/categories/{id}")
     public Categorie update(@PathVariable Long id, @RequestBody Categorie categorie){
        Categorie categorie1 = categorieRepository.getById(id);
        categorie1.setCode(categorie.getCode());
        categorie1.setLibelle(categorie.getLibelle());

        return categorieRepository.save(categorie1);
     }
     @DeleteMapping("/categories/{id}")
     public String delete(@Validated @PathVariable Long id){
         categorieRepository.deleteById(id);
         return "Categorie supprime avec success";
     }*/
    @GetMapping("/categories")
    public List<Categorie> list(){
        return categorieService.getAll();
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Categorie> post(@PathVariable String code){
        Optional<Categorie> cat = categorieService.findByCode(code);
        return cat.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping("/categories")
    public long save(@RequestBody Categorie categorie){
        return categorieService.save(categorie);
    }

    @PutMapping("/categories/{code}")
    public void update(@PathVariable String code, @RequestBody Categorie categorie){
        Optional<Categorie> categorie1 = categorieService.findByCode(code);
        if(categorie1.isPresent()){
            categorieService.update(code,categorie);
        }
        else {
            categorieService.save(categorie);
        }
    }

    @DeleteMapping("/categories/{code}")
    public void delete(@PathVariable String code){
         categorieService.delete(code);
    }
}
