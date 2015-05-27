package UILayer;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import CtrLayer.TeamController;
import CtrLayer.UserController;
import ModelLayer.Team;
import ModelLayer.User;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class ControlPanelUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtHandle;
	private JTextField txtName;
	private JLabel lblStatus;
	private JPasswordField pwPassword;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void controlPanelUser(String handle) {
		try {
			ControlPanelUser dialog = new ControlPanelUser(handle);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ControlPanelUser(String handle) {
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
			JLabel lblHandlealias = new JLabel("Handle (alias):");
			lblHandlealias.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblHandlealias.setBounds(54, 66, 92, 14);
			contentPanel.add(lblHandlealias);
		}

		txtHandle = new JTextField();
		txtHandle.setEditable(false);
		txtHandle.setBounds(248, 65, 120, 14);
		contentPanel.add(txtHandle);
		txtHandle.setColumns(10);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(54, 107, 92, 14);
		contentPanel.add(lblName);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(54, 146, 92, 14);
		contentPanel.add(lblPassword);
		{
			txtName = new JTextField();
			txtName.setBounds(248, 105, 120, 14);
			contentPanel.add(txtName);
			txtName.setColumns(10);
		}
		{
			lblStatus = new JLabel("");
			lblStatus.setBounds(152, 268, 105, 14);
			contentPanel.add(lblStatus);
		}

		pwPassword = new JPasswordField();
		pwPassword.setBounds(248, 148, 120, 14);
		contentPanel.add(pwPassword);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 181, 314, 101);
		contentPanel.add(scrollPane);
		
		/**
		 * data table for team members
		 **/
		
		TeamController teamCtr = new TeamController();
		UserController userCtr = new UserController();
		User u = userCtr.findUserByHandle(handle);
		DefaultTableModel data = new DefaultTableModel();
		data.setColumnIdentifiers(new String[] { "id", "Team Name", "Leader" });
		ArrayList<Team> teams = teamCtr.getTeamsFromUser(u.getUserID());
		for (Team t : teams) {
			data.addRow(new String[] { t.getIdAsString(), t.getName(),
					userCtr.findUserNameById(t.getLeader()) });
		}
		table = new JTable();
		table.setEnabled(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(data);
		scrollPane.setViewportView(table);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 304, 409, 27);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JButton btnUpdate = new JButton("Update");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						updateUser(handle);
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
		}
		getUserData(handle);

	}

	/* Private methods */

	/*
	 * 
	 **/
	@SuppressWarnings("deprecation")
	private void updateUser(String handle) {
		UserController userCtr = new UserController();
		User openUser = userCtr.findUserByHandle(handle);
		String pass = new String(pwPassword.getPassword());
		String hashed = new String();
		try {
			hashed = userCtr.stringToHash(pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (pwPassword.getText().length() >= 3
				&& txtName.getText().length() > 2) {
			try {
				int result = userCtr.updateUser(openUser.getUserID(),
						txtHandle.getText(), txtName.getText(),
						hashed, false);
				if (result == 1) {
					lblStatus.setText("User updated");
				} else
					lblStatus.setText("User not updated");

			} catch (Exception e) {
				lblStatus.setText("Error in inputs, please try again!");
			}
		} else
			lblStatus.setText("Please, fill out all fields Thanks :)");
	}

	private void getUserData(String handle) {
		UserController userCtr = new UserController();
		User u = userCtr.findUserByHandle(handle);
		txtHandle.setText(u.getHandle());
		txtName.setText(u.getName());
	}
}
