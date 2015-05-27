package UILayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import CtrLayer.TeamController;
import CtrLayer.TournamentController;
import ModelLayer.Team;
import ModelLayer.Tournament;

import java.util.ArrayList;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class TournamentUI extends JDialog {

	Tournament tournament;

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton btnClose;
	private JTable table;
	private JComboBox<String> cb_team;
	private JLabel lblTournamentstatusinfo;
	private JLabel lblRoundNumberInfo;
	private JLabel lblWinnerteaminfo;
	private JLabel lblWithplayoffinfo;
	private JLabel lblTeamsizeinfo;
	private JLabel lblGamenameinfo;
	private JLabel lblNameinfo;
	private JButton btnAddTeam;
	private JButton btnEnableSignup;
	private JButton btnStartTournament;
	private JButton btnEndTournament;
	private JButton btnAdvanceTournament;

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
		displayTournamentInfo();
		fillTeamCombo();
	}

	private void initialize() {
		setBounds(100, 100, 529, 397);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JPanel panel = new JPanel();

		JLabel lblTournamentStatus = new JLabel("Tournament Status:");

		lblTournamentstatusinfo = new JLabel("tournamentStatusInfo");

		cb_team = new JComboBox<String>();
		cb_team.setFocusTraversalKeysEnabled(false);

		btnAddTeam = new JButton("Add Team");
		btnAddTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Do jack shit.
			}
		});

		btnEnableSignup = new JButton("Enable Signup");

		btnStartTournament = new JButton("Start Tournament");

		btnEndTournament = new JButton("End Tournament");

		btnAdvanceTournament = new JButton("Advance Tournament");

		table = new JTable();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(table, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addComponent(lblTournamentStatus)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblTournamentstatusinfo))
														.addGroup(gl_contentPanel.createSequentialGroup()
																.addComponent(btnEndTournament)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnAdvanceTournament, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																.addGroup(gl_contentPanel.createSequentialGroup()
																		.addComponent(cb_team, 0, 101, Short.MAX_VALUE)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(btnAddTeam, GroupLayout.PREFERRED_SIZE, 9, Short.MAX_VALUE))
																		.addGroup(gl_contentPanel.createSequentialGroup()
																				.addComponent(btnEnableSignup, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(ComponentPlacement.RELATED)
																				.addComponent(btnStartTournament, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))))
																				.addGap(42))
				);
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(6)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblTournamentStatus)
												.addComponent(lblTournamentstatusinfo))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
														.addComponent(cb_team, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(btnAddTeam))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
																.addComponent(btnEnableSignup)
																.addComponent(btnStartTournament))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
																		.addComponent(btnEndTournament)
																		.addComponent(btnAdvanceTournament)))
																		.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
																		.addComponent(table, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
				);

		JLabel lblName = new JLabel("Name:");

		JLabel lblGameName = new JLabel("Game Name:");

		JLabel lblTeamSize = new JLabel("Team Size:");

		JLabel lblWithPlayOff = new JLabel("With Play Off:");

		JLabel lblWinnerTeam = new JLabel("Winner team:");

		JLabel lblRoundNumber = new JLabel("Round Number:");

		JLabel lblTournamentInfo = new JLabel("Tournament Info");

		lblRoundNumberInfo = new JLabel("roundNumberInfo");

		lblWinnerteaminfo = new JLabel("winnerTeamInfo");

		lblWithplayoffinfo = new JLabel("withPlayOffInfo");

		lblTeamsizeinfo = new JLabel("teamSizeInfo");

		lblGamenameinfo = new JLabel("gameNameInfo");

		lblNameinfo = new JLabel("nameInfo");

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTournamentInfo)
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblRoundNumber)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblRoundNumberInfo))
										.addGroup(gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblWinnerTeam)
														.addComponent(lblWithPlayOff)
														.addComponent(lblTeamSize)
														.addComponent(lblGameName)
														.addComponent(lblName))
														.addGap(18)
														.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																.addComponent(lblNameinfo)
																.addComponent(lblGamenameinfo)
																.addComponent(lblTeamsizeinfo)
																.addComponent(lblWithplayoffinfo)
																.addComponent(lblWinnerteaminfo))))
																.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTournamentInfo)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblName)
								.addComponent(lblNameinfo))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblGameName)
										.addComponent(lblGamenameinfo))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblTeamSize)
												.addComponent(lblTeamsizeinfo))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblWithPlayOff)
														.addComponent(lblWithplayoffinfo))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblWinnerTeam)
																.addComponent(lblWinnerteaminfo))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
																		.addComponent(lblRoundNumber)
																		.addComponent(lblRoundNumberInfo))
																		.addGap(30))
				);
		panel.setLayout(gl_panel);
		contentPanel.setLayout(gl_contentPanel);
		{
			buttonPane = new JPanel();

			btnClose = new JButton("Close");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tournament = null;
					System.out.println("Closing Tournament Window");
					dispose();
				}
			});
			btnClose.setActionCommand("Cancel");

			getRootPane().setDefaultButton(btnClose);
		}
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(contentPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
								.addComponent(buttonPane, GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
								.addGap(0))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
				);
		GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
		gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
				.addComponent(btnClose, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
				);
		gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
				.addComponent(btnClose, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
				);
		buttonPane.setLayout(gl_buttonPane);
		getContentPane().setLayout(groupLayout);
	}

	/**
	 * Gets the tournament by the given tournamentName and sets it as a global variable.
	 * @param tournamentName	The tournaments name.
	 */
	private void getTournamentData(String tournamentName) {
		TournamentController tournamentController = new TournamentController();
		ArrayList<Tournament> tournaments = tournamentController.getTournaments();
		boolean found = false;
		for(int i = 0; !found && i < tournaments.size(); i++) {
			if(tournaments.get(i).getName().equals(tournamentName)) {
				found = true;
				this.tournament = tournaments.get(i);
			}
		}
	}

	private void displayTournamentInfo() {
		System.out.println("Tournament Status: " + tournament.getStatus());
		lblTournamentstatusinfo.setText(Tournament.statusToString(tournament.getStatus()));
		lblRoundNumberInfo.setText(Integer.toString(tournament.getRoundNumber()));
		if(tournament.getWinnerTeam() != null) {
			lblWinnerteaminfo.setText(tournament.getWinnerTeam().getName());
		}
		else {
			lblWinnerteaminfo.setText("None yet");
		}
		if(tournament.isWithPlayOff()) {
			lblWithplayoffinfo.setText("Yes");
		}
		else {
			lblWithplayoffinfo.setText("No");
		}
		lblTeamsizeinfo.setText(Integer.toString(tournament.getTeamSize()));
		lblGamenameinfo.setText(tournament.getGameName());
		lblNameinfo.setText(tournament.getName());
	}

	private void fillTeamCombo() {
		try {
			TeamController teamController = new TeamController();
			ArrayList<Team> teams = teamController.getAllTeams();
			for (Team team : teams) {
				cb_team.addItem(team.getName());
			}
		} catch (Exception e) {
			cb_team.addItem("Error");
		}
	}
}
