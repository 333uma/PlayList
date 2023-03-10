package com.example.song.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import com.example.song.model.Song;
import com.example.song.service.SongH2Service;

@RestController
public class SongController{
    @Autowired
    public SongH2Service songServe;

    @GetMapping("/songs")
    public ArrayList<Song> getSongs(){
        return songServe.getSongs();
    }

    @GetMapping("/songs/{songId}")
    public Song getSongById(@PathVariable("songId") int songId){
        return songServe.getSongById(songId);
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song){
        return songServe.addSong(song);
    }

    @PutMapping("/songs/{songId}")
    public Song updateSong(@RequestBody Song song, @PathVariable("songId") int songId){
        return songServe.updateSong(song, songId);
    }

    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable("songId") int songId){
        songServe.deleteSong(songId);
    }
}