package gr.movies.service;

import gr.movies.repo.MoviesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gr.movies.dto.MoviesDTO;
import gr.movies.model.Movies;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MovieServiceImpl implements IMovieService{
    private final MoviesRepo moviesRepo;

    @Autowired
    public MovieServiceImpl(MoviesRepo moviesRepo) {
        this.moviesRepo = moviesRepo;
    }


    @Override
    public Movies addMovie(MoviesDTO movieDTO) {
        System.out.println("i am now in service");
        Movies movie = new Movies();
        movie.setTitle(movieDTO.getTitle());
        movie.setYear(movieDTO.getYear());
        movie.setGenre(movieDTO.getGenre());
        moviesRepo.save(movie);
        movieDTO.setId(movie.getId());
        return  moviesRepo.save(movie);
    }

    @Override
    public List<Movies> findAllMovies() {
        return moviesRepo.findAll();
    }


}
