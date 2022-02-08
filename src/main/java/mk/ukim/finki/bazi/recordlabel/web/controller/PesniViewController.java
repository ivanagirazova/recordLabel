package mk.ukim.finki.bazi.recordlabel.web.controller;

import mk.ukim.finki.bazi.recordlabel.model.entities.Album;
import mk.ukim.finki.bazi.recordlabel.model.entities.Artist;
import mk.ukim.finki.bazi.recordlabel.model.views.Pesni;
import mk.ukim.finki.bazi.recordlabel.service.AlbumService;
import mk.ukim.finki.bazi.recordlabel.service.ArtistService;
import mk.ukim.finki.bazi.recordlabel.service.PesnaService;
import mk.ukim.finki.bazi.recordlabel.service.PesniViewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/songs")
public class PesniViewController {

    private final PesniViewService pesniViewService;
    private final AlbumService albumService;
    private final ArtistService artistService;
    private final PesnaService pesnaService;

    public PesniViewController(PesniViewService pesniViewService, AlbumService albumService, ArtistService artistService, PesnaService pesnaService) {
        this.pesniViewService = pesniViewService;
        this.albumService = albumService;
        this.artistService = artistService;
        this.pesnaService = pesnaService;
    }

    @GetMapping
    public String getAlbumsPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Pesni> songs = this.pesniViewService.findAll();
        List<Album> albums = this.albumService.findAll();
        List<Artist> artists = this.artistService.findAll();
        model.addAttribute("songs",songs);
        model.addAttribute("albums", albums);
        model.addAttribute("artists",artists);
        model.addAttribute("bodyContent", "songs");
        return "master-template";
    }

    @GetMapping("/filter-artist")
    public String getSongsByArtist(@RequestParam String artist, Model model) {
        List<Pesni> songs = pesniViewService.findAllByArtist(artist);
        List<Artist> artists = this.artistService.findAll();
        List<Album> albums = this.albumService.findAll();
        model.addAttribute("songs",songs);
        model.addAttribute("albums", albums);
        model.addAttribute("artists",artists);
        model.addAttribute("bodyContent", "songs");
        return "master-template";
    }

    @GetMapping("/filter-album")
    public String getSongsByAlbum(@RequestParam String album, Model model) {
        List<Pesni> songs = pesniViewService.findAllByAlbum(album);
        List<Artist> artists = this.artistService.findAll();
        List<Album> albums = this.albumService.findAll();
        model.addAttribute("songs",songs);
        model.addAttribute("albums", albums);
        model.addAttribute("artists",artists);
        model.addAttribute("bodyContent", "songs");
        return "master-template";
    }

    @GetMapping("/add-form")
    public String getAddNewSongPage(Model model) {
        List<Album> albums = this.albumService.findAll();
        List<Artist> artists = this.artistService.findAll();
        model.addAttribute("artists",artists);
        model.addAttribute("albums", albums);
        model.addAttribute("bodyContent","add-song");
        return "master-template";
    }

    @PostMapping("/add")
    public String addNewSong(@RequestParam String ime,
                             @RequestParam String vremetraenje,
                             @RequestParam String artist,
                             @RequestParam Integer album,
                             @RequestParam String collaborator) {
        pesnaService.save(ime, vremetraenje, artist, album, collaborator);
        return "redirect:/songs";
    }
}
