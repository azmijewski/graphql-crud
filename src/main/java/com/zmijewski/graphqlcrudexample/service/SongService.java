package com.zmijewski.graphqlcrudexample.service;

import com.zmijewski.graphqlcrudexample.entity.Song;
import com.zmijewski.graphqlcrudexample.repository.SongRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getSongs(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Song> songs = songRepository.findAll(pageable);
        return songs.getContent();
    }

    public Song getSongById(Long id) {
        return songRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find song with requested id"));
    }

    public Song save(Song song) {
        return songRepository.save(song);
    }

    public Song delete(Long id) {
        Song songToDelete = getSongById(id);
        songRepository.delete(songToDelete);
        return songToDelete;
    }

    public Song modify(Long id, String name, String artist) {
        Song songToUpdate = getSongById(id);
        songToUpdate.setArtist(artist);
        songToUpdate.setName(name);
        return songRepository.save(songToUpdate);
    }


}
