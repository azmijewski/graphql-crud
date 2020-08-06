package com.zmijewski.graphqlcrudexample.ql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.zmijewski.graphqlcrudexample.entity.Song;
import com.zmijewski.graphqlcrudexample.service.SongService;
import org.springframework.stereotype.Component;

@Component
public class SongMutation implements GraphQLMutationResolver {
    private final SongService songService;

    public SongMutation(SongService songService) {
        this.songService = songService;
    }

    public Song saveSong(String name, String artist) {
        Song song = new Song();
        song.setArtist(artist);
        song.setName(name);
        return songService.save(song);
    }
    public Song updateSong(Long id, String name, String artist) {
        return songService.modify(id, name, artist);
    }
    public Song deleteSong(Long id){
        return songService.delete(id);
    }
}
