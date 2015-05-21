package UILayer;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import CtrLayer.UserController;
import ModelLayer.User;

@SuppressWarnings("serial")
public class ListUsersUI extends JPanel {
	DefaultTableModel userTable;
	UserController userController;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ListUsersUI() {
		userController = new UserController();
		setMinimumSize(new Dimension(383, 386));
		setPreferredSize(new Dimension(383, 386));
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 363, 348);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"id", "handle/alias", "Name"
			}
		));
		scrollPane.setViewportView(table);

	}

	private void loadUserTable() {
		ArrayList<User> users = userController.getAllUsers();
		for (User u : users) {
			userTable.addRow(new Object[] { u.getUserID(), u.getHandle(),
					u.getName(), });
		}
		userTable.newDataAvailable(null);
	}
}
