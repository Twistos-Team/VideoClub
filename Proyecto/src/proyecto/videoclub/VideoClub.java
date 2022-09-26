
package proyecto.videoclub;
import java.util.*;
import java.io.*;
public class VideoClub {
	
	public static void main(String[] args) throws IOException {
		Menu menu = new Menu();
		
		ArrayList<Movie> catalogueM = new ArrayList<Movie>();
		Hashtable<String,Client> listC = new Hashtable<String,Client>(); 
		
		readCsv(catalogueM);
		
		menu.principalMenu(catalogueM, listC);
		System.out.println("Gracias :)");
	}//END MAIN
	
	public static void readCsv(ArrayList<Movie> catalogueM) throws IOException {
		BufferedReader csvReader = new BufferedReader(new FileReader("movies.csv"));
		String lineText = null;
		int i = 0; 
		
		while ((lineText = csvReader.readLine()) != null) {
			String[] arr = lineText.split(",");
			Movie p = new Movie(arr[0], arr[1],i);
			catalogueM.add(i,p);
			i += 1;
		}
		csvReader.close();
	}

}//END CLASS