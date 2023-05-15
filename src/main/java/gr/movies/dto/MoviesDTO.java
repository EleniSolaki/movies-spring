package gr.movies.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MoviesDTO {
    private Long id;

    private String title;

    private String year;

    private String genre;

    public MoviesDTO(Long id, String title, String year, String genre) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
    }
}