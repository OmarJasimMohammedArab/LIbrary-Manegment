package Context;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;

import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.SimpleDateRule;
import com.mysql.cj.protocol.Resultset;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IssusBook extends JFrame {

	private JPanel contentPane;
	private JTextField txtBookId;
	private JTextField txtstudentID;
	private JTable table_Issue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssusBook frame = new IssusBook();
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
	public IssusBook() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book ID :");
		lblNewLabel.setBounds(100, 150, 100, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
		
		JLabel lblStudentId = new JLabel("Student ID :");
		lblStudentId.setBounds(100, 200, 100, 25);
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblStudentId);
		
		JLabel lblIssuseData = new JLabel("Issuse Data :");
		lblIssuseData.setBounds(100, 250, 100, 25);
		lblIssuseData.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblIssuseData);
		
		JLabel lblDueData = new JLabel("Due Data :");
		lblDueData.setBounds(100, 300, 100, 25);
		lblDueData.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblDueData);
		
		txtBookId = new JTextField();
		txtBookId.setBounds(210, 150, 160, 25);
		txtBookId.setBackground(new Color(255, 255, 255));
		txtBookId.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(txtBookId);
		txtBookId.setColumns(10);
		
		txtstudentID = new JTextField();
		txtstudentID.setBounds(210, 200, 160, 25);
		txtstudentID.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtstudentID.setColumns(10);
		txtstudentID.setBackground(new Color(255, 255, 255));
		contentPane.add(txtstudentID);
		
		JDateChooser dateIssue = new JDateChooser();
		dateIssue.setBounds(210, 250, 160, 25);
		dateIssue.setBackground(new Color(255, 228, 196));
		contentPane.add(dateIssue);
		
		JDateChooser dateDue = new JDateChooser();
		dateDue.setBounds(210, 300, 160, 25);
		dateDue.setBackground(new Color(255, 228, 196));
		contentPane.add(dateDue);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(512, 178, 678, 255);
		scrollPane_1.setAlignmentX(1.0f);
		contentPane.add(scrollPane_1);
		
		table_Issue = new JTable();
		table_Issue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		table_Issue.setRowMargin(4);
		table_Issue.setRowHeight(25);
		scrollPane_1.setViewportView(table_Issue);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Connection con =DBConnection.getCon();
					String qurey="select *from issue";
					PreparedStatement pest= con.prepareStatement(qurey);
					ResultSet rs1=pest.executeQuery();
					table_Issue.setModel(DbUtils.resultSetToTableModel(rs1));
					
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
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\table1.png"));
		lblNewLabel_2.setBounds(512, 105, 175, 50);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Manage Issus Book");
		lblNewLabel_1_1.setForeground(new Color(255, 51, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_1_1.setBounds(537, 12, 350, 50);
		contentPane.add(lblNewLabel_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 51, 0));
		panel_1.setBackground(new Color(255, 51, 0));
		panel_1.setBounds(512, 63, 370, 7);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new home().setVisible(true);
			}
		});
		lblNewLabel_8.setIcon(new ImageIcon("D:\\Gorsel Programlama\\close (1).png"));
		lblNewLabel_8.setBounds(1160, 11, 30, 30);
		contentPane.add(lblNewLabel_8);
		
		JLabel btn_Save = new JLabel("");
		btn_Save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
				String bookID = txtBookId.getText();
				String studentID = txtstudentID.getText();
				String issueDate = dFormat.format(dateIssue.getDate());	
				String dueDate = dFormat.format(dateDue.getDate());
				String returnBook =("No");
				try {
					Connection con = DBConnection.getCon();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select *from book where bookID='"+bookID+"'");
					if(rs.next()) {
						ResultSet rs1 = st.executeQuery("select *from student where studentID='"+studentID+"'");
						if(rs1.next()) {
							st.executeUpdate("insert into issue values ('"+bookID+"','"+studentID+"','"+issueDate+"','"+dueDate+"','"+returnBook+"')");
							JOptionPane.showMessageDialog(null,"Book is Successfuly Issued");
							setVisible(false);
							new IssusBook().setVisible(true);
						}
						else 
							  JOptionPane.showMessageDialog(null,"inCurrect Student ID !");
					}
					else 
					  JOptionPane.showMessageDialog(null,"inCurrect Book ID !");
					
					
					
				}
				catch(Exception evt) {
					// TODO: handle exception
			    	System.out.println(evt);
			    	JOptionPane.showMessageDialog(null,"The Update is Error");
			    	setVisible(false);
					new IssusBook().setVisible(true);
				}
			}
		});
		btn_Save.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\btn_Save.png"));
		btn_Save.setBounds(100, 356, 100, 50);
		contentPane.add(btn_Save);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Gorsel Programlama\\pngegg (1).png"));
		lblNewLabel_1.setBounds(0 , 0, 480, 600);
		contentPane.add(lblNewLabel_1);
	}
}
