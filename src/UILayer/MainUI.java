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
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setPreferredSize(new Dimension(700, 2));
		separator.setAlignmentY(Component.TOP_ALIGNMENT);
		GroupLayout groupLayout = new GroupLayout(frmTournamentplanner.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelBottom, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
				.addComponent(panelTop, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelTop, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelBottom, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
		);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelLogin.setAlignmentY(Component.TOP_ALIGNMENT);
		
		JLabel lblLogin = new JLabel("User Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtloginHandle = new JTextField();
		txtloginHandle.setText("Youre handle");
		txtloginHandle.setToolTipText("Youre handle");
		txtloginHandle.setColumns(10);
		
		JButton btnlogin = new JButton("Login");
		
		JLabel lblErrorMessage = new JLabel("Error Message");
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setVisible(false);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setToolTipText("Youre password");
		pwdPassword.setText("Password");
		GroupLayout gl_panelLogin = new GroupLayout(panelLogin);
		gl_panelLogin.setHorizontalGroup(
			gl_panelLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogin.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelLogin.createParallelGroup(Alignment.LEADING)
						.addComponent(lblErrorMessage, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
						.addComponent(txtloginHandle, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
						.addGroup(gl_panelLogin.createSequentialGroup()
							.addComponent(lblLogin)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnlogin, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
						.addComponent(pwdPassword, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelLogin.setVerticalGroup(
			gl_panelLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogin.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panelLogin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogin)
						.addComponent(btnlogin))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtloginHandle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pwdPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblErrorMessage)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
		GroupLayout gl_panelTitle = new GroupLayout(panelTitle);
		gl_panelTitle.setHorizontalGroup(
			gl_panelTitle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTitle.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelTitle.createParallelGroup(Alignment.LEADING)
						.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
						.addComponent(lblYourTournamentMade))
					.addContainerGap())
				.addGroup(gl_panelTitle.createSequentialGroup()
					.addGap(8)
					.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
					.addGap(12))
		);
		gl_panelTitle.setVerticalGroup(
			gl_panelTitle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTitle.createSequentialGroup()
					.addGap(18)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
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
		GroupLayout gl_panelTop = new GroupLayout(panelTop);
		gl_panelTop.setHorizontalGroup(
			gl_panelTop.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTop.createSequentialGroup()
					.addComponent(panelLogin, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelTitle, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelDatabaseConnection, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelTop.setVerticalGroup(
			gl_panelTop.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTop.createSequentialGroup()
					.addGroup(gl_panelTop.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panelTop.createParallelGroup(Alignment.TRAILING)
							.addGroup(Alignment.LEADING, gl_panelTop.createSequentialGroup()
								.addGap(2)
								.addComponent(panelDatabaseConnection, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
							.addComponent(panelLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
						.addComponent(panelTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelTop.setLayout(gl_panelTop);
		frmTournamentplanner.getContentPane().setLayout(groupLayout);
	}
}
