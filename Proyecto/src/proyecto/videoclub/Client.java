package proyecto.videoclub;

import java.util.ArrayList;

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
	public Client(String name, String rut, int cantMovies) {
		this.name = name;
		this.rut = rut;
		this.cantMovies = cantMovies;
		this.movies = new ArrayList<Movie>();
	}
	
	//METODOS
	public String getName() {
		return name;
	}
	
	public String getRut() {
		return rut;
	}
	
	public int getCantMovies() {
		return cantMovies;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setRut(String rut) {
		this.rut = rut;
	}
	
	public void setClient(String name, String rut) {
		setName(name);
		setRut(rut);
	}
	
	public void setClient(String name, int rut) {
		setName(name);
		setRut(String.valueOf(rut));
	}
	
	public void showClient() {
		System.out.println("Nombre: "+name);
		System.out.println("Rut: "+rut+"\n");
	}
	
	public void addClientMovie(Movie mov){
		ControllerCL ctr = new ControllerCL();
		ctr.addClientMovie(movies, mov, cantMovies);
		cantMovies ++;
		mov.upCant();
	}
	
	public void showClientMovies() {
		ControllerCL ctr = new ControllerCL();
		if (movies.size() == 0) {
			System.out.println("No tienes peliculas rentadas\n");
			return;
		}
		
		ctr.showClientMovies(movies);
		cantMovies++;
	}
	
	public void deleteMovie(String sMov) {
		ControllerCL ctr = new ControllerCL();
		if (ctr.deleteMovie(movies, sMov)) System.out.println("Pelicula devuelta\n");
		else System.out.println("Pelicula no adquirida\n");
		cantMovies--;
	}
}//END CLASS