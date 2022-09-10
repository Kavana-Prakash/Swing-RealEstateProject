package Real_estate;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CLIENT_WINDOW extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldFName;
	private JTextField textFieldLName;
	private JTextField textFieldPhone;
	private JTextField textFieldEmail;
	 String url="jdbc:mysql://localhost:3306/database1?autoReconnect=true&useSSL=false";
	 String uname="root";
	 String pswd="root";
	 private JTable table;
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
					CLIENT_WINDOW frame = new CLIENT_WINDOW();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public void RefreshTable(){
		
		try {
			String query="select * from client";
			Class.forName("com.mysql.jdbc.Driver");
		     java.sql.Connection con=DriverManager.getConnection(url,uname,pswd);
			PreparedStatement st=con.prepareStatement(query);
			ResultSet rs=st.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			rs.close();
			st.close();
			con.close();
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
	public CLIENT_WINDOW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1407, 778);
		setTitle("CLIENT WINDOW");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_title = new JPanel();
		panel_title.setLayout(null);
		panel_title.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		panel_title.setBackground(new Color(0, 51, 102));
		panel_title.setBounds(0, 0, 1389, 90);
		contentPane.add(panel_title);
		
		JLabel label_proptype = new JLabel("CLIENTS");
		label_proptype.setForeground(Color.WHITE);
		label_proptype.setFont(new Font("Tahoma", Font.BOLD, 36));
		label_proptype.setBounds(569, 13, 175, 64);
		panel_title.add(label_proptype);
		
		JPanel panel_body = new JPanel();
		panel_body.setLayout(null);
		panel_body.setBackground(new Color(0, 153, 153));
		panel_body.setBounds(0, 86, 1389, 645);
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
		textAreaAddress.setFont(new Font("Monospaced", Font.PLAIN, 20));
		scrollPane.setViewportView(textAreaAddress);
		
		JButton btnAdd_type = new JButton("ADD");
		btnAdd_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname=textFieldFName.getText();
				String lname=textFieldLName.getText();
				String phone=textFieldPhone.getText();
				String email=textFieldEmail.getText();
				String address=textAreaAddress.getText();
				P_CLIENT client=new P_CLIENT();
				if(fname.trim().equals("")|| phone.trim().equals("")||address.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter required fields", "Empty Fields", 1);
				}
				else {
					
					if(client.addNewClient(new P_CLIENT(0,fname,lname,phone,email,address))){
						JOptionPane.showMessageDialog(null, "New Client Added To The System", "Client Add", 1);
					}
					else {
						JOptionPane.showMessageDialog(null, " Client NOT Added To The System", "Client Add", 2);	
					}
				}
				
			}
		});
		btnAdd_type.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnAdd_type.setBounds(36, 549, 175, 41);
		panel_body.add(btnAdd_type);
		
		JButton btnEdit_type = new JButton("EDIT");
		btnEdit_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname=textFieldFName.getText();
				String lname=textFieldLName.getText();
				String phone=textFieldPhone.getText();
				String email=textFieldEmail.getText();
				String address=textAreaAddress.getText();
				P_CLIENT client=new P_CLIENT();
				if(fname.trim().equals("")|| phone.trim().equals("")||address.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter required fields", "Empty Fields", 1);
				}
				else {
					Integer clientID=Integer.valueOf(textFieldID.getText());
					if(client.editClient(new P_CLIENT(clientID,fname,lname,phone,email,address))){
						JOptionPane.showMessageDialog(null, "Client information edited To The System", "Client Edit", 1);
					}
					else {
						JOptionPane.showMessageDialog(null, " Client information NOT edited To The System", "Client Edit", 2);	
					}
				}
			}
		});
		btnEdit_type.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnEdit_type.setBounds(269, 549, 175, 41);
		panel_body.add(btnEdit_type);
		
		JButton btnRemove_type = new JButton("REMOVE");
		btnRemove_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P_CLIENT client=new P_CLIENT();
				if(textFieldID.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter ID", "Empty ID", 2);
				}	
				
				else {
					int yes_no=JOptionPane.showConfirmDialog(null,"Do you want to delete this row","Delete Confirmation",JOptionPane.YES_NO_OPTION);
					if(yes_no==JOptionPane.YES_OPTION)
					{
						Integer clientID=Integer.valueOf(textFieldID.getText());
					   if(client.deleteClient(clientID)) {
						   JOptionPane.showMessageDialog(null, "Client details deleted", "Client Deletion", 1);
						   textFieldID.setText("");
							textFieldFName.setText("");
							textFieldLName.setText("");
							textFieldPhone.setText("");
							textFieldEmail.setText("");
							textAreaAddress.setText("");
					   }
					   else {
						   JOptionPane.showMessageDialog(null, "Client details NOT deleted", "Client Deletion", 2);
					   }
					}
			  }	
			}
		});
		btnRemove_type.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnRemove_type.setBounds(519, 551, 175, 41);
		panel_body.add(btnRemove_type);
		
		JButton btnRefresh_type = new JButton("REFRESH");
		btnRefresh_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RefreshTable();
			}
		});
		btnRefresh_type.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnRefresh_type.setBounds(777, 551, 175, 41);
		panel_body.add(btnRefresh_type);
		
		JScrollPane scrollPane_table = new JScrollPane();
		scrollPane_table.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_table.setBackground(Color.WHITE);
		scrollPane_table.setBounds(539, 39, 748, 453);
		panel_body.add(scrollPane_table);
		
		table = new JTable();
		table.setRowHeight(40);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row=table.getSelectedRow();
				String ID1=(table.getModel().getValueAt(row, 0)).toString();
					String query="select * from client where ID='"+ID1+"'";
					Class.forName("com.mysql.jdbc.Driver");
				     java.sql.Connection con=DriverManager.getConnection(url,uname,pswd);
					PreparedStatement st=con.prepareStatement(query);
					ResultSet rs=st.executeQuery();
					while(rs.next()) {
					
					textFieldID.setText(((Integer)rs.getInt("id")).toString());
					textFieldFName.setText(rs.getString("fname"));
					textFieldLName.setText(rs.getString("sname"));
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Fname", "sname", "email", "phone", "address"
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
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(115);
		table.getColumnModel().getColumn(4).setPreferredWidth(116);
		table.getColumnModel().getColumn(5).setPreferredWidth(337);
		scrollPane_table.setViewportView(table);
		
		textFieldFName = new JTextField();
		textFieldFName.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textFieldFName.setColumns(10);
		textFieldFName.setBounds(183, 89, 271, 41);
		panel_body.add(textFieldFName);
		
		JLabel Label_Lname = new JLabel("LastName:");
		Label_Lname.setForeground(Color.BLACK);
		Label_Lname.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label_Lname.setBounds(36, 150, 131, 29);
		panel_body.add(Label_Lname);
		
		textFieldLName = new JTextField();
		textFieldLName.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textFieldLName.setColumns(10);
		textFieldLName.setBounds(183, 143, 271, 41);
		panel_body.add(textFieldLName);
		
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
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldID.setText("");
				textFieldFName.setText("");
				textFieldLName.setText("");
				textFieldPhone.setText("");
				textFieldEmail.setText("");
				textAreaAddress.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnClear.setBounds(1012, 549, 175, 41);
		panel_body.add(btnClear);
		
		RefreshTable();
	}
}
