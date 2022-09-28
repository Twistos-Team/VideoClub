package proyecto.videoclub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;

import project.exceptions.NotIntException;
import project.exceptions.ValidRutException;

public class Menu {
	private BufferedReader reader;
	private int resp;
	private ControllerCL ctr = new ControllerCL();
	
	public Menu() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		resp = 0;
	}
	
	// MENU PRINCIPAL
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
		System.out.println("\nCLIENTE - QUE DESEA HACER?");
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
				else System.out.println("Cliente no existente\n");
				break;
		
		case 3: showClientMovies(listC);
				break;
				
		case 4: addMovie(listC, catalogueM);
				break;
		
		case 5: Client cc = searchClient(listC); 
				if (cc != null)
					deleteMovie(cc);
				else System.out.println("Cliente no existente\n");
				break;
		
		default: System.out.println("Saliendo...\n"); break;
		}
	}//End menuCliente
	
	public void showClientMovies(Hashtable<String,Client>listC) throws IOException {
		Client cc = searchClient(listC);
		if (cc != null) cc.showClientMovies();
		else System.out.println("Cliente no existente\n");
		return;
	}
	
	public void insertClient(Hashtable<String,Client>listC) throws IOException{
		try {
			String insertedName;
			String insertedRut;
			Client c = new Client();
			System.out.println("Ingrese su nombre");
			insertedName = reader.readLine();
			System.out.println("Ingrese su rut");
			insertedRut = reader.readLine();
		
			ctr.isInt(insertedRut);
			ctr.invalidRut(insertedRut);
			
			if (listC.containsKey(insertedRut)) {
				System.out.println("Rut ya existente");
				return;
			}
			
			c.setClient(insertedName, insertedRut);
			listC.put(insertedRut, c);
			System.out.println("Cliente registrado\n");
			
		}
		catch(NotIntException ix) {
			System.out.println("Rut no valido\nNo es un numero\n");
		}
		catch(ValidRutException rx) {
			System.out.println("Rut no valido\nNo cumple cantidad de digitos\n");
		}
	}
	
	public Client searchClient(Hashtable<String,Client>listC) throws IOException{
		System.out.println("Ingrese su rut");
		String insertedRut = reader.readLine();
		System.out.println("\n");
		Client c = ctr.searchClient(listC, insertedRut);
		return c;
	}
	
	public void addMovie(Hashtable<String,Client>listC, ArrayList<Movie> catalogueM) throws IOException{
		Client c = searchClient(listC);
		
		if (c != null) {
			System.out.println("Que pelicula desea rentar?");
			String searchedMovie = reader.readLine();
			Movie mov = ctr.searchMovie(catalogueM, searchedMovie);
			
			if (mov == null) {
				System.out.println("Pelicula no existe");
				return;
			}
			if (mov.getUser() != null) {
				System.out.println("Pelicula no disponible");
				return;
			}
			c.addClientMovie(mov);
			mov.setUser(c.getRut());
		}
	}
	
	public void deleteMovie(Client cc) throws IOException{
		System.out.println("Que pelicula desea devolver?");
		String sMov= reader.readLine();
		cc.deleteMovie(sMov);
		
	}
	
	// MENU CATALOGO
	// MENU CATALOGO
	public void menuCatalogue(ArrayList<Movie> catalogueM, Hashtable<String,Client>listC) throws IOException{
		System.out.println("\nCATALOGO - QUE DESEA HACER?");
		System.out.println("1) Mostrar todas las peliculas");
		System.out.println("2) Buscar pelicula");
		System.out.println("Otherwise: Salir");
		resp = Integer.parseInt(reader.readLine());
		
		switch (resp){
		case 1:	ctr.showCatalogue(catalogueM);
				break;
				
		case 2: System.out.println("Ingrese nombre de pelicula");
				String searchedMovie = reader.readLine();
				Movie movie = ctr.searchMovie(catalogueM, searchedMovie);
				if(movie!=null) {
					movie.showMovies();				
				}
				else System.out.println("Pelicula no encontrada");
				break;
		
		default: System.out.println("Saliendo...\n"); break;
		}
	}//End menuCatalogo
	
}//END CLASS
