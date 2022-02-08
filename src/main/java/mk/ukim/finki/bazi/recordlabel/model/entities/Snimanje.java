package mk.ukim.finki.bazi.recordlabel.model.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;

@Data
@Entity
public class Snimanje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id_snimanje;

    @NotNull
    public Date datum;

    @NotNull
    public Time chas;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "embg_producent")
    public Producent producent;
//    public String embg_producent;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_pesna")
    public Pesna pesna;
//    public Integer id_pesna;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_studio")
    public Studio studio;
//    public Integer id_studio;

    public Snimanje() {
    }

    public Snimanje(Date datum, Time chas, Producent producent, Pesna pesna, Studio studio) {
        this.datum = datum;
        this.chas = chas;
        this.producent = producent;
        this.pesna = pesna;
        this.studio = studio;
    }
}
