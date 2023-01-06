package Context;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Button;
import java.awt.Point;

public class Login extends JFrame {
 home hm = new home();
	private JPanel contentPane;
	private JTextField txtMail;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setUndecorated(true);
		setResizable(false);
		setVisible(true);
		setRootPaneCheckingEnabled(false);
		setAutoRequestFocus(false);
		setLocation(new Point(325, 125));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setLocation(new Point(325, 125));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name :");
		lblNewLabel.setIcon(new ImageIcon("D:\\Gorsel Programlama\\user (1).png"));
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(321, 150, 196, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name :");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Gorsel Programlama\\lock.png"));
		lblNewLabel_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(321, 233, 196, 30);
		contentPane.add(lblNewLabel_1);
		
		txtMail = new JTextField();
		txtMail.setBackground(new Color(255, 250, 240));
		txtMail.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMail.setBounds(321, 187, 200, 30);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		JButton btnLogin = new JButton("");
		btnLogin.setIcon(new ImageIcon("D:\\Gorsel Programlama\\button (2).png"));
		btnLogin.setBackground(new Color(255, 255, 204));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DBConnection.getCon();
				    Statement st = con.createStatement();
				    ResultSet rs = st.executeQuery("select *from tadmin");
				    while(rs.next()) {
				    	if(txtMail.getText().equals(rs.getString("mail")) && txtPassword.getText().equals(rs.getString("password"))) {
				    		JOptionPane.showMessageDialog(null, "The Login is Successfuly");
				    		setVisible(false);
				    		new home().setVisible(true);
				    	}
				    	/*else{
				    		JOptionPane.showMessageDialog(null, 
									  "Invalid Mail or Password", "ERROR", JOptionPane.ERROR_MESSAGE);*/
				    	
				   }		
				}
				
			 catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, 
						  "Invalid Mail or Password", "ERROR", JOptionPane.ERROR_MESSAGE);
			  }
			}
		});
		btnLogin.setForeground(new Color(0, 204, 102));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBounds(256, 336, 150, 57);
		contentPane.add(btnLogin);
		
		JButton btnClose = new JButton("");
		btnClose.setIcon(new ImageIcon("D:\\Gorsel Programlama\\button (3).png"));
		btnClose.setBackground(new Color(255, 255, 204));
		btnClose.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (JOptionPane.showConfirmDialog(null,"The program is closing, are you sure","WARNING",JOptionPane.YES_NO_OPTION)==0) 
				System.exit(0);
				
			}
		});
		btnClose.setForeground(new Color(255, 51, 51));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClose.setBounds(433, 336, 150, 57);
		contentPane.add(btnClose);
		
		txtPassword = new JPasswordField();
		txtPassword.setBackground(new Color(255, 250, 240));
		txtPassword.setBounds(321, 274, 200, 30);
		contentPane.add(txtPassword);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIconTextGap(0);
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/Image/backLogin.jpg")));
		lblNewLabel_2.setBounds(0, 0, 800, 600);
		contentPane.add(lblNewLabel_2);
	}
}
/*try {
					Connection con = DBConnection.getCon();
					String query="select * from tadmin where mail=? and password=?";
					PreparedStatement statement=con.prepareStatement(query);
					statement.setString(1, txtMail.getText().toString());
					statement.setString(2, String.valueOf(txtPassword.getPassword()));
					ResultSet rs= statement.executeQuery();
					if (rs.next()) {
						
						JOptionPane.showMessageDialog(null,"Welcome "+ rs.getString("first_name") +" "+ rs.getString("last_name"));
						//diðer forma girilen kullanýcýnýn name i yolladým	
					 //   txtMail=rs.getString("first_name");
					   setVisible(false);
						new home().setVisible(true);
			        }
					else
					JOptionPane.showMessageDialog(null, 
							  "Invalid username or password", "ERROR", JOptionPane.ERROR_MESSAGE);
					
					
						
				}
				
			 catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			  }*/
