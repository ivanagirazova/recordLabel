package mk.ukim.finki.bazi.recordlabel.repository;

import mk.ukim.finki.bazi.recordlabel.model.views.Artisti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistViewRepository extends JpaRepository<Artisti,String> {
}
