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

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BusBooking extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtname;
	private JTextField txtage;
	private JTextField txtphoneno;
	private JTextField txtseat;
	private JTextField txtdate;
	private JComboBox combofrom;
	private JComboBox comboto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusBooking frame = new BusBooking();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void busfromCBFillData() {
		try{
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/busmanagement";
            Connection con = DriverManager.getConnection(databaseURL, "root", "");
            Statement stat = con.createStatement();    
            String selectQuery="select * from bus_details";
            ResultSet rs=stat.executeQuery(selectQuery);
            while(rs.next())
            {
            	combofrom.addItem(rs.getString("busfrom"));
                
            }
                    
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
	}
	
	public void bustoCBFillData() {
		try{
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/busmanagement";
            Connection con = DriverManager.getConnection(databaseURL, "root", "");
            Statement stat = con.createStatement();    
            String selectQuery="select * from bus_details";
            ResultSet rs=stat.executeQuery(selectQuery);
            while(rs.next())
            {
            	comboto.addItem(rs.getString("busto"));
                
            }
                    
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
	}
	
	public void clear() {
		txtname.setText("");
		txtage.setText("");
		txtphoneno.setText("");
		txtdate.setText("");
		txtseat.setText("");
	}
	
	public void busSourceCBFillData() {
		try{
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/busmanagement";
            Connection con = DriverManager.getConnection(databaseURL, "root", "");
            Statement stat = con.createStatement();    
            String selectQuery="select * from bus_details";
            ResultSet rs=stat.executeQuery(selectQuery);
            while(rs.next())
            {
                combofrom.addItem(rs.getString("busfrom"));
                
            }
                    
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
	}
	
	public void busDestCBFillData() {
		try{
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/busmanagement";
            Connection con = DriverManager.getConnection(databaseURL, "root", "");
            Statement stat = con.createStatement();    
            String selectQuery="select * from bus_details";
            ResultSet rs=stat.executeQuery(selectQuery);
            while(rs.next())
            {
            	comboto.addItem(rs.getString("busto"));
                
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
	public BusBooking() {
		setTitle("Booking");
		setBounds(100, 100, 983, 488);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bus Booking");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(389, 28, 171, 29);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(105, 106, 125, 29);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Age");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(105, 174, 125, 29);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Gender");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(105, 241, 125, 29);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Phone No");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(105, 310, 125, 29);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("From");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(509, 106, 103, 29);
		getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("To");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_5.setBounds(509, 174, 103, 29);
		getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Date");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_6.setBounds(509, 241, 103, 29);
		getContentPane().add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Seat No");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_7.setBounds(509, 310, 103, 29);
		getContentPane().add(lblNewLabel_1_7);
		
		txtname = new JTextField();
		txtname.setBounds(224, 106, 183, 29);
		getContentPane().add(txtname);
		txtname.setColumns(10);
		
		txtage = new JTextField();
		txtage.setColumns(10);
		txtage.setBounds(224, 174, 183, 29);
		getContentPane().add(txtage);
		
		txtphoneno = new JTextField();
		txtphoneno.setColumns(10);
		txtphoneno.setBounds(224, 310, 183, 29);
		getContentPane().add(txtphoneno);
		
		txtseat = new JTextField();
		txtseat.setColumns(10);
		txtseat.setBounds(624, 310, 183, 29);
		getContentPane().add(txtseat);
		
		txtdate = new JTextField();
		txtdate.setColumns(10);
		txtdate.setBounds(624, 241, 183, 29);
		getContentPane().add(txtdate);
		
		JComboBox combogender = new JComboBox();
		combogender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		combogender.setBounds(227, 241, 180, 29);
		getContentPane().add(combogender);
		
		combofrom = new JComboBox();
		combofrom.setBounds(624, 106, 180, 29);
		getContentPane().add(combofrom);
		busfromCBFillData();
		
		comboto = new JComboBox();
		comboto.setBounds(624, 174, 180, 29);
		getContentPane().add(comboto);
		bustoCBFillData();
		
		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String name=txtname.getText();
				String age=txtage.getText();
				String gender=combogender.getSelectedItem().toString();
				String mobilenumber=txtphoneno.getText();
				String fromstart=combofrom.getSelectedItem().toString();
				String toend=comboto.getSelectedItem().toString();
				String date=txtdate.getText();
				String seatno=txtseat.getText();
				
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/busmanagement";
					Connection con=DriverManager.getConnection(url,"root","");
					Statement stat = con.createStatement();    
			          String insertQuery = "insert into bus_booking values(null,'" + name + "','" + age + "','" + gender + "','" + mobilenumber + "','" + fromstart + "','" + toend +"','" + date + "','" + seatno + "')";
			           
			          stat.executeUpdate(insertQuery);
			          JOptionPane.showMessageDialog(null,"Bus Booking Successfully" ,"WelCome",JOptionPane.INFORMATION_MESSAGE);
					clear();
				}
				catch(Exception ex){
					System.out.println(ex.toString());
				}
			
			}
			
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(404, 380, 140, 34);
		getContentPane().add(btnNewButton);

	}
}
