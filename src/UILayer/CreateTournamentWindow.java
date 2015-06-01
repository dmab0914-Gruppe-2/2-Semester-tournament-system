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
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import CtrLayer.TournamentController;

@SuppressWarnings("serial")
public class CreateTournamentWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtGame;
	private JTextField txtTeamSize;
	private JLabel lblStatus;
	private JCheckBox cbPlayOff;

	/**
	 * Launch the application.
	 */
	public static void createTournamentWindow() {
		try {
			CreateTournamentWindow dialog = new CreateTournamentWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CreateTournamentWindow() {
		setAlwaysOnTop(true);

		setBounds(100, 100, 425, 288);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 409, 224);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Create new Tournament");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel.setBounds(10, 11, 195, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 36, 599, 2);
			contentPanel.add(separator);
		}
		
		JLabel lblTournamentName = new JLabel("Tournament name:");
		lblTournamentName.setBounds(40, 59, 117, 14);
		contentPanel.add(lblTournamentName);
		{
			JLabel lblGameName = new JLabel("Game name:");
			lblGameName.setBounds(40, 95, 91, 14);
			contentPanel.add(lblGameName);
		}
		{
			JLabel lblTeamSize = new JLabel("Team size:");
			lblTeamSize.setBounds(40, 136, 66, 14);
			contentPanel.add(lblTeamSize);
		}
		{
			JLabel lblWithPlayoff = new JLabel("With playoff:");
			lblWithPlayoff.setBounds(40, 180, 80, 14);
			contentPanel.add(lblWithPlayoff);
		}
		
		cbPlayOff = new JCheckBox("");
		cbPlayOff.setBounds(196, 176, 97, 23);
		contentPanel.add(cbPlayOff);
		
		txtName = new JTextField();
		txtName.setBounds(196, 56, 169, 20);
		contentPanel.add(txtName);
		txtName.setColumns(10);
		
		txtGame = new JTextField();
		txtGame.setBounds(196, 92, 169, 20);
		contentPanel.add(txtGame);
		txtGame.setColumns(10);
		
		txtTeamSize = new JTextField();
		txtTeamSize.setBounds(196, 133, 86, 20);
		contentPanel.add(txtTeamSize);
		txtTeamSize.setColumns(10);
		{
			lblStatus = new JLabel("");
			lblStatus.setBounds(196, 206, 169, 14);
			contentPanel.add(lblStatus);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 225, 409, 27);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JButton btnCreate = new JButton("Create");
				btnCreate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						createTounament();
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
	private void createTounament(){
		TournamentController tourCtr = new TournamentController();
		if(tourCtr.getTournamentByName(txtName.getText()) == null) {
			if(txtName.getText().length() >2 && txtGame.getText().length() >2){
				try {
					tourCtr.addTournamenet(txtName.getText(), txtGame.getText(), Integer.parseInt(txtTeamSize.getText()), cbPlayOff.isSelected());
					lblStatus.setText("Tournament created");
					txtName.setText("");
					txtGame.setText("");
					txtTeamSize.setText("");
					cbPlayOff.setSelected(false);
				}catch (Exception e) {
					lblStatus.setText("Error in inputs, please check");
				}
			
			}else {
				lblStatus.setText("Error in inputs, please check it");
			}
			
		} else {
			lblStatus.setText("Sorry this tournament name is taken");
		}
	}
}
