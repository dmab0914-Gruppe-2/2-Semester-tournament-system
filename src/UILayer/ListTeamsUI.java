package UILayer;

import java.awt.Dimension;

import javax.swing.JPanel;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import CtrLayer.TeamController;
import CtrLayer.UserController;
import ModelLayer.Team;

import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class ListTeamsUI extends JPanel {
	private static JTable table;
	private static TeamController teamController;
	private static UserController userController;
	static DefaultTableModel data;
	
	/**
	 * Create the panel.
	 */
	public ListTeamsUI() {
		teamController = new TeamController();
		userController = new UserController();
		setMinimumSize(new Dimension(383, 386));
		setPreferredSize(new Dimension(383, 386));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 363, 348);
		add(scrollPane);
		data = new DefaultTableModel();
		data.setColumnIdentifiers(new String[] { "id", "Team Name", "Leader" });
		ArrayList<Team> teams = teamController.getAllTeams();
		for (Team t : teams) {
			data.addRow(new String[] { t.getIdAsString(), t.getName(), userController.findUserNameById(t.getLeader()) });
		}

		table = new JTable();
		table.setEnabled(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(data);
		scrollPane.setViewportView(table);
	}

	public static void updateData() {
		int rowCount = data.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--)
			data.removeRow(i);

		ArrayList<Team> teams = teamController.getAllTeams();
		for (Team t : teams) {
			data.addRow(new String[]{t.getIdAsString(), t.getName(), userController.findUserNameById(t.getLeader())});
		}
	}
}
