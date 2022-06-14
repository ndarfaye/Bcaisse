package sid.org.Bcaisse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sid.org.Bcaisse.entites.User;
import sid.org.Bcaisse.service.UserService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http:localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public List<User> userList(){
        return userService.getAll();
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> postUser(@PathVariable int id){
        Optional<User> user = userService.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(
                ()->ResponseEntity.notFound().build()
        );
    }
    @PutMapping("/users/{id}")
    public void update(@PathVariable int id,@RequestBody User user){
        Optional<User> user1 = userService.findById(id);
        if(user1.isPresent()){
            userService.update(id,user);
        }
    }
    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }

}
