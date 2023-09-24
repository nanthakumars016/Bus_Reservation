package bus.management;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.InputEvent;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminControlPanel extends JFrame {

	private JPanel contentPane;

	JDesktopPane desktopPane;
	JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminControlPanel frame = new AdminControlPanel();
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
	public AdminControlPanel() {
		setTitle("Admin Control");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1111, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1056, 33);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu_4 = new JMenu("Manage Bus");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Add Bus Details");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				AddBusDetails abd=new AddBusDetails();
				desktopPane.add(abd);
				abd.show();
				
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("All Bus Details");
		mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
			//private AbstractButton tblData;

			public void actionPerformed(ActionEvent e) {
				AllBusDetails albd=new AllBusDetails();
				desktopPane.add(albd);
				albd.show();
				albd.loadData();
				}
		});
		mnNewMenu_4.add(mntmNewMenuItem_1_1);
		
		JMenu mnNewMenu_5 = new JMenu("Booking");
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Add Booking");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				BusBooking bb=new BusBooking();
				desktopPane.add(bb);
				bb.show();
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_2_1 = new JMenuItem("Booking Details");
		mntmNewMenuItem_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				BookingDetails bd=new BookingDetails();
				desktopPane.add(bd);
				bd.show();
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_2_1);
		
		JMenu mnNewMenu_3 = new JMenu("Employee");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Add Employee");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				AddEmployee ae=new AddEmployee();
				desktopPane.add(ae);
				ae.show();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_5_1 = new JMenuItem("All Employee");
		mntmNewMenuItem_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				AllEmployeeDetails aed=new AllEmployeeDetails();
				desktopPane.add(aed);
				aed.show();
				aed.loadData();
			
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_5_1);
		
		JMenuItem mntmNewMenuItem_5_1_1 = new JMenuItem("Assign Bus");
		mntmNewMenuItem_5_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				AssignBus asb=new AssignBus();
				desktopPane.add(asb);
				asb.show();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_5_1_1);
		
		JMenu mnNewMenu_2 = new JMenu("Manage Admin");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Add Admin");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				AddAdmin ad=new AddAdmin();
				desktopPane.add(ad);
				ad.show();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu = new JMenu("Quit");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen ms=new MainScreen();
				dispose();
				ms.setLocationRelativeTo(null);
				ms.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		lblNewLabel = new JLabel("WelCome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(764, 48, 282, 33);
		contentPane.add(lblNewLabel);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 91, 1062, 543);
		contentPane.add(desktopPane);
	}
}
