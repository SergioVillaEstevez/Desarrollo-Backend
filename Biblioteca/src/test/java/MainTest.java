import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MainTest {

    private Main main;
    private Session session;
    private Transaction transaction;

    @Mock
    private SessionFactory sessionFactory;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        session = mock(Session.class);
        transaction = mock(Transaction.class);

        when(sessionFactory.openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);

        main = new Main(sessionFactory);
    }

    @AfterEach
    public void tearDown() {
        session.close();
    }

    @Test
    public void testAgregarLibro() {
        String input = "TestTitulo\nTestAutor\n2022\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        main.agregarLibro(session);

        verify(session).save(any(Libro.class));
        verify(transaction).commit();
    }

    @Test
    public void testAgregarLector() {
        String input = "TestNombre\nTestApellido\nTestEmail\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        main.agregarLector(session);
       ;

        verify(session).save(any(Lector.class));
        verify(transaction).commit();
    }

    @Test
    public void testRegistrarPrestamo() {
        // Suponiendo que tenemos un libro y un lector ya creados
        when(session.get(Libro.class, 1)).thenReturn(new Libro());
        when(session.get(Lector.class, 1)).thenReturn(new Lector());

        String input = "1\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        main.registrarPrestamo(session);

        verify(session).save(any(Prestamo.class));
        verify(session).update(any(Libro.class));
        verify(transaction).commit();
    }
}
