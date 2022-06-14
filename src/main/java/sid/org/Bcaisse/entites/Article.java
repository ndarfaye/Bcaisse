package sid.org.Bcaisse.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String code;
    private String libelle;
    private double pa;
    private double pv;
    private int tva;
    private int stock;
    private String ccateg;
    private String cscateg;
    private String fileName;
    private int codef;
    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "article", fetch=FetchType.EAGER)
    @Valid
    private List<Carticle> carticle =  new ArrayList<>();

}
