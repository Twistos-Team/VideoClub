package proyecto.videoclub;

public class Movie {
	private String name;
	private String distributor;
	private int id;
	//private boolean rented;
	
	public Movie() {
		this.name = null;
		this.distributor=null;
	}
	public Movie(String name, String distributor,int id) {
		this.name = name;
		this.distributor = distributor;
		this.id = id;
	}
	
	// METODOS
	
	public String getName() {
		return name;
	}
	
	public void showMovies() {
		System.out.println("Nombre: "+name);
		System.out.println("Distribuidor: "+distributor);
		System.out.println("ID: "+id+"\n");
	}
}
