package Context;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class addAuthor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addAuthor frame = new addAuthor();
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
	public addAuthor() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Author ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(74, 84, 110, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblAuthorName = new JLabel("Name :");
		lblAuthorName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAuthorName.setBounds(74, 134, 110, 25);
		contentPane.add(lblAuthorName);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLastName.setBounds(74, 184, 110, 25);
		contentPane.add(lblLastName);
		
		JLabel lblAbout = new JLabel("About :");
		lblAbout.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAbout.setBounds(74, 234, 110, 25);
		contentPane.add(lblAbout);
		
		JTextArea textArea = new JTextArea();
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setBackground(new Color(255, 228, 181));
		textArea.setFont(new Font("Monospaced", Font.BOLD, 14));
		textArea.setBounds(177, 235, 193, 61);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String authorsID = textField.getText();
				String name = textField_1.getText();
			    String lastName = textField_2.getText();
				String about = textArea.getText();
				try {
					Connection con = DBConnection.getCon();
					Statement st = con.createStatement();
					st.executeUpdate("insert into tbauthors values ('"+authorsID+"','"+name+"','"+lastName+"', '"+about+"')" );
					JOptionPane.showMessageDialog(null,"Successful Update");
					setVisible(false);
					new addNewStudent().setVisible(true);
					
				}
				catch (Exception evt) {
					// TODO: handle exception
			    	System.out.println(evt);
			    	JOptionPane.showMessageDialog(null,"The Update is Error");
			    	setVisible(false);
					new addAuthor().setVisible(true);
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btnS.png"));
		btnNewButton.setBounds(74, 320, 140, 50);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setBackground(new Color(255, 222, 173));
		textField.setBounds(177, 84, 193, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_1.setBackground(new Color(255, 222, 173));
		textField_1.setColumns(10);
		textField_1.setBounds(177, 134, 193, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_2.setBackground(new Color(255, 222, 173));
		textField_2.setColumns(10);
		textField_2.setBounds(177, 184, 193, 25);
		contentPane.add(textField_2);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new home().setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("D:\\Gorsel Programlama\\button (3).png"));
		btnNewButton_1.setBounds(230, 320, 140, 50);
		contentPane.add(btnNewButton_1);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Gorsel Programlama\\pngegg - Copy.png"));
		lblNewLabel_1.setBounds(0, 0, 480, 500);
		contentPane.add(lblNewLabel_1);
	}
}
