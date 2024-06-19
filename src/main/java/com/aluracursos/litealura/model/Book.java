package com.aluracursos.litealura.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;
    @Column(unique = true)
    private String _title;
    @ManyToOne(fetch = FetchType.EAGER)
    private Author _author;
    private String _lenguage;
    private int _countDowloads;

    public Book(String _title, Author _author, String _lenguage, int _countDowloads) {
        this._title = _title;
        this._author = _author;
        this._lenguage = _lenguage;
        this._countDowloads = _countDowloads;
    }
}
