package sid.org.Bcaisse.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http:localhost:4200")
@RestController
@RequestMapping("/api")
public class ParametreController {
    /*@Autowired
    private ParametreService parametreService;
    @GetMapping("/parametres")
    public List<Parametre> parametreList(){
        return parametreService.getAll();
    }
    @GetMapping("/parametres/{id}")
    public ResponseEntity<Parametre> post(@PathVariable int id){
        Optional<Parametre> parametre = parametreService.findById(id);
        return parametre.map(ResponseEntity::ok).orElseGet(
                ()->ResponseEntity.notFound().build()
        );
    }
    @PostMapping("/parametres")
    public long save(@RequestBody Parametre parametre){
        return parametreService.save(parametre);
    }
    @PutMapping("/parametres/{id}")
    public void update(@PathVariable int id, @RequestBody Parametre parametre){
        Optional<Parametre> para = parametreService.findById(id);
        if(para.isPresent()){
            parametreService.update(id, parametre);
        }
    }
    @DeleteMapping("/parametres/{id}")
    public void delete(@PathVariable int id){
        parametreService.delete(id);
    }
*/
}
