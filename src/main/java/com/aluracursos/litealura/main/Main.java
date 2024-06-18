package com.aluracursos.litealura.main;

import com.aluracursos.litealura.model.Book;
import com.aluracursos.litealura.model.DataBook;
import com.aluracursos.litealura.repository.AuthorRepository;
import com.aluracursos.litealura.repository.BookRepository;
import com.aluracursos.litealura.service.Apiclient;
import com.aluracursos.litealura.service.ConvertData;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.jpa.repository.query.JSqlParserUtils;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private BookRepository _bRepository;
    private AuthorRepository _aRepository;

    private ConvertData cvtData = new ConvertData();
    private Apiclient apiclt = new Apiclient();

    private Scanner sc = new Scanner(System.in);

    private final String URL_BASE = "https://gutendex.com/books/";

    public Main(BookRepository repository, AuthorRepository authorRepository) {
        this._bRepository = repository;
        this._aRepository = authorRepository;
    }

    public void ShowMenu() {
        int op = 0;
        do {
            System.out.println("""
                    ****************************************
                                   <LiterAlura>
                    ----------------------------------------
                    1.Buscar libro por titulo
                    2.Buscar Autor
                    3.Mostrar Top 10 libros
                    4.Ver libros guardados
                    5.Salir
                    ****************************************
                    """);
            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    searchBook().forEach(e -> System.out.println(e.toString()));
                    break;
                case 2:
                    searchAuthor();
                    break;
                case 3:
                    getTopBooks();
                    break;
                case 4:
                    showBooks();
                    break;
                case 5:
                    System.out.println("Hasta Luego");
                    op = -1;
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
            }
        } while (op != -1);
    }

    private void showBooks() {
    }

    private void getTopBooks() {
    }

    private void searchAuthor() {
    }

    public List<DataBook> searchBook() {
        System.out.println("Ingrese el titlo del libro: ");
        String titleBook = sc.nextLine();
        String json = apiclt.getData(URL_BASE + "?search=" + titleBook.replace(" ", "+"));
        List<DataBook> rBooks = (cvtData.getData(json, DataBook.class));
        List<Book> books = rBooks.stream().map(e -> new Book(e.title(), e.authors(), e.dwlCounts(), e.languages())).collect(Collectors.toList());
        saveBooks(rBooks);
        return rBooks;
    }

    public void saveBooks(List<DataBook> books) {

    }

}
