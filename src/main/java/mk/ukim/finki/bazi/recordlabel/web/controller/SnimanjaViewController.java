package mk.ukim.finki.bazi.recordlabel.web.controller;

import mk.ukim.finki.bazi.recordlabel.model.entities.Pesna;
import mk.ukim.finki.bazi.recordlabel.model.entities.Producent;
import mk.ukim.finki.bazi.recordlabel.model.entities.Studio;
import mk.ukim.finki.bazi.recordlabel.model.views.Snimanja;
import mk.ukim.finki.bazi.recordlabel.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Controller
@RequestMapping("/recordings")
public class SnimanjaViewController {

    private final SnimanjaViewService snimanjaViewService;
    private final PesnaService pesnaService;
    private final StudioService studioService;
    private final ProducentService producentService;
    private final SnimanjeService snimanjeService;

    public SnimanjaViewController(SnimanjaViewService snimanjaViewService,
                                  PesnaService pesnaService,
                                  StudioService studioService,
                                  ProducentService producentService,
                                  SnimanjeService snimanjeService) {
        this.snimanjaViewService = snimanjaViewService;
        this.pesnaService = pesnaService;
        this.studioService = studioService;
        this.producentService = producentService;
        this.snimanjeService = snimanjeService;
    }

    @GetMapping
    public String getRecordingsPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Snimanja> recordings = snimanjaViewService.findAll();
        List<Pesna> songs = pesnaService.findAll();
        model.addAttribute("recordings",recordings);
        model.addAttribute("songs",songs);
        model.addAttribute("bodyContent", "recordings");
        return "master-template";
    }

    @GetMapping("/filter")
    public String getRecordingsForSong(@RequestParam String song, Model model) {
        List<Snimanja> recordings = snimanjaViewService.findAllByPesna(song);
        List<Pesna> songs = pesnaService.findAll();
        model.addAttribute("recordings",recordings);
        model.addAttribute("songs",songs);
        model.addAttribute("bodyContent", "recordings");
        return "master-template";
    }

    @GetMapping("/add-form")
    public String getAddNewRecordingPage(Model model) {
        List<Producent> producers = producentService.findAll();
        List<Studio> studios = studioService.findAll();
        List<Pesna> songs = pesnaService.findAll();
        model.addAttribute("producers",producers);
        model.addAttribute("studios",studios);
        model.addAttribute("songs",songs);
        model.addAttribute("bodyContent","add-recording");
        return "master-template";
    }

    @PostMapping("/add")
    public String addNewRecording(@RequestParam Date datum,
                                  @RequestParam String chas,
                                  @RequestParam String producer,
                                  @RequestParam Integer song,
                                  @RequestParam Integer studio) {
        snimanjeService.save(datum,Time.valueOf(chas+":00"),song,producer,studio);
        return "redirect:/recordings";
    }
}
