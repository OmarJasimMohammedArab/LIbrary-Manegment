package Context;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

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
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class addAdmin extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_9;
	private JPanel panel;
	private JTextField txt_adminID;
	private JTextField txt_TCNO;
	private JTextField txt_Name;
	private JTextField txt_SurName;
	private JTextField txt_Address;
	private JTextField txt_TelNO;
	private JTextField txt_Gmail;
	private JPasswordField txt_Password;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1_1;
	private JPanel panel_1;
	private JLabel lblNewLabel_10;
	private JTable table_Admin;
	private JLabel btn_Update;
	private JLabel btn_Delete;
	private JLabel lblNewLabel_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addAdmin frame = new addAdmin();
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
	public addAdmin() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(0, 0, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		panel = new JPanel();
		panel.setBounds(10, 10, 425, 580);
		panel.setBackground(new Color(0, 191, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Admin ID :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(35, 44, 100, 25);
		panel.add(lblNewLabel_7);
		
		txt_adminID = new JTextField();
		txt_adminID.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_adminID.setColumns(10);
		txt_adminID.setBackground(new Color(255, 255, 255));
		txt_adminID.setBounds(140, 44, 180, 25);
		panel.add(txt_adminID);
		
		JLabel lblNewLabel = new JLabel("T.C NO :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(35, 99, 100, 25);
		panel.add(lblNewLabel);
		
		txt_TCNO = new JTextField();
		txt_TCNO.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_TCNO.setColumns(10);
		txt_TCNO.setBackground(new Color(255, 255, 255));
		txt_TCNO.setBounds(140, 99, 180, 25);
		panel.add(txt_TCNO);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(35, 149, 100, 25);
		panel.add(lblNewLabel_1);
		
		txt_Name = new JTextField();
		txt_Name.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_Name.setColumns(10);
		txt_Name.setBackground(new Color(255, 255, 255));
		txt_Name.setBounds(140, 149, 180, 25);
		panel.add(txt_Name);
		
		JLabel lblNewLabel_2 = new JLabel("Surname :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(35, 199, 100, 25);
		panel.add(lblNewLabel_2);
		
		txt_SurName = new JTextField();
		txt_SurName.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_SurName.setColumns(10);
		txt_SurName.setBackground(new Color(255, 255, 255));
		txt_SurName.setBounds(140, 199, 180, 25);
		panel.add(txt_SurName);
		
		JLabel lblNewLabel_3 = new JLabel("Address :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(35, 249, 100, 25);
		panel.add(lblNewLabel_3);
		
		txt_Address = new JTextField();
		txt_Address.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_Address.setColumns(10);
		txt_Address.setBackground(new Color(255, 255, 255));
		txt_Address.setBounds(140, 249, 180, 25);
		panel.add(txt_Address);
		
		JLabel lblNewLabel_4 = new JLabel("Phone NO :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(35, 299, 100, 25);
		panel.add(lblNewLabel_4);
		
		txt_TelNO = new JTextField();
		txt_TelNO.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_TelNO.setColumns(10);
		txt_TelNO.setBackground(new Color(255, 255, 255));
		txt_TelNO.setBounds(140, 299, 180, 25);
		panel.add(txt_TelNO);
		
		JLabel lblNewLabel_5 = new JLabel("Gmail :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(35, 349, 100, 25);
		panel.add(lblNewLabel_5);
		
		txt_Gmail = new JTextField();
		txt_Gmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_Gmail.setColumns(10);
		txt_Gmail.setBackground(new Color(255, 255, 255));
		txt_Gmail.setBounds(140, 349, 180, 25);
		panel.add(txt_Gmail);
		
		JLabel lblNewLabel_5_1 = new JLabel("Password :");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_1.setBounds(35, 396, 100, 25);
		panel.add(lblNewLabel_5_1);
		
		txt_Password = new JPasswordField();
		txt_Password.setBackground(new Color(255, 255, 255));
		txt_Password.setBounds(140, 396, 180, 25);
		panel.add(txt_Password);
		
		JLabel btn_Save = new JLabel("");
		btn_Save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String adminID = txt_adminID.getText();
				String TCNO = txt_TCNO.getText();
				String name = txt_Name.getText();
			    String surName = txt_SurName.getText();
			    String address = txt_Address.getText();
			    String phoneNO = txt_TelNO.getText();
			    String mail = txt_Gmail.getText();
			    String password = txt_Password.getText();
				try {
					Connection con = DBConnection.getCon();
					Statement st = con.createStatement();
					st.executeUpdate("insert into tadmin values ('"+adminID+"','"+TCNO+"','"+name+"','"+surName+"', "
							+ "'"+address+"','"+phoneNO+"','"+mail+"','"+password+"')" );
					JOptionPane.showMessageDialog(null,"Successful Update");
					setVisible(false);
					new addAdmin().setVisible(true);
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
		btn_Save.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\btn_Save.png"));
		btn_Save.setBounds(35, 443, 100, 52);
		panel.add(btn_Save);
		
		btn_Update = new JLabel("");
		btn_Update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(updateAdmin() == true) {
					JOptionPane.showMessageDialog(null,"The Updated is Successful");
					clearTable();
				}
				else
					JOptionPane.showMessageDialog(null,"The Updated is Error");
			}
		});
		btn_Update.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\btn_Update.png"));
		btn_Update.setBounds(155, 443, 100, 52);
		panel.add(btn_Update);
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBounds(155, 443, 100, 52);
		panel.add(lblNewLabel_9);
		
		btn_Delete = new JLabel("");
		btn_Delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(deleteAdmin() == true) {
					JOptionPane.showMessageDialog(null,"The Deleted is Successful");
					clearTable();
				}
				else
					JOptionPane.showMessageDialog(null,"The Deleted is Error");
			}
		});
		btn_Delete.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\btn_delete.png"));
		btn_Delete.setBounds(278, 443, 100, 52);
		panel.add(btn_Delete);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(474, 170, 716, 299);
		scrollPane.setAlignmentX(1.0f);
		contentPane.add(scrollPane);
		
		table_Admin = new JTable();
		table_Admin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowNo = table_Admin.getSelectedRow();
				TableModel model =table_Admin.getModel();
				
				txt_adminID.setText(model.getValueAt(rowNo, 0).toString());
				txt_TCNO.setText(model.getValueAt(rowNo, 1).toString());
				txt_Name.setText(model.getValueAt(rowNo, 2).toString());
				txt_SurName.setText(model.getValueAt(rowNo, 3).toString());
				txt_Address.setText(model.getValueAt(rowNo, 4).toString());
				txt_TelNO.setText(model.getValueAt(rowNo, 5).toString());
				txt_Gmail.setText(model.getValueAt(rowNo, 6).toString());
				txt_Password.setText(model.getValueAt(rowNo, 7).toString());
			}
		});
		table_Admin.setSelectionBackground(new Color(255, 51, 0));
		table_Admin.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane.setViewportView(table_Admin);
		
		lblNewLabel_1_1 = new JLabel("Manage Admin");
		lblNewLabel_1_1.setBounds(537, 11, 300, 50);
		lblNewLabel_1_1.setForeground(new Color(255, 51, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		contentPane.add(lblNewLabel_1_1);
		
		panel_1 = new JPanel();
		panel_1.setBounds(512, 62, 350, 7);
		panel_1.setForeground(new Color(255, 51, 0));
		panel_1.setBackground(new Color(255, 51, 0));
		contentPane.add(panel_1);
		
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\table4.png"));
		lblNewLabel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Connection con =DBConnection.getCon();
					String qurey="select *from tadmin";
					PreparedStatement pest= con.prepareStatement(qurey);
					ResultSet rs1=pest.executeQuery();
					table_Admin.setModel(DbUtils.resultSetToTableModel(rs1));
					
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
		lblNewLabel_10.setBounds(475, 108, 170, 50);
		
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_8 = new JLabel("");
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
	
	public boolean updateAdmin() {
		boolean isUpdated = false;
		String adminID = txt_adminID.getText();
		String TCNO = txt_TCNO.getText();
		String name = txt_Name.getText();
	    String surName = txt_SurName.getText();
	    String address = txt_Address.getText();
	    String phoneNO = txt_TelNO.getText();
	    String mail = txt_Gmail.getText();
	    String password = txt_Password.getText();
		try {
			Connection con =DBConnection.getCon();
			String sql = "update tadmin set TCNO =?, name =?, "
					+ "surName =?, address =?, phoneNO =?, mail =?, password =? where adminID =?";
			PreparedStatement pst = con.prepareStatement(sql);
			//pst.setString(0, bookID);
			pst.setString(1, TCNO);
			pst.setString(2, name);
			pst.setString(3, surName);
			pst.setString(4, address);
			pst.setString(5, phoneNO);
			pst.setString(6, mail);
			pst.setString(7, password);
			pst.setString(8, adminID);
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
	
	public boolean deleteAdmin() {
		boolean isDeleted = false;
		 String adminID = txt_adminID.getText();
		 
		 try {
			 Connection con =DBConnection.getCon();
			 String sql = "delete from tadmin where adminID =?";
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
		DefaultTableModel model = (DefaultTableModel) table_Admin.getModel();
		model.setRowCount(0);
	}
	
}

	

