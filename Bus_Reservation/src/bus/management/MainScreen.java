package bus.management;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
//import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void windowcenter() {
		Toolkit toolkit=getToolkit();
		Dimension size=toolkit.getScreenSize();
		setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		
		windowcenter();
		
		setTitle("Bus Reservation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bus Booking Application");
		lblNewLabel.setBounds(229, 76, 326, 30);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 24));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("User Login");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UserLogin ul=new UserLogin();
				ul.setLocationRelativeTo(null);
				ul.setVisible(true);
			}
		});
		btnNewButton.setBounds(171, 177, 146, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Admin Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminLogin al=new AdminLogin();
				al.setLocationRelativeTo(null);
				al.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.setBounds(468, 177, 146, 40);
		contentPane.add(btnNewButton_1);
	}
}
