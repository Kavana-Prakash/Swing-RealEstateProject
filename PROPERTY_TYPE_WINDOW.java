package Real_estate;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;
import com.mysql.jdbc.Connection;

import net.proteanit.sql.DbUtils;

import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PROPERTY_TYPE_WINDOW extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textField_1;
	private JTextField textFieldName;
	private JTable table;
    Connection con;
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
					PROPERTY_TYPE_WINDOW frame = new PROPERTY_TYPE_WINDOW();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void RefreshTable(){
		
		try {
			String query="select * from property_type";
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

	/**
	 * Create the frame.
	 */
	public PROPERTY_TYPE_WINDOW() {
		setTitle("PROPERTY-TYPE");
		setBackground(Color.RED);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1157, 712);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
	
		
		
		JPanel panel_title = new JPanel();
		panel_title.setBackground(Color.DARK_GRAY);
		panel_title.setBounds(0, 0, 1149, 90);
		contentPane.add(panel_title);
		panel_title.setLayout(null);
		panel_title.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		
		JLabel label_proptype = new JLabel("PROPERTY-TYPE");
		label_proptype.setBounds(391, 13, 342, 64);
		panel_title.add(label_proptype);
		label_proptype.setForeground(Color.WHITE);
		label_proptype.setFont(new Font("Tahoma", Font.BOLD, 36));
		
		JPanel panel_body = new JPanel();
		panel_body.setBackground(Color.LIGHT_GRAY);
		panel_body.setBounds(0, 89, 1149, 585);
		contentPane.add(panel_body);
		panel_body.setLayout(null);
		
		JLabel Label_ID = new JLabel("ID:");
		Label_ID.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label_ID.setForeground(Color.BLACK);
		Label_ID.setBounds(93, 32, 49, 29);
		panel_body.add(Label_ID);
		
		
		JLabel Label_Name = new JLabel("Name:");
		Label_Name.setForeground(Color.BLACK);
		Label_Name.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label_Name.setBounds(65, 150, 86, 29);
		panel_body.add(Label_Name);
		
		JLabel Label_Description = new JLabel("Description:");
		Label_Description.setForeground(Color.BLACK);
		Label_Description.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label_Description.setBounds(6, 239, 145, 29);
		panel_body.add(Label_Description);
		
		textFieldID = new JTextField();
		textFieldID.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textFieldID.setBounds(171, 33, 161, 50);
		panel_body.add(textFieldID);
		textFieldID.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(171, 132, 297, 50);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(181, 234, 286, 146);
		panel_body.add(scrollPane);
		
		JTextArea textAreaDescription =new JTextArea();
		textAreaDescription.setFont(new Font("Monospaced", Font.PLAIN, 28));
		scrollPane.setViewportView(textAreaDescription);
		
		Border button_border=BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white);
		
		
		JButton btnAdd_type = new JButton("ADD");
		btnAdd_type.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd_type.setBorder(button_border);
		btnAdd_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textFieldName.getText();
				String description=textAreaDescription.getText();
				P_TYPE type=new P_TYPE(1,name,description);
				if(!name.trim().equals("")) {
					if(type.execTypeQuery("add", type)) {
						JOptionPane.showMessageDialog(null,"New row values ADDED","Add Button", 1);
					}
					else {
						JOptionPane.showMessageDialog(null,"Operation Failed","Add Button",2);
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Enter Name","Empty Name Field",2);
				}
			}
		});
		btnAdd_type.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnAdd_type.setBounds(65, 469, 175, 41);
		panel_body.add(btnAdd_type);
		
		JButton btnEdit_type = new JButton("EDIT");
		btnEdit_type.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEdit_type.setBorder(button_border);
		btnEdit_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name=textFieldName.getText();
					String description=textAreaDescription.getText();
					int id=Integer.valueOf(textFieldID.getText());
					P_TYPE type=new P_TYPE(id,name,description);
					if(!name.trim().equals("")) {
						if(type.execTypeQuery("edit", type)) {
							JOptionPane.showMessageDialog(null,"one row EDITED","Edit Button", 1);
						}
						else {
							JOptionPane.showMessageDialog(null,"Operation Failed","Edit Button",2);
						}
					}	
				}
				catch(Exception a) {
					JOptionPane.showMessageDialog(null,a.getMessage()+"Enter ID","Empty Name Field",0);
				}
				
			}
		});
		btnEdit_type.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnEdit_type.setBounds(344, 469, 175, 41);
		panel_body.add(btnEdit_type);
		
		JButton btnRemove_type = new JButton("REMOVE");
		btnRemove_type.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRemove_type.setBorder(button_border);
		btnRemove_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer id=Integer.valueOf(textFieldID.getText());
					P_TYPE type=new P_TYPE(id,"","");
					if(!(textFieldID.getText().trim().equals(""))) {
						int yes_no=JOptionPane.showConfirmDialog(null,"Do you want to delete this row","Delete Confirmation",JOptionPane.YES_NO_OPTION);
						if(yes_no==JOptionPane.YES_OPTION)
						{
							if(type.execTypeQuery("remove", type)) {
								JOptionPane.showMessageDialog(null,"one row deleted","Remove Button", 1);
								textFieldID.setText("");
								textFieldName.setText("");
								textAreaDescription.setText("");
							}
							else {
								JOptionPane.showMessageDialog(null,"Operation failed","Remove Button",2);
							}
						}
					}
				}
				catch(Exception w) {
						JOptionPane.showMessageDialog(null,w.getMessage()+"Enter ID","Empty ID Field",0);
				}	
			}
		});
		btnRemove_type.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnRemove_type.setBounds(650, 471, 175, 41);
		panel_body.add(btnRemove_type);
		
		JButton btnRefresh_type = new JButton("REFRESH");
		btnRefresh_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RefreshTable();
			}
		});
		btnRefresh_type.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRefresh_type.setBorder(button_border);
		btnRefresh_type.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnRefresh_type.setBounds(920, 471, 175, 41);
		panel_body.add(btnRefresh_type);
		
		JScrollPane scrollPane_list = new JScrollPane();
		scrollPane_list.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_list.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_list.setBackground(Color.WHITE);
		scrollPane_list.setBounds(509, 32, 586, 379);
		panel_body.add(scrollPane_list);
		
		table = new JTable();
		table.setRowMargin(2);
		table.setRowHeight(30);
		table.setFont(new Font("Tahoma", Font.PLAIN, 22));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row=table.getSelectedRow();
				String ID1=(table.getModel().getValueAt(row, 0)).toString();
					String query="select * from property_type where ID='"+ID1+"'";
					Class.forName("com.mysql.jdbc.Driver");
				     java.sql.Connection con=DriverManager.getConnection(url,uname,pswd);
					PreparedStatement st=con.prepareStatement(query);
					ResultSet rs=st.executeQuery();
					while(rs.next()) {
					
					textFieldID.setText(((Integer)rs.getInt("id")).toString());
					textFieldName.setText(rs.getString("name"));
					textAreaDescription.setText(rs.getString("description"));
					
					}	
				} catch (ClassNotFoundException e1) {
		            e1.printStackTrace();
			       }	
			        catch (SQLException e1) {
			            e1.printStackTrace();
			        }	
			}
			
		});
			
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"ID", "NAME", "DESCRIPTION"
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
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		scrollPane_list.setViewportView(table);
		
		
		
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textFieldName.setBounds(171, 150, 271, 41);
		panel_body.add(textFieldName);
		textFieldName.setColumns(10);
		RefreshTable();
		}
}
		 
		

