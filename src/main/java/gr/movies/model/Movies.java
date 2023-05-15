package gr.movies.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="MOVIES")
@NoArgsConstructor
public class Movies implements Serializable {

    @Id
    @Column(name= "ID")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="TITLE", unique = true)
    private String title;

    @Column(name="YEAR")
    private String year;

    @Column(name="GENRE")
    private String genre;

    public Movies(Long id, String title, String year, String genre) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
    }
}
