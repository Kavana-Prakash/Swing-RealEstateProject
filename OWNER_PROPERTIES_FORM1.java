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

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.Font;

public class OWNER_PROPERTIES_FORM1 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	String url="jdbc:mysql://localhost:3306/database1?autoReconnect=true&useSSL=false";
	 String uname="root";
	 String pswd="root";
	 java.sql.PreparedStatement st;
	public void RefreshTable1(int id){
		
		try {
			String query="select * from property where ownerid=?";
			Class.forName("com.mysql.jdbc.Driver");
		     java.sql.Connection con=DriverManager.getConnection(url,uname,pswd);
			st=con.prepareStatement(query);
			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
			
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.getColumnModel().getColumn(0).setPreferredWidth(30);
			table.getColumnModel().getColumn(1).setPreferredWidth(25);
			table.getColumnModel().getColumn(2).setPreferredWidth(50);
			table.getColumnModel().getColumn(3).setPreferredWidth(60);
			table.getColumnModel().getColumn(5).setPreferredWidth(100);
			table.getColumnModel().getColumn(6).setPreferredWidth(65);
			table.getColumnModel().getColumn(7).setPreferredWidth(65);
			table.getColumnModel().getColumn(8).setPreferredWidth(55);
			table.getColumnModel().getColumn(9).setPreferredWidth(55);
			table.getColumnModel().getColumn(10).setPreferredWidth(45);
			table.getColumnModel().getColumn(11).setPreferredWidth(65);
			table.getColumnModel().getColumn(12).setPreferredWidth(55);
			table.getColumnModel().getColumn(13).setPreferredWidth(350);
		} catch (ClassNotFoundException e1) {
	        e1.printStackTrace();
	       }	
	        catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	}
	public void RefreshTable2() {
		try {
			String query="select * from typeName";
			Class.forName("com.mysql.jdbc.Driver");
		     java.sql.Connection con=DriverManager.getConnection(url,uname,pswd);
			PreparedStatement st=con.prepareStatement(query);
			ResultSet rs=st.executeQuery();
			tablePropertyType.setModel(DbUtils.resultSetToTableModel(rs));
			table.getColumnModel().getColumn(0).setPreferredWidth(25);
			table.getColumnModel().getColumn(1).setPreferredWidth(200);
		} catch (ClassNotFoundException e1) {
            e1.printStackTrace();
	       }	
	        catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	}
	static int ownerID;
	private JTable tablePropertyType;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					OWNER_PROPERTIES_FORM1 frame = new OWNER_PROPERTIES_FORM1(ownerID);
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
	public OWNER_PROPERTIES_FORM1(int oID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1728, 788);
		setTitle("OWNER PROPERTIES LIST");
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.setForeground(UIManager.getColor("Desktop.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 1382, 715);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table.setRowHeight(45);
		table.setBackground(UIManager.getColor("ComboBox.buttonHighlight"));
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(1406, 13, 292, 715);
		contentPane.add(scrollPane_1);
		
		tablePropertyType = new JTable();
		tablePropertyType.setRowHeight(85);
		scrollPane_1.setViewportView(tablePropertyType);
		
		RefreshTable1(oID);
		RefreshTable2();
	}
}
