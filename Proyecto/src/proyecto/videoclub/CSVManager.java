package proyecto.videoclub;

import java.io.*;
import java.util.ArrayList;

public class CSVManager {
	static String MOVIES = "movies.csv";
	static String TEMPM = "tempm.csv";
	
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
			System.out.println("Imported OK\n");
			fileReader.close();
		}
		catch(FileNotFoundException ex) {
			System.out.println("Error File Not Found\n");
		}
	}
	
	public void writeCsvMov(ArrayList<Movie> cat) {
		try {
			createTemp(TEMPM);
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter(TEMPM, true));
			PrintWriter wrt = new PrintWriter(fileWriter);
			
			Movie mm = null;
			int i = 0;
			while (i < 800){
				mm = cat.get(i);
				wrt.println(mm.getName()+","+mm.getDistributor()+","+mm.getDate()+","+mm.getCantR());
				i++;
			}
			
			editFiles(MOVIES, TEMPM);
			System.out.println("Exported OK\n");
			wrt.flush();
			wrt.close();
		}
		catch(IOException ex) {
			System.out.println("Error Not Exported");
		}
	}
	
	public void editFiles(String mvs, String tmp) throws IOException{
		File oldf = new File(mvs);
		oldf.delete();
		
		renameFile(TEMPM, MOVIES);
		createTemp(TEMPM);
		return;
	}
	
	public void renameFile(String tmp, String mvs){
		File dump = new File(mvs);
		File t = new File(tmp);
		
		if (t.renameTo(dump)) System.out.println("Renamed\n");
		else System.out.println("Not Renamed\n");
	}
	
	public void createTemp(String tmp)throws IOException {
		File t = new File(tmp);
		
		if (t.createNewFile()) System.out.println("File Created\n");
		else System.out.println(" File Not Created\n");
	}
		
}
