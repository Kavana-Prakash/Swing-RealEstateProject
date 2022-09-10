package Real_estate;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PropertyTypeName extends JFrame {

	private JPanel contentPane;
	private JTable table;
	 String url="jdbc:mysql://localhost:3306/database1?autoReconnect=true&useSSL=false";
	 String uname="root";
	 String pswd="root";
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
					PropertyTypeName frame = new PropertyTypeName();
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
	public PropertyTypeName() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 463);
		setTitle("PROPERTY TYPE NAME");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 425, 393);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 22));
		table.setRowHeight(60);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Type No.", "Property Type Name"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(270);
		try {
			String query="select * from typeName";
			Class.forName("com.mysql.jdbc.Driver");
		     java.sql.Connection con=DriverManager.getConnection(url,uname,pswd);
			PreparedStatement st=con.prepareStatement(query);
			ResultSet rs=st.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (ClassNotFoundException e1) {
            e1.printStackTrace();
	       }	
	        catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	}
}
