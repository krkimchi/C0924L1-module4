package com.codegym.validate_thong_tin_bai_hat.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

public class Song {

    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 800, message = "Tên bài hát không vượt quá 800 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Tên bài hát không được chứa ký tự đặc biệt")
    private String name;

    @NotBlank(message = "Nghệ sĩ không được để trống")
    @Size(max = 300, message = "Nghệ sĩ không vượt quá 300 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Nghệ sĩ không được chứa ký tự đặc biệt")
    private String artist;

    @NotBlank(message = "Thể loại không được để trống")
    @Size(max = 1000, message = "Thể loại không vượt quá 1000 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9 ,]+$", message = "Thể loại chỉ được chứa chữ, số, dấu cách và dấu phẩy")
    private String genre;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
}
