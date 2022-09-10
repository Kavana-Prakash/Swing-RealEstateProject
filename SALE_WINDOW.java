package Real_estate;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SALE_WINDOW extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldPropertyID;
	private JTextField textFieldClientID;
	private JTextField textFieldFinalPrice;
	private JTable tableProperty;
	 String url="jdbc:mysql://localhost:3306/database1?autoReconnect=true&useSSL=false";
	 String uname="root";
	 String pswd="root";
	 private JTable tableClient;
	 private JTable tableSales;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			//UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			UIManager.setLookAndFeel(new com.jtattoo.plaf.hifi.HiFiLookAndFeel());
		}catch(Exception e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SALE_WINDOW frame = new SALE_WINDOW();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public void PopulateClientTable(){
		
		try {
			String query="select id,fname,sname from client";
			Class.forName("com.mysql.jdbc.Driver");
		     java.sql.Connection con=DriverManager.getConnection(url,uname,pswd);
			PreparedStatement st1=con.prepareStatement(query);
			ResultSet rs1=st1.executeQuery();
			tableClient.setSelectionBackground(Color.cyan);
			tableClient.setModel(DbUtils.resultSetToTableModel(rs1));
		} catch (ClassNotFoundException e1) {
            e1.printStackTrace();
	       }	
	        catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	}
public void PopulatePropertyTable(){
	
	try {
		String query="select id,ownerid,price from property";
		Class.forName("com.mysql.jdbc.Driver");
	     Connection con1;
	     con1=DriverManager.getConnection(url,uname,pswd);
		PreparedStatement st2=con1.prepareStatement(query);
		ResultSet rs2=st2.executeQuery();
		tableProperty.setSelectionBackground(Color.cyan);
		tableProperty.setModel(DbUtils.resultSetToTableModel(rs2));
		
	} catch (ClassNotFoundException e1) {
        e1.printStackTrace();
       }	
        catch (SQLException e1) {
            e1.printStackTrace();
        }
}
public void PopulateSaleTable(){
	
	try {
		String query="select * from sale";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con2;
	    con2=DriverManager.getConnection(url,uname,pswd);
		PreparedStatement st=con2.prepareStatement(query);
		ResultSet rs=st.executeQuery();
		tableSales.setSelectionBackground(Color.cyan);
		tableSales.setModel(DbUtils.resultSetToTableModel(rs));
		
	} catch (ClassNotFoundException e1) {
        e1.printStackTrace();
       }	
        catch (SQLException e1) {
            e1.printStackTrace();
        }
}

	/**
	 * Create the frame.
	 */
	public SALE_WINDOW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1757, 784);
		setTitle("SALE WINDOW");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel_title = new JPanel();
		panel_title.setLayout(null);
		panel_title.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		panel_title.setBackground(new Color(51, 153, 51));
		panel_title.setBounds(0, 0, 1739, 90);
		contentPane.add(panel_title);
		
		JLabel label_proptype = new JLabel("SALE");
		label_proptype.setForeground(Color.WHITE);
		label_proptype.setFont(new Font("Tahoma", Font.BOLD, 46));
		label_proptype.setBounds(796, 13, 114, 64);
		panel_title.add(label_proptype);
		
		JPanel panel_body = new JPanel();
		panel_body.setLayout(null);
		panel_body.setBackground(new Color(51, 153, 102));
		panel_body.setBounds(0, 89, 1739, 635);
		contentPane.add(panel_body);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setForeground(Color.WHITE);
		lblID.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblID.setBounds(117, 42, 49, 29);
		panel_body.add(lblID);
		
		JLabel lblPropertyID = new JLabel("Property ID:");
		lblPropertyID.setForeground(Color.WHITE);
		lblPropertyID.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPropertyID.setBounds(12, 96, 161, 29);
		panel_body.add(lblPropertyID);
		
		textFieldID = new JTextField();
		textFieldID.setFont(new Font("Tahoma", Font.PLAIN, 34));
		textFieldID.setColumns(10);
		textFieldID.setBounds(185, 33, 161, 39);
		panel_body.add(textFieldID);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(185, 273, 238, 49);
		panel_body.add(dateChooser);
		
		JButton btnAdd_type = new JButton("ADD");
		btnAdd_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//int id=Integer.valueOf(textFieldID.getText());
					int propertyID=Integer.valueOf(textFieldPropertyID.getText());
					int clientID=Integer.valueOf(textFieldClientID.getText());
					String finalPrice=textFieldFinalPrice.getText();
					SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
					String sellingdate=dateFormat.format(dateChooser.getDate());
					
					P_SALE sale=new P_SALE(0,propertyID,clientID,finalPrice,sellingdate);
					if(new P_SALE().addNewSale(sale)) {
						JOptionPane.showMessageDialog(null, "Sale details added", "Sale Details Addition", 1);
					}
					else {
						JOptionPane.showMessageDialog(null, "Sale details NOT added", "Sale Details Addition", 2);
					}
					
				}
				catch(Exception q) {
				  JOptionPane.showMessageDialog(null, "Enter the property and client details", "ERROR", 2);
				}
				
			}
		});
		btnAdd_type.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnAdd_type.setBounds(60, 347, 363, 41);
		panel_body.add(btnAdd_type);
		btnAdd_type.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.red));
		
		JButton btnEdit_type = new JButton("EDIT");
		btnEdit_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id=Integer.valueOf(textFieldID.getText());
					int propertyID=Integer.valueOf(textFieldPropertyID.getText());
					int clientID=Integer.valueOf(textFieldClientID.getText());
					String finalPrice=textFieldFinalPrice.getText();
					SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
					String sellingdate=dateFormat.format(dateChooser.getDate());
					
					P_SALE sale=new P_SALE(id,propertyID,clientID,finalPrice,sellingdate);
					if(new P_SALE().editSale(sale)) {
						JOptionPane.showMessageDialog(null, "Sale details edited", "Sale Details Edition", 1);
					}
					else {
						JOptionPane.showMessageDialog(null, "Sale details NOT edited", "Sale Details Edition", 2);
					}
				}
				catch(Exception r) {
					JOptionPane.showMessageDialog(null, "Enter the Sale ID", "ERROR", 2);
				}
			}
		});
		btnEdit_type.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnEdit_type.setBounds(60, 411, 363, 41);
		panel_body.add(btnEdit_type);
		btnEdit_type.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.red));
		
		JButton btnRemove_type = new JButton("REMOVE");
		btnRemove_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id=Integer.valueOf(textFieldID.getText());
					
					
					if(new P_SALE().deleteSale(id)) {
						JOptionPane.showMessageDialog(null, "Sale details deleted", "Sale Details deletion", 1);
					}
					else {
						JOptionPane.showMessageDialog(null, "Sale details NOT deleted", "Sale Details deletion", 2);
					}
				}
				catch(Exception r) {
					JOptionPane.showMessageDialog(null, "Enter Sale ID", "ERROR", 2);
				}
			}
		});
		btnRemove_type.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnRemove_type.setBounds(60, 477, 363, 41);
		panel_body.add(btnRemove_type);
		btnRemove_type.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.red));
		
		textFieldPropertyID = new JTextField();
		textFieldPropertyID.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textFieldPropertyID.setColumns(10);
		textFieldPropertyID.setBounds(185, 89, 238, 41);
		panel_body.add(textFieldPropertyID);
		
		JLabel lblClientId = new JLabel("Client ID:");
		lblClientId.setForeground(Color.WHITE);
		lblClientId.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblClientId.setBounds(48, 150, 118, 29);
		panel_body.add(lblClientId);
		
		textFieldClientID = new JTextField();
		textFieldClientID.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textFieldClientID.setColumns(10);
		textFieldClientID.setBounds(185, 143, 238, 41);
		panel_body.add(textFieldClientID);
		
		textFieldFinalPrice = new JTextField();
		textFieldFinalPrice.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textFieldFinalPrice.setColumns(10);
		textFieldFinalPrice.setBounds(185, 209, 238, 41);
		panel_body.add(textFieldFinalPrice);
		
		JLabel lblFinalPrice = new JLabel("Final Price:");
		lblFinalPrice.setForeground(Color.WHITE);
		lblFinalPrice.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblFinalPrice.setBounds(23, 216, 144, 29);
		panel_body.add(lblFinalPrice);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDate.setBounds(82, 283, 81, 29);
		panel_body.add(lblDate);
		
		JScrollPane scrollPanePropertyTable = new JScrollPane();
		scrollPanePropertyTable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanePropertyTable.setBackground(Color.WHITE);
		scrollPanePropertyTable.setBounds(1357, 69, 355, 430);
		panel_body.add(scrollPanePropertyTable);
		
		tableProperty = new JTable();
		tableProperty.setRowHeight(30);
		tableProperty.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRowIndex=tableProperty.getSelectedRow();
				textFieldID.setText(tableProperty.getValueAt(selectedRowIndex, 0).toString());
				textFieldPropertyID.setText(tableProperty.getValueAt(selectedRowIndex, 1).toString());
				textFieldFinalPrice.setText(tableProperty.getValueAt(selectedRowIndex, 2).toString());
				
			}
		});
		tableProperty.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"ID", "OwnerID", "Price"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableProperty.getColumnModel().getColumn(2).setPreferredWidth(85);
		scrollPanePropertyTable.setViewportView(tableProperty);
		
		JScrollPane scrollPaneClientTable = new JScrollPane();
		scrollPaneClientTable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneClientTable.setBackground(Color.WHITE);
		scrollPaneClientTable.setBounds(966, 69, 367, 430);
		panel_body.add(scrollPaneClientTable);
		
		tableClient = new JTable();
		tableClient.setRowHeight(30);
		tableClient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tableClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				int selectedRowIndex=tableClient.getSelectedRow();
				textFieldClientID.setText(tableClient.getValueAt(selectedRowIndex, 0).toString());
					
					
						
				} 
		});
		tableClient.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"ID", "FirstName", "LastName"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableClient.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableClient.getColumnModel().getColumn(2).setPreferredWidth(100);
		scrollPaneClientTable.setViewportView(tableClient);
		
		JLabel LabelClientList = new JLabel("Clients list:");
		LabelClientList.setForeground(Color.WHITE);
		LabelClientList.setFont(new Font("Tahoma", Font.BOLD, 24));
		LabelClientList.setBounds(966, 13, 144, 29);
		panel_body.add(LabelClientList);
		
		JLabel LabelSalesList = new JLabel("Sales list:");
		LabelSalesList.setForeground(Color.WHITE);
		LabelSalesList.setFont(new Font("Tahoma", Font.BOLD, 24));
		LabelSalesList.setBounds(495, 13, 131, 29);
		panel_body.add(LabelSalesList);
		
		JLabel LabelPropertyList = new JLabel("Properties list:");
		LabelPropertyList.setForeground(Color.WHITE);
		LabelPropertyList.setFont(new Font("Tahoma", Font.BOLD, 24));
		LabelPropertyList.setBounds(1357, 13, 190, 29);
		panel_body.add(LabelPropertyList);
		
		JScrollPane scrollPaneClientTable_1 = new JScrollPane();
		scrollPaneClientTable_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneClientTable_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneClientTable_1.setBackground(Color.WHITE);
		scrollPaneClientTable_1.setBounds(452, 69, 485, 473);
		panel_body.add(scrollPaneClientTable_1);
		
		tableSales = new JTable();
		tableSales.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRowIndex=tableSales.getSelectedRow();
				textFieldID.setText(tableSales.getValueAt(selectedRowIndex, 0).toString());
				textFieldPropertyID.setText(tableSales.getValueAt(selectedRowIndex, 1).toString());
				textFieldClientID.setText(tableSales.getValueAt(selectedRowIndex, 2).toString());
				textFieldFinalPrice.setText(tableSales.getValueAt(selectedRowIndex, 3).toString());
				java.util.Date dateFormat;
				try {
					dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse(tableSales.getValueAt(selectedRowIndex, 4).toString());
					dateChooser.setDate(dateFormat);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		tableSales.setRowHeight(30);
		tableSales.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "PropertyID", "ClientID", "FinalPrice", "SellingDate"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableSales.getColumnModel().getColumn(0).setPreferredWidth(55);
		tableSales.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableSales.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableSales.getColumnModel().getColumn(3).setPreferredWidth(150);
		tableSales.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableSales.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPaneClientTable_1.setViewportView(tableSales);
		
		JButton btnRefreshSaleTable = new JButton("Refresh ");
		btnRefreshSaleTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				PopulateSaleTable();
			}
		});
		btnRefreshSaleTable.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnRefreshSaleTable.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.red));
		btnRefreshSaleTable.setBounds(452, 555, 485, 41);
		panel_body.add(btnRefreshSaleTable);
		
		JButton btnRefreshClientstable = new JButton("Refresh ");
		btnRefreshClientstable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PopulateClientTable();
			}
		});
		btnRefreshClientstable.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnRefreshClientstable.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.red));
		btnRefreshClientstable.setBounds(966, 512, 367, 41);
		panel_body.add(btnRefreshClientstable);
		
		JButton btnRefreshPropertyTable = new JButton("Refresh");
		btnRefreshPropertyTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PopulatePropertyTable();
			}
		});
		btnRefreshPropertyTable.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnRefreshPropertyTable.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.red));
		btnRefreshPropertyTable.setBounds(1357, 512, 355, 41);
		panel_body.add(btnRefreshPropertyTable);
		
		JButton btnAddClient = new JButton("Add New Client");
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CLIENT_WINDOW CLIENTform=new CLIENT_WINDOW();
				CLIENTform.setVisible(true);
				CLIENTform.setLocationRelativeTo(null);;
				CLIENTform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnAddClient.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnAddClient.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.red));
		btnAddClient.setBounds(966, 567, 367, 41);
		panel_body.add(btnAddClient);
		
		JButton btnAddProperty = new JButton("Add New Property");
		btnAddProperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PROPERTY_WINDOW PROPERTYform=new PROPERTY_WINDOW();
				PROPERTYform.setVisible(true);
				PROPERTYform.setLocationRelativeTo(null);;
				PROPERTYform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnAddProperty.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnAddProperty.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.red));
		btnAddProperty.setBounds(1357, 567, 355, 41);
		panel_body.add(btnAddProperty);
		
		JButton btnRemove_type_1 = new JButton("CLEAR");
		btnRemove_type_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldID.setText("");
				textFieldPropertyID.setText("");
				textFieldFinalPrice.setText("");
				textFieldClientID.setText("");
				dateChooser.setDate(null);
			}
		});
		btnRemove_type_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnRemove_type_1.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.red));
		btnRemove_type_1.setBounds(60, 544, 363, 41);
		panel_body.add(btnRemove_type_1);
		PopulatePropertyTable();
		PopulateClientTable();
		PopulateSaleTable();
		
	}
}
