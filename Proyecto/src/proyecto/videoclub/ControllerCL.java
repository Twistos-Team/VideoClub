package proyecto.videoclub;

import java.util.ArrayList;

public class ControllerCL {
	public void showClientMovies(ArrayList<Movie>lst) {
		int sz = lst.size();
		for (int i = 0 ; i < sz ; i+=1) {
			lst.get(i).showMovies();
		}
	}
	
	public void deleteMovie (ArrayList<Movie>lst, String sMov) {
		Movie mv = searchMovie(lst, sMov);
		if (mv != null) {
			lst.remove(mv);
			mv.setAvailable(true);
			System.out.println("Pelicula devuelta\n");
		}
		else System.out.println("Pelicula no adquirida\n");
	}
	
	public void addClientMovie(ArrayList<Movie>movies, Movie mov, int cant) {
		movies.add(cant, mov);
	}
	
	public void showCatalogue(ArrayList<Movie> cat){
		Movie p;
		for (int i = 0 ; i < 799 ; i+=1) {
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
	
	public void isInt(String xd) throws NotIntegerException {
		try {
			Integer.parseInt(xd);
		}
		catch(Exception ex) {
			throw new NotIntegerException();
		}
	}
	
	public Movie searchMovie(ArrayList<Movie>list, String sMov) {
		Movie mov = null;
		System.out.println(sMov);
		try {
			isInt(sMov);
			int searchedMovie = Integer.parseInt(sMov);
			int sz = list.size(); 
			for (int i = 0 ; i < sz ; i+=1) {
				mov = list.get(i);
				if (mov.getId() == searchedMovie) return mov;
			}
		}
		catch(NotIntegerException e) {
			String space = " ";
			sMov = sMov+space;
			mov = searchMovie2(list, sMov);
			return mov;
		}
		return null;
	}
	
}
