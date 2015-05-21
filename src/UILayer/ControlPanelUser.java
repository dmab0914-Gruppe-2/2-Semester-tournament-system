package UILayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import CtrLayer.UserController;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanelUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtHandle;
	private JTextField txtName;
	private JTextField txtPassword;
	private UserController uC;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void ControlPanelUser() {
		try {
			ControlPanelUser dialog = new ControlPanelUser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ControlPanelUser() {
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
		txtHandle.setBounds(248, 65, 120, 20);
		contentPanel.add(txtHandle);
		txtHandle.setColumns(10);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(54, 146, 92, 14);
		contentPanel.add(lblName);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(54, 226, 92, 14);
		contentPanel.add(lblPassword);
		{
			txtName = new JTextField();
			txtName.setBounds(248, 144, 120, 20);
			contentPanel.add(txtName);
			txtName.setColumns(10);
		}
		{
			txtPassword = new JTextField();
			txtPassword.setBounds(248, 223, 120, 20);
			contentPanel.add(txtPassword);
			txtPassword.setColumns(10);
		}
		{
			lblStatus = new JLabel("");
			lblStatus.setBounds(152, 268, 105, 14);
			contentPanel.add(lblStatus);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 304, 409, 27);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JButton btnUpdate = new JButton("Update");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						updateUser();
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

	}

	/* Private methods */

	/*
	 * 
	 **/
	private void updateUser() {
		UserController userCtr = new UserController();
		if (txtPassword.getText().length() >= 3
				&& txtName.getText().length() > 2) {
			try {
				int result = userCtr.updateUser(1, txtHandle.getText(), // TODO fix to real ID from logged in user!
						txtName.getText(), txtPassword.getText(), false);
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

}
