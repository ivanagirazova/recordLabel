package mk.ukim.finki.bazi.recordlabel.repository;

import mk.ukim.finki.bazi.recordlabel.model.views.Pesni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PesniViewRepository extends JpaRepository<Pesni,Integer> {
    List<Pesni> findAllByArtist(String artist);
    List<Pesni> findAllByAlbum(String album);
}
