package bus.management;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddEmployee extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtfirstname;
	private JTextField txtlastname;
	private JTextField txtphone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee frame = new AddEmployee();
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
		txtphone.setText("");
	}

	/**
	 * Create the frame.
	 */
	public AddEmployee() {
		setTitle("Add Employee Details");
		setBounds(100, 100, 887, 413);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Employee");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(324, 42, 193, 29);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(216, 115, 137, 29);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(216, 183, 137, 29);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phone Number");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(216, 249, 151, 29);
		getContentPane().add(lblNewLabel_1_2);
		
		txtfirstname = new JTextField();
		txtfirstname.setBounds(393, 115, 216, 29);
		getContentPane().add(txtfirstname);
		txtfirstname.setColumns(10);
		
		txtlastname = new JTextField();
		txtlastname.setColumns(10);
		txtlastname.setBounds(393, 183, 216, 29);
		getContentPane().add(txtlastname);
		
		txtphone = new JTextField();
		txtphone.setColumns(10);
		txtphone.setBounds(393, 249, 216, 29);
		getContentPane().add(txtphone);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String firstname=txtfirstname.getText();
		        String lastname=txtlastname.getText();
		        String phoneno=txtphone.getText();
		        try
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            String URL = "jdbc:mysql://localhost:3306/busmanagement";
		            Connection con = DriverManager.getConnection(URL, "root", "");
		            Statement stat = con.createStatement();    
		            String selectQuery = "select * from employee_details where phone_number	='"+phoneno+"'";
		            System.out.println(selectQuery);
		            ResultSet rs=stat.executeQuery(selectQuery);
		         //   System.out.println(rs.next());
		           if(rs.next())
		           {
		             JOptionPane.showMessageDialog(null,"Already Inserted", "ALert !!",JOptionPane.INFORMATION_MESSAGE);
		             clear();
		           }
		           else
		           {
		          String insertQuery = "insert into employee_details values(null,'" + firstname + "','" + lastname + "','" + phoneno + "')";
		           
		          stat.executeUpdate(insertQuery);
		           JOptionPane.showMessageDialog(null,"information is inserted", "Welcome Bro !!",JOptionPane.INFORMATION_MESSAGE);
		        clear();
		          
		        }
		        }
		        catch(Exception ex)
		                {
		                    System.out.println(ex.toString());
		                }
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(366, 312, 151, 36);
		getContentPane().add(btnNewButton);

	}

}
