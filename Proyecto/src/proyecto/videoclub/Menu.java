package proyecto.videoclub;

import java.util.*;
import java.io.*;

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
		System.out.println("Otherwise: Salir");
		resp = Integer.parseInt(reader.readLine());
		
		switch (resp){
		case 1: menuClient(catalogueM, listC); break;
		case 2: menuCatalogue(catalogueM, listC); break;
		default: System.out.println("Saliendo...\n"); return;
		}
		principalMenu(catalogueM, listC);
	}//End menuPrincipal
	
	

	// MENU CLIENTE
	public void menuClient(ArrayList<Movie> catalogueM, Hashtable<String,Client>listC) throws IOException{
		System.out.println("CLIENTE - QUE DESEA HACER?");
		System.out.println("1) Registrarse como cliente");
		System.out.println("2) Mostrar cliente");
		System.out.println("3) Mostrar peliculas de cliente");
		System.out.println("4) Arrendar pelicula");
		System.out.println("5) Devolver pelicula");
		System.out.println("Otherwise: Salir");
		resp = Integer.parseInt(reader.readLine());
		
		switch (resp){
		case 1: insertClient(listC); break;
		
		case 2: Client sC = searchClient(listC); 
				if (sC != null) sC.showClient();
				else System.out.println("Cliente no existente");
				break;
		
		case 3: showClientMovies(listC); break;
				
		case 4: addMovie(listC, catalogueM); break;
		
		case 5: deleteMovie(); break;
		
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
		int lng = catalogueM.size(); 
		
		if (c != null) {
			System.out.println("Que pelicula deseas rentar");
			String searchedMovie = reader.readLine();
			for (int i = 0 ; i < lng ; i+=1) {
				Movie mov = catalogueM.get(i);
				if (mov.getName().equals(searchedMovie)){
					c.setClientMovie(mov);
				}
			}
		}
	}
	
	public void deleteMovie() {
		return;
	}
	
	// MENU CATALOGO
	public void menuCatalogue(ArrayList<Movie> catalogueM, Hashtable<String,Client>listC) throws IOException{
		System.out.println("CATALOGO - QUE DESEA HACER?");
		System.out.println("1) Mostrar todas las peliculas");
		System.out.println("2) Buscar pelicula por nombre");
		System.out.println("3) Buscar pelicula por ID");
		System.out.println("Otherwise: Salir");
		resp = Integer.parseInt(reader.readLine());
		
		switch (resp){
		case 1:	showCatalogue(catalogueM);
				break;
		case 2: break;
		default: System.out.println("Saliendo...\n"); break;
		}
	}//End menuCatalogo
	
	
	public void showCatalogue(ArrayList<Movie> catalogueM) {
		Movie p;
		for (int i = 0 ; i < 800 ; i+=1) {
			p = catalogueM.get(i);
			p.showMovies();
		}
	}

}//END CLASS
