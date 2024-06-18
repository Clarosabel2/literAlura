package com.aluracursos.litealura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataAuthor(
        @JsonAlias("name") String name,
        @JsonAlias("birth_year") String bithYear,
        @JsonAlias("death_year") String deathYeah
        ) {
}
