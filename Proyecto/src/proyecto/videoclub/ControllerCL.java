package proyecto.videoclub;

import java.util.ArrayList;
import java.util.Hashtable;

import project.exceptions.NotIntException;
import project.exceptions.ValidRutException;

public class ControllerCL {
	public void showClientMovies(ArrayList<Movie>lst) {
		int sz = lst.size();
		for (int i = 0 ; i < sz ; i+=1) {
			lst.get(i).showMovies();
		}
	}
	
	public Client searchClient(Hashtable<String,Client>map, String rut) {
		Client cc = null;
		if (map.containsKey(rut)) {
			cc = map.get(rut);
			return cc;
		}
		return null;
	}
	
	public boolean deleteMovie (ArrayList<Movie>lst, String sMov) {
		Movie mv = searchMovie(lst, sMov);
		if (mv != null) {
			lst.remove(mv);
			mv.setUser(null);
			return true;
		}
		return true;
	}
	
	public void addClientMovie(ArrayList<Movie>movies, Movie mov, int cant) {
		movies.add(cant, mov);
		
	}
	
	public void showCatalogue(ArrayList<Movie> cat){
		Movie p;
		int sz = cat.size();
		for (int i = 0 ; i < sz ; i+=1) {
			p = cat.get(i);
			p.showMovies();
		}
	}
	
	public Movie searchMovie2(ArrayList<Movie> list, String sMov){
		Movie move = null;
		int sz = list.size(); 
		for (int i = 0 ; i < sz ; i++) {
			move = list.get(i);
			if (move.getName().equals(sMov)) {
				return move;
			}
		}
		return null;
	}
	
	public void invalidRut(String rut) throws ValidRutException{
		if(rut.length() < 7 || rut.length() > 8)
			throw new ValidRutException();
	}
	
	public void isInt(String x) throws NotIntException {
		try {
			Integer.parseInt(x);
		}
		catch(Exception ex) {
			throw new NotIntException();
		}
	}
	
	
	public Movie searchMovie(ArrayList<Movie>list, String sMov) {
		Movie mov = null;
		try {
			isInt(sMov);
			int searchedMovie = Integer.parseInt(sMov);
			int sz = list.size(); 
			for (int i = 0 ; i < sz ; i+=1) {
				mov = list.get(i);
				if (mov.getId() == searchedMovie) return mov;
			}
		}
		catch(NotIntException e) {
			String space = " ";
			sMov = sMov+space;
			mov = searchMovie2(list, sMov);
			return mov;
		}
		return null;
	}
	
}
