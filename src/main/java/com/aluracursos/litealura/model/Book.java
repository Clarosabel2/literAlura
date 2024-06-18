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
    @ManyToOne
    private Author _author;
    private String _lenguages;
    private double _countDowloads;
}
