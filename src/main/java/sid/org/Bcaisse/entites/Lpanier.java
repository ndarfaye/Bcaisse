package sid.org.Bcaisse.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Lpanier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int numero ;
    private String code;
    private String libelle;
    private int pv;
    private double qte;
    private int tva;
    private double montht;
    private double monttva;
    private double montttc;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private Panier panier;

}
