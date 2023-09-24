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
import java.sql.Statement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class NewUser extends JFrame {

	private JPanel contentPane;
	private JTextField txtfirstname;
	private JTextField txtusername;
	private JTextField txtemail;
	private JTextField txtlastname;
	private JTextField txtmobile;
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUser frame = new NewUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void clear() {
		txtfirstname.setText("");
		txtlastname.setText("");
		txtusername.setText("");
		txtmobile.setText("");
		txtemail.setText("");
		txtpassword.setText("");
	}

	/**
	 * Create the frame.
	 */
	public NewUser() {
		setTitle("New User Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1071, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New User Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(358, 57, 316, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FirstName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(139, 146, 111, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("UserName");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(139, 219, 111, 35);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email Id");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(139, 294, 111, 35);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Last Name");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(595, 146, 111, 35);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Mobile");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(595, 219, 140, 35);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Password");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_5.setBounds(595, 294, 111, 35);
		contentPane.add(lblNewLabel_1_5);
		
		txtfirstname = new JTextField();
		txtfirstname.setBounds(274, 146, 229, 35);
		contentPane.add(txtfirstname);
		txtfirstname.setColumns(10);
		
		txtusername = new JTextField();
		txtusername.setColumns(10);
		txtusername.setBounds(274, 219, 229, 35);
		contentPane.add(txtusername);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(274, 297, 229, 35);
		contentPane.add(txtemail);
		
		txtlastname = new JTextField();
		txtlastname.setColumns(10);
		txtlastname.setBounds(745, 146, 229, 35);
		contentPane.add(txtlastname);
		
		txtmobile = new JTextField();
		txtmobile.setColumns(10);
		txtmobile.setBounds(745, 219, 229, 35);
		contentPane.add(txtmobile);
		
		JButton btnregister = new JButton("Register");
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String firstname=txtfirstname.getText();
				String lastname=txtlastname.getText();
				String username=txtusername.getText();
				String mobilenumber=txtmobile.getText();
				String email=txtemail.getText();
				String password=txtpassword.getText();
				
				if(firstname==null||firstname.isEmpty()||firstname.trim().isEmpty()){
					JOptionPane.showMessageDialog(null,"Please Enter FirstName");
					txtfirstname.requestFocus();
					return;
				}
				if(username==null||username.isEmpty()||username.trim().isEmpty()){
					JOptionPane.showMessageDialog(null,"Please Enter UserName");
					txtusername.requestFocus();
					return;
				}
				if(mobilenumber==null||mobilenumber.isEmpty()||mobilenumber.trim().isEmpty()){
					JOptionPane.showMessageDialog(null,"Please Enter Mobile Number");
					txtmobile.requestFocus();
					return;
				}
				if(email==null||email.isEmpty()||email.trim().isEmpty()){
					JOptionPane.showMessageDialog(null,"Please Enter E-mail");
					txtemail.requestFocus();
					return;
				}
				if(password==null||password.isEmpty()||password.trim().isEmpty()){
					JOptionPane.showMessageDialog(null,"Please Enter password");
					txtpassword.requestFocus();
					return;
				}
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/busmanagement";
					Connection con=DriverManager.getConnection(url,"root","");
					Statement stat = con.createStatement();    
			        String selectQuery = "select * from user_details where username='"+username+"' and password='"+password+"'";
			        System.out.println(selectQuery);
			        ResultSet rs=stat.executeQuery(selectQuery);
			           System.out.println(rs.next());
			           if(rs.next()==true)
			           {
			        	   JOptionPane.showMessageDialog(null,"Already Registered", "Welcome Bro !!",JOptionPane.INFORMATION_MESSAGE);
			           }
			           else
			           {
			          String insertQuery = "insert into user_details values(null,'" + firstname + "','" + lastname + "','" + username + "','" + mobilenumber + "','" + email + "','" + password + "')";
			           
			          stat.executeUpdate(insertQuery);
			          JOptionPane.showMessageDialog(null,"Information inserted Successfully" ,"WelCome",JOptionPane.INFORMATION_MESSAGE);
			          dispose(); 
			          UserLogin ln=new UserLogin();
			          ln.setLocationRelativeTo(null);
			          ln.setVisible(true);
			               
					clear();
					}
				}
				catch(Exception ex){
					System.out.println(ex.toString());
				}
			
			}
		});
		btnregister.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnregister.setBounds(361, 379, 142, 35);
		contentPane.add(btnregister);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBounds(606, 379, 142, 35);
		contentPane.add(btnReset);
		
		JButton btnAlreadyHaveAccount = new JButton("Already have Account?  Sign In");
		btnAlreadyHaveAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UserLogin ul=new UserLogin();
				ul.setLocationRelativeTo(null);
				ul.setVisible(true);
			}
		});
		btnAlreadyHaveAccount.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAlreadyHaveAccount.setBounds(358, 445, 390, 35);
		contentPane.add(btnAlreadyHaveAccount);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(745, 294, 229, 35);
		contentPane.add(txtpassword);
	}
}
