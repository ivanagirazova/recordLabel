package mk.ukim.finki.bazi.recordlabel.service.impl;

import mk.ukim.finki.bazi.recordlabel.model.entities.Studio;
import mk.ukim.finki.bazi.recordlabel.repository.StudioRepository;
import mk.ukim.finki.bazi.recordlabel.service.StudioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudioServiceImpl implements StudioService {

    private final StudioRepository studioRepository;

    public StudioServiceImpl(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    @Override
    public List<Studio> findAll() {
        return studioRepository.findAll();
    }
}
