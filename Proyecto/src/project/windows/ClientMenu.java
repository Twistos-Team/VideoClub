package project.windows;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import project.exceptions.NotIntException;
import project.exceptions.ValidRutException;
import proyecto.videoclub.Client;
import proyecto.videoclub.ControllerCL;
import proyecto.videoclub.Movie;


@SuppressWarnings("serial")
public class ClientMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public ClientMenu(ArrayList<Movie> movs, Hashtable <String, Client>clts) {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel titleLabel = new JLabel("MENU CLIENTE");
		titleLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 60));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		// REGISTRAR CLIENTE
		JButton RegisterButton = new JButton("Registrarse");
		RegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControllerCL ctr = new ControllerCL();
				
					String name = JOptionPane.showInputDialog("Ingrese Nombre");
					if (name == null) return;
					
					String rut = JOptionPane.showInputDialog("Ingrese RUT");		
					if (rut == null) return;
										
					Client cc = new Client();
			
					ctr.isInt(rut);
					ctr.invalidRut(rut);
				
					if (clts.containsKey(rut)) {
						JOptionPane.showMessageDialog(null, "Cliente ya existente");
						return;
					}
					cc.setClient(name, rut);
					clts.put(rut, cc);
					JOptionPane.showMessageDialog(null, "Cliente registrado");
					
				}catch(NotIntException ix) {
					JOptionPane.showMessageDialog(null, "RUT no válido\nFormato incorrecto");
				}
				catch(ValidRutException rx) {
					JOptionPane.showMessageDialog(null, "RUT no válido\nNo cumple con cantidad de dígitos");
				}
			}
		});
		RegisterButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		
		
		// BUSCAR CLIENTE
		JButton searchClButton = new JButton("Buscar Cliente");
		searchClButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inp = JOptionPane.showInputDialog("Ingrese RUT");
				
				if (inp == null) {
					return;
				}
				
				ControllerCL ctr = new ControllerCL();
				Client cc = ctr.searchClient(clts, inp);
				
				if (cc == null) {
					JOptionPane.showMessageDialog(null, "Cliente no encontrado");
					return;
				}
				String outp = "Cliente buscado\n\nNombre: "+cc.getName()+"\nRUT: "+cc.getRut();
				JOptionPane.showMessageDialog(null, outp);
			}
		});
		searchClButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		
		
		// ARRENDAR PELICULA
		JButton RentMovieButton = new JButton("Arrendar Película");
		RentMovieButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inp = JOptionPane.showInputDialog("Ingrese RUT");
				
				if (inp == null) {
					return;
				}
				
				ControllerCL ctr = new ControllerCL();
				Client c = ctr.searchClient(clts, inp);
				
				if (c != null) {
					
					String searchedMovie = JOptionPane.showInputDialog("Nombre/ID");
					if (searchedMovie == null) return;
					
					Movie mov = ctr.searchMovie(movs, searchedMovie);
					
					if (mov == null) {
						JOptionPane.showMessageDialog(null, "Película no existente");
						return;
					}
					if (mov.getUser() != null) {
						JOptionPane.showMessageDialog(null, "Película no disponible");
						return;
					}
					c.addClientMovie(mov);
					mov.setUser(c.getRut());
					JOptionPane.showMessageDialog(null, "Película rentada");
				}
				else JOptionPane.showMessageDialog(null, "Cliente no existente");
			}
		});
		RentMovieButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		
		
		// DEVOLVER PELICULA
		JButton ReturnMovieButton = new JButton("Devolver Película");
		ReturnMovieButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inp = JOptionPane.showInputDialog("Ingrese RUT");
				if (inp == null) {
					return;
				}
				
				ControllerCL ctr = new ControllerCL();
				Client c = ctr.searchClient(clts, inp);
				
				if (c != null) {
					
					String searchedMovie = JOptionPane.showInputDialog("Nombre/ID");
					if (searchedMovie == null) return;
					
					if (c.deleteMovie(searchedMovie)) JOptionPane.showMessageDialog(null, "Pelicula devuelta");
					else JOptionPane.showMessageDialog(null, "Pelicula no devuelta");

				}
				else JOptionPane.showMessageDialog(null, "Cliente no existente");
			}
		});
		ReturnMovieButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		
		
		// MOSTRAR PELICULAS CLIETNES
		JButton ShowAllMoviesButton = new JButton("Mostrar mis Películas");
		ShowAllMoviesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inp = JOptionPane.showInputDialog("Ingrese RUT");
				if (inp == null) {
					return;
				}
				ControllerCL ctr = new ControllerCL();
				Client c = ctr.searchClient(clts, inp);
				
				if (c == null) {
					JOptionPane.showMessageDialog(null, "Cliente no existente");
					return;
				}
				int i = 0;
				Movie mm = null;
				
				while ( (mm = c.getMovie(i)) != null) {				
					String outp = "Nombre: "+mm.getName()+"\nDistribuidor: "+mm.getDistributor()+"\nFecha: "+mm.getDate()+"\nVeces Rentada: "+mm.getCantR();
					outp = outp + "\nID: "+mm.getId();
					
					JOptionPane.showMessageDialog(null, outp);
					i++;
				}
				if (i == 0) JOptionPane.showMessageDialog(null, "No tienes películas arrendadas");
			}
		});
		ShowAllMoviesButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(134)
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 298, Short.MAX_VALUE)
					.addGap(164))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(RentMovieButton, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
							.addComponent(ReturnMovieButton, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(RegisterButton, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
							.addGap(26)
							.addComponent(searchClButton, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)))
					.addGap(41))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(168)
					.addComponent(ShowAllMoviesButton, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(183, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(RegisterButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchClButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(RentMovieButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(ReturnMovieButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(ShowAllMoviesButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(94))
		);
		setLayout(groupLayout);

	}
}
