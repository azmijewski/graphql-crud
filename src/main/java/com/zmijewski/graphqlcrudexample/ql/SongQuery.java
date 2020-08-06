package com.zmijewski.graphqlcrudexample.ql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.zmijewski.graphqlcrudexample.entity.Song;
import com.zmijewski.graphqlcrudexample.service.SongService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SongQuery implements GraphQLQueryResolver {

    private final SongService songService;

    public SongQuery(SongService songService) {
        this.songService = songService;
    }

    public List<Song> getSongs(int page, int size) {
        return songService.getSongs(page, size);
    }
    public Song getSongById(Long id) {
        return songService.getSongById(id);
    }
}
