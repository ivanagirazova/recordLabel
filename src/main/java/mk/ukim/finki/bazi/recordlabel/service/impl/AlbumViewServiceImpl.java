package mk.ukim.finki.bazi.recordlabel.service.impl;

import mk.ukim.finki.bazi.recordlabel.model.views.Albumi;
import mk.ukim.finki.bazi.recordlabel.repository.AlbumViewRepository;
import mk.ukim.finki.bazi.recordlabel.service.AlbumViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumViewServiceImpl implements AlbumViewService {

    private final AlbumViewRepository albumViewRepository;


    public AlbumViewServiceImpl(AlbumViewRepository albumRepository) {
        this.albumViewRepository = albumRepository;
    }

    @Override
    public List<Albumi> findAll() {
        return albumViewRepository.findAll();
    }

    @Override
    public List<Albumi> findAllByArtist(String artist) {
        if(artist.equals("all"))
            return albumViewRepository.findAll();
        else
            return albumViewRepository.findAllByArtist(artist);
    }
}
