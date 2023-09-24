package bus.management;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookingDetails extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JComboBox cBox;
	private JComboBox cBox_1;

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
	
	public void loadData() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/busmanagement";
			Connection con=DriverManager.getConnection(url,"root","");
			PreparedStatement pst = con.prepareStatement("Select * from bus_booking");
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
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
                cBox.addItem(rs.getString("busfrom"));
                
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
                cBox_1.addItem(rs.getString("busto"));
                
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
	public BookingDetails() {
		setTitle("Booking Details");
		setBounds(100, 100, 1037, 505);
		getContentPane().setLayout(null);
			
		JLabel lblNewLabel = new JLabel("Booking Info");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(385, 23, 158, 25);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("From");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(59, 108, 74, 25);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("To");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(59, 172, 74, 25);
		getContentPane().add(lblNewLabel_1_1);
		
		cBox = new JComboBox();
		cBox.setBounds(171, 108, 158, 25);
		getContentPane().add(cBox);
		busSourceCBFillData();
		
		cBox_1 =new JComboBox();
		cBox_1.setBounds(171, 172, 158, 25);
		getContentPane().add(cBox_1);
		busDestCBFillData();
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					
					/**
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/busmanagement";
					Connection con=DriverManager.getConnection(url,"root","");
					Statement stat = con.createStatement();    
			        String selectQuery = "select * from bus_booking";
			        
			        ResultSet rs=stat.executeQuery(selectQuery);
			        */
			        loadData();
			}
				catch(Exception ex) {
					System.out.print(ex.toString());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(111, 247, 128, 39);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(373, 109, 627, 334);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);

	}
}
