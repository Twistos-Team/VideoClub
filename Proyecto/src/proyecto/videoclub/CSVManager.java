package proyecto.videoclub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class CSVManager {
	static String MOVIES = "movies.txt";
	static String CLIENTS = "clients.txt";
	
	public void readCsvMov(ArrayList<Movie> cat) throws IOException {
		try {
			File mvs = new File(MOVIES);
			FileReader fr = new FileReader(mvs);
			BufferedReader fileReader = new BufferedReader(fr);
			
			String lineText = null;
			int i = 0; 
		
			while ((lineText = fileReader.readLine()) != null) {
				String[] arr = lineText.split(",");
				Movie p = new Movie(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]), arr[4],i);
				cat.add(i,p);
				i += 1;
			}
			fileReader.close();
			fr.close();
			//System.out.println("Imported OK\n");
		}
		catch(Exception ex) {
			//System.out.println("Error File Not Found\n");
		}
	}
	
	public void writeCsvMov(ArrayList<Movie> cat) {
		try {
			File file = new File(MOVIES);
			file.delete();
			File nw = new File(MOVIES);
			nw.createNewFile();
			
			FileWriter fw = new FileWriter(nw, true);
			BufferedWriter fileWriter = new BufferedWriter(fw);
			PrintWriter wrt = new PrintWriter(fileWriter);
			
			Movie mm = null;
			int i = 0;
			while (i < 800){
				mm = cat.get(i);
				wrt.write(mm.getName()+","+mm.getDistributor()+","+mm.getDate()+","+mm.getCantR()+","+mm.getUser());
				if (i != 799) wrt.write("\n");
				i++;
			}
			
			//System.out.println("Exported OK");
			wrt.close();
			fileWriter.close();
			fw.close();
		}
		catch(IOException ex) {
			//System.out.println("Error Not Exported");
		}
	}

	public void readCsvClt(Hashtable<String, Client> map) {
		try {
			File txt = new File(CLIENTS);
			FileReader fr = new FileReader(txt);
			BufferedReader fReader = new BufferedReader(fr);
			String lineText = null;
			
			while ( (lineText = fReader.readLine()) != null) {
				String[] arr = lineText.split(",");
				Client clt = new Client(arr[0],arr[1],Integer.parseInt(arr[2])); 
				map.put(arr[1], clt);
			}
			fReader.close();
			fr.close();
		}
		catch(Exception ex) {
		}
	}
	
	public void writeCsvClt(Hashtable<String, Client>map) throws IOException{
		File f = new File(CLIENTS);
		f.delete();
		File nw = new File(CLIENTS);
		nw.createNewFile();
		
		FileWriter fw = new FileWriter(nw, true);
		BufferedWriter fileWriter = new BufferedWriter(fw);
		PrintWriter wrt = new PrintWriter(fileWriter); 
		
		Enumeration<String> kys= map.keys();
		Client cc = null;
		while (kys.hasMoreElements()) {
			cc = map.get(kys.nextElement());
			wrt.write(cc.getName()+","+cc.getRut()+","+cc.getCantMovies()+"\n");
		}
		
		wrt.close();
		fileWriter.close();
	}

	public void addAllMovies(ArrayList<Movie> cat, Hashtable<String, Client> map) {
		int sz = cat.size();
		for (int i = 0 ; i < sz ; i++) {
			String usr = cat.get(i).getUser();
			
			if (map.get(usr) != null) {
				map.get(usr).addClientMovie(cat.get(i));
			}
		}
	}
}