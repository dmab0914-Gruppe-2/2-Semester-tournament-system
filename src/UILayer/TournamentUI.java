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
import ModelLayer.Match;
import ModelLayer.Team;
import ModelLayer.Tournament;

import java.util.ArrayList;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class TournamentUI extends JDialog {

	Tournament tournament;

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton btnClose;
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

	private TournamentController tournamentController;
	private JComboBox<String> cb_chooseMatch;
	private JLabel lblStatus;

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
		setAlwaysOnTop(true);
		tournamentController = new TournamentController();
		initialize(tournamentName);
		getTournamentData(tournamentName);
		displayTournamentInfo();
		fillTeamCombo();
		fillMatchCombo(tournamentName);
	}

	private void initialize(String tournamentName) {
		setBounds(100, 100, 529, 419);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JPanel panel = new JPanel();

		JLabel lblTournamentStatus = new JLabel("Tournament Status:");

		lblTournamentstatusinfo = new JLabel("tournamentStatusInfo");

		cb_team = new JComboBox<String>();
		cb_team.setFocusTraversalKeysEnabled(false);

		btnAddTeam = new JButton("Add Team");
		btnAddTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTeam(tournamentName);
			}
		});

		btnEnableSignup = new JButton("Enable Signup");
		btnEnableSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enableSignup();
			}
		});

		btnStartTournament = new JButton("Start Tournament");
		btnStartTournament.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startTournament(tournamentName);
			}
		});

		btnEndTournament = new JButton("End Tournament");
		btnEndTournament.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO End Tournament
			}
		});

		btnAdvanceTournament = new JButton("Advance Tournament");
		btnAdvanceTournament.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				advanceTournament(tournamentName);
			}
		});

		JPanel panel_setMatch = new JPanel();

		JSeparator separator = new JSeparator();

		lblStatus = new JLabel("");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel
				.setHorizontalGroup(gl_contentPanel
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_contentPanel
										.createSequentialGroup()
										.addComponent(panel,
												GroupLayout.PREFERRED_SIZE,
												187, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_contentPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPanel
																		.createSequentialGroup()
																		.addGroup(
																				gl_contentPanel
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_contentPanel
																										.createSequentialGroup()
																										.addComponent(
																												btnAdvanceTournament,
																												GroupLayout.DEFAULT_SIZE,
																												147,
																												Short.MAX_VALUE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												btnEndTournament))
																						.addGroup(
																								gl_contentPanel
																										.createSequentialGroup()
																										.addComponent(
																												lblTournamentStatus)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												lblTournamentstatusinfo))
																						.addGroup(
																								gl_contentPanel
																										.createSequentialGroup()
																										.addComponent(
																												cb_team,
																												0,
																												170,
																												Short.MAX_VALUE)
																										.addPreferredGap(
																												ComponentPlacement.UNRELATED)
																										.addComponent(
																												btnAddTeam,
																												GroupLayout.PREFERRED_SIZE,
																												84,
																												Short.MAX_VALUE))
																						.addGroup(
																								gl_contentPanel
																										.createSequentialGroup()
																										.addComponent(
																												btnEnableSignup,
																												GroupLayout.PREFERRED_SIZE,
																												103,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												btnStartTournament,
																												GroupLayout.DEFAULT_SIZE,
																												155,
																												Short.MAX_VALUE)))
																		.addGap(42))
														.addGroup(
																gl_contentPanel
																		.createSequentialGroup()
																		.addComponent(
																				lblStatus,
																				GroupLayout.PREFERRED_SIZE,
																				160,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap())))
						.addGroup(
								gl_contentPanel
										.createSequentialGroup()
										.addComponent(panel_setMatch,
												GroupLayout.PREFERRED_SIZE,
												488, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
						.addGroup(
								gl_contentPanel
										.createSequentialGroup()
										.addComponent(separator,
												GroupLayout.DEFAULT_SIZE, 493,
												Short.MAX_VALUE)
										.addContainerGap()));
		gl_contentPanel
				.setVerticalGroup(gl_contentPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPanel
										.createSequentialGroup()
										.addGroup(
												gl_contentPanel
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addGroup(
																gl_contentPanel
																		.createSequentialGroup()
																		.addGap(6)
																		.addGroup(
																				gl_contentPanel
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								lblTournamentStatus)
																						.addComponent(
																								lblTournamentstatusinfo))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				gl_contentPanel
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								cb_team,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								btnAddTeam))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				gl_contentPanel
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								btnEnableSignup)
																						.addComponent(
																								btnStartTournament))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				gl_contentPanel
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								btnEndTournament)
																						.addComponent(
																								btnAdvanceTournament))
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				lblStatus,
																				GroupLayout.PREFERRED_SIZE,
																				23,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																panel,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(separator,
												GroupLayout.PREFERRED_SIZE, 2,
												GroupLayout.PREFERRED_SIZE)
										.addGap(10)
										.addComponent(panel_setMatch,
												GroupLayout.PREFERRED_SIZE,
												109, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(28, Short.MAX_VALUE)));
		panel_setMatch.setLayout(null);

		JLabel lblSetMatchResult = new JLabel("Set match result");
		lblSetMatchResult.setBounds(10, 11, 186, 14);
		panel_setMatch.add(lblSetMatchResult);

		JLabel lblChooseMatch = new JLabel("Choose match:");
		lblChooseMatch.setBounds(10, 30, 93, 14);
		panel_setMatch.add(lblChooseMatch);

		cb_chooseMatch = new JComboBox<String>();
		cb_chooseMatch.setBounds(10, 55, 478, 20);
		panel_setMatch.add(cb_chooseMatch);

		JButton btnOpenMatch = new JButton("Set Result");
		btnOpenMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int first = cb_chooseMatch.getSelectedItem().toString()
						.indexOf("(") + 1;
				int last = cb_chooseMatch.getSelectedItem().toString()
						.indexOf(")");
				String Str = cb_chooseMatch.getSelectedItem().toString()
						.substring(first, last);
				int matchID = Integer.parseInt(Str);// matchID to open match
				SetResult.setResultWindow(matchID);
			}

		});
		btnOpenMatch.setBounds(10, 86, 122, 23);
		panel_setMatch.add(btnOpenMatch);

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
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(lblTournamentInfo)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		lblRoundNumber)
																.addPreferredGap(
																		ComponentPlacement.UNRELATED)
																.addComponent(
																		lblRoundNumberInfo))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addComponent(
																						lblWinnerTeam)
																				.addComponent(
																						lblWithPlayOff)
																				.addComponent(
																						lblTeamSize)
																				.addComponent(
																						lblGameName)
																				.addComponent(
																						lblName))
																.addGap(18)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addComponent(
																						lblNameinfo)
																				.addComponent(
																						lblGamenameinfo)
																				.addComponent(
																						lblTeamsizeinfo)
																				.addComponent(
																						lblWithplayoffinfo)
																				.addComponent(
																						lblWinnerteaminfo))))
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						Alignment.TRAILING,
						gl_panel.createSequentialGroup()
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(lblTournamentInfo)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblName)
												.addComponent(lblNameinfo))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblGameName)
												.addComponent(lblGamenameinfo))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblTeamSize)
												.addComponent(lblTeamsizeinfo))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblWithPlayOff)
												.addComponent(
														lblWithplayoffinfo))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblWinnerTeam)
												.addComponent(lblWinnerteaminfo))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblRoundNumber)
												.addComponent(
														lblRoundNumberInfo))
								.addGap(30)));
		panel.setLayout(gl_panel);
		contentPanel.setLayout(gl_contentPanel);
		{
			buttonPane = new JPanel();

			btnClose = new JButton("Close");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					closeWindows();
				}
			});
			btnClose.setActionCommand("Cancel");

			getRootPane().setDefaultButton(btnClose);
		}
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																contentPanel,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																481,
																Short.MAX_VALUE)
														.addComponent(
																buttonPane,
																GroupLayout.DEFAULT_SIZE,
																447,
																Short.MAX_VALUE))
										.addGap(0)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.TRAILING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE,
								323, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE,
								29, GroupLayout.PREFERRED_SIZE)));
		GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
		gl_buttonPane.setHorizontalGroup(gl_buttonPane.createParallelGroup(
				Alignment.LEADING).addComponent(btnClose, Alignment.TRAILING,
				GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE));
		gl_buttonPane.setVerticalGroup(gl_buttonPane.createParallelGroup(
				Alignment.LEADING).addComponent(btnClose, Alignment.TRAILING,
				GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE));
		buttonPane.setLayout(gl_buttonPane);
		getContentPane().setLayout(groupLayout);
	}

	private void closeWindows() {
		tournament = null;
		System.out.println("Closing Tournament Window");
		dispose();
	}

	/**
	 * Gets the tournament by the given tournamentName and sets it as a global
	 * variable.
	 * 
	 * @param tournamentName
	 *            The tournaments name.
	 */
	private void getTournamentData(String tournamentName) {
		TournamentController tournamentController = new TournamentController();
		ArrayList<Tournament> tournaments = tournamentController
				.getTournaments();
		boolean found = false;
		for (int i = 0; !found && i < tournaments.size(); i++) {
			if (tournaments.get(i).getName().equals(tournamentName)) {
				found = true;
				this.tournament = tournaments.get(i);
			}
		}
	}

	private void displayTournamentInfo() {
		tournament = tournamentController.getTournament(tournament.getId());
		System.out.println("Tournament Status: " + tournament.getStatus());
		lblTournamentstatusinfo.setText(Tournament.statusToString(tournament
				.getStatus()));
		lblRoundNumberInfo
				.setText(Integer.toString(tournament.getRoundNumber()));
		if (tournament.getWinnerTeam() != null) {
			lblWinnerteaminfo.setText(tournament.getWinnerTeam().getName());
			lblWinnerteaminfo.setToolTipText(tournament.getWinnerTeam()
					.getName());
		} else {
			lblWinnerteaminfo.setText("None yet");
		}
		if (tournament.isWithPlayOff()) {
			lblWithplayoffinfo.setText("Yes");
		} else {
			lblWithplayoffinfo.setText("No");
		}
		lblTeamsizeinfo.setText(Integer.toString(tournament.getTeamSize()));
		lblGamenameinfo.setText(tournament.getGameName());
		lblGamenameinfo.setToolTipText(tournament.getGameName());
		lblNameinfo.setText(tournament.getName());
		lblNameinfo.setToolTipText(tournament.getName());
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

	private void fillMatchCombo(String tournamentName) {
		TournamentController tournamentController = new TournamentController();
		TeamController teamController = new TeamController();
		Tournament tour = tournamentController
				.getTournamentByName(tournamentName);
		if (cb_chooseMatch.getItemCount() > 0) {
			cb_chooseMatch.removeAllItems();
		}
		ArrayList<Match> matches = new ArrayList<Match>();
		if (tour.getStatus().equals(Tournament.Status.running)) {
			try {
				if (matches.isEmpty()) {
					matches = tournamentController.getMatchesForTournament(tour
							.getId());
				} else {
					matches.clear();
					cb_chooseMatch.removeAllItems();
					matches = tournamentController.getMatchesForTournament(tour
							.getId());
				}
				for (Match m : matches) {
					if (m.getRoundNumber() == tour.getRoundNumber()) {
						cb_chooseMatch.addItem("("
								+ m.getId()
								+ ") Round: "
								+ m.getRoundNumber()
								+ " - "
								+ teamController.findTeamById(
										m.getTeam1().getId()).getName()
								+ " VS. "
								+ teamController.findTeamById(
										m.getTeam2().getId()).getName()
								+ " Status: " + m.getStatus());
					}
				}
			} catch (Exception e) {
				cb_chooseMatch.addItem("Error");
			}
		}
	}

	private void enableSignup() {
		if (tournament.getStatus().equals(Tournament.Status.waiting)) {
			tournamentController.enableSignup(tournament.getId());
			displayTournamentInfo();
			System.out.println("signup for the tournament have been enabled.");
		} else {
			System.out.println("Couldn't enable signup for the tournament.");
		}
	}

	private void addTeam(String tournamentName) {
		TeamController teamCtr = new TeamController();
		TournamentController tourCtr = new TournamentController();
		Team team = teamCtr.findTeam(cb_team.getSelectedItem().toString());

		try {
			tourCtr.addTeamToTournament(
					tourCtr.getTournamentByName(tournamentName), team);
		} catch (Exception e) {
			System.out.println("Couldn't enable add team for the tournament.");
		}
	}

	private void startTournament(String tournamentName) {
		if (tournament.getStatus().equals(Tournament.Status.ready)) {
			try {
				tournamentController.startTournament(tournament.getId());
				System.out.println("The tournament have been started.");
			} catch (Exception ex) {
				System.out.println(ex);
			}
			displayTournamentInfo();
			fillMatchCombo(tournamentName);
		} else {
			System.out.println("The tournament could't be started.");
		}
	}

	private void advanceTournament(String tournamentName) {
		if (tournament.getStatus().equals(Tournament.Status.running)) {
			try {
				if (tournamentController.advanceTournament(tournament.getId()) != null) {
					System.out.println("Tournament has been advanced! HEST");
					fillMatchCombo(tournamentName);
				} else {
					lblStatus.setText("You need to end tournamet!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			displayTournamentInfo();
		} else {
			System.out.println("Tournament cold not be advanced!");
		}
	}
}
