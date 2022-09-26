package proyecto.videoclub;
import java.util.*;
	
public class Client {
	private String name;
	private String rut;
	private int cantMovies;
	ArrayList<Movie> movies;
	
	//CONSTRUCTORES
	public Client() {
		this.name=null;
		this.cantMovies = 0;
		this.rut=null;
		this.movies = new ArrayList<Movie>();
	}
	
	public Client(String name, String rut) {
		this.name = name;
		this.rut = rut;
		cantMovies = 0;
		this.movies = new ArrayList<Movie>();
	}
	
	
	//METODOS
	public void setClient(String name, String rut) {
		this.name = name;
		this.rut = rut;
	}
	
	public void setClient(String name, int rut) {
		this.name = name;
		this.rut = String.valueOf(rut);
	}
	
	public void showClient() {
		System.out.println("Nombre: "+name);
		System.out.println("Rut: "+rut+"\n");
	}
	
	public void setClientMovie(Movie mov){
		movies.add(cantMovies, mov);
		cantMovies ++;
	}
	
	public void showClientMovies() {
		for (int i = 0 ; i < cantMovies ; i+=1) {
			movies.get(i).showMovies();
		}
	}
	
}//END CLASS