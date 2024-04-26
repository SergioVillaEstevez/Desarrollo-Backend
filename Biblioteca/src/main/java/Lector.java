
public class Lector {
	
	private int idLector;
	private String nombre;
	private String apellido;
	private String email;
	
	
	
	public Lector() {}
	
	public Lector(int idLector, String nombre, String apellido, String email) {
		
		this.idLector=idLector;
		this.nombre=nombre;
		this.apellido=apellido;
		this.email=email;
	}


	public int getIdLector() {
		return idLector;
	}


	public void setIdLector(int idLector) {
		this.idLector = idLector;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Lector [idLector=" + idLector + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ "]";
	}
	
	

}
