package sid.org.Bcaisse.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Table(name = "fournisseur", uniqueConstraints = {@UniqueConstraint(columnNames = "code" + ""  ),
                @UniqueConstraint(columnNames = "email")
        })
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int code;
    @NotBlank
    @Size(max = 60)
    private String libelle;
    private String responsable;
    private String adresse;
    private String ville;
    private String tel;
    @NotBlank
    @Size(max = 60)
    @Email
    private String email;
    private String fax;
    private String pwd;
    private String  matfisc;
    private double  soldef;

    @Override
    public String toString() {
        return "Fournisseur [id=" + id + ", code=" + code + ", libelle=" + libelle + ", responsable=" + responsable
                + ", adresse=" + adresse + ", ville=" + ville + ", tel=" + tel + ", email=" + email + ", fax=" + fax
                + ", pwd=" + pwd + ", matfisc=" + matfisc + ", soldef=" + soldef + "]";
    }

}
