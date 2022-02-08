package mk.ukim.finki.bazi.recordlabel.service;

import mk.ukim.finki.bazi.recordlabel.model.entities.Chovek;

import java.util.Optional;

public interface ChovekService {
    Optional<Chovek> save(String embg, String ime, String prezime, String ulica, String broj);
}
