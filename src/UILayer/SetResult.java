package UILayer;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import CtrLayer.TeamController;
import CtrLayer.TournamentController;
import ModelLayer.Match;
import ModelLayer.Team;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SetResult extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private TournamentController tournamentController;
	private JLabel lblTeam1;
	private JTextField txtScore1;
	private JLabel lblTeam2;
	private JTextField txtScore2;
	private TeamController teamController;
	private JLabel lblError;

	/**
	 * Launch the application.
	 */
	public static void setResultWindow(int matchID) {
		try {
			SetResult dialog = new SetResult(matchID);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SetResult(int matchID) {
		setTitle("Set Score");
		setAlwaysOnTop(true);
		setBounds(100, 100, 277, 209);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		tournamentController = new TournamentController();
		teamController = new TeamController();
		

		JLabel lblSetResult = new JLabel("Set result");
		lblSetResult.setBounds(102, 11, 56, 14);
		contentPanel.add(lblSetResult);

		lblTeam1 = new JLabel("");
		lblTeam1.setBounds(59, 38, 142, 14);
		contentPanel.add(lblTeam1);

		txtScore1 = new JTextField();
		txtScore1.setBounds(75, 54, 111, 20);
		contentPanel.add(txtScore1);
		txtScore1.setColumns(10);

		lblTeam2 = new JLabel("");
		lblTeam2.setBounds(62, 85, 137, 14);
		contentPanel.add(lblTeam2);

		txtScore2 = new JTextField();
		txtScore2.setBounds(75, 102, 111, 20);
		contentPanel.add(txtScore2);
		
		/*
		 *  get data from match after lbl's and txt's are added
		 */
		getMatchData(matchID);
		
		txtScore2.setColumns(10);
		
		lblError = new JLabel("");
		lblError.setBounds(107, 128, 46, 14);
		contentPanel.add(lblError);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JButton btnUpdate = new JButton("Update result");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setResult(matchID);
						dispose();
					}
				});
				btnUpdate.setActionCommand("OK");
				buttonPane.add(btnUpdate);
				getRootPane().setDefaultButton(btnUpdate);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("btnCancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void setResult(int matchID) {
		try {
			int score1 = Integer.parseInt(txtScore1.getText());
			int score2 = Integer.parseInt(txtScore2.getText());
			
			tournamentController.setMatchResults(matchID, score1, score2);
			lblError.setText("Result updated, match is now done");
		}catch (Exception e) {
			lblError.setText("Results must both be number only!");
		}
	}

	private void getMatchData(int matchID) {
		Match m = tournamentController.getMatch(matchID);
		Team team1 = teamController.findTeamById(m.getTeam1().getId());
		Team team2 = teamController.findTeamById(m.getTeam2().getId());

		lblTeam1.setText(team1.getName());
		lblTeam2.setText(team2.getName());

		txtScore1.setText(Integer.toString(m.getTeam1Score()));
		txtScore2.setText(Integer.toString(m.getTeam2Score()));
	}
}
