package mk.ukim.finki.bazi.recordlabel.repository;

import mk.ukim.finki.bazi.recordlabel.model.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlbumRepository extends JpaRepository<Album,Integer> {
}
