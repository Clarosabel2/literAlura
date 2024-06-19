package com.aluracursos.litealura.main;

import com.aluracursos.litealura.model.Author;
import com.aluracursos.litealura.model.Book;
import com.aluracursos.litealura.model.DataBook;
import com.aluracursos.litealura.repository.AuthorRepository;
import com.aluracursos.litealura.repository.BookRepository;
import com.aluracursos.litealura.service.Apiclient;
import com.aluracursos.litealura.service.ConvertData;

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
                    2.Mostrar Escritores
                    3.Mostrar Top 10 libros
                    4.Ver libros guardados
                    5.Salir
                    ****************************************
                    """);
            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    int[] i = {0}; // Array de un solo elemento para mantener el contador mutable
                    List<Book> books = searchBooks();
                    System.out.println("""
                            ****************************************
                                            Resultados
                            """);
                    books.forEach(e -> System.out.println( (++i[0]) + ". " + e.get_title()+" Autor: "+ e.get_author().get_name()));
                    System.out.println("Ingrese el libro que desea guardar");
                    Book book = books.get(sc.nextInt()-1);
                    saveBook(book);
                    break;
                case 2:
                    showAuthor();
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
        int[] i = {0};
        _bRepository.findAll().forEach(e-> System.out.printf("""
                Libro: %s
                    Titulo: %s
                    Autor: %s
                    Idioma: %s
                """,(++i[0]), e.get_title(),e.get_author().get_name(),e.get_lenguage()));
    }

    private void getTopBooks() {
        System.out.println("Libros con mas Descargas:");
        _bRepository.findAllByOrderBy_countDowloadsDesc(10).forEach(e-> System.out.println("Libro: "+ e.get_title()+" Descargas: "+e.get_countDowloads()));
    }

    private void showAuthor() {
        int[] i = {0};
        _aRepository.findAll().forEach(e-> System.out.printf("""
                Autor: %s
                    Nombre: %s
                    Año Nacimieno: %s
                    Año Fallecimiento: %s
                    Libros realizados: %s
                """,(++i[0]),e.get_name(),e.get_birthYear(),e.get_deathYear(),(e.get_books().toArray().length)));
    }

    public List<Book> searchBooks() {
        System.out.println("Ingrese el titlo del libro: ");
        String titleBook = sc.nextLine();
        String json = apiclt.getData(URL_BASE + "?search=" + titleBook.replace(" ", "+"));
        List<DataBook> rBooks = (cvtData.getData(json, DataBook.class));
        List<Book> books = rBooks.stream().map(
                b -> new Book(b.title(),
                        new Author(b.authors().get(0).name(), b.authors().get(0).birthYear(), b.authors().get(0).deathYeah()),
                        b.languages().get(0),
                        Integer.parseInt(b.dwlCounts()))).collect(Collectors.toList());

        return books;
    }

    public void saveBook(Book b) {
        _aRepository.save(b.get_author());
        _bRepository.save(b);
    }


}
