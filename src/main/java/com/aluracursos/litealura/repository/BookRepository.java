package com.aluracursos.litealura.repository;

import com.aluracursos.litealura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Query("SELECT b FROM Book b ORDER BY b._countDowloads DESC")
    List<Book> findAllByOrderBy_countDowloadsDesc(int limit);
}
