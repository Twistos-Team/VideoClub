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
	
	public String getDistributor() {
		return distributor;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}
	
	public void showMovies() {
		System.out.println("Nombre: "+name);
		System.out.println("Distribuidor: "+distributor);
		System.out.println("ID: "+id+"\n");
	}
}
