package gr.movies.resource;

import gr.movies.service.MovieServiceImpl;
import gr.movies.exception.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gr.movies.dto.MoviesDTO;
import gr.movies.model.Movies;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieResource {
    private final MovieServiceImpl movieServiceImpl;

    public MovieResource(MovieServiceImpl movieServiceImpl) {
        this.movieServiceImpl = movieServiceImpl;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Movies>> getAllMovies () {
        List<Movies> movies = movieServiceImpl.findAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MoviesDTO> addMovie(@RequestBody MoviesDTO dto) {
        try{
            Movies favMovie = movieServiceImpl.addMovie(dto);
            MoviesDTO movieDTO = map(favMovie);
            return new ResponseEntity<>(movieDTO, HttpStatus.CREATED);
        }catch (MovieNotFoundException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private MoviesDTO map(Movies movie){
        MoviesDTO dto = new MoviesDTO();
        dto.setTitle(movie.getTitle());
        dto.setId(movie.getId());
        dto.setGenre(movie.getGenre());
        dto.setYear(movie.getYear());
        return dto;
    }

}
