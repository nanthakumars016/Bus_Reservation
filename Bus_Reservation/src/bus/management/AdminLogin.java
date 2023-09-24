package bus.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField adminuser;
	private JPasswordField adminpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminLogin() {
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(314, 44, 162, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(181, 128, 121, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password\r\n");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(181, 182, 121, 29);
		contentPane.add(lblNewLabel_1_1);
		
		adminuser = new JTextField();
		adminuser.setBounds(314, 128, 261, 29);
		contentPane.add(adminuser);
		adminuser.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = adminuser.getText();
		        String password = adminpass.getText();
				 try
			        {
			            Class.forName("com.mysql.jdbc.Driver");
			            String databaseURL = "jdbc:mysql://localhost:3306/busmanagement";
			            Connection con = DriverManager.getConnection(databaseURL, "root", "");
			            String selectQuery = "select * from admin_details where username='"+username+"' and password='"+password+"'";
			            java.sql.Statement stat = con.createStatement(); 
			            ResultSet rs=stat.executeQuery(selectQuery);
			            if(rs.next()){

			            //JOptionPane.showMessageDialog(null,"Welcome", "Welcome Bro !!",JOptionPane.INFORMATION_MESSAGE);
			             dispose();
			             AdminControlPanel acp=new AdminControlPanel();
			             acp.lblNewLabel.setText("Welcome : "+username);
			             acp.setLocationRelativeTo(null);
			             acp.setVisible(true);
			    
			           }
			           else
			           {
			        	   JOptionPane.showMessageDialog(null,"You are not valid user", "Go back",JOptionPane.INFORMATION_MESSAGE);

			           }
			               
			            
			        }
			        catch(Exception ex)
			        {
			            
			        }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(314, 234, 99, 29);
		contentPane.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBounds(476, 238, 99, 29);
		contentPane.add(btnReset);
		
		JButton btnCreateAccount = new JButton("User Login");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogin ul=new UserLogin();
				ul.setLocationRelativeTo(null);
				ul.setVisible(true);
				dispose();
			}
		});
		btnCreateAccount.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCreateAccount.setBounds(314, 284, 261, 29);
		contentPane.add(btnCreateAccount);
		
		adminpass = new JPasswordField();
		adminpass.setBounds(314, 182, 261, 29);
		contentPane.add(adminpass);
	}
}
