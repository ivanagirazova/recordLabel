package mk.ukim.finki.bazi.recordlabel.service.impl;

import mk.ukim.finki.bazi.recordlabel.model.entities.Artist;
import mk.ukim.finki.bazi.recordlabel.model.entities.Chovek;
import mk.ukim.finki.bazi.recordlabel.repository.ArtistRepository;
import mk.ukim.finki.bazi.recordlabel.repository.ChovekRepository;
import mk.ukim.finki.bazi.recordlabel.service.ArtistService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Artist> save(String embg, String ime, String prezime, String ulica, String broj, String stagename) {
        Artist artist = new Artist(embg,ime,prezime,ulica,broj,stagename);
        return Optional.of(artistRepository.save(artist));
    }
}
