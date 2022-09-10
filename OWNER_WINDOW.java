package Real_estate;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OWNER_WINDOW extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldFname;
	private JTextField textFieldLname;
	private JTextField textFieldPhone;
	private JTextField textFieldEmail;
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
					OWNER_WINDOW frame = new OWNER_WINDOW();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public void RefreshTable(){
		
		try {
			String query="select * from property_owner";
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
	public OWNER_WINDOW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1412, 780);
		setTitle("OWNER WINDOW");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel_title = new JPanel();
		panel_title.setLayout(null);
		panel_title.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		panel_title.setBackground(SystemColor.controlShadow);
		panel_title.setBounds(0, 0, 1400, 90);
		contentPane.add(panel_title);
		Border button_border=BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white);
		panel_title.setBorder(button_border);
		
		JLabel lblOwners = new JLabel("OWNERS");
		lblOwners.setForeground(Color.WHITE);
		lblOwners.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblOwners.setBounds(585, 13, 170, 64);
		panel_title.add(lblOwners);
		
		JPanel panel_body = new JPanel();
		panel_body.setLayout(null);
		panel_body.setBackground(new Color(255, 228, 181));
		panel_body.setBounds(0, 88, 1400, 645);
		contentPane.add(panel_body);
		
		JLabel Label_ID = new JLabel("ID:");
		Label_ID.setForeground(Color.BLACK);
		Label_ID.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label_ID.setBounds(117, 42, 49, 29);
		panel_body.add(Label_ID);
		
		JLabel lblfirstname = new JLabel("*FirstName:");
		lblfirstname.setForeground(Color.BLACK);
		lblfirstname.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblfirstname.setBounds(12, 96, 155, 29);
		panel_body.add(lblfirstname);
		
		JLabel lbladdress = new JLabel("*Address:");
		lbladdress.setForeground(Color.BLACK);
		lbladdress.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbladdress.setBounds(36, 353, 118, 29);
		panel_body.add(lbladdress);
		
		textFieldID = new JTextField();
		textFieldID.setFont(new Font("Tahoma", Font.PLAIN, 34));
		textFieldID.setColumns(10);
		textFieldID.setBounds(184, 32, 161, 39);
		panel_body.add(textFieldID);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(178, 361, 271, 131);
		panel_body.add(scrollPane);
		
		JTextArea textAreaAddress = new JTextArea();
		textAreaAddress.setFont(new Font("Monospaced", Font.PLAIN, 28));
		scrollPane.setViewportView(textAreaAddress);
		
		JButton btnAdd_type = new JButton("ADD");
		btnAdd_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname=textFieldFname.getText();
				String lname=textFieldLname.getText();
				String phone=textFieldPhone.getText();
				String email=textFieldEmail.getText();
				String address=textAreaAddress.getText();
				P_OWNER owner=new P_OWNER();
				if(fname.trim().equals("")|| phone.trim().equals("")||address.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter required fields", "Empty Fields", 1);
				}
				else {
					
					if(owner.addNewOwner(new P_OWNER(0,fname,lname,phone,email,address))){
						JOptionPane.showMessageDialog(null, "New Owner Added To The System", "Owner Add", 1);
					}
					else {
						JOptionPane.showMessageDialog(null, " Owner NOT Added To The System", "Owner Add", 2);	
					}
				}
				
			}
		});
		btnAdd_type.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnAdd_type.setBounds(36, 522, 175, 41);
		panel_body.add(btnAdd_type);
		btnAdd_type.setBorder(button_border);
		
		JButton btnEdit_type = new JButton("EDIT");
		btnEdit_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fname=textFieldFname.getText();
				String lname=textFieldLname.getText();
				String phone=textFieldPhone.getText();
				String email=textFieldEmail.getText();
				String address=textAreaAddress.getText();
				P_OWNER owner=new P_OWNER();
				if(fname.trim().equals("")|| phone.trim().equals("")||address.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter required fields", "Empty Fields", 1);
				}
				else {
					Integer ownerID=Integer.valueOf(textFieldID.getText());
					if(owner.editOwner(new P_OWNER(ownerID,fname,lname,phone,email,address))){
						JOptionPane.showMessageDialog(null, "Owner information edited To The System", "Owner Edit", 1);
					}
					else {
						JOptionPane.showMessageDialog(null, " Owner NOT Added To The System", "Owner Edit", 2);	
					}
				}
			}
		});
		btnEdit_type.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnEdit_type.setBounds(283, 522, 175, 41);
		panel_body.add(btnEdit_type);
		btnEdit_type.setBorder(button_border);
		
		JButton btnRemove_type = new JButton("REMOVE");
		btnRemove_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				P_OWNER owner=new P_OWNER();
				if(textFieldID.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter ID", "Empty ID", 2);
				}	
				
				else {
					int yes_no=JOptionPane.showConfirmDialog(null,"Do you want to delete this row","Delete Confirmation",JOptionPane.YES_NO_OPTION);
					if(yes_no==JOptionPane.YES_OPTION)
					{
						Integer ownerID=Integer.valueOf(textFieldID.getText());
					   if(owner.deleteOwner(ownerID)) {
						   JOptionPane.showMessageDialog(null, "Owner details deleted", "Owner Deletion", 1);
						   textFieldID.setText("");
						   textFieldFname.setText("");
						   textFieldLname.setText("");
						   textFieldPhone.setText("");
						   textFieldEmail.setText("");
						   textAreaAddress.setText("");
					   }
					   else {
						   JOptionPane.showMessageDialog(null, "owner details NOT deleted", "Owner Deletion", 2);
					   }
					}
				}
			}
		});
		btnRemove_type.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnRemove_type.setBounds(537, 524, 175, 41);
		panel_body.add(btnRemove_type);
		btnRemove_type.setBorder(button_border);
		
		JButton btnRefresh_type = new JButton("REFRESH");
		btnRefresh_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RefreshTable();
			}
		});
		btnRefresh_type.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnRefresh_type.setBounds(784, 524, 175, 41);
		panel_body.add(btnRefresh_type);
		btnRefresh_type.setBorder(button_border);
		
		
		JScrollPane scrollPane_table = new JScrollPane();
		scrollPane_table.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_table.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_table.setBackground(Color.WHITE);
		scrollPane_table.setBounds(537, 32, 808, 460);
		panel_body.add(scrollPane_table);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row=table.getSelectedRow();
				String ID1=(table.getModel().getValueAt(row, 0)).toString();
					String query="select * from property_owner where ID='"+ID1+"'";
					Class.forName("com.mysql.jdbc.Driver");
				     java.sql.Connection con=DriverManager.getConnection(url,uname,pswd);
					PreparedStatement st=con.prepareStatement(query);
					ResultSet rs=st.executeQuery();
					while(rs.next()) {
					
					textFieldID.setText(((Integer)rs.getInt("id")).toString());
					textFieldFname.setText(rs.getString("fname"));
					textFieldLname.setText(rs.getString("sname"));
					textFieldPhone.setText(rs.getString("phone"));
					textFieldEmail.setText(rs.getString("email"));
					textAreaAddress.setText(rs.getString("address"));
					
					}	
				} catch (ClassNotFoundException e1) {
		            e1.printStackTrace();
			       }	
			        catch (SQLException e1) {
			            e1.printStackTrace();
			        }	
			}	
			
		});
		table.setRowMargin(2);
		table.setRowHeight(28);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "FirstName", "LastName", "Phone", "Email", "Address"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(35);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(200);
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane_table.setViewportView(table);
		
		textFieldFname = new JTextField();
		textFieldFname.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textFieldFname.setColumns(10);
		textFieldFname.setBounds(183, 89, 271, 41);
		panel_body.add(textFieldFname);
		
		JLabel Label_Lname = new JLabel("LastName:");
		Label_Lname.setForeground(Color.BLACK);
		Label_Lname.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label_Lname.setBounds(36, 150, 131, 29);
		panel_body.add(Label_Lname);
		
		textFieldLname = new JTextField();
		textFieldLname.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textFieldLname.setColumns(10);
		textFieldLname.setBounds(183, 143, 271, 41);
		panel_body.add(textFieldLname);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(183, 209, 271, 41);
		panel_body.add(textFieldPhone);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(184, 283, 271, 41);
		panel_body.add(textFieldEmail);
		
		JLabel lblphone = new JLabel("*Phone:");
		lblphone.setForeground(Color.BLACK);
		lblphone.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblphone.setBounds(63, 216, 104, 29);
		panel_body.add(lblphone);
		
		JLabel lblemail = new JLabel("Email:");
		lblemail.setForeground(Color.BLACK);
		lblemail.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblemail.setBounds(82, 283, 81, 29);
		panel_body.add(lblemail);
		
		JLabel lblNewLabel = new JLabel("*REQUIRED");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(585, 13, 97, 16);
		panel_body.add(lblNewLabel);
		
		JButton btnOwnProp_type_1 = new JButton("Owner Properties");
		btnOwnProp_type_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					int selectedRowIndex=table.getSelectedRow();
					int id=Integer.valueOf(table.getValueAt(selectedRowIndex,0).toString());
					OWNER_PROPERTIES_FORM1 form=new OWNER_PROPERTIES_FORM1(id);
					form.ownerID=id;
					form.setVisible(true);
					form.setLocationRelativeTo(null);;
					form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
				catch(Exception r) {
					JOptionPane.showMessageDialog(null, "Select owner from the table", "No Owner Selected", 2);
				}
			}
		});
		btnOwnProp_type_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		btnOwnProp_type_1.setBounds(73, 589, 401, 41);
		panel_body.add(btnOwnProp_type_1);
		btnOwnProp_type_1.setBorder(button_border);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldID.setText("");
				textFieldFname.setText("");
				textFieldLname.setText("");
				textFieldPhone.setText("");
				textFieldEmail.setText("");
				textAreaAddress.setText("");
				
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnClear.setBounds(1046, 522, 175, 41);
		btnClear.setBorder(button_border);
		panel_body.add(btnClear);
		RefreshTable();
	}
}
