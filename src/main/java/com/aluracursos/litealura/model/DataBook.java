package com.aluracursos.litealura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataBook(
        @JsonAlias("title") String title,
        @JsonAlias("authros")List<DataAuthor>authors,
        @JsonAlias("languages") List<String> languages,
        @JsonAlias("download_count") String dwlCounts
        ) {
}
