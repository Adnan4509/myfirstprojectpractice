package com.mycompany.myfirstproject.services;

import com.mycompany.myfirstproject.entity.Song;
import com.mycompany.myfirstproject.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {
    private final SongRepository songRepo;

    public List<Song> getAllSongs(){
        return songRepo.findAll();
    }

    public Song createSong(Song songObj) {

        return songRepo.save(songObj);
    }
}
