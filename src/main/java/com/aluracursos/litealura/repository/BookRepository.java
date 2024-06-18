package com.aluracursos.litealura.repository;

import com.aluracursos.litealura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Book findBy_titleIgnoreCase(String title);

    List<Book> findBy_lenguagesContaining(String lenguage);

}