package mk.ukim.finki.bazi.recordlabel.model.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Pesna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id_pesna;

    @NotNull
    public String ime;

    @NotNull
    public String vremetraenje;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "embg_artist")
    public Artist artist;
    //public String embg_artist;

    @ManyToOne
    @JoinColumn(name = "id_album")
    public Album album;
//    public Integer id_album;

    public Pesna() {
    }

    public Pesna(String ime, String vremetraenje, Artist artist, Album album) {
        this.ime = ime;
        this.vremetraenje = vremetraenje;
        this.artist = artist;
        this.album = album;
    }

    public Integer getIdPesna() {
        return id_pesna;
    }
}
