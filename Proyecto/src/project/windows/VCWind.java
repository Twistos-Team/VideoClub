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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import proyecto.videoclub.CSVManager;
import proyecto.videoclub.Client;
import proyecto.videoclub.Movie;

public class VCWind {

	private JFrame VcWindow;
	private JPanel content;
	private JButton ClientMenu;
	private JButton MovieMenu;
	private JButton startMenuButton;
	
	// Para ejecutar el programa
	private ArrayList<Movie> movs = new ArrayList<Movie>();
	private Hashtable<String, Client> clts = new Hashtable<String, Client>(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VCWind window = new VCWind();
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
	public VCWind() {
		initialize();
		
		try {
			CSVManager txtM = new CSVManager();
			txtM.readCsvMov(movs);
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
		
		MainPanel mP = new MainPanel();
		mP.setSize(580, 300);
		mP.setLocation(0,0);
		
		
		
		content.removeAll();
		content.add(mP, BorderLayout.CENTER);
		content.revalidate();
		content.repaint();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		initComponents();
		createEvents();
		
	}

	
	//////////////////////////////////////////////
	public void initComponents() {
		VcWindow = new JFrame();
		VcWindow.setTitle("VideoClub - Twistos");
		VcWindow.setBounds(100, 100, 600, 400);
		VcWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ClientMenu = new JButton("Menu Clientes");
		
		MovieMenu = new JButton("Menu Películas");
		
		content = new JPanel();
		
		startMenuButton = new JButton("Inicio");
	
		GroupLayout groupLayout = new GroupLayout(VcWindow.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(content, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(ClientMenu)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(MovieMenu)
							.addPreferredGap(ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
							.addComponent(startMenuButton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ClientMenu)
						.addComponent(MovieMenu)
						.addComponent(startMenuButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(content, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
					.addContainerGap())
		);
		VcWindow.getContentPane().setLayout(groupLayout);
		
	}
	
	
	////////////////////////////////////////////////////////////
	public void createEvents() {
		
		// CLIENT MENU
		ClientMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientMenu clMenu = new ClientMenu();
				clMenu.setSize(580,300);
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
				MovieMenu mvMenu = new MovieMenu();
				mvMenu.setSize(580,300);
				mvMenu.setLocation(0,0);
				
				content.removeAll();
				content.add(mvMenu, BorderLayout.CENTER);
				content.revalidate();
				content.repaint();
			}
		});
		
		// MAIN MENU
		startMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPanel mP = new MainPanel();
				mP.setSize(580, 300);
				mP.setLocation(0,0);
				
				content.removeAll();
				content.add(mP, BorderLayout.CENTER);
				content.revalidate();
				content.repaint();
			}
		});
	}
}
