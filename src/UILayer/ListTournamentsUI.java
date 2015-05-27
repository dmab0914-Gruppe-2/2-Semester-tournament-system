package UILayer;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import CtrLayer.TournamentController;
import ModelLayer.Tournament;

@SuppressWarnings("serial")
public class ListTournamentsUI extends JPanel {
	private JTable table;
	private TournamentController tournamentCtr;

	/**
	 * Create the panel.
	 */
	public ListTournamentsUI() {
		tournamentCtr = new TournamentController();
		setMinimumSize(new Dimension(383, 386));
		setPreferredSize(new Dimension(383, 386));
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 363, 348);
		add(scrollPane);

		DefaultTableModel data = new DefaultTableModel();
		data.setColumnIdentifiers(new String[] { "id", "Name", "Game", "Status" });
		ArrayList<Tournament> tournaments = tournamentCtr.getTournaments();
		for (Tournament t : tournaments) {
			data.addRow(new String[] { t.getIdAsString(), t.getName(),
					t.getGameName(), t.getStatus().toString() });
		}
		table = new JTable();
		table.setEnabled(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(data);
		scrollPane.setViewportView(table);
	}

}
