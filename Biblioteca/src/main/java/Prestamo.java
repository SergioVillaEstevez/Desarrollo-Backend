import java.time.LocalDate;

public class Prestamo {
	
	private int idPrestamo;
	private LocalDate fechaDeDevolucion;
	private LocalDate fechaDePrestamo;
	private Lector lector;
	private Libro libro;
	
	
	public Prestamo() {
		
	}
	
	public Prestamo(LocalDate fechaDeDevolucion,LocalDate fechaDePrestamo, Lector lector, Libro libro) {
		
		
		this.fechaDeDevolucion=fechaDeDevolucion;
		this.fechaDePrestamo=fechaDePrestamo;
		this.lector=lector;
		this.libro=libro;
		
		
		
	}

	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public LocalDate getFechaDeDevolucion() {
		return fechaDeDevolucion;
	}

	public void setFechaDeDevolucion(LocalDate fechaDeDevolucion) {
		this.fechaDeDevolucion = fechaDeDevolucion;
	}

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	

	public LocalDate getFechaDePrestamo() {
		return fechaDePrestamo;
	}

	public void setFechaDePrestamo(LocalDate fechaDePrestamo) {
		this.fechaDePrestamo = fechaDePrestamo;
	}

	@Override
	public String toString() {
		return "Prestamo [idPrestamo=" + idPrestamo + ", fechaDeDevolucion=" + fechaDeDevolucion + ", fechaDePrestamo="
				+ fechaDePrestamo + ", lector=" + lector + ", libro=" + libro + "]";
	}


	
	
	
	
	
	

}
