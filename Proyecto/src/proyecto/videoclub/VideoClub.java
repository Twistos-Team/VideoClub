package proyecto.videoclub;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class VideoClub {
	
	public static void main(String[] args) throws IOException {
		Menu menu = new Menu();
		
		ArrayList<Movie> catalogueM = new ArrayList<Movie>();
		Hashtable<String,Client> listC = new Hashtable<String,Client>(); 
		
		CSVManager csvM = new CSVManager();
		csvM.readCsvMov(catalogueM);
		
		menu.principalMenu(catalogueM, listC);
		
		csvM.writeCsvMov(catalogueM);
		
		catalogueM.clear();
		listC.clear();
		System.out.println("Gracias :)");
	}//END MAIN

}//END CLASS