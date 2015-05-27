package UILayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import CtrLayer.TournamentController;
import ModelLayer.Tournament;

import java.awt.BorderLayout;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class TournamentUI extends JDialog {

	Tournament tournamnent;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void tournamentUI(String tournamentName) {
		try {
			TournamentUI dialog = new TournamentUI(tournamentName);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TournamentUI(String tournamentName) {
		initialize();
		getTournamentData(tournamentName);
	}

	private void initialize() {
		setBounds(100, 100, 452, 397);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 436, 179);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGap(-10, -10, Short.MAX_VALUE)
				);
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGap(-10, -10, Short.MAX_VALUE)
				);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 335, 436, 23);
			getContentPane().add(buttonPane);

			JButton btnClose = new JButton("Close");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tournamnent = null;
					dispose();
				}
			});
			buttonPane.setLayout(new BorderLayout(0, 0));
			btnClose.setActionCommand("Cancel");
			buttonPane.add(btnClose);

			getRootPane().setDefaultButton(btnClose);
		}
	}

	/**
	 * Gets the tournament by the given tournamentName and sets it as a global variable.
	 * @param tournamentName	The tournaments name.
	 */
	private void getTournamentData(String tournamentName) {
		TournamentController tournamentController = new TournamentController();
		ArrayList<Tournament> tournaments = tournamentController.getTournaments();
		boolean found = false;
		for(int i = 0; !found || i < tournaments.size(); i++) {
			if(tournaments.get(i).getName() == tournamentName) {
				tournamnent = tournaments.get(i);
			}
		}
		//		txtHandle.setText(u.getHandle());
		//		txtName.setText(u.getName());
	}

}