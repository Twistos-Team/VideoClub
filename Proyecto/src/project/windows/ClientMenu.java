package project.windows;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class ClientMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public ClientMenu() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel titleLabel = new JLabel("MENU CLIENTE");
		titleLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 60));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton RegisterButton = new JButton("Registrarse");
		RegisterButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		
		JButton searchClButton = new JButton("Buscar Cliente");
		searchClButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		
		JButton logInButton = new JButton("Ingresar");
		logInButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(145)
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(153))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(186)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(searchClButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(logInButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(RegisterButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
					.addGap(195))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(RegisterButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(logInButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(searchClButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(23))
		);
		setLayout(groupLayout);

	}

}
