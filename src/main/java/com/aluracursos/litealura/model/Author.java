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
    private int _bithYear;
    private int _deathYear;
    @OneToMany(mappedBy = "_author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> _books;
}
