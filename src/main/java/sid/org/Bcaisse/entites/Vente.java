package sid.org.Bcaisse.entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int annee;
    private int numero;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
    private Date date_mvt;
    private String nom;
    private String adresse;
    private String ville;
    private String codep;
    private String tel;
    private String tel1;
    private double totht;
    private double tottva;
    private double totttc;
    private String modreg;
    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "vente", fetch=FetchType.EAGER)
    private List<Lvente> lventes = new ArrayList<>();

    @Override
    public String toString() {
        return "Vente [id=" + id + ", annee=" + annee + ", numero=" + numero + ", date_mvt=" + date_mvt + ", nom=" + nom
                + ", adresse=" + adresse + ", ville=" + ville + ", codep=" + codep + ", tel=" + tel + ", tel1=" + tel1
                + ", totht=" + totht + ", tottva=" + tottva + ", totttc=" + totttc + ", modreg=" + modreg + ", lventes="
                + lventes + "]";
    }
}
