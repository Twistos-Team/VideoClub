package project.window;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PpMenuPane extends JPanel {

	/**
	 * Create the panel.
	 */
	public PpMenuPane() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		initialize();
	}
	
	public void initialize() {
		initComponents();
		createEvents();
	}
	
	/////////////////////////////
	public void initComponents(){
		JLabel PpMenuLabel = new JLabel("Menu Principal");
		PpMenuLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PpMenuLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 60));
		
		JButton ClientMenuButton = new JButton("Menu Clientes");
		ClientMenuButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		
		JButton MovieMenuButton = new JButton("Menu Catalogo");
		MovieMenuButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(99)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(ClientMenuButton, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
							.addComponent(MovieMenuButton))
						.addComponent(PpMenuLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
					.addGap(97))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(PpMenuLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(71)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(ClientMenuButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(MovieMenuButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(199, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	public void createEvents() {
		
	}

}
