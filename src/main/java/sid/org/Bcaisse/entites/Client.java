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
import java.util.Date;
@Entity @Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int code;
    @NotBlank
    @Size(max = 60)
    private String libelle;
    private String adresse;
    private String tel;
    @NotBlank
    @Size(max = 60)
    @Email
    private String email;
    private String fax;
    private String pwd;
    private Date cree;

}
