package mk.ukim.finki.bazi.recordlabel.service.impl;

import mk.ukim.finki.bazi.recordlabel.model.views.Snimanja;
import mk.ukim.finki.bazi.recordlabel.repository.SnimanjaViewRepository;
import mk.ukim.finki.bazi.recordlabel.service.SnimanjaViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SnimanjaViewServiceImpl implements SnimanjaViewService {

    private final SnimanjaViewRepository snimanjaViewRepository;

    public SnimanjaViewServiceImpl(SnimanjaViewRepository snimanjaViewRepository) {
        this.snimanjaViewRepository = snimanjaViewRepository;
    }

    @Override
    public List<Snimanja> findAll() {
        return snimanjaViewRepository.findAll();
    }

    @Override
    public List<Snimanja> findAllByPesna(String pesna) {
        if(pesna.equals("all"))
            return snimanjaViewRepository.findAll();
        else
            return snimanjaViewRepository.findAllByPesna(pesna);
    }
}
