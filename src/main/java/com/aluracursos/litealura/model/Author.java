package com.aluracursos.litealura.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;
    private String _name;
    private String _birthYear;
    private String _deathYear;
    @OneToMany(mappedBy = "_author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> _books;

    public Author(String _name, String _birthYear, String _deathYear) {
        this._name = _name;
        this._birthYear = _birthYear;
        this._deathYear = _deathYear;
    }
}
