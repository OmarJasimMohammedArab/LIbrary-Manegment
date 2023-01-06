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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

public class addNewBook extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Bookid;
	private JTextField txt_BookName;
	private JTextField txt_BookGrne;
	private JTextField txt_BookAuthor;
	private JTextField txt_Quantity;
	private JTextField txt_publis;
	private JTable table_Book;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addNewBook frame = new addNewBook();
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
	public addNewBook() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(10, 10, 425, 580);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Book ID :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(35, 50, 125, 25);
		panel.add(lblNewLabel_3);
		
		txt_Bookid = new JTextField();
		txt_Bookid.setForeground(Color.BLACK);
		txt_Bookid.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_Bookid.setColumns(10);
		txt_Bookid.setBackground(new Color(255, 255, 255));
		txt_Bookid.setBounds(185, 50, 170, 25);
		panel.add(txt_Bookid);
		
		JLabel lblNewLabel_1_2 = new JLabel("Book Name :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(35, 100, 125, 25);
		panel.add(lblNewLabel_1_2);
		
		txt_BookName = new JTextField();
		txt_BookName.setForeground(Color.BLACK);
		txt_BookName.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_BookName.setColumns(10);
		txt_BookName.setBackground(new Color(255, 255, 255));
		txt_BookName.setBounds(185, 100, 170, 25);
		panel.add(txt_BookName);
		
		txt_BookGrne = new JTextField();
		txt_BookGrne.setForeground(Color.BLACK);
		txt_BookGrne.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_BookGrne.setColumns(10);
		txt_BookGrne.setBackground(new Color(255, 255, 255));
		txt_BookGrne.setBounds(185, 150, 170, 25);
		panel.add(txt_BookGrne);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Book Genre :");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_2.setBounds(35, 150, 125, 25);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Author Book  :");
		lblNewLabel_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_3.setBounds(35, 200, 125, 25);
		panel.add(lblNewLabel_1_1_1_3);
		
		txt_BookAuthor = new JTextField();
		txt_BookAuthor.setForeground(Color.BLACK);
		txt_BookAuthor.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_BookAuthor.setColumns(10);
		txt_BookAuthor.setBackground(new Color(255, 255, 255));
		txt_BookAuthor.setBounds(185, 200, 170, 25);
		panel.add(txt_BookAuthor);
		
		txt_Quantity = new JTextField();
		txt_Quantity.setForeground(Color.BLACK);
		txt_Quantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_Quantity.setColumns(10);
		txt_Quantity.setBackground(new Color(255, 255, 255));
		txt_Quantity.setBounds(185, 250, 170, 25);
		panel.add(txt_Quantity);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Book Quantity :");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_1.setBounds(35, 250, 140, 25);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		txt_publis = new JTextField();
		txt_publis.setForeground(Color.BLACK);
		txt_publis.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_publis.setColumns(10);
		txt_publis.setBackground(new Color(255, 255, 255));
		txt_publis.setBounds(185, 300, 170, 25);
		panel.add(txt_publis);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Publisher Yera :");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_1.setBounds(35, 300, 140, 25);
		panel.add(lblNewLabel_1_1_1_2_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				  String bookID = txt_Bookid.getText();
				     String bName =  txt_BookName.getText();
				     String bGenre = txt_BookGrne.getText();
				     String bAuthor = txt_BookAuthor.getText();
				     String bQuantity = txt_Quantity.getText();
				     String bPublis = txt_publis.getText();
					try {
						Connection con =DBConnection.getCon();
						Statement statement = con.createStatement();
						statement.executeUpdate("insert into Book values ('"+bookID+"','"+bName+"',"
								+ "'"+bGenre+"', '"+bAuthor+"','"+bQuantity+"','"+bPublis+"')");
						JOptionPane.showMessageDialog(null,"Successful Update");
						setVisible(false);
						new addNewBook().setVisible(true);
					}
				    catch (Exception evt) {
					// TODO: handle exception
			    	System.out.println(evt);
			    	JOptionPane.showMessageDialog(null,"The Update is Error");
			    	setVisible(false);
					new addNewBook().setVisible(true);
				    }
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\btn_Save.png"));
		lblNewLabel_4.setBounds(35, 362, 100, 50);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\btn_Update.png"));
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(updateBook() == true) {
					JOptionPane.showMessageDialog(null,"The Updated is Successful");
					clearTable();
				}
				else
					JOptionPane.showMessageDialog(null,"The Update is Error");
			}
		});
		lblNewLabel_6.setBounds(156, 362, 100, 50);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\btn_delete.png"));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(deleteBook() == true) {
					JOptionPane.showMessageDialog(null,"The Deleted is Successful");
					clearTable();
				}
				else
					JOptionPane.showMessageDialog(null,"The Deleted is Error");
			}
		});
		lblNewLabel.setBounds(276, 362, 100, 50);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Manage Book ");
		lblNewLabel_1.setBounds(562, 11, 300, 50);
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Gorsel Programlama\\Iconlar\\icons8_Books_52px_1.png"));
		lblNewLabel_1.setForeground(new Color(255, 51, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(537, 62, 350, 7);
		panel_1.setBackground(new Color(255, 51, 0));
		panel_1.setForeground(new Color(255, 51, 0));
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(1160, 10, 30, 30);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new home().setVisible(true);
				
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Gorsel Programlama\\close (1).png"));
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(493, 164, 684, 288);
		scrollPane_1.setAlignmentX(1.0f);
		contentPane.add(scrollPane_1);
		
		table_Book = new JTable();
		table_Book.setSelectionBackground(new Color(255, 51, 0));
		table_Book.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowNo = table_Book.getSelectedRow();
				TableModel model =table_Book.getModel();
				
				txt_Bookid.setText(model.getValueAt(rowNo, 0).toString());
				txt_BookName.setText(model.getValueAt(rowNo, 1).toString());
				txt_BookGrne.setText(model.getValueAt(rowNo, 2).toString());
				txt_BookAuthor.setText(model.getValueAt(rowNo, 3).toString());
				txt_Quantity.setText(model.getValueAt(rowNo, 4).toString());
				txt_publis.setText(model.getValueAt(rowNo, 5).toString());
			}
		});
		table_Book.setFont(new Font("Tahoma", Font.BOLD, 14));
		table_Book.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				
			}
		));
		scrollPane_1.setViewportView(table_Book);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Gorsel Programlama\\btn\\table2.png"));
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Connection con =DBConnection.getCon();
					String qurey="select *from book";
					PreparedStatement pest= con.prepareStatement(qurey);
					ResultSet rs1=pest.executeQuery();
					table_Book.setModel(DbUtils.resultSetToTableModel(rs1));
					
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
		lblNewLabel_5.setBounds(493, 100, 170, 50);
		contentPane.add(lblNewLabel_5);
		
		
	}
	
	public boolean updateBook() {
		boolean isUpdated = false;
		 String bookID = txt_Bookid.getText();
	     String bName =  txt_BookName.getText();
	     String bGenre = txt_BookGrne.getText();
	     String bAuthor = txt_BookAuthor.getText();
	     String bQuantity = txt_Quantity.getText();
	     String bPublis = txt_publis.getText();
		try {
			Connection con =DBConnection.getCon();
			String sql = "update book set bName =?, bGenre =?, "
					+ "bAuthor =?, bQuantity =?, bPublis =? where bookID =?";
			PreparedStatement pst = con.prepareStatement(sql);
			//pst.setString(0, bookID);
			pst.setString(1, bName);
			pst.setString(2, bGenre);
			pst.setString(3, bAuthor);
			pst.setString(4, bQuantity);
			pst.setString(5, bPublis);
			pst.setString(6, bookID);
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
	
	public boolean deleteBook() {
		boolean isDeleted = false;
		 String bookID = txt_Bookid.getText();
		 
		 try {
			 Connection con =DBConnection.getCon();
			 String sql = "delete from book where bookID =?";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, bookID);
				
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
		DefaultTableModel model = (DefaultTableModel) table_Book.getModel();
		model.setRowCount(0);
	}
}

