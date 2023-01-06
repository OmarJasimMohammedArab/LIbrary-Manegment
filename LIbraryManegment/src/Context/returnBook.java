package Context;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;

import net.proteanit.sql.DbUtils;

import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class returnBook extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField txt_DueDate;
	private JTextField txt_IssueDate;
	private JTextField txt_StudentID;
	private JTextField txt_BookID;
	private JLabel lblNewLabel_4;
	private JScrollPane scrollPane;
	private JTable table_Return;
	private JLabel btn_Details;
	private JLabel lblNewLabel_1_1;
	private JPanel panel_1;
	private JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					returnBook frame = new returnBook();
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
	public returnBook() {
		setLocation(new Point(350, 150));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 10, 425, 579);
		panel.setBackground(new Color(0, 191, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		txt_DueDate = new JTextField();
		txt_DueDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_DueDate.setColumns(10);
		txt_DueDate.setBackground(new Color(255, 222, 173));
		txt_DueDate.setBounds(166, 309, 200, 25);
		panel.add(txt_DueDate);
		
		txt_IssueDate = new JTextField();
		txt_IssueDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_IssueDate.setColumns(10);
		txt_IssueDate.setBackground(new Color(255, 222, 173));
		txt_IssueDate.setBounds(166, 259, 200, 25);
		panel.add(txt_IssueDate);
		
		txt_StudentID = new JTextField();
		txt_StudentID.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_StudentID.setColumns(10);
		txt_StudentID.setBackground(new Color(255, 222, 173));
		txt_StudentID.setBounds(166, 165, 200, 25);
		panel.add(txt_StudentID);
		
		txt_BookID = new JTextField();
		txt_BookID.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_BookID.setColumns(10);
		txt_BookID.setBackground(new Color(255, 222, 173));
		txt_BookID.setBounds(166, 115, 200, 25);
		panel.add(txt_BookID);
		
		JLabel lblNewLabel = new JLabel("Book ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(46, 115, 120, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(46, 165, 120, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Issue Date :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(46, 259, 120, 25);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Due Date :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(46, 309, 120, 25);
		panel.add(lblNewLabel_3);
		
		JLabel btn_Save = new JLabel("");
		btn_Save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String bookID = txt_BookID.getText();
				String studentID = txt_StudentID.getText();
				try {
					Connection con = DBConnection.getCon();
					Statement st = con.createStatement();
					st.executeUpdate("update issue set returnBook='Yes' where studentID='"+studentID+"'and bookID='"+bookID+"'");
					JOptionPane.showMessageDialog(null, "The book successfuly return ");
					setVisible(false);
					new returnBook().setVisible(true);
				}
				catch(Exception evt) {
					JOptionPane.showMessageDialog(null, "inCurrect Student ID or inCurrect Book ID !");
					setVisible(false);
					new returnBook().setVisible(true);
				}
			}
		});
		btn_Save.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\btn_Save.png"));
		btn_Save.setBounds(50, 377, 100, 51);
		panel.add(btn_Save);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String bookID = txt_BookID.getText();
				String studentID = txt_StudentID.getText();
				try {
					Connection con = DBConnection.getCon();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select *from issue where bookID='"+bookID+"'and studentID='"+studentID+"' ");
					if(rs.next()) {
						txt_IssueDate.setText(rs.getString(3));
						txt_DueDate.setText(rs.getString(4));
						txt_BookID.setEditable(false);
						txt_StudentID.setEditable(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Book is not Issue to this Student");
						setVisible(false);
						new returnBook().setVisible(true);
						}   
				}
				catch(Exception evt) {
					JOptionPane.showMessageDialog(null, "Connection Error");
					
				}
			}
		});
		lblNewLabel_4.setBounds(46, 214, 46, 14);
		panel.add(lblNewLabel_4);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(473, 181, 717, 255);
		scrollPane.setAlignmentX(1.0f);
		contentPane.add(scrollPane);
		
		table_Return = new JTable();
		table_Return.setRowMargin(4);
		table_Return.setRowHeight(25);
		scrollPane.setViewportView(table_Return);
		
		btn_Details = new JLabel("");
		btn_Details.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Connection con =DBConnection.getCon();
					String qurey="select *from issue";
					PreparedStatement pest= con.prepareStatement(qurey);
					ResultSet rs1=pest.executeQuery();
					table_Return.setModel(DbUtils.resultSetToTableModel(rs1));
					
					//JOptionPane.showMessageDialog(null, "Show Table is Successfuly");
				}
				catch(Exception evt) {
					System.out.println(evt);
			    	JOptionPane.showMessageDialog(null,"The table cannot be found","Error!",JOptionPane.WARNING_MESSAGE );
			    	setVisible(false);
					new statisticDate().setVisible(true);
				}
			}
		});
		btn_Details.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\table1.png"));
		btn_Details.setBounds(473, 120, 174, 50);
		contentPane.add(btn_Details);
		
		lblNewLabel_1_1 = new JLabel("Manage Issus Book");
		lblNewLabel_1_1.setForeground(new Color(255, 51, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_1_1.setBounds(537, 11, 350, 50);
		contentPane.add(lblNewLabel_1_1);
		
		panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 51, 0));
		panel_1.setBackground(new Color(255, 51, 0));
		panel_1.setBounds(512, 62, 370, 7);
		contentPane.add(panel_1);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new home().setVisible(true);
			}
		});
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Gorsel Programlama\\close (1).png"));
		lblNewLabel_6.setBounds(1160, 10, 30, 30);
		contentPane.add(lblNewLabel_6);
	}
}
