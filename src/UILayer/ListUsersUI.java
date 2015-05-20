package UILayer;

import java.awt.Dimension;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class ListUsersUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public ListUsersUI() {
		setMinimumSize(new Dimension(383, 386));
		setPreferredSize(new Dimension(383, 386));
		setLayout(new BorderLayout(0, 0));
		
		JLayeredPane layeredPane = new JLayeredPane();
		add(layeredPane);
		layeredPane.setMinimumSize(new Dimension(383, 386));
		layeredPane.setPreferredSize(new Dimension(383, 386));

	}

}
