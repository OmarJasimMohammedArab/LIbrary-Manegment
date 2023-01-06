package Context;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
//import project.ConnectionProvider;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class addNewStudent extends JFrame {

	private JPanel contentPane;
	private JTable table_Student;
	private JTextField txt_Name;
	private JTextField txt_Surname;
	private JTextField txt_StudentID;
	private JTextField txt_Facult;
	private JTextField txt_Branch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addNewStudent frame = new addNewStudent();
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
	public addNewStudent() {
		setLocationByPlatform(true);
		setResizable(false);
		setLocation(new Point(500, 300));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setAlignmentX(1.0f);
		scrollPane_1.setBounds(445, 160, 745, 299);
		contentPane.add(scrollPane_1);
		
		table_Student = new JTable();
		table_Student.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"StudentID", "Name", "surName", "faculty", "branch"
			}
		));
		table_Student.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowNo = table_Student.getSelectedRow();
				TableModel model =table_Student.getModel();
				
				txt_StudentID.setText(model.getValueAt(rowNo, 0).toString());
				txt_Name.setText(model.getValueAt(rowNo, 1).toString());
				txt_Surname.setText(model.getValueAt(rowNo, 2).toString());
				txt_Facult.setText(model.getValueAt(rowNo, 3).toString());
				txt_Branch.setText(model.getValueAt(rowNo, 4).toString());
				
			}
		});
		table_Student.setSelectionBackground(new Color(255, 51, 0));
		table_Student.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane_1.setViewportView(table_Student);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\table3.png"));
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Connection con =DBConnection.getCon();
					String qurey="select *from student";
					PreparedStatement pest= con.prepareStatement(qurey);
					ResultSet rs1=pest.executeQuery();
					table_Student.setModel(DbUtils.resultSetToTableModel(rs1));
					
				//	JOptionPane.showMessageDialog(null, "Show Table is Successfuly");
				}
				catch(Exception evt) {
					System.out.println(evt);
			    	JOptionPane.showMessageDialog(null,"The table cannot be found","Error!",JOptionPane.WARNING_MESSAGE );
			    	setVisible(false);
					new statisticDate().setVisible(true);
				}
			}
		});
		lblNewLabel_6.setBounds(445, 99, 170, 50);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_1_1 = new JLabel("Manage Student");
		lblNewLabel_1_1.setForeground(new Color(255, 51, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_1_1.setBounds(561, 11, 300, 50);
		contentPane.add(lblNewLabel_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 51, 0));
		panel_1.setBackground(new Color(255, 51, 0));
		panel_1.setBounds(536, 62, 350, 7);
		contentPane.add(panel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(10, 10, 425, 580);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Branch Name :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(47, 342, 150, 25);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Faculty Name :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(47, 282, 150, 25);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Surname :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(47, 222, 150, 25);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(47, 162, 150, 25);
		panel.add(lblNewLabel_1);
		
		txt_Name = new JTextField();
		txt_Name.setForeground(Color.BLACK);
		txt_Name.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_Name.setColumns(10);
		txt_Name.setBackground(Color.WHITE);
		txt_Name.setBounds(182, 163, 200, 25);
		panel.add(txt_Name);
		
		txt_Surname = new JTextField();
		txt_Surname.setForeground(Color.BLACK);
		txt_Surname.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_Surname.setColumns(10);
		txt_Surname.setBackground(Color.WHITE);
		txt_Surname.setBounds(182, 223, 200, 25);
		panel.add(txt_Surname);
		
		JLabel lblNewLabel = new JLabel("Student ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(47, 102, 150, 25);
		panel.add(lblNewLabel);
		
		txt_StudentID = new JTextField();
		txt_StudentID.setForeground(Color.BLACK);
		txt_StudentID.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_StudentID.setColumns(10);
		txt_StudentID.setBackground(Color.WHITE);
		txt_StudentID.setBounds(182, 101, 200, 25);
		panel.add(txt_StudentID);
		
		JLabel btn_save = new JLabel("");
		btn_save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String studentID = txt_StudentID.getText();
				String name = txt_Name.getText();
				String surName = txt_Surname.getText();
			    String facultyName = txt_Facult.getText();
			    String branchName = txt_Branch.getText();
			   
				try {
					Connection con = DBConnection.getCon();
					Statement st = con.createStatement();
					st.executeUpdate("insert into student values ('"+studentID+"','"+name+"','"+surName+"', "
							+ "'"+facultyName+"','"+branchName+"')" );
					JOptionPane.showMessageDialog(null,"Successful Update");
					setVisible(false);
					new addNewStudent().setVisible(true);
				}
				catch (Exception evt) {
					// TODO: handle exception
			    	System.out.println(evt);
			    	JOptionPane.showMessageDialog(null,"The Update is Error");
			    	setVisible(false);
					new addNewStudent().setVisible(true);
				}	
			}
		});
		btn_save.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\btn_Save.png"));
		btn_save.setBounds(41, 409, 100, 50);
		panel.add(btn_save);
		
		JLabel btn_Update = new JLabel("");
		btn_Update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(updateStudent() == true) {
					JOptionPane.showMessageDialog(null,"The Updated is Successful");
					clearTable();
				}
				else
					JOptionPane.showMessageDialog(null,"The Updated is Error");
			}
		});
		btn_Update.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\btn_Update.png"));
		btn_Update.setBounds(161, 409, 100, 50);
		panel.add(btn_Update);
		
		JLabel btn_Delete = new JLabel("");
		btn_Delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(deleteStudent() == true) {
					JOptionPane.showMessageDialog(null,"The Updated is Successful");
					clearTable();
				}
				else
					JOptionPane.showMessageDialog(null,"The Updated is Error");
			}
		});
		btn_Delete.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\btn_delete.png"));
		btn_Delete.setBounds(282, 409, 100, 50);
		panel.add(btn_Delete);
		
		txt_Facult = new JTextField();
		txt_Facult.setForeground(Color.BLACK);
		txt_Facult.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_Facult.setColumns(10);
		txt_Facult.setBackground(Color.WHITE);
		txt_Facult.setBounds(182, 282, 200, 25);
		panel.add(txt_Facult);
		
		txt_Branch = new JTextField();
		txt_Branch.setForeground(Color.BLACK);
		txt_Branch.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_Branch.setColumns(10);
		txt_Branch.setBackground(Color.WHITE);
		txt_Branch.setBounds(182, 342, 200, 25);
		panel.add(txt_Branch);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new home().setVisible(true);
			}
		});
		lblNewLabel_8.setIcon(new ImageIcon("D:\\Gorsel Programlama\\close (1).png"));
		lblNewLabel_8.setBounds(1160, 10, 30, 30);
		contentPane.add(lblNewLabel_8);
		
	}
	
	public boolean updateStudent() {
		boolean isUpdated = false;
		String studentID = txt_StudentID.getText();
		String name = txt_Name.getText();
		String surName = txt_Surname.getText();
	    String facultyName = txt_Facult.getText();
	    String branchName = txt_Branch.getText();
	    
		try {
			Connection con =DBConnection.getCon();
			String sql = "update student set name =?, surName =?, facultyName =?, branchName =?  where studentID =?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, surName);
			pst.setString(3, facultyName);
			pst.setString(4, branchName);
			pst.setString(5, studentID);
			
		   int rwoCount = pst.executeUpdate();
			if(rwoCount >= 0) {
				isUpdated = true;
			}
			else {
				isUpdated = false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isUpdated;
	}
	
	public boolean deleteStudent() {
		boolean isDeleted = false;
		 String adminID = txt_StudentID.getText();
		 
		 
		 try {
			 Connection con =DBConnection.getCon();
			 String sql = "delete from student where studentID =?";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, adminID);
				
				int rwoCount = pst.executeUpdate();
				if(rwoCount >= 0) {
					isDeleted = true;
				}
				else {
					isDeleted = false;
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return isDeleted;
	}
	
	public void clearTable() {
		DefaultTableModel model = (DefaultTableModel) table_Student.getModel();
		model.setRowCount(0);
	}
	
	public void setStudentTabloDetails() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lm","root","1234root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select *from student");
			
			while(rs.next()) {
				String studentID = rs.getString("studentID");
				String name = rs.getString("Name");
				String surName = rs.getString("surName");
			    String facultyName = rs.getString("faculty");
			    String branchName = rs.getString("branch");
			    
			    Object[] obj = {studentID, name, surName, facultyName, branchName};
			     model = (DefaultTableModel) table_Student.getModel();
			     model.addRow(obj);
			   //  model.addColumn(obj);
			    
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	DefaultTableModel model;
	public void manegeStudent() {
		initComponents();
		setStudentTabloDetails();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		
	}
}
