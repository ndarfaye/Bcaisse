package sid.org.Bcaisse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sid.org.Bcaisse.entites.Client;
import sid.org.Bcaisse.service.ClientService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @GetMapping("/clients")
    public List<Client> clientList(){
        return clientService.getAll();
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> post(@PathVariable int id){
        System.out.println("Get id utilisateur...111111");
        Optional<Client> client = clientService.findByCode(id);
        System.out.println("Get id utilisateur...111111");
     return client.map(ResponseEntity::ok).orElseGet(
             ()->ResponseEntity.notFound().build());
    }

    @PostMapping("/clients")
    public long save(@RequestBody Client client){
         return clientService.save(client);
    }

    @PutMapping("/clients/{code}")
    public void update(@PathVariable int code, @RequestBody Client client){
        Optional<Client> client1 = clientService.findByCode(code);
        if(client1.isPresent()){
            clientService.update(code, client);
        }else {
            clientService.save(client);
        }
    }

    @DeleteMapping("/clients/{id}")
    public void delete(@PathVariable int id){
        clientService.delete(id);
    }

}
