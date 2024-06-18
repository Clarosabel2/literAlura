package com.aluracursos.litealura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aluracursos.litealura.model.Author;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findBy_nameIgnoreCase(String name);


}
