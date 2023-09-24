package bus.management;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddBusDetails extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtbusno;
	private JTextField txtfrom;
	private JTextField txtprice;
	private JTextField txtdate;
	private JTextField txtseat;
	private JTextField txttime;
	private JTextField txtto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBusDetails frame = new AddBusDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void clear() {
		txtbusno.setText("");
		txtfrom.setText("");
		txtto.setText("");
		txtprice.setText("");
		txtseat.setText("");
		txttime.setText("");
		txtdate.setText("");
	}

	/**
	 * Create the frame.
	 */
	public AddBusDetails() {
		setTitle("Add Bus Details");
		setBounds(100, 100, 918, 445);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Bus Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(351, 26, 196, 36);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bus No");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(105, 102, 111, 28);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("From");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(105, 159, 111, 28);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Date");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(105, 222, 111, 28);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Price");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(105, 286, 111, 28);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Movement");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(463, 102, 111, 28);
		getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("To");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_5.setBounds(463, 159, 111, 28);
		getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Time");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_6.setBounds(463, 222, 111, 28);
		getContentPane().add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Seat");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_7.setBounds(463, 286, 111, 28);
		getContentPane().add(lblNewLabel_1_7);
		
		txtbusno = new JTextField();
		txtbusno.setBounds(229, 102, 190, 32);
		getContentPane().add(txtbusno);
		txtbusno.setColumns(10);
		
		txtfrom = new JTextField();
		txtfrom.setColumns(10);
		txtfrom.setBounds(229, 159, 190, 36);
		getContentPane().add(txtfrom);
		
		txtprice = new JTextField();
		txtprice.setColumns(10);
		txtprice.setBounds(229, 286, 190, 32);
		getContentPane().add(txtprice);
		
		txtdate = new JTextField();
		txtdate.setColumns(10);
		txtdate.setBounds(226, 222, 190, 36);
		getContentPane().add(txtdate);
		
		txtseat = new JTextField();
		txtseat.setColumns(10);
		txtseat.setBounds(584, 288, 190, 32);
		getContentPane().add(txtseat);
		
		txttime = new JTextField();
		txttime.setColumns(10);
		txttime.setBounds(584, 222, 190, 36);
		getContentPane().add(txttime);
		
		txtto = new JTextField();
		txtto.setColumns(10);
		txtto.setBounds(584, 159, 190, 36);
		getContentPane().add(txtto);
		
		final JComboBox txtmove = new JComboBox();
		txtmove.setModel(new DefaultComboBoxModel(new String[] {"UP", "DOWN"}));
		txtmove.setBounds(584, 101, 190, 36);
		getContentPane().add(txtmove);
		
		JButton btnsave = new JButton("Save");
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String busno=txtbusno.getText();
				String busmove=txtmove.getSelectedItem().toString();
				String busfrom=txtfrom.getText();
				String busto=txtto.getText();
				String busdate=txtdate.getText();
				String bustime=txttime.getText();
				String busprice=txtprice.getText();
				String busseat=txtseat.getText();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/busmanagement";
					Connection con=DriverManager.getConnection(url,"root","");
					Statement stat = con.createStatement();    
			        String selectQuery = "select * from bus_details where bus_no='"+busno+"'";
			        
			        ResultSet rs=stat.executeQuery(selectQuery);
			       
			           if(rs.next()==true)
			           {
			        	   JOptionPane.showMessageDialog(null,"Already Bus Details is Added", "Create Fresh Entry",JOptionPane.INFORMATION_MESSAGE);
			        	   clear();
			           }
			           else
			           {
			          String insertQuery = "insert into bus_details values(null,'" + busno + "','" + busmove + "','" + busfrom+"','" + busto +"','" + busdate + "','"+bustime+"','" + busprice + "','" + busseat+"')";
			           
			          stat.executeUpdate(insertQuery);
			          JOptionPane.showMessageDialog(null,"Bus Details Added" ,"Greate Word...",JOptionPane.INFORMATION_MESSAGE);
			          clear();
				}
			    }
				catch(Exception ex) {
					System.out.print(ex.toString());
				}
			
			}
		});
		btnsave.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnsave.setBounds(300, 350, 140, 36);
		getContentPane().add(btnsave);
		
		JButton btnreset = new JButton("Reset");
		btnreset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnreset.setBounds(481, 350, 140, 36);
		getContentPane().add(btnreset);

	}
}
