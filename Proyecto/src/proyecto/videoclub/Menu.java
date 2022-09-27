package proyecto.videoclub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;

public class Menu {
	private BufferedReader reader;
	private int resp;
	
	public Menu() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		resp = 0;
	}
	
	public void principalMenu(ArrayList<Movie> catalogueM, Hashtable<String,Client>listC) throws IOException{
		System.out.println("MENU PRINCIPAL");
		System.out.println("1) Menu Clientes");
		System.out.println("2) Menu Catalogo Peliculas");
		System.out.println("3) Up Cant");
		System.out.println("Otherwise: Salir");
		resp = Integer.parseInt(reader.readLine());
		
		switch (resp){
		case 1: menuClient(catalogueM, listC); break;
		case 2: menuCatalogue(catalogueM, listC); break;
		case 3: catalogueM.get(799).upCant();
		default: System.out.println("Saliendo...\n"); return;
		}
		principalMenu(catalogueM, listC);
	}//End menuPrincipal
	

	// MENU CLIENTE
	public void menuClient(ArrayList<Movie> catalogueM, Hashtable<String,Client>listC) throws IOException{
		System.out.println("CLIENTE - QUE DESEA HACER?");
		System.out.println("1) Registrarse como cliente");
		System.out.println("2) Buscar cliente");
		System.out.println("3) Mostrar peliculas de cliente");
		System.out.println("4) Arrendar pelicula");
		System.out.println("5) Devolver pelicula");
		System.out.println("Otherwise: Salir");
		resp = Integer.parseInt(reader.readLine());
		
		switch (resp){
		case 1: insertClient(listC); 
				break;
		
		case 2: Client sC = searchClient(listC); 
				if (sC != null) sC.showClient();
				else System.out.println("Cliente no existente");
				break;
		
		case 3: showClientMovies(listC);
				break;
				
		case 4: addMovie(listC, catalogueM);
				break;
		
		case 5: Client cc = searchClient(listC); 
				if (cc != null) {
					deleteMovie(cc);
				}
				else System.out.println("Cliente no existente");
				break;
		
		default: System.out.println("Saliendo...\n"); break;
		}
	}//End menuCliente
	
	public void showClientMovies(Hashtable<String,Client>listC) throws IOException {
		Client cc = searchClient(listC);
		cc.showClientMovies();
		return;
	}
	
	
	public void insertClient(Hashtable<String,Client>listC) throws IOException{
		String insertedName;
		String insertedRut;
	
		Client c = new Client();
		System.out.println("Ingrese su nombre");
		insertedName = reader.readLine();
		System.out.println("Ingrese su rut");
		insertedRut = reader.readLine();
		
		if (listC.containsKey(insertedRut)) {
			System.out.println("Rut ya existente");
			return;
		}
		c.setClient(insertedName, insertedRut);
		listC.put(insertedRut, c);
	}
	
	public Client searchClient(Hashtable<String,Client>listC) throws IOException{
		String insertedRut;
		System.out.println("Ingrese rut");
		insertedRut = reader.readLine();
		Client c = listC.get(insertedRut);
		return c;
	}
	
	public void addMovie(Hashtable<String,Client>listC, ArrayList<Movie> catalogueM) throws IOException{
		Client c = searchClient(listC);
		
		if (c != null) {
			System.out.println("Que pelicula desea rentar?");
			String searchedMovie = reader.readLine();
			Movie mov = searchMovie(catalogueM, searchedMovie);
			if (mov != null)c.addClientMovie(mov);
		}
	}
	
	public void deleteMovie(Client cc) throws IOException{
		System.out.println("Que pelicula desea devolver?");
		int ide= Integer.parseInt(reader.readLine());
		cc.deleteMovie(ide);
	}
	
	// MENU CATALOGO
	public void menuCatalogue(ArrayList<Movie> catalogueM, Hashtable<String,Client>listC) throws IOException{
		System.out.println("CATALOGO - QUE DESEA HACER?");
		System.out.println("1) Mostrar todas las peliculas");
		System.out.println("2) Buscar pelicula");
		System.out.println("Otherwise: Salir");
		resp = Integer.parseInt(reader.readLine());
		
		switch (resp){
		case 1:	showCatalogue(catalogueM);
				break;
				
		case 2: System.out.println("Ingrese nombre de pelicula");
				String searchedMovie = reader.readLine();
				Movie movie = searchMovie(catalogueM, searchedMovie);
				if(movie!=null) {
					movie.showMovies();				
				}
				else System.out.println("Pelicula no encontrada");
				break;
		
		default: System.out.println("Saliendo...\n"); break;
		}
	}//End menuCatalogo
	
	
	public void showCatalogue(ArrayList<Movie> catalogueM){
		Movie p;
		for (int i = 0 ; i < 800 ; i+=1) {
			p = catalogueM.get(i);
			p.showMovies();
		}
	}
	
	public Movie searchMovie2(ArrayList<Movie> catalogueM, String searchedMovie){
		Movie mov = null;
		int lng = catalogueM.size(); 
			for (int i = 0 ; i < lng ; i+=1) {
				mov = catalogueM.get(i);
				if (mov.getName().equals(searchedMovie)) return mov;
			
			}
			return null;
	}
	
	public Movie searchMovie2(ArrayList<Movie> catalogueM, int searchedMovie){
		Movie mov = null;
		int lng = catalogueM.size(); 
			for (int i = 0 ; i < lng ; i+=1) {
				mov = catalogueM.get(i);
				if(mov.getId() == searchedMovie) return mov;
			}
		return null;
	}

	public Movie searchMovie(ArrayList<Movie>catalogueM, String sMov) {
		try {
			int searchedMovie = Integer.parseInt(sMov);
			return searchMovie2(catalogueM, searchedMovie);
		}
		catch(Exception e) {
			String searchedMovie = sMov;
			return searchMovie2(catalogueM, searchedMovie);
		}
	}
	
}//END CLASS
