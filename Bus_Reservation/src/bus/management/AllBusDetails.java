package bus.management;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class AllBusDetails extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllBusDetails frame = new AllBusDetails();
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
			PreparedStatement pst = con.prepareStatement("Select * from bus_details");
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 */
	public AllBusDetails() {
		setTitle("All Bus Details");
		setBounds(100, 100, 924, 475);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 40, 834, 378);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}
}
