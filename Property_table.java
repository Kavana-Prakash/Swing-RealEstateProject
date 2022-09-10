package Real_estate;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ScrollPaneConstants;

public class Property_table extends JFrame {

	private JPanel contentPane;
	private JTable table;
	 String url="jdbc:mysql://localhost:3306/database1?autoReconnect=true&useSSL=false";
	 String uname="root";
	 String pswd="root";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Property_table frame = new Property_table();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void RefreshTable() {
		try {
			String query="select * from property";
			Class.forName("com.mysql.jdbc.Driver");
		     java.sql.Connection con=DriverManager.getConnection(url,uname,pswd);
			PreparedStatement st=con.prepareStatement(query);
			ResultSet rs=st.executeQuery();
		
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.getColumnModel().getColumn(0).setPreferredWidth(25);
			table.getColumnModel().getColumn(1).setPreferredWidth(25);
			table.getColumnModel().getColumn(2).setPreferredWidth(65);
			table.getColumnModel().getColumn(3).setPreferredWidth(25);
			table.getColumnModel().getColumn(5).setPreferredWidth(100);
			table.getColumnModel().getColumn(6).setPreferredWidth(35);
			table.getColumnModel().getColumn(7).setPreferredWidth(35);
			table.getColumnModel().getColumn(8).setPreferredWidth(35);
			table.getColumnModel().getColumn(9).setPreferredWidth(25);
			table.getColumnModel().getColumn(10).setPreferredWidth(25);
			table.getColumnModel().getColumn(11).setPreferredWidth(25);
			table.getColumnModel().getColumn(12).setPreferredWidth(25);
			table.getColumnModel().getColumn(13).setPreferredWidth(300);
			
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
	public Property_table() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PROPERTY TABLE");
		setBounds(100, 100, 1748, 769);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 13, 1730, 696);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		table.setRowHeight(45);
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane.setViewportView(table);
		
	
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Type", "Square_Feet", "Owner_id", "Price", "Address", "Bedroom", "Bathroom", "Age_building", "Balcony", "Pool", "Backyard", "Garage", "Description"
				}
			) {
				Class[] columnTypes = new Class[] {
					Integer.class, Integer.class, Integer.class, Integer.class, String.class, String.class, Integer.class, Integer.class, Integer.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			
			RefreshTable();
		} 
	}

