![badge literalura](https://github.com/Clarosabel2/literAlura/assets/95495732/4a175e90-96bf-4dcf-9103-7cb96e7c0e95)

# LiteAlura Project

## Tecnologías Utilizadas

- **Java 17**: Lenguaje de programación utilizado para el desarrollo del backend.
- **Spring Boot (3.3.0)**: Framework de Java utilizado para simplificar el desarrollo de aplicaciones nuevas y existentes.
- **Spring Data JPA**: Módulo de Spring Framework que facilita la implementación de repositorios basados en JPA.
- **PostgreSQL**: Sistema de gestión de bases de datos relacional utilizado para almacenar los datos de la aplicación.
- **Maven (3.9.7)**: Herramienta de gestión y comprensión de proyectos de software.
- **Lombok**: Biblioteca de Java que se utiliza para minimizar el código repetitivo.
- **Jackson Databind (2.17.1)**: Biblioteca de Java para serializar y deserializar objetos Java a (y desde) JSON.

## Descripción del Proyecto

El proyecto LiteAlura es una aplicación de consola desarrollada en Java utilizando el framework Spring Boot. Su propósito principal es permitir a los usuarios buscar libros por título, mostrar información sobre autores, listar los libros más descargados, y ver los libros guardados en la base de datos.

### Funcionalidades Principales

1. **Buscar Libro por Título**: Permite a los usuarios buscar libros por su título. La búsqueda se realiza a través de una API externa (Gutendex) y muestra los resultados en la consola.

2. **Mostrar Escritores**: Lista todos los autores almacenados en la base de datos junto con información relevante como nombre, año de nacimiento, año de fallecimiento y cantidad de libros realizados.

3. **Mostrar Top 10 Libros**: Muestra los 10 libros con más descargas, ordenados de mayor a menor según el número de descargas.

4. **Ver Libros Guardados**: Lista todos los libros que han sido guardados en la base de datos, mostrando detalles como título, autor e idioma.

### Ejecución

Para ejecutar el proyecto, es necesario tener instalado Java 17 y Maven. Una vez configurado el entorno, se puede iniciar la aplicación ejecutando el comando `mvn spring-boot:run` desde la raíz del proyecto. Esto lanzará la aplicación y mostrará un menú de opciones en la consola para interactuar con las distintas funcionalidades.

### Configuración

El proyecto utiliza variables de entorno para configurar la conexión a la base de datos PostgreSQL. Es necesario establecer las variables `DB_HOST`, `DB_NAME`, `DB_USER`, y `DB_PASSWORD` con los valores correspondientes a la configuración de la base de datos.

### Repositorios y Capa de Datos

El acceso a datos se gestiona a través de repositorios JPA, utilizando Spring Data JPA para simplificar la implementación. Se definen interfaces para `BookRepository` y `AuthorRepository`, que extienden de `JpaRepository`, facilitando operaciones CRUD y consultas personalizadas sobre las entidades `Book` y `Author`.
