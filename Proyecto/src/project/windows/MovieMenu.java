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

import proyecto.videoclub.Client;
import proyecto.videoclub.ControllerCL;
import proyecto.videoclub.Movie;

@SuppressWarnings("serial")
public class MovieMenu extends JPanel {
	private ControllerCL ctr = new ControllerCL();
	private JPanel panel;
	
	/**
	 * Create the panel.
	 */
	public MovieMenu(ArrayList<Movie> movs, Hashtable <String, Client>clts) {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblMenuCatalogo = new JLabel("MENU CATALOGO");
		lblMenuCatalogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuCatalogo.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 60));
		
		JButton showAllButton = new JButton("Mostrar Catálogo");
		
		//MOSTRAR CATALOGO
		showAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i;
				int sz = movs.size();
				String outp = "";
				
				for (i = 0 ; i < sz ; i++) {				
					Movie mm = movs.get(i);
					outp = "Nombre: "+mm.getName()+"\nDistribuidor: "+mm.getDistributor()+"\nFecha: "+mm.getDate()+"\nVeces Rentada: "+mm.getCantR();
					outp = outp + "\nID: "+mm.getId();
					String x = mm.getUser();
					if (x == null)
						outp = outp + "\nDisponible: Si\n\n";
					else outp = outp + "\nDisponible: No\n\n";
					
					JOptionPane.showMessageDialog(null, outp);
					
				}
			}
		});
		showAllButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		
		JButton searchMovieButton = new JButton("Buscar Película");
		searchMovieButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inp = JOptionPane.showInputDialog(null, "Nombre/ID");
				
				ControllerCL ctr = new ControllerCL();
				Movie mm = ctr.searchMovie(movs, inp);
				
				if (mm == null) {
					JOptionPane.showMessageDialog(null, "Película no encontrada");
					return;
				}
				String outp = "Pelicula Buscada\n\nNombre: "+mm.getName()+"\nDistribuidor: "+mm.getDistributor()+"\nFecha: "+mm.getDate()+"\nVeces Rentada: "+mm.getCantR();
				outp = outp + "\nID: "+mm.getId();
				String x = mm.getUser();
				if (x == null)
					outp = outp + "\nDisponible: Si";
				else outp = outp + "\nDisponible: No";
				
				
				JOptionPane.showMessageDialog(null, outp);
			}
		});
		searchMovieButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		
		JButton showPopularButton = new JButton("Más popular");
		
		// MAS POPULAR
		showPopularButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerCL ctr = new ControllerCL();
				Movie mm = ctr.popularMovie(movs);
				
				if (mm == null) {
					JOptionPane.showMessageDialog(null, "Película no encontrada");
					return;
				}
				String outp = "Pelicula más Popular\n\nNombre: "+mm.getName()+"\nDistribuidor: "+mm.getDistributor()+"\nFecha: "+mm.getDate()+"\nVeces Rentada: "+mm.getCantR();
				outp = outp + "\nID: "+mm.getId();
				String x = mm.getUser();
				if (x == null)
					outp = outp + "\nDisponible: Si";
				else outp = outp + "\nDisponible: No";
				
				
				JOptionPane.showMessageDialog(null, outp);
			}
		});
		showPopularButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(123)
					.addComponent(lblMenuCatalogo, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(143, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(163)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(searchMovieButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
						.addComponent(showPopularButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
						.addComponent(showAllButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
					.addGap(172))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMenuCatalogo, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(showAllButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(showPopularButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(searchMovieButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(101, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
