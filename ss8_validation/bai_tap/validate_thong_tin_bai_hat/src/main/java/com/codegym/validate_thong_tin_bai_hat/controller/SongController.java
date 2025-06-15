package com.codegym.validate_thong_tin_bai_hat.controller;

import com.codegym.validate_thong_tin_bai_hat.model.Song;
import com.codegym.validate_thong_tin_bai_hat.service.ISongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("song") Song song, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        songService.save(song);
        return "redirect:/song";
    }

    @GetMapping("/edit/{index}")
    public String showEditForm(@PathVariable int index, Model model) {
        model.addAttribute("song", songService.findById(index));
        model.addAttribute("index", index);
        return "edit";
    }

    @PostMapping("/update")
    public String update(@RequestParam int index,
                         @Valid @ModelAttribute("song") Song song,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        songService.update(index, song);
        return "redirect:/song";
    }
}
