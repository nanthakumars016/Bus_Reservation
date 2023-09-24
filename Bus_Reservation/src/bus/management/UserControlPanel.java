package bus.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class UserControlPanel extends JFrame {

	private JPanel contentPane;
	JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserControlPanel frame = new UserControlPanel();
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
	public UserControlPanel() {
		setTitle("User Control");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1121, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 92, 1074, 492);
		contentPane.add(desktopPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 10, 1033, 31);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Bus Book");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Book");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				BusBooking bb=new BusBooking();
				desktopPane.add(bb);
				bb.show();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Quit");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				MainScreen ms=new MainScreen();
				dispose();
				ms.setLocationRelativeTo(null);
				ms.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setBounds(813, 51, 230, 31);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
	}
}
