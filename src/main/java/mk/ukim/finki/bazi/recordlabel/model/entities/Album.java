package mk.ukim.finki.bazi.recordlabel.model.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id_album;

    public Integer getId_album() {
        return id_album;
    }

    @NotNull
    public String ime;

    @NotNull
    public String vremetraenje;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "embg_artist")
    public Artist artist;
    //public String embg_artist;

    public Album() {
    }

    public Album(String ime, String vremetraenje, Artist artist) {
        this.ime = ime;
        this.vremetraenje = vremetraenje;
        this.artist = artist;
    }
}
