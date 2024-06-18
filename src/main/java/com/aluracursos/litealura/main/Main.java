package com.aluracursos.litealura.main;

import com.aluracursos.litealura.repository.AuthorRepository;
import com.aluracursos.litealura.repository.BookRepository;
import com.aluracursos.litealura.service.Apiclient;
import com.aluracursos.litealura.service.ConvertData;

import java.util.Scanner;

public class Main {

    private BookRepository _bRepository;
    private AuthorRepository _aRepository;

    private ConvertData cvtData;
    private Apiclient apiclt;

    private Scanner sc = new Scanner(System.in);

    private final String URL_BASE = "https://gutendex.com/books/";

    public Main(BookRepository repository, AuthorRepository authorRepository) {
        this._bRepository = repository;
        this._aRepository = authorRepository;
    }

    public void showMenu() {
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
            switch (op) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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

}
