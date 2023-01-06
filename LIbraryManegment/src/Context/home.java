package Context;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel btnaddnewStudent = new JLabel("");
		btnaddnewStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new addNewStudent().setVisible(true);
				
			}
		});
		btnaddnewStudent.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\addst.png"));
		btnaddnewStudent.setBounds(10, 10, 170, 112);
		contentPane.add(btnaddnewStudent);
		
		JLabel btnaddnewbook = new JLabel("");
		btnaddnewbook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new addNewBook().setVisible(true);
			}
		});
		btnaddnewbook.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\addbook.png"));
		btnaddnewbook.setBounds(190, 10, 160, 112);
		contentPane.add(btnaddnewbook);
		
		JLabel btnissueBook = new JLabel("");
		btnissueBook.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\issue.png"));
		btnissueBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new IssusBook().setVisible(true);
			}
		});
		btnissueBook.setBounds(370, 10, 160, 112);
		contentPane.add(btnissueBook);
		
		JLabel btnreturnBook = new JLabel("");
		btnreturnBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new returnBook().setVisible(true);
			}
		});
		btnreturnBook.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\re.png"));
		btnreturnBook.setBounds(561, 10, 160, 112);
		contentPane.add(btnreturnBook);
		
		JLabel btnaddadmin = new JLabel("");
		btnaddadmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new addAdmin().setVisible(true);
			}
		});
		btnaddadmin.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\addadmin..png"));
		btnaddadmin.setBounds(750, 10, 160, 112);
		contentPane.add(btnaddadmin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel.setIcon(new ImageIcon("D:\\Gorsel Programlama\\close (1).png"));
		lblNewLabel.setBounds(1160, 10, 30, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Gorsel Programlama\\11.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1200, 600);
		contentPane.add(lblNewLabel_1);
		//
	}
}
