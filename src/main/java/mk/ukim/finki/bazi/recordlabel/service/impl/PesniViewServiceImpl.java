package mk.ukim.finki.bazi.recordlabel.service.impl;

import mk.ukim.finki.bazi.recordlabel.model.views.Pesni;
import mk.ukim.finki.bazi.recordlabel.repository.PesniViewRepository;
import mk.ukim.finki.bazi.recordlabel.service.PesniViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PesniViewServiceImpl implements PesniViewService {

    private final PesniViewRepository pesniViewRepository;

    public PesniViewServiceImpl(PesniViewRepository pesniViewRepository) {
        this.pesniViewRepository = pesniViewRepository;
    }

    @Override
    public List<Pesni> findAll() {
        return pesniViewRepository.findAll();
    }

    @Override
    public List<Pesni> findAllByArtist(String artist) {
        if(artist.equals("all"))
            return pesniViewRepository.findAll();
        else
            return pesniViewRepository.findAllByArtist(artist);
    }

    @Override
    public List<Pesni> findAllByAlbum(String album) {
        if(album.equals("all"))
            return pesniViewRepository.findAll();
        else
            return pesniViewRepository.findAllByAlbum(album);
    }
}
