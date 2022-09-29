package project.window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project.windows.MainPanel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.BorderLayout;
import java.awt.CardLayout;

public class VClubFrame extends JFrame {

	private JPanel content;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VClubFrame frame = new VClubFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VClubFrame() {
		setTitle("Video Club - Twistos");
		initialize();
		
		// START PANE
		StartPane sp = new StartPane();
		sp.setSize(600, 400);
		sp.setLocation(0,0);
		content.removeAll();
		content.add(sp, BorderLayout.CENTER);
		content.revalidate();
		content.repaint();
		
		// PRINCIPAL MENU
		PpMenuPane ppm = new PpMenuPane();
		ppm.setSize(600, 400);
		ppm.setLocation(0,0);
		content.removeAll();
		content.add(ppm, BorderLayout.CENTER);
		content.revalidate();
		content.repaint();
	}
	
	public void initialize() {
		initComponents();
		createEvents();
	}
	
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		content = new JPanel();
		content.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(content);
		content.setLayout(new CardLayout(0, 0));
	}
	
	public void createEvents() {
		
	}

}
