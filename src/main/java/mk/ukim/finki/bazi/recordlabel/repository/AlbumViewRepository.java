package mk.ukim.finki.bazi.recordlabel.repository;

import mk.ukim.finki.bazi.recordlabel.model.views.Albumi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumViewRepository extends JpaRepository<Albumi,Integer> {
    List<Albumi> findAllByArtist(String artist);
}
