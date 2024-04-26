
public class Libro {
	
	
	private int idLibro;
	private String titulo;
	private String autor;
	private int anoDePublicacion;
	private boolean disponible;
	
	public Libro() {}
	
	public Libro(int idLibro,String titulo,String autor,int anoDePublicacion,boolean disponible) {
		
		
		this.idLibro= idLibro;
		this.titulo=titulo;
		this.autor=autor;
		this.anoDePublicacion=anoDePublicacion;
		this.disponible=disponible;
		
		
	}
	
	
	public int getIdLibro() {
		return idLibro;
	}



	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	public int getAnoDePublicacion() {
		return anoDePublicacion;
	}



	public void setAnoDePublicacion(int anoDePublicacion) {
		this.anoDePublicacion = anoDePublicacion;
	}



	public boolean isDisponible() {
		return disponible;
	}



	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", autor=" + autor + ", anoDePublicacion="
				+ anoDePublicacion + ", disponible=" + disponible + "]";
	}




	
	
	
	

}
