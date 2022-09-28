package proyecto.videoclub;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class VideoClub {
	
	public static void main(String[] args) throws IOException {
		Menu menu = new Menu();
		
		ArrayList<Movie> catalogueM = new ArrayList<Movie>();
		Hashtable<String,Client> listC = new Hashtable<String,Client>(); 
		TxtManager csvM = new TxtManager();
		
		// Importar
		csvM.readTxtMov(catalogueM);
		csvM.readTxtClt(listC);
		csvM.addAllMovies(catalogueM, listC);
		
		menu.principalMenu(catalogueM, listC);
		
		// Exportar
		csvM.writeTxtMov(catalogueM);
		csvM.writeTxtClt(listC);
		
		catalogueM.clear();
		listC.clear();
		System.out.println("Gracias :)");
	}//END MAIN

}//END CLASS