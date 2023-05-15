package gr.movies.service;

import gr.movies.dto.MoviesDTO;
import gr.movies.model.Movies;

import java.util.List;

public interface IMovieService {
     Movies addMovie(MoviesDTO dto);

     List<Movies> findAllMovies();


}
