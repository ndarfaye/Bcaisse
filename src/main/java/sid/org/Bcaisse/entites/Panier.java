package sid.org.Bcaisse.entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @ToString
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int annee;
    private int numero;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
    private Date date_mvt;
    private String nom;
    private String adresse;
    private String sadresse;
    private String ville;
    private String codep;
    private String tel;
    private String tel1;
    private double totht;
    private double tottva;
    private double totttc;
    private String modreg;
    private String numcarte;
    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "panier", fetch=FetchType.EAGER)
    @Valid
    private List<Lpanier> lpaniers = new ArrayList<>();

}
