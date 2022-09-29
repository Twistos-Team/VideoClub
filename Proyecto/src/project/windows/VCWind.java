package project.windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import proyecto.videoclub.Client;
import proyecto.videoclub.ControllerCL;
import proyecto.videoclub.Movie;
import proyecto.videoclub.TxtManager;
import java.awt.Font;

@SuppressWarnings("unused")
public class VCWind {

	private JFrame VcWindow;
	private JPanel content;
	private JButton ClientMenu;
	private JButton MovieMenu;
	private JButton SaveChangesButton;
	
	// Para ejecutar el programa 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ArrayList<Movie> movs = new ArrayList<Movie>();
				Hashtable<String, Client> clts = new Hashtable<String, Client>();
				try {
					TxtManager txtM = new TxtManager();
					txtM.readTxtMov(movs);
					txtM.readTxtClt(clts);
					txtM.addAllMovies(movs, clts);
				}
				catch(IOException ex) {
					ex.printStackTrace();
				}
				
				
				try {
					VCWind window = new VCWind(movs, clts);
					window.VcWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VCWind(ArrayList<Movie> movs, Hashtable <String, Client>clts) {
		initialize(movs, clts);
		
		
		MainPanel sP = new MainPanel();
		sP.setSize(600, 400);
		sP.setLocation(0,0);
		
		content.removeAll();
		content.add(sP, BorderLayout.CENTER);
		content.revalidate();
		content.repaint();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Movie> movs, Hashtable <String, Client>clts) {

		
		initComponents();
		createEvents(movs, clts);
	}

	
	//////////////////////////////////////////////
	public void initComponents() {
		VcWindow = new JFrame();
		VcWindow.setTitle("VideoClub - Twistos");
		VcWindow.setBounds(100, 100, 800, 600);
		VcWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ClientMenu = new JButton("Menu Clientes");
		ClientMenu.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		
		MovieMenu = new JButton("Menu Películas");
		MovieMenu.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		
		content = new JPanel();
		
		SaveChangesButton = new JButton("Guardar Cambios");
	
		SaveChangesButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
	
		GroupLayout groupLayout = new GroupLayout(VcWindow.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(content, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(ClientMenu)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(MovieMenu)
							.addPreferredGap(ComponentPlacement.RELATED, 364, Short.MAX_VALUE)
							.addComponent(SaveChangesButton, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ClientMenu)
						.addComponent(MovieMenu)
						.addComponent(SaveChangesButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(content, GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE))
		);
		VcWindow.getContentPane().setLayout(groupLayout);
		
	}
	
	
	////////////////////////////////////////////////////////////
	public void createEvents(ArrayList<Movie> movs, Hashtable <String, Client>clts) {
		
		// CLIENT MENU
		ClientMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientMenu clMenu = new ClientMenu(movs, clts);
				clMenu.setSize(700,500);
				clMenu.setLocation(0,0);
				
				content.removeAll();
				content.add(clMenu, BorderLayout.CENTER);
				content.revalidate();
				content.repaint();
			}
		});
		
		// MOVIE MENU
		MovieMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MovieMenu mvMenu = new MovieMenu(movs, clts);
				mvMenu.setSize(700,500);
				mvMenu.setLocation(0,0);
				
				content.removeAll();
				content.add(mvMenu, BorderLayout.CENTER);
				content.revalidate();
				content.repaint();
			}
		
			
		});
		
		SaveChangesButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				TxtManager txtM = new TxtManager();
					try {
						txtM.writeTxtClt(clts);
						txtM.writeTxtMov(movs);
					} catch (IOException e1) {
					}
			}
		});
	}
}

