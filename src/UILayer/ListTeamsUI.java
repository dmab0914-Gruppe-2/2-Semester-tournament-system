package UILayer;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ListTeamsUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public ListTeamsUI() {
		setMinimumSize(new Dimension(383, 386));
		setPreferredSize(new Dimension(383, 386));
		setLayout(new BorderLayout(0, 0));

		JLayeredPane layeredPane = new JLayeredPane();
		add(layeredPane);
		layeredPane.setMinimumSize(new Dimension(383, 386));
		layeredPane.setPreferredSize(new Dimension(383, 386));
	}

}
