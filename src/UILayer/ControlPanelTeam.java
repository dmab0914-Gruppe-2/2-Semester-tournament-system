package UILayer;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import CtrLayer.TeamController;
import CtrLayer.UserController;
import ModelLayer.Team;
import ModelLayer.User;

@SuppressWarnings("serial")
public class ControlPanelTeam extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTeamName;
	private JTextField txtLeader;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void controlPanelTeam(String team) {
		try {
			ControlPanelTeam dialog = new ControlPanelTeam(team);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ControlPanelTeam(String team) {
		setAlwaysOnTop(true);
		setBounds(100, 100, 425, 370);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 409, 293);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblUpdateUser = new JLabel("Update User");
			lblUpdateUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblUpdateUser.setBounds(10, 11, 136, 14);
			contentPanel.add(lblUpdateUser);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 36, 599, 2);
			contentPanel.add(separator);
		}
		{
			JLabel lblTeamName = new JLabel("Team Name:");
			lblTeamName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTeamName.setBounds(54, 66, 92, 14);
			contentPanel.add(lblTeamName);
		}

		txtTeamName = new JTextField();
		txtTeamName.setEditable(false);
		txtTeamName.setBounds(248, 65, 120, 20);
		contentPanel.add(txtTeamName);
		txtTeamName.setColumns(10);

		JLabel lblLeader = new JLabel("Name:");
		lblLeader.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLeader.setBounds(54, 113, 92, 14);
		contentPanel.add(lblLeader);
		{
			txtLeader = new JTextField();
			txtLeader.setBounds(248, 111, 120, 20);
			contentPanel.add(txtLeader);
			txtLeader.setColumns(10);
		}
		{
			lblStatus = new JLabel("");
			lblStatus.setBounds(152, 268, 105, 14);
			contentPanel.add(lblStatus);
		}
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 304, 409, 27);
		getContentPane().add(buttonPane);
		buttonPane.setLayout(new GridLayout(0, 2, 0, 0));
		{
			JButton btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateTeam(team);
				}
			});
			btnUpdate.setActionCommand("OK");
			buttonPane.add(btnUpdate);
			getRootPane().setDefaultButton(btnUpdate);
		}
		{
			JButton btnClose = new JButton("Close / Cancel");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnClose.setActionCommand("Cancel");
			buttonPane.add(btnClose);

		}
		getTeamData(team);
	}

	/* Private methods */

	private void updateTeam(String team) {
		TeamController teamCtr = new TeamController();
		UserController userCtr = new UserController();
		Team openTeam = teamCtr.findTeam(team);
		User u = userCtr.findUserByHandle(txtLeader.getText());
		int id = u.getUserID();
		if (txtLeader.getText().length() >= 2) {
			try {
				int result = teamCtr.updateTeam(openTeam.getLeader(),
						openTeam.getName(), id);

				if (result == 1) {
					lblStatus.setText("Team updated");
				} else
					lblStatus.setText("Team not updated");
			} catch (Exception e) {
				lblStatus.setText("Error in inputs, please try again!");
			}
		}
	}

	private void getTeamData(String team) {
		TeamController teamCtr = new TeamController();
		UserController userCtr = new UserController();
		
		Team t = teamCtr.findTeam(team);
		User leader = userCtr.findUserID(t.getLeader());
		
		txtTeamName.setText(t.getName());
		txtLeader.setText(leader.getHandle());
	}
}
