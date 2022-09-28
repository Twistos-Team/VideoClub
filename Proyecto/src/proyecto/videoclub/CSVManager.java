package proyecto.videoclub;

import java.io.*;
import java.util.ArrayList;

public class CSVManager {
	public String MOVIES = "movies.txt";
	
	public void readCsvMov(ArrayList<Movie> cat) throws IOException {
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(MOVIES));
			String lineText = null;
			int i = 0; 
		
			while ((lineText = fileReader.readLine()) != null) {
				String[] arr = lineText.split(",");
				Movie p = new Movie(arr[0], arr[1], arr[2], i);
				cat.add(i,p);
				i += 1;
			}
			fileReader.close();
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
			
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter(MOVIES, true));
			PrintWriter wrt = new PrintWriter(fileWriter);
			
			Movie mm = null;
			int i = 0;
			while (i < 800){
				mm = cat.get(i);
				wrt.write(mm.getName()+","+mm.getDistributor()+","+mm.getDate()+","+mm.getCantR());
				if (i != 799) wrt.write("\n");
				i++;
			}
			
			//System.out.println("Exported OK");
			
			fileWriter.close();
			wrt.close();
		}
		catch(IOException ex) {
			//System.out.println("Error Not Exported");
		}
	}
}