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
	private JTable table;
	DefaultTableModel userTable;
	UserController userController;
	

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
	//	loadUserTable();
		DefaultTableModel data = new DefaultTableModel();
		data.setColumnIdentifiers(new String[]{"id", "Handle", "name"});
		ArrayList<User> users = userController.getAllUsers();
		for (User u : users) {
		data.addRow(new String[]{u.getUserIdAsString(), u.getHandle(), u.getName()});
		}
		
		table = new JTable();
		table.setModel(data);
		scrollPane.setViewportView(table);
		
	}

//	private void loadUserTable() {
//		ArrayList<User> users = userController.getAllUsers();
//		for (User u : users) {
//			userTable.addRow(new Object[] { u.getUserID(), u.getHandle(),
//					u.getName(), });
//		}
//		userTable.newDataAvailable(null);
//	}
}
