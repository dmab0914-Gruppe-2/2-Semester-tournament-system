package UILayer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.JTextField;

import CtrLayer.UserController;

@SuppressWarnings("serial")
public class CreateUserWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtHandle;
	private JTextField txtName;
	private JTextField txtPassword;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void createUserWindow() {
		try {

			CreateUserWindow dialog = new CreateUserWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CreateUserWindow() {
		setAlwaysOnTop(true);

		setBounds(100, 100, 425, 370);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 409, 293);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Create new user");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel.setBounds(10, 11, 136, 14);
			contentPanel.add(lblNewLabel);
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
				JButton btnCreate = new JButton("Create");
				btnCreate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						createUser();
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

	private void createUser() {
		UserController userCtr = new UserController();
		if (userCtr.findUserByHandle(txtHandle.getText()) == null) {
			if (txtPassword.getText().length() >= 3
					&& txtName.getText().length() > 2) {
				try {
					userCtr.addUser(txtHandle.getText(), txtName.getText(),
							txtPassword.getText(), false);
					lblStatus.setText("User Created");
					txtHandle.setText("");
					txtName.setText("");
					txtPassword.setText("");
				} catch (Exception e) {
					lblStatus.setText("Error in inputs, please try again!");
				}
			} else
				lblStatus.setText("Please, fill out all fields Thanks :)");
		}else
			lblStatus.setText("Sorry this handle is taken :(");
	}
}
