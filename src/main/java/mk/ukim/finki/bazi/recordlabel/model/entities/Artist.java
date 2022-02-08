package mk.ukim.finki.bazi.recordlabel.model.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Artist extends Chovek {
    @Column(name = "stage_name")
    public String stageName;

    public String getStageName() {
        return stageName;
    }

    public Artist(String embg, String ime, String prezime, String ulica, String broj, String stageName) {
        super(embg, ime, prezime, ulica, broj);
        this.stageName = stageName;
    }

    public Artist() {
        super();
    }

}
