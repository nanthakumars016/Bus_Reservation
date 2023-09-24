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

public class UserLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtusername;
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
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
	public UserLogin() {
		setTitle("User Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Login");
		lblNewLabel.setBounds(314, 41, 145, 37);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(154, 128, 141, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(154, 191, 141, 31);
		contentPane.add(lblNewLabel_1_1);
		
		txtusername = new JTextField();
		txtusername.setBounds(314, 125, 280, 37);
		contentPane.add(txtusername);
		txtusername.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String username = txtusername.getText();
		        String password = txtpassword.getText();
		        
				 try
			        {
			            Class.forName("com.mysql.jdbc.Driver");
			            String databaseURL = "jdbc:mysql://localhost:3306/busmanagement";
			            Connection con = DriverManager.getConnection(databaseURL, "root", "");
			            String selectQuery = "select * from user_details where username='"+username+"' and password='"+password+"'";
			            java.sql.Statement stat = con.createStatement(); 
			            ResultSet rs=stat.executeQuery(selectQuery);
			            if(rs.next()){

			             JOptionPane.showMessageDialog(null,"Welcome", "Welcome Bro !!",JOptionPane.INFORMATION_MESSAGE);
			             dispose();
			             UserControlPanel ucp=new UserControlPanel();
			             ucp.lblNewLabel.setText("Welcome : "+username);
			             ucp.setLocationRelativeTo(null);
			             ucp.setVisible(true);
			             
			             
			             
			    
			           }
			           else
			           {
			        	   JOptionPane.showMessageDialog(null,"Create New Account", "Welcome Bro !!",JOptionPane.INFORMATION_MESSAGE);
			                 dispose();
			                 NewUser nu=new NewUser();
			                 nu.setLocationRelativeTo(null);
			                 nu.setVisible(true);
			                 
			           }
			               
			            
			        }
			        catch(Exception ex)
			        {
			            
			        }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(315, 247, 115, 31);
		contentPane.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReset.setBounds(479, 247, 115, 31);
		contentPane.add(btnReset);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				NewUser nu=new NewUser();
				nu.setLocationRelativeTo(null);
				nu.setVisible(true);
			}
		});
		btnCreateAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCreateAccount.setBounds(312, 288, 282, 31);
		contentPane.add(btnCreateAccount);
		
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminLogin al=new AdminLogin();
				al.setLocationRelativeTo(null);
				al.setVisible(true);
			}
		});
		
		btnAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdminLogin.setBounds(154, 247, 141, 72);
		contentPane.add(btnAdminLogin);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(315, 191, 280, 31);
		contentPane.add(txtpassword);
	}

}
