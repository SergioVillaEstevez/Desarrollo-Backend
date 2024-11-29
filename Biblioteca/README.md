# BibliotecaPAC

BibliotecaPAC es una aplicación de gestión de bibliotecas que permite administrar libros, lectores y préstamos. La aplicación está desarrollada en Java y utiliza Hibernate para la persistencia de datos.

## Características

- **Gestión de Libros**: Agregar, actualizar, eliminar y listar libros.
- **Gestión de Lectores**: Agregar, actualizar, eliminar y listar lectores.
- **Préstamos**: Registrar y devolver préstamos de libros.
- **Historial de Préstamos**: Consultar el historial de préstamos de un lector.
- **Libros Disponibles**: Consultar libros disponibles para préstamo.

## Tecnologías Utilizadas

- Java
- Hibernate
- MySQL
- Maven

## Configuración inicial

### Requisitos previos

- Java 8 o superior
- Maven
- Base de datos MySQL

### Instalación

1. Importa el proyecto en Eclipse como un proyecto Maven.

2. Configura la conexión a la base de datos en el archivo `hibernate.cfg.xml`.

## Ejecución

Para ejecutar la aplicación, simplemente corre la clase `Main` desde Eclipse o ejecuta el siguiente comando Maven:

mvn exec:java -Dexec.mainClass="Main"


## Pruebas Unitarias

Las pruebas unitarias se encuentran en el directorio `src/test/java`. Utilizan JUnit para validar el comportamiento de las clases y métodos del proyecto.

### Ejecución de las pruebas

Para ejecutar las pruebas unitarias, puedes utilizar JUnit desde Eclipse o ejecutar el siguiente comando Maven:

mvn test


