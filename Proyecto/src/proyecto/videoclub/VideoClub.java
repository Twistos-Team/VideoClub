package proyecto.videoclub;
import java.util.*;
import java.io.*;
public class VideoClub {
	
	public static void main(String[] args) throws IOException {
		Menu menu = new Menu();
		
		ArrayList<Movie> catalogueM = new ArrayList<Movie>();
		Hashtable<String,Client> listC = new Hashtable<String,Client>(); 
		
		readTxt(catalogueM);
		
		menu.principalMenu(catalogueM, listC);
		System.out.println("Gracias :)");
	}//END MAIN
	
	public static void readTxt(ArrayList<Movie> catalogueM) throws IOException {
		BufferedReader txtReader = new BufferedReader(new FileReader("movies.csv"));
		String lineText = null;
		int i = 0; 
		
		while ((lineText = txtReader.readLine()) != null) {
			String[] arr = lineText.split(",");
			Movie p = new Movie(arr[0], arr[1],i);
			catalogueM.add(i,p);
			i += 1;
		}
		txtReader.close();
	}

}//END CLASS