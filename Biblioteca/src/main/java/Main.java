import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {
	
	
	 private final SessionFactory sessionFactory;

	    public Main(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }

    public static void main(String[] args) {
    	
    
        Scanner scanner = new Scanner(System.in);
        
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();

        boolean salir = false;
        
        while (!salir) {
        	System.out.println("----------------------------");
            System.out.println("	Biblioteca:		");
            System.out.println("----------------------------");
            System.out.println("1. Insertar Libro");
            System.out.println("2. Insertar Lector");
            System.out.println("----------------------------");
            System.out.println("3. Registrar Prestamo");
            System.out.println("4. Devolver Prestamo");
            System.out.println("----------------------------");
            System.out.println("5. Listado de Libros");
            System.out.println("6. Listado de Lectores");
            System.out.println("----------------------------");
            System.out.println("7. Libros prestados a un lector");
            System.out.println("8. Libros disponibles para prestamo");
            System.out.println("9. Historial Prestamo por Lector");
            System.out.println("----------------------------");
            System.out.println("10. Eliminar Libro");
            System.out.println("11. Eliminar Lector");
            System.out.println("----------------------------");
            System.out.println("12. Actualizar Libro");
            System.out.println("13. Actualizar Lector");
            System.out.println("----------------------------");
           
            System.out.println("14. Salir");
            System.out.println("----------------------------");
            
            System.out.print("Selecciona una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();  
            
            switch (opcion) {
                case 1:
                    agregarLibro(session);
                    break;
                case 2:
                    agregarLector(session);
                    break;
                case 3:
                    registrarPrestamo(session);
                    break;  
               case 4:
                	devolverPrestamo(session);
                	break;
                case 5: 
                	listarLibros(session);
                	break;
                case 6:
                	listarLectores(session);
                	break;
                case 7:
                	librosPrestadosAUnLector(session);;
                	break;
                case 8:
                	librosDisponiblesParaPrestamo(session);
                	break;
                	
                case 9:
                	historialPrestamosPorLector(session);
                	break;
                case 10:
                	eliminarLibro(session);
                	break;
                case 11:
                	eliminarLector(session);
                	break;
                case 12:
                	actualizarLibro(session);
                	break;
                case 13:
                	actualizarLector(session);
                	break;
              
                	
                case 14:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        
        session.close();
        sessionFactory.close();
        scanner.close();
    }

    
    
  /* 
   
   * Metodos CRUD para libros y lectores.
   * Metodos como libros actualmente prestados a un lector, Libros disponibles para prestamo,Historial de prestamos por lector.
 
  */
    
    
 public static void agregarLibro(Session session) {
        Libro libro = new Libro();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Título: ");
        libro.setTitulo(scanner.nextLine());
        
        System.out.print("Autor: ");
        libro.setAutor(scanner.nextLine());
        
        System.out.print("Año de Publicación: ");
        libro.setAnoDePublicacion(scanner.nextInt());
        
        libro.setDisponible(true);
        
        Transaction transaction = session.beginTransaction();
        session.save(libro);
        transaction.commit();
        
        System.out.println("Libro agregado correctamente.");
    }

  public static void agregarLector(Session session) {
        Lector lector = new Lector();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nombre: ");
        lector.setNombre(scanner.nextLine());
        
        System.out.print("Apellido: ");
        lector.setApellido(scanner.nextLine());
        
        System.out.print("Email: ");
        lector.setEmail(scanner.nextLine());
        
        Transaction transaction = session.beginTransaction();
        session.save(lector);
        transaction.commit();
        
        System.out.println("Lector agregado correctamente.");
    }
    
    
    
public static void eliminarLibro(Session session) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("ID del Libro a eliminar: ");
        int libroId = scanner.nextInt();
        
        Libro libro = session.get(Libro.class, libroId);
        
        if (libro == null) {
            System.out.println("No se encontró ningún libro con el ID proporcionado.");
            return;
        }
        
        Transaction transaction = session.beginTransaction();
        session.delete(libro);
        transaction.commit();
        
        System.out.println("Libro eliminado correctamente.");
    }
    
 
    
 public static void eliminarLector(Session session) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("ID del Lector a eliminar: ");
        int lectorId = scanner.nextInt();
        
        Lector lector = session.get(Lector.class, lectorId);
        
        if (lector == null) {
            System.out.println("No se encontró ningún lector con el ID proporcionado.");
            return;
        }
    
        Transaction transaction = session.beginTransaction();
        session.delete(lector);
        transaction.commit();
        
        System.out.println("Lector eliminado correctamente.");
    }
    
  
 public static void actualizarLibro(Session session) {
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.print("ID del Libro a actualizar: ");
	    int libroId = scanner.nextInt();
	    
	    Libro libro = session.get(Libro.class, libroId);
	    
	    if (libro == null) {
	        System.out.println("No se encontró ningún libro con el ID proporcionado.");
	        return;
	    }
	    
	    System.out.println("Detalles actuales del Libro:");
	    System.out.println("Título: " + libro.getTitulo());
	    System.out.println("Autor: " + libro.getAutor());
	    System.out.println("Año de Publicación: " + libro.getAnoDePublicacion());
	    
	    System.out.print("Nuevo Título (Dejar vacío para mantener el actual): ");
	    String nuevoTitulo = scanner.next().trim();
	    if (!nuevoTitulo.isEmpty()) {
	        libro.setTitulo(nuevoTitulo);
	    }
	    
	    System.out.print("Nuevo Autor (Dejar vacío para mantener el actual): ");
	    String nuevoAutor = scanner.next().trim();
	    if (!nuevoAutor.isEmpty()) {
	        libro.setAutor(nuevoAutor);
	    }
	    
	    System.out.print("Nuevo Año de Publicación (Dejar 0 para mantener el actual): ");
	    int nuevoAno = scanner.nextInt();
	    if (nuevoAno != 0) {
	        libro.setAnoDePublicacion(nuevoAno);
	    }
	    
	    Transaction transaction = session.beginTransaction();
	    session.update(libro);
	    transaction.commit();
	    
	    System.out.println("Libro actualizado correctamente.");
 }
 
 
 
    
    

public static void actualizarLector(Session session) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("ID del Lector a actualizar: ");
    int lectorId = scanner.nextInt();
    
    Lector lector = session.get(Lector.class, lectorId);
    
    if (lector == null) {
        System.out.println("No se encontró ningún lector con el ID proporcionado.");
        return;
    }
    
    System.out.println("Detalles actuales del Lector:");
    System.out.println("Nombre: " + lector.getNombre());
    System.out.println("Apellido: " + lector.getApellido());
    System.out.println("Email: " + lector.getEmail());
    
    System.out.print("Nuevo Nombre (Dejar vacío para mantener el actual): ");
    String nuevoNombre = scanner.next().trim();
    if (!nuevoNombre.isEmpty()) {
        lector.setNombre(nuevoNombre);
    }
    
    System.out.print("Nuevo Apellido (Dejar vacío para mantener el actual): ");
    String nuevoApellido = scanner.next().trim();
    if (!nuevoApellido.isEmpty()) {
        lector.setApellido(nuevoApellido);
    }
    
    System.out.print("Nuevo Email (Dejar vacío para mantener el actual): ");
    String nuevoEmail = scanner.next().trim();
    if (!nuevoEmail.isEmpty()) {
        lector.setEmail(nuevoEmail);
    }
    
    Transaction transaction = session.beginTransaction();
    session.update(lector);
    transaction.commit();
    
    System.out.println("Lector actualizado correctamente.");
}
    
    
    

  public static void registrarPrestamo(Session session) {
        Prestamo prestamo = new Prestamo();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("ID del Libro: ");
        int libroId = scanner.nextInt();
        Libro libro = session.get(Libro.class, libroId);
        
        if (libro != null) {
            System.out.println("Detalles del Libro:");
            System.out.println("ID: " + libro.getIdLibro());
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Año de Publicación: " + libro.getAnoDePublicacion());
            System.out.println("Disponible: " + (libro.isDisponible() ? "Sí" : "No"));
        } else {
            System.out.println("No se encontró ningún libro con el ID proporcionado.");
            return; // Salir del método si no se encuentra el libro
        }
        
       
        
        
        System.out.print("ID del Lector: ");
        int lectorId = scanner.nextInt();
        
        //  la lógica para obtener el Libro y el Lector de la base de datos
       
        Lector lector = session.get(Lector.class, lectorId);
        
        if (lector != null) {
            System.out.println("Detalles del Autor:");
            System.out.println("ID: " + lector.getIdLector());
            System.out.println("Nombre: " + lector.getNombre());
            System.out.println("Apellido: " + lector.getApellido());
            System.out.println("Email: " + lector.getEmail());
          
        } else {
            System.out.println("No se encontró ningún lector con el ID proporcionado.");
            return; // Salir del método si no se encuentra el libro
        }
        
        
        
        prestamo.setFechaDePrestamo(LocalDate.now());
        prestamo.setFechaDeDevolucion(null);
        prestamo.setLector(lector);
        prestamo.setLibro(libro);
        libro.setDisponible(false);
        
        Transaction transaction = session.beginTransaction();
        session.update(libro);
        session.save(prestamo);
        transaction.commit();
        
        System.out.println("Préstamo registrado correctamente.");
    }
    
  public static void listarLibros(Session session) {
    	
    	List<Libro>libros=session.createQuery("FROM Libro", Libro.class).getResultList();
    	
    	
    	if(libros.isEmpty()) {
    		System.out.println("No hay libros registrados");
    	}
    	
    	else {
    		
    		System.out.println("Listado de Libros: ");
    		
    		for(Libro libro:libros) {
    			
    			System.out.println("ID: "+ libro.getIdLibro()+ ", Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor() +
    					", Año de publicacion: " + libro.getAnoDePublicacion() + ", Disponibilidad: "+ libro.isDisponible());
    			
    		}
    	}
    }
    	
    
    public static void listarLectores(Session session) {
    	
    	List<Lector>lectores=session.createQuery("FROM Lector", Lector.class).getResultList();
    	
    	if(lectores.isEmpty()) {
    		System.out.println("No hay lectores registrados");
    		
    	
    	}else {
    		
    		for(Lector lector:lectores) {
    			
    			System.out.println("Id:" +lector.getIdLector()+", Nombre:" + lector.getNombre()+", Apellido:"+ lector.getApellido()+", Email:"+ lector.getEmail());
    			
    		}
    		
    	}
    	
    	
    }
    
 public static void librosPrestadosAUnLector(Session session) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("ID del Lector: ");
        int lectorId = scanner.nextInt();
        
        Lector lector = session.get(Lector.class, lectorId);
        
        if (lector == null) {
            System.out.println("No se encontró ningún lector con el ID proporcionado.");
            return; // Salir del método si no se encuentra el lector
        }
        
        List<Prestamo> prestamos = session.createQuery("FROM Prestamo WHERE lector_id = :lectorId AND fechaDeDevolucion IS NULL", Prestamo.class)
                                          .setParameter("lectorId", lectorId)
                                          .getResultList();
        
        if (prestamos.isEmpty()) {
            System.out.println("El lector no tiene libros prestados actualmente.");
        } else {
            System.out.println("Libros prestados a " + lector.getNombre() + " " + lector.getApellido() + ":");
            for (Prestamo prestamo : prestamos) {
                System.out.println("ID: " + prestamo.getLibro().getIdLibro());
                System.out.println("Título: " + prestamo.getLibro().getTitulo());
                System.out.println("Autor: " + prestamo.getLibro().getAutor());
                System.out.println("----------------------------------------");
            }
        }
    }
    
    
    
    
    
    
    
  public static void librosDisponiblesParaPrestamo(Session session) {
        List<Libro> librosDisponibles = session.createQuery("FROM Libro WHERE disponible = true", Libro.class)
                                                .getResultList();
        
        if (librosDisponibles.isEmpty()) {
            System.out.println("No hay libros disponibles para préstamo en este momento.");
        } else {
            System.out.println("Libros disponibles para préstamo:");
            for (Libro libro : librosDisponibles) {
                System.out.println("ID: " + libro.getIdLibro());
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor());
                System.out.println("Año de Publicación: " + libro.getAnoDePublicacion());
                System.out.println("----------------------------------------");
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public static void historialPrestamosPorLector(Session session) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("ID del Lector: ");
        int lectorId = scanner.nextInt();
        
        Lector lector = session.get(Lector.class, lectorId);
        
        if (lector == null) {
            System.out.println("No se encontró ningún lector con el ID proporcionado.");
            return; // Salir del método si no se encuentra el lector
        }
        
        List<Prestamo> prestamos = session.createQuery("FROM Prestamo WHERE lector_id = :lectorId", Prestamo.class)
                                          .setParameter("lectorId", lectorId)
                                          .getResultList();
        
        if (prestamos.isEmpty()) {
            System.out.println("El lector no tiene préstamos registrados.");
        } else {
            System.out.println("Historial de Préstamos para " + lector.getNombre() + " " + lector.getApellido() + ":");
            for (Prestamo prestamo : prestamos) {
                System.out.println("ID: " + prestamo.getIdPrestamo());
                System.out.println("Fecha de Préstamo: " + prestamo.getFechaDePrestamo());
                System.out.println("Fecha de Devolución: " + (prestamo.getFechaDeDevolucion() != null ? prestamo.getFechaDeDevolucion() : "No devuelto"));
                System.out.println("Libro: " + prestamo.getLibro().getTitulo() + " - " + prestamo.getLibro().getAutor());
                System.out.println("----------------------------------------");
            }
        }
    }
    
    public static void devolverPrestamo(Session session) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("ID del Libro a devolver: ");
        int libroId = scanner.nextInt();
        
        Libro libro = session.get(Libro.class, libroId);
        
        if (libro == null) {
            System.out.println("No se encontró ningún libro con el ID proporcionado.");
            return;
        }
        
        libro.setDisponible(true);  // Actualiza el estado del libro a disponible
        
        Transaction transaction = session.beginTransaction();
        session.update(libro);  // Actualiza el estado del libro
        transaction.commit();
        
        System.out.println("Libro devuelto correctamente.");
    }
    

    	
    	
}

