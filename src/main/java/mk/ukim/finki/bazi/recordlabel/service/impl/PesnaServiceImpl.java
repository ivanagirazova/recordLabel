package mk.ukim.finki.bazi.recordlabel.service.impl;

import mk.ukim.finki.bazi.recordlabel.model.entities.Album;
import mk.ukim.finki.bazi.recordlabel.model.entities.Artist;
import mk.ukim.finki.bazi.recordlabel.model.entities.Kolaboracii;
import mk.ukim.finki.bazi.recordlabel.model.entities.Pesna;
import mk.ukim.finki.bazi.recordlabel.repository.AlbumRepository;
import mk.ukim.finki.bazi.recordlabel.repository.ArtistRepository;
import mk.ukim.finki.bazi.recordlabel.repository.KolaboraciiRepository;
import mk.ukim.finki.bazi.recordlabel.repository.PesnaRepository;
import mk.ukim.finki.bazi.recordlabel.service.PesnaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PesnaServiceImpl implements PesnaService {

    private final PesnaRepository pesnaRepository;
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;
    private final KolaboraciiRepository kolaboraciiRepository;

    public PesnaServiceImpl(PesnaRepository pesnaRepository,
                            ArtistRepository artistRepository,
                            AlbumRepository albumRepository,
                            KolaboraciiRepository kolaboraciiRepository) {
        this.pesnaRepository = pesnaRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
        this.kolaboraciiRepository = kolaboraciiRepository;
    }

    @Override
    public Optional<Pesna> save(String ime, String vremetraenje, String artistName, Integer albumId, String collaborator) {
        Artist artist = artistRepository.findByStageName(artistName).get();
        Album album = albumId != -1 ? albumRepository.findById(albumId).get() : null;
        Pesna pesna = new Pesna(ime,vremetraenje,artist,album);
        Optional<Pesna> optional = Optional.of(pesnaRepository.save(pesna));
        if(!collaborator.equals("none")) {
            Kolaboracii kolaboracija = new Kolaboracii(collaborator, pesna.getId_pesna());
            kolaboraciiRepository.save(kolaboracija);
        }
        return optional;
    }

    @Override
    public List<Pesna> findAll() {
        return pesnaRepository.findAll();
    }
}
