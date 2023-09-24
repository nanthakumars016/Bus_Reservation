package bus.management;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AddAdmin extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtname;
	private JTextField txtuname;
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAdmin frame = new AddAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void clear() {
		txtname.setText("");
		txtuname.setText("");
		txtpassword.setText("");
	}

	/**
	 * Create the frame.
	 */
	public AddAdmin() {
		setTitle("Add Admin");
		setBounds(100, 100, 904, 461);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Admin");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(355, 38, 146, 31);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(208, 131, 116, 31);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("UserName");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(208, 200, 116, 31);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Password");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(208, 275, 116, 31);
		getContentPane().add(lblNewLabel_1_2);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			
				String name=txtname.getText();
				String username=txtuname.getText();
				String password=txtpassword.getText();
				
				if(name==null||name.isEmpty()||name.trim().isEmpty()){
				JOptionPane.showMessageDialog(null,"Please Enter Name");
				txtname.requestFocus();
				return;
				}
					
				if(username==null||username.isEmpty()||username.trim().isEmpty()){
				JOptionPane.showMessageDialog(null,"Please Enter UserName");
				txtuname.requestFocus();
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
			        String selectQuery = "select * from admin_details where username='"+username+"' and password='"+password+"'";
			        System.out.println(selectQuery);
			        ResultSet rs=stat.executeQuery(selectQuery);
			           System.out.println(rs.next());
			           if(rs.next()==true)
			           {
			        	   JOptionPane.showMessageDialog(null,"Already Admin", "Welcome Admin !!",JOptionPane.INFORMATION_MESSAGE);
			           }
			           else
			           {
			          String insertQuery = "insert into admin_details values(null,'" + name + "','" + username + "','" +password + "')";
			           
			          stat.executeUpdate(insertQuery);
			          JOptionPane.showMessageDialog(null,"Admin inserted Successfully" ,"WelCome",JOptionPane.INFORMATION_MESSAGE);
			          dispose(); 
			          AdminLogin al=new AdminLogin();
			          al.setLocationRelativeTo(null);
			          al.setVisible(true);
			               
					clear();
					}
				}
				catch(Exception ex){
					System.out.println(ex.toString());
				}
			
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(370, 346, 131, 37);
		getContentPane().add(btnNewButton);
		
		txtname = new JTextField();
		txtname.setBounds(369, 131, 198, 31);
		getContentPane().add(txtname);
		txtname.setColumns(10);
		
		txtuname = new JTextField();
		txtuname.setColumns(10);
		txtuname.setBounds(370, 203, 198, 31);
		getContentPane().add(txtuname);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(370, 275, 198, 31);
		getContentPane().add(txtpassword);

	}
}
