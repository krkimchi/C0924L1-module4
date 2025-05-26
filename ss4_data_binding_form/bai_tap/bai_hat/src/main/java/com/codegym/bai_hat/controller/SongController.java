package com.codegym.bai_hat.controller;

import com.codegym.bai_hat.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SongController {
    private List<Song> songs = new ArrayList<>();

    private static final String UPLOAD_DIR = "D:/music-upload/";

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("song", new Song());
        return "upload";
    }

    @PostMapping("/upload")
    public String handleUpload(@ModelAttribute("song") Song song,
                               @RequestParam("file") MultipartFile file,
                               Model model) {

        String filename = StringUtils.cleanPath(file.getOriginalFilename());

        if (!filename.matches(".*\\.(mp3|wav|ogg|m4p)$")) {
            model.addAttribute("error", "Chỉ chấp nhận file .mp3, .wav, .ogg, .m4p");
            return "upload";
        }

        try {
            File uploadPath = new File(UPLOAD_DIR);
            if (!uploadPath.exists()) uploadPath.mkdirs();

            File destination = new File(UPLOAD_DIR + filename);
            file.transferTo(destination);

            song.setFilePath("/music/" + filename);
            songs.add(song);
            return "redirect:/songs";
        } catch (IOException e) {
            model.addAttribute("error", "Lỗi khi upload file!");
            return "upload";
        }
    }

    @GetMapping("/songs")
    public String showSongs(Model model) {
        model.addAttribute("songs", songs);
        return "list";
    }
}
