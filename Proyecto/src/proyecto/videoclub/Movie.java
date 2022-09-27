package proyecto.videoclub;

public class Movie {
	private String name;
	private String distributor;
	private String date;
	private int cantRented;
	private int id;
	private boolean available;
	
	public Movie() {
		this.name = null;
		this.distributor=null;
		this.date = null;
		this.cantRented = 0;
		this.available = true;
	}
	public Movie(String name, String distributor, String date, int id) {
		this.name = name;
		this.distributor = distributor;
		this.date = date;
		this.cantRented = 0;
		this.available=true;
		this.id = id;
	}
	
	// METODOS
	public String getName() {
		return name;
	}
	
	public String getDistributor() {
		return distributor;
	}
	
	public String getDate() {
		return date;}
	
	public int getId() {
		return id;
	}

	public int getCantR() {
		return cantRented;}
	
	public boolean getAvailable() {
		return available;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public void upCant() {
		cantRented++;
	}
	
	public void showMovies() {
		System.out.println("Nombre: "+name);
		System.out.println("Distribuidor: "+distributor);
		System.out.println("Fecha: "+date);
		if (available) System.out.println("Disponible: Si");
		else System.out.println("Disponible: No");
		System.out.println("Veces rentada: "+cantRented);
		System.out.println("ID: "+id+"\n");
	}
}
