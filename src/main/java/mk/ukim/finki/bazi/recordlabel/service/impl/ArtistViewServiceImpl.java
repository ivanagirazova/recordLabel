package mk.ukim.finki.bazi.recordlabel.service.impl;

import mk.ukim.finki.bazi.recordlabel.model.views.Artisti;
import mk.ukim.finki.bazi.recordlabel.repository.ArtistViewRepository;
import mk.ukim.finki.bazi.recordlabel.service.ArtistViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistViewServiceImpl implements ArtistViewService {

    private final ArtistViewRepository artistViewRepository;

    public ArtistViewServiceImpl(ArtistViewRepository artistViewRepository) {
        this.artistViewRepository = artistViewRepository;
    }

    @Override
    public List<Artisti> findAll() {
        return artistViewRepository.findAll();
    }
}
