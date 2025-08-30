package com.mycompany.myfirstproject.controllers;

import com.mycompany.myfirstproject.entity.Song;
import com.mycompany.myfirstproject.services.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
@RequiredArgsConstructor
public class SongController {

    public final SongService songService;

    @GetMapping
    public ResponseEntity<List<Song>> getSongs(){
        List<Song> Songs = songService.getAllSongs();
        return ResponseEntity.ok(Songs);
    }

    @PostMapping
    public Song newSong(@RequestBody Song body){
        Song newSong = songService.createSong(body);
        return newSong;
    }

}
