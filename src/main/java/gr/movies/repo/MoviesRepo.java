package gr.movies.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import gr.movies.model.Movies;

import java.util.List;

public interface MoviesRepo extends JpaRepository<Movies, Long> {

    List<Movies> findAll ();
}
