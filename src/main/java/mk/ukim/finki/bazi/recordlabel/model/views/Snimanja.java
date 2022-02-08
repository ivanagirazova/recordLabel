package mk.ukim.finki.bazi.recordlabel.model.views;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

@Entity
@Data
@Immutable
public class Snimanja {
    @Id
    public Integer id_snimanje;
    public Date datum;
    public Time chas;
    public Integer id_pesna;
    public String pesna;
    public String album;
    public String artist;
    @Column(name = "producent_ime")
    public String producentIme;
    @Column(name = "producent_prezime")
    public String producentPrezime;

    public String getDate() {
        return datum.toString().split(" ")[0];
    }

}
