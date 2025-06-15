package com.codegym.validate_thong_tin_bai_hat.service;

import com.codegym.validate_thong_tin_bai_hat.model.Song;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService implements ISongService {

    private final List<Song> songs = new ArrayList<>();

    @Override
    public void save(Song song) {
        songs.add(song);
    }

    @Override
    public void update(int index, Song song) {
        songs.set(index, song);
    }

    @Override
    public List<Song> findAll() {
        return songs;
    }

    @Override
    public Song findById(int index) {
        return songs.get(index);
    }
}
