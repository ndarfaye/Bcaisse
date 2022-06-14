package sid.org.Bcaisse.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank
    @Size(max = 40)
    private String username;
    @NotBlank
    @Size(max = 60)
    @Email
    private String email;
    private String nom;
    private int code;
    private String password;
    private boolean isActive;
    private String role;
    private String fileName;

}
