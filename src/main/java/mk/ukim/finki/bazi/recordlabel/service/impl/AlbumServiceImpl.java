package mk.ukim.finki.bazi.recordlabel.service.impl;

import mk.ukim.finki.bazi.recordlabel.model.entities.Album;
import mk.ukim.finki.bazi.recordlabel.model.entities.Artist;
import mk.ukim.finki.bazi.recordlabel.repository.AlbumRepository;
import mk.ukim.finki.bazi.recordlabel.repository.ArtistRepository;
import mk.ukim.finki.bazi.recordlabel.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository, ArtistRepository artistRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Optional<Album> save(String ime, String vremetraenje, String artistName) {
        Artist artist = artistRepository.findByStageName(artistName).get();
        Album album = new Album(ime,vremetraenje,artist);
        return Optional.of(albumRepository.save(album));
    }
}
