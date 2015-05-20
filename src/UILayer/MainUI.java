/**
 * 
 */
package UILayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Window.Type;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Jacob 19/05/2015
 *
 */
public class MainUI {

	private JFrame frmTournamentplanner;
	private JTextField txtloginHandle;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	/*
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
	}*/

	/**
	 * Create the application.
	 */
	public MainUI() {
		initialize();
		frmTournamentplanner.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTournamentplanner = new JFrame();
		frmTournamentplanner.setMaximumSize(new Dimension(1024, 768));
		frmTournamentplanner.setTitle("TournamentPlanner");
		frmTournamentplanner.setPreferredSize(new Dimension(800, 600));
		frmTournamentplanner.setMinimumSize(new Dimension(800, 600));
		frmTournamentplanner.setBounds(100, 100, 450, 300);
		frmTournamentplanner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelTop = new JPanel();
		
		JPanel panelBottom = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmTournamentplanner.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panelTop, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
				.addComponent(panelBottom, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelTop, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelBottom, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
		);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelLogin.setAlignmentY(Component.TOP_ALIGNMENT);
		
		JLabel lblLogin = new JLabel("User Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtloginHandle = new JTextField();
		txtloginHandle.setToolTipText("Youre handle");
		txtloginHandle.setColumns(10);
		
		
		JButton btnlogin = new JButton("Login");
		btnlogin.setFont(new Font("Tahoma", Font.PLAIN, 8));
		
		JLabel lblErrorMessage = new JLabel("Error Message");
		lblErrorMessage.setForeground(Color.RED);
		
		pwdPassword = new JPasswordField();

		pwdPassword.setToolTipText("Youre password");
		
		JButton btnCreateUser = new JButton("Create");
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createUserWindow cuw = new createUserWindow();
				cuw.createUserWindow();
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
							.addContainerGap(44, Short.MAX_VALUE))
						.addGroup(gl_panelLogin.createSequentialGroup()
							.addComponent(pwdPassword, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(44, Short.MAX_VALUE))
						.addGroup(gl_panelLogin.createSequentialGroup()
							.addComponent(lblLogin)
							.addContainerGap(44, Short.MAX_VALUE))
						.addGroup(gl_panelLogin.createSequentialGroup()
							.addComponent(lblUsername)
							.addContainerGap(44, Short.MAX_VALUE))
						.addGroup(gl_panelLogin.createSequentialGroup()
							.addComponent(txtloginHandle, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(44, Short.MAX_VALUE))
						.addGroup(gl_panelLogin.createSequentialGroup()
							.addComponent(lblPassword)
							.addContainerGap(44, Short.MAX_VALUE))))
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
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(pwdPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelLogin.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnlogin)
						.addComponent(btnCreateUser))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblErrorMessage))
		);
		panelLogin.setLayout(gl_panelLogin);
		
		JPanel panelTitle = new JPanel();
		
		JLabel lblTitle = new JLabel("Tournament Planer");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setPreferredSize(new Dimension(500, 2));
		
		JLabel lblYourTournamentMade = new JLabel("Your tournament made easier!");
		lblYourTournamentMade.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		
		JSeparator separator = new JSeparator();
		GroupLayout gl_panelTitle = new GroupLayout(panelTitle);
		gl_panelTitle.setHorizontalGroup(
			gl_panelTitle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTitle.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelTitle.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTitle.createSequentialGroup()
							.addGroup(gl_panelTitle.createParallelGroup(Alignment.LEADING)
								.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
								.addComponent(lblYourTournamentMade))
							.addContainerGap())
						.addGroup(gl_panelTitle.createSequentialGroup()
							.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(405, Short.MAX_VALUE))))
		);
		gl_panelTitle.setVerticalGroup(
			gl_panelTitle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTitle.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_panelTitle.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelTitle.createSequentialGroup()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(28))
						.addGroup(gl_panelTitle.createSequentialGroup()
							.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblYourTournamentMade)
					.addContainerGap(47, Short.MAX_VALUE))
		);
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
		GroupLayout gl_panelDatabaseConnection = new GroupLayout(panelDatabaseConnection);
		gl_panelDatabaseConnection.setHorizontalGroup(
			gl_panelDatabaseConnection.createParallelGroup(Alignment.LEADING)
				.addComponent(lblConnectionStatus, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
				.addGroup(gl_panelDatabaseConnection.createSequentialGroup()
					.addGap(10)
					.addComponent(lblToDatabse, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panelDatabaseConnection.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblStatus, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelDatabaseConnection.setVerticalGroup(
			gl_panelDatabaseConnection.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDatabaseConnection.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblConnectionStatus)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblToDatabse)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblStatus)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		panelDatabaseConnection.setLayout(gl_panelDatabaseConnection);
		
		JSeparator separator_2 = new JSeparator();
		GroupLayout gl_panelTop = new GroupLayout(panelTop);
		gl_panelTop.setHorizontalGroup(
			gl_panelTop.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTop.createSequentialGroup()
					.addComponent(panelLogin, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(panelTitle, GroupLayout.PREFERRED_SIZE, 421, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelDatabaseConnection, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelTop.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator_2, GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
					.addGap(23))
		);
		gl_panelTop.setVerticalGroup(
			gl_panelTop.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTop.createSequentialGroup()
					.addGroup(gl_panelTop.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panelTop.createSequentialGroup()
							.addGap(2)
							.addComponent(panelDatabaseConnection, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
						.addComponent(panelTitle, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(2)
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE))
		);
		panelTop.setLayout(gl_panelTop);
		frmTournamentplanner.getContentPane().setLayout(groupLayout);
	}
}
