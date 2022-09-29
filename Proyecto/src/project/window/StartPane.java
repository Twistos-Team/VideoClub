package project.window;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartPane extends JPanel {
	private JButton StartButton;

	/**
	 * Create the panel.
	 */
	public StartPane() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		initialize();

	}
	
	public void initialize() {
		initComponents();
		createEvents();
	}
	
	public void initComponents() {
		
		JLabel StartLabel = new JLabel("Video Club");
		StartLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 70));
		StartLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel WelcomeLabel = new JLabel("Bienvenido!");
		WelcomeLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		WelcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		StartButton = new JButton("Empezar");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(101)
					.addComponent(StartLabel, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addGap(95))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(228)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(StartButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
						.addComponent(WelcomeLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
					.addGap(218))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(StartLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(WelcomeLabel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(116)
					.addComponent(StartButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(91, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	public void createEvents() {
		StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

}
