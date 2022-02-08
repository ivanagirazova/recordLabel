package mk.ukim.finki.bazi.recordlabel.model.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Chovek {
    @Id
    public String embg;
    @NotNull
    public String ime;
    @NotNull
    public String prezime;
    @NotNull
    public String ulica;
    @NotNull
    public String broj;

    public Chovek(String embg, String ime, String prezime, String ulica, String broj) {
        this.embg = embg;
        this.ime = ime;
        this.prezime = prezime;
        this.ulica = ulica;
        this.broj = broj;
    }

    public Chovek() {
    }
}
