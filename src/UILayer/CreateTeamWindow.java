package UILayer;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import CtrLayer.TeamController;

@SuppressWarnings("serial")
public class CreateTeamWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTeamName;
	private JTextField txtLeader;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void createTeamWindow() {
		try {
			CreateTeamWindow dialog = new CreateTeamWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CreateTeamWindow() {
		setAlwaysOnTop(true);

		setBounds(100, 100, 425, 266);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 409, 199);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblHeading = new JLabel("Create new team");
			lblHeading.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblHeading.setBounds(10, 11, 136, 14);
			contentPanel.add(lblHeading);
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
		txtTeamName.setBounds(248, 65, 120, 20);
		contentPanel.add(txtTeamName);
		txtTeamName.setColumns(10);

		JLabel lblLeader = new JLabel("Team Leader:");
		lblLeader.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLeader.setBounds(54, 146, 92, 14);
		contentPanel.add(lblLeader);
		{
			txtLeader = new JTextField();
			txtLeader.setEditable(false);
			txtLeader.setToolTipText("You will be leader when you create team");
			txtLeader.setBounds(248, 144, 120, 20);
			contentPanel.add(txtLeader);
			txtLeader.setColumns(10);
			txtLeader.setText(MainUI.getLoggedUser().getHandle());
		}
		{
			lblStatus = new JLabel("");
			lblStatus.setBounds(152, 175, 105, 14);
			contentPanel.add(lblStatus);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 200, 409, 27);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JButton btnCreate = new JButton("Create");
				btnCreate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						createTeam();
					}
				});
				btnCreate.setActionCommand("OK");
				buttonPane.add(btnCreate);
				getRootPane().setDefaultButton(btnCreate);
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
		}
	}

	private void createTeam(){
		TeamController teamCtr = new TeamController();
		if(teamCtr.findTeam(txtTeamName.getText()) == null) {
			if(txtTeamName.getText().length() >= 3 && txtLeader.getText().length() > 2) {
				try {
					teamCtr.addTeam(txtTeamName.getText(), MainUI.getLoggedUser().getUserID());
					lblStatus.setText("Team Created");
					txtTeamName.setText("");
				}catch (Exception e) {
					lblStatus.setText("Error in inputs, please try again!");
				}
			}
		} else
			lblStatus.setText("Sorry this team name is taken :(");
	}
}