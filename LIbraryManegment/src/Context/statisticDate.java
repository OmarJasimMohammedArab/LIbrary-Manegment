package Context;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.List;
import java.awt.Choice;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import Context.DBConnection;
import net.proteanit.sql.DbUtils;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.Component;

public class statisticDate extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel;
	private JLabel lbl_btnReturn;
	private JLabel lbl_btnBook;
	private JTextField txt_Bookid;
	private JTextField txt_BookName;
	private JTextField txt_BookGrne;
	private JTextField txt_BookAuthor;
	private JTextField txt_Quantity;
	private JTextField txt_publis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					statisticDate frame = new statisticDate();
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
	public statisticDate() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 11, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		scrollPane_1.setBounds(692, 110, 498, 121);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowNo = table_1.getSelectedRow();
				TableModel model =table_1.getModel();
				
				txt_Bookid.setText(model.getValueAt(rowNo, 0).toString());
				txt_BookName.setText(model.getValueAt(rowNo, 1).toString());
				txt_BookGrne.setText(model.getValueAt(rowNo, 2).toString());
				txt_BookAuthor.setText(model.getValueAt(rowNo, 3).toString());
				txt_Quantity.setText(model.getValueAt(rowNo, 4).toString());
				txt_publis.setText(model.getValueAt(rowNo, 5).toString());
			}
		});
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table_1.setRowHeight(25);
		table_1.setRowMargin(4);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Gorsel Programlama\\010 (2).png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(402, 11, 350, 57);
		contentPane.add(lblNewLabel_1);
		
		JButton btnClose = new JButton("");
		btnClose.setBackground(new Color(255, 228, 181));
		btnClose.setIcon(new ImageIcon("D:\\Gorsel Programlama\\close (1).png"));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new home().setVisible(true);
			}
		});
		btnClose.setBounds(1160, 11, 30, 30);
		contentPane.add(btnClose);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\Gorsel Programlama\\2299265.jpg"));
		lblNewLabel.setBounds(0, 0, 700, 00);
		contentPane.add(lblNewLabel);
		
		lbl_btnReturn = new JLabel("");
		lbl_btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Connection con =DBConnection.getCon();
					String qurey="select *from issue";
					PreparedStatement pest= con.prepareStatement(qurey);
					ResultSet rs1=pest.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs1));
					
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
		lbl_btnReturn.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\table1.png"));
		lbl_btnReturn.setBounds(510, 79, 172, 45);
		contentPane.add(lbl_btnReturn);
		
		lbl_btnBook = new JLabel("");
		lbl_btnBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Connection con =DBConnection.getCon();
					String qurey="select *from book";
					PreparedStatement pest= con.prepareStatement(qurey);
					ResultSet rs1=pest.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs1));
					
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
		lbl_btnBook.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\table2.png"));
		lbl_btnBook.setBounds(510, 135, 172, 45);
		contentPane.add(lbl_btnBook);
		
		JLabel lbl_btnBook_1 = new JLabel("");
		lbl_btnBook_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Connection con =DBConnection.getCon();
					String qurey="select *from student";
					PreparedStatement pest= con.prepareStatement(qurey);
					ResultSet rs1=pest.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs1));
					
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
		lbl_btnBook_1.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\table3.png"));
		lbl_btnBook_1.setBounds(510, 191, 172, 45);
		contentPane.add(lbl_btnBook_1);
		
		JLabel lbl_btnBook_1_1 = new JLabel("");
		lbl_btnBook_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Connection con =DBConnection.getCon();
					String qurey="select *from book";
					PreparedStatement pest= con.prepareStatement(qurey);
					ResultSet rs1=pest.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs1));
					
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
		lbl_btnBook_1_1.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\table4.png"));
		lbl_btnBook_1_1.setBounds(510, 247, 172, 45);
		contentPane.add(lbl_btnBook_1_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(10, 11, 382, 578);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Book ID :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(38, 50, 100, 25);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Book Name :");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(38, 103, 100, 25);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Book Genre :");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(38, 160, 100, 25);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Book Author :");
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(38, 214, 100, 25);
		panel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Book Quantity :");
		lblNewLabel_2_4.setForeground(Color.WHITE);
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_4.setBounds(38, 271, 115, 25);
		panel.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Book Publis :");
		lblNewLabel_2_5.setForeground(Color.WHITE);
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_5.setBounds(38, 325, 100, 25);
		panel.add(lblNewLabel_2_5);
		
		txt_Bookid = new JTextField();
		txt_Bookid.setBounds(175, 50, 170, 25);
		panel.add(txt_Bookid);
		txt_Bookid.setColumns(10);
		
		txt_BookName = new JTextField();
		txt_BookName.setColumns(10);
		txt_BookName.setBounds(175, 103, 170, 25);
		panel.add(txt_BookName);
		
		txt_BookGrne = new JTextField();
		txt_BookGrne.setColumns(10);
		txt_BookGrne.setBounds(175, 160, 170, 25);
		panel.add(txt_BookGrne);
		
		txt_BookAuthor = new JTextField();
		txt_BookAuthor.setColumns(10);
		txt_BookAuthor.setBounds(175, 214, 170, 25);
		panel.add(txt_BookAuthor);
		
		txt_Quantity = new JTextField();
		txt_Quantity.setColumns(10);
		txt_Quantity.setBounds(175, 271, 170, 25);
		panel.add(txt_Quantity);
		
		txt_publis = new JTextField();
		txt_publis.setColumns(10);
		txt_publis.setBounds(175, 325, 170, 25);
		panel.add(txt_publis);
		
	
	}
}
