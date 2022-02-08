package mk.ukim.finki.bazi.recordlabel.service;

import mk.ukim.finki.bazi.recordlabel.model.entities.Artist;

import java.util.List;
import java.util.Optional;

public interface ArtistService {
    List<Artist> findAll();
    Optional<Artist> save(String embg, String ime, String prezime, String ulica, String broj, String stagename);
}
