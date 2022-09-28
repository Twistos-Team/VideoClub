package project.windows;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class MovieMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public MovieMenu() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblMenuCatalogo = new JLabel("MENU CATALOGO");
		lblMenuCatalogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuCatalogo.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 60));
		
		JButton showAllButton = new JButton("Mostrar Catálogo");
		showAllButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		
		JButton searchMovieButton = new JButton("Buscar Película");
		searchMovieButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		
		JButton showAvButton = new JButton("Mostrar Disponibles");
		showAvButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(105)
					.addComponent(lblMenuCatalogo, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(111, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(163)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(searchMovieButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
						.addComponent(showAvButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
						.addComponent(showAllButton, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
					.addGap(172))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMenuCatalogo, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(showAllButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(showAvButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(searchMovieButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
