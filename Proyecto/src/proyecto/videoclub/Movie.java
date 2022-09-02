package proyecto.videoclub;

public class Movie {
	private String name;
	private String director;
	private int id;
	
	public Movie() {
		this.name = null;
		this.director=null;
	}
	public Movie(String name, String director, int id) {
		this.name = name;
		this.director = director;
		this.id = id;
	}
	
	// METODOS
	
	public String getName() {
		return name;
	}
	
	public void showMovies() {
		System.out.println("Nombre:"+name);
		System.out.println("Director:"+director);
		System.out.println("ID:"+id+"\n");
	}
}
