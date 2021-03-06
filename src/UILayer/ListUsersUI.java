package UILayer;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import CtrLayer.UserController;
import ModelLayer.User;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class ListUsersUI extends JPanel {
	private JTable table;
	private static UserController userController;
	private static DefaultTableModel data;

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

		data = new DefaultTableModel();
		data.setColumnIdentifiers(new String[] { "id", "Handle", "name" });
		ArrayList<User> users = userController.getAllUsers();
		for (User u : users) {
			data.addRow(new String[] { u.getUserIdAsString(), u.getHandle(),
					u.getName() });
		}
		table = new JTable();
		table.setEnabled(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(data);
		scrollPane.setViewportView(table);
	}

	public static void updateData(){
		int rowCount = data.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--)
			data.removeRow(i);

		ArrayList<User> users = userController.getAllUsers();
		for (User u : users) {
			data.addRow(new String[] { u.getUserIdAsString(), u.getHandle(),
					u.getName() });
		}

	}
}
