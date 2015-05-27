/**
 * 
 */
package UILayer;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JPanel;

import java.awt.Component;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JLabel;

//import com.jgoodies.forms.factories.DefaultComponentFactory;  wtf jacob??
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;

import CtrLayer.TeamController;
import CtrLayer.UserController;
import ModelLayer.Team;
import ModelLayer.User;

/**
 * @author Jacob 19/05/2015
 *
 */
public class MainUI {

	private JFrame frmTournamentplanner;
	private JTextField txtloginHandle;
	private JPasswordField pwdPassword;
	private JComboBox cb_team;
	private JComboBox cb_user;
	private UserController userController;
	private JLabel lblErrorMessage;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI window = new MainUI();
					window.frmTournamentplanner.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainUI() {
		initialize();
		frmTournamentplanner.setVisible(true);
		fillTeamCombo();
		fillUserCombo();
		userController = new UserController();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @param <lblErrorMessage>
	 */
	@SuppressWarnings("rawtypes")
	private <lblErrorMessage> void initialize() {
		frmTournamentplanner = new JFrame();
		frmTournamentplanner.setMaximumSize(new Dimension(1024, 768));
		frmTournamentplanner.setTitle("TournamentPlanner");
		frmTournamentplanner.setPreferredSize(new Dimension(800, 600));
		frmTournamentplanner.setMinimumSize(new Dimension(800, 600));
		frmTournamentplanner.setBounds(100, 100, 450, 300);
		frmTournamentplanner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panelTop = new JPanel();

		JPanel panelBottom = new JPanel();
		GroupLayout groupLayout = new GroupLayout(
				frmTournamentplanner.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout
				.createParallelGroup(Alignment.TRAILING)
				.addComponent(panelTop, GroupLayout.DEFAULT_SIZE, 784,
						Short.MAX_VALUE)
				.addComponent(panelBottom, GroupLayout.DEFAULT_SIZE, 784,
						Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addComponent(panelTop, GroupLayout.PREFERRED_SIZE,
								169, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelBottom, GroupLayout.DEFAULT_SIZE,
								386, Short.MAX_VALUE)));
		panelBottom.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panelBottom.add(tabbedPane);
		tabbedPane.setBounds(0, 0, 383, 386);

		ListTournamentsUI listTournamentsUI = new ListTournamentsUI();
		ListTeamsUI listTeamsUI = new ListTeamsUI();
		ListUsersUI listUsersUI = new ListUsersUI();

		tabbedPane.addTab("Tournaments", null, listTournamentsUI, null);
		tabbedPane.addTab("Teams", null, listTeamsUI, null);
		tabbedPane.addTab("Players", null, listUsersUI, null);

		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		controlPanel.setBounds(393, 23, 381, 363);
		panelBottom.add(controlPanel);
		controlPanel.setLayout(null);

		JLabel lblControlpanel = new JLabel("Control Panel");
		lblControlpanel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblControlpanel.setBounds(10, 11, 100, 14);
		controlPanel.add(lblControlpanel);

		JLabel lblTournament = new JLabel("Tournament");
		lblTournament.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTournament.setBounds(31, 41, 79, 14);
		controlPanel.add(lblTournament);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(41, 66, 271, 20);
		controlPanel.add(comboBox);

		JButton btnOpenTournament = new JButton("Open Tournament");
		btnOpenTournament.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnOpenTournament.setBounds(51, 97, 146, 23);
		controlPanel.add(btnOpenTournament);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 136, 361, 2);
		controlPanel.add(separator_3);

		JLabel lblTeam = new JLabel("Team");
		lblTeam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTeam.setBounds(31, 149, 46, 14);
		controlPanel.add(lblTeam);

		cb_team = new JComboBox();
		cb_team.setBounds(41, 174, 137, 20);
		controlPanel.add(cb_team);

		JButton btnOpenTeam = new JButton("Open Team");
		btnOpenTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlPanelTeam.controlPanelTeam(cb_team.getSelectedItem()
						.toString());
			}
		});
		btnOpenTeam.setBounds(51, 205, 127, 23);
		controlPanel.add(btnOpenTeam);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 243, 361, 2);
		controlPanel.add(separator_4);

		JLabel lblPlayer = new JLabel("Player");
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPlayer.setBounds(31, 256, 46, 14);
		controlPanel.add(lblPlayer);

		cb_user = new JComboBox();
		cb_user.setBounds(41, 281, 137, 20);
		controlPanel.add(cb_user);

		JButton btnOpenPlayer = new JButton("Open Player");
		btnOpenPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlPanelUser.controlPanelUser(cb_user.getSelectedItem()
						.toString());
			}
		});
		btnOpenPlayer.setBounds(51, 312, 127, 23);
		controlPanel.add(btnOpenPlayer);

		JPanel panelLogin = new JPanel();
		panelLogin.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelLogin.setAlignmentY(Component.TOP_ALIGNMENT);

		JLabel lblLogin = new JLabel("User Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));

		txtloginHandle = new JTextField();
		txtloginHandle.setToolTipText("Youre handle");
		txtloginHandle.setColumns(10);

		JButton btnlogin = new JButton("Login");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User u = userController.findUser(txtloginHandle.getText());
				if (u != null) {
					try {
						if (u.getPassword() == userController
								.stringToHash(pwdPassword.getPassword()
										.toString())) {
							panelLogin.setVisible(false);
							panelLogin.setEnabled(false);

						} else {
							lblErrorMessage.setVisible(true);
							lblErrorMessage.setText("INCORRECT PASSWORD!");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnlogin.setFont(new Font("Tahoma", Font.PLAIN, 8));

		lblErrorMessage = new JLabel("Error Message");
		lblErrorMessage.setForeground(Color.RED);

		pwdPassword = new JPasswordField();

		pwdPassword.setToolTipText("Your password");

		JButton btnCreateUser = new JButton("Create");
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateUserWindow.createUserWindow();
			}
		});
		btnCreateUser.setFont(new Font("Tahoma", Font.PLAIN, 9));

		JLabel lblUsername = new JLabel("Username:");

		JLabel lblPassword = new JLabel("Password:");
		GroupLayout gl_panelLogin = new GroupLayout(panelLogin);
		gl_panelLogin.setHorizontalGroup(
			gl_panelLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogin.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelLogin.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelLogin.createSequentialGroup()
							.addComponent(lblErrorMessage, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(148))
						.addGroup(gl_panelLogin.createSequentialGroup()
							.addComponent(btnlogin)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCreateUser)
							.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE))
						.addGroup(gl_panelLogin.createSequentialGroup()
							.addComponent(pwdPassword, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE))
						.addGroup(gl_panelLogin.createSequentialGroup()
							.addComponent(lblLogin)
							.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE))
						.addGroup(gl_panelLogin.createSequentialGroup()
							.addComponent(lblUsername)
							.addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE))
						.addGroup(gl_panelLogin.createSequentialGroup()
							.addComponent(txtloginHandle, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panelLogin.createSequentialGroup()
							.addComponent(lblPassword)
							.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE)))
					.addGap(172))
		);
		gl_panelLogin.setVerticalGroup(
			gl_panelLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogin.createSequentialGroup()
					.addComponent(lblLogin)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblUsername)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtloginHandle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPassword)
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addComponent(pwdPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelLogin.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnlogin)
						.addComponent(btnCreateUser))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblErrorMessage)
					.addContainerGap())
		);
		panelLogin.setLayout(gl_panelLogin);

		JPanel panelTitle = new JPanel();

		JLabel lblTitle = new JLabel("Tournament Planer");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 40));

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setPreferredSize(new Dimension(500, 2));

		JLabel lblYourTournamentMade = new JLabel(
				"Your tournament made easier!");
		lblYourTournamentMade.setFont(new Font("Tahoma", Font.BOLD
				| Font.ITALIC, 13));

		JSeparator separator = new JSeparator();
		GroupLayout gl_panelTitle = new GroupLayout(panelTitle);
		gl_panelTitle
				.setHorizontalGroup(gl_panelTitle
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panelTitle
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panelTitle
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panelTitle
																		.createSequentialGroup()
																		.addGroup(
																				gl_panelTitle
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								separator_1,
																								GroupLayout.DEFAULT_SIZE,
																								539,
																								Short.MAX_VALUE)
																						.addComponent(
																								lblYourTournamentMade))
																		.addContainerGap())
														.addGroup(
																gl_panelTitle
																		.createSequentialGroup()
																		.addComponent(
																				lblTitle,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				separator,
																				GroupLayout.PREFERRED_SIZE,
																				1,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap(
																				405,
																				Short.MAX_VALUE)))));
		gl_panelTitle
				.setVerticalGroup(gl_panelTitle
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panelTitle
										.createSequentialGroup()
										.addGap(36)
										.addGroup(
												gl_panelTitle
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_panelTitle
																		.createSequentialGroup()
																		.addComponent(
																				separator,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(28))
														.addGroup(
																gl_panelTitle
																		.createSequentialGroup()
																		.addComponent(
																				lblTitle,
																				GroupLayout.PREFERRED_SIZE,
																				38,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)))
										.addComponent(separator_1,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(lblYourTournamentMade)
										.addContainerGap(47, Short.MAX_VALUE)));
		panelTitle.setLayout(gl_panelTitle);

		JPanel panelDatabaseConnection = new JPanel();

		JLabel lblConnectionStatus = new JLabel("Connection status");
		lblConnectionStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConnectionStatus.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblToDatabse = new JLabel("to databse");
		lblToDatabse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblToDatabse.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panelDatabaseConnection = new GroupLayout(
				panelDatabaseConnection);
		gl_panelDatabaseConnection
				.setHorizontalGroup(gl_panelDatabaseConnection
						.createParallelGroup(Alignment.LEADING)
						.addComponent(lblConnectionStatus,
								GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
						.addGroup(
								gl_panelDatabaseConnection
										.createSequentialGroup()
										.addGap(10)
										.addComponent(lblToDatabse,
												GroupLayout.DEFAULT_SIZE, 159,
												Short.MAX_VALUE)
										.addContainerGap())
						.addGroup(
								gl_panelDatabaseConnection
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblStatus,
												GroupLayout.DEFAULT_SIZE, 159,
												Short.MAX_VALUE)
										.addContainerGap()));
		gl_panelDatabaseConnection.setVerticalGroup(gl_panelDatabaseConnection
				.createParallelGroup(Alignment.LEADING).addGroup(
						gl_panelDatabaseConnection.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblConnectionStatus)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblToDatabse)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblStatus)
								.addContainerGap(46, Short.MAX_VALUE)));
		panelDatabaseConnection.setLayout(gl_panelDatabaseConnection);

		JSeparator separator_2 = new JSeparator();
		GroupLayout gl_panelTop = new GroupLayout(panelTop);
		gl_panelTop.setHorizontalGroup(gl_panelTop
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panelTop
								.createSequentialGroup()
								.addComponent(panelLogin,
										GroupLayout.PREFERRED_SIZE, 172,
										GroupLayout.PREFERRED_SIZE)
								.addGap(2)
								.addComponent(panelTitle,
										GroupLayout.PREFERRED_SIZE, 421,
										Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(panelDatabaseConnection,
										GroupLayout.PREFERRED_SIZE, 179,
										GroupLayout.PREFERRED_SIZE))
				.addGroup(
						gl_panelTop
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(separator_2,
										GroupLayout.DEFAULT_SIZE, 751,
										Short.MAX_VALUE).addGap(23)));
		gl_panelTop
				.setVerticalGroup(gl_panelTop
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panelTop
										.createSequentialGroup()
										.addGroup(
												gl_panelTop
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																Alignment.TRAILING,
																gl_panelTop
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				panelDatabaseConnection,
																				GroupLayout.DEFAULT_SIZE,
																				156,
																				Short.MAX_VALUE))
														.addComponent(
																panelTitle,
																Alignment.TRAILING,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																panelLogin,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addGap(2)
										.addComponent(separator_2,
												GroupLayout.PREFERRED_SIZE, 9,
												GroupLayout.PREFERRED_SIZE)));
		panelTop.setLayout(gl_panelTop);
		frmTournamentplanner.getContentPane().setLayout(groupLayout);
	}

	private void fillTeamCombo() {
		try {
			TeamController teamController = new TeamController();
			ArrayList<Team> teams = teamController.getAllTeams();
			for (Team t : teams) {
				cb_team.addItem(t.getName());
			}
		} catch (Exception e) {
			cb_team.addItem("Error");
		}

	}

	private void fillUserCombo() {
		try {
			UserController userController = new UserController();
			ArrayList<User> users = userController.getAllUsers();
			for (User u : users) {
				cb_user.addItem(u.getHandle());
			}
		} catch (Exception e) {
			cb_user.addItem("Error");
		}

	}
}
