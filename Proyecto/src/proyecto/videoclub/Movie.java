package proyecto.videoclub;

public class Movie {
	private String name;
	private String distributor;
	private String date;
	private int cantRented;
	private String user;
	private int id;
	
	public Movie() {
		this.name = null;
		this.distributor=null;
		this.date = null;
		this.cantRented = 0;
		this.user = null;
	}
	public Movie(String name, String distributor, String date, int cantRented, int id) {
		this.name = name;
		this.distributor = distributor;
		this.date = date;
		this.cantRented = cantRented;
		this.user = null;
		this.id = id;
	}
	
	public Movie(String name, String distributor, String date, int cantRented, String user, int id) {
		this.name = name;
		this.distributor = distributor;
		this.date = date;
		this.cantRented = cantRented;
		this.user = user;
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
	
	public String getUser() {
		return user;
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
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public void upCant() {
		cantRented++;
	}
	
	public void showMovies() {
		System.out.println("Nombre: "+name);
		System.out.println("Distribuidor: "+distributor);
		System.out.println("Fecha: "+date);
		if (user == null) System.out.println("Disponible: Si");
		else System.out.println("Disponible: No");
		System.out.println("Veces rentada: "+cantRented);
		System.out.println("ID: "+id+"\n");
	}
}
