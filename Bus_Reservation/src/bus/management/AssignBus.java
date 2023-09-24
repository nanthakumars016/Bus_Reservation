package bus.management;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AssignBus extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JComboBox cBox;
	private JComboBox cBox_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssignBus frame = new AssignBus();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void fillccombo() {
		 try{
	            Class.forName("com.mysql.jdbc.Driver");
	            String databaseURL = "jdbc:mysql://localhost:3306/busmanagement";
	            Connection con = DriverManager.getConnection(databaseURL, "root", "");
	            Statement stat = con.createStatement();    
	            String selectQuery="select * from employee_details";
	            ResultSet rs=stat.executeQuery(selectQuery);
	            while(rs.next())
	            {
	                cBox.addItem(Integer.toString(rs.getInt("id")));
	                
	            }
	                    
	        
	        }
	        catch(Exception e)
	        {
	            System.out.println(e);
	        }
	}
	
	public void fillccombo_1() {
		try{
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/busmanagement";
            Connection con = DriverManager.getConnection(databaseURL, "root", "");
            Statement stat = con.createStatement();    
            String selectQuery="select * from bus_details";
            ResultSet rs=stat.executeQuery(selectQuery);
            while(rs.next())
            {
                cBox_1.addItem(rs.getString("bus_no"));
                
            }
                    
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
	}

	/**
	 * Create the frame.
	 */
	public AssignBus() {
		setTitle("Assign Bus From Employees");
		setBounds(100, 100, 827, 432);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Assign Bus");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(308, 28, 139, 38);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Employee Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(148, 121, 161, 27);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Bus No");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(148, 203, 161, 27);
		getContentPane().add(lblNewLabel_1_1);
		
		cBox = new JComboBox();
		cBox.setBounds(397, 121, 133, 27);
		getContentPane().add(cBox);
		fillccombo();
		
		cBox_1 = new JComboBox();
		cBox_1.setBounds(397, 203, 133, 27);
		getContentPane().add(cBox_1);
		fillccombo_1();
		
		JButton btnNewButton = new JButton("Assign");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String employee_no=(String)cBox.getSelectedItem();
		        String bus_no=(String)cBox_1.getSelectedItem();
		        try{
		           Class.forName("com.mysql.jdbc.Driver");
		            String databaseURL = "jdbc:mysql://localhost:3306/busmanagement";
		            Connection con = DriverManager.getConnection(databaseURL, "root", "");
		            Statement stat = con.createStatement();    
		            String selectQuery="select bus_no from bus_assign where employee_id='"+employee_no+"' and bus_no='"+bus_no+"'";
		            ResultSet rs=stat.executeQuery(selectQuery);
		            if(rs.next())
		            {
		                JOptionPane.showMessageDialog(null,"Already Bus Details is Added", "Create Fresh Entry !!",JOptionPane.INFORMATION_MESSAGE);
		            }
		            else
		            {
		                String insertQuery="insert into bus_assign values(null,'"+employee_no+"','"+bus_no+"')";
		                int i=stat.executeUpdate(insertQuery);
		                if(i==1)
		                {
		                     JOptionPane.showMessageDialog(null,"Bus is Assign With Employee", "Create Fresh Entry !!",JOptionPane.INFORMATION_MESSAGE);
		                }
		                
		                
		                
		            }
		        
		        }
		        catch(Exception ex)
		        {
		            System.out.print(ex.toString());
		        }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(294, 284, 106, 27);
		getContentPane().add(btnNewButton);

	}

}
