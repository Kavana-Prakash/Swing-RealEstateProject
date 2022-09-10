package Real_estate;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import java.util.HashMap;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class PROPERTY_WINDOW extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldSqft;
	private JTextField textFieldOwnID;
	private JTextField textFieldPrice;
	private JComboBox comboBoxType;
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
					PROPERTY_WINDOW frame = new PROPERTY_WINDOW();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void fillComboBox()
	{
		try {
				String query="select * from property_type";
				Class.forName("com.mysql.jdbc.Driver");
			     java.sql.Connection con=DriverManager.getConnection(url,uname,pswd);
				PreparedStatement st=con.prepareStatement(query);
				comboBoxType.addItem(" ");
				ResultSet rs=st.executeQuery();
				while(rs.next())
				{
					comboBoxType.addItem(rs.getString("name"));
				}
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
	public PROPERTY_WINDOW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1219, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Property");
		
		JPanel panel_title = new JPanel();
		panel_title.setLayout(null);
		panel_title.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		panel_title.setBackground(new Color(255, 0, 0));
		panel_title.setBounds(0, 0, 1201, 90);
		contentPane.add(panel_title);
		
		JLabel label_proptype = new JLabel("Property");
		label_proptype.setForeground(Color.WHITE);
		label_proptype.setFont(new Font("Tahoma", Font.BOLD, 39));
		label_proptype.setBounds(484, 13, 175, 64);
		panel_title.add(label_proptype);
		
		JPanel panel_body = new JPanel();
		panel_body.setLayout(null);
		panel_body.setBackground(new Color(222, 184, 135));
		panel_body.setBounds(0, 90, 1201, 647);
		contentPane.add(panel_body);
		
		JLabel Label_ID = new JLabel("ID:");
		Label_ID.setForeground(Color.BLACK);
		Label_ID.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label_ID.setBounds(117, 42, 49, 29);
		panel_body.add(Label_ID);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setForeground(Color.BLACK);
		lblType.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblType.setBounds(87, 95, 67, 29);
		panel_body.add(lblType);
		
		JLabel lbladdress = new JLabel("Address:");
		lbladdress.setForeground(Color.BLACK);
		lbladdress.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbladdress.setBounds(51, 354, 103, 29);
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
		textAreaAddress.setFont(new Font("Monospaced", Font.PLAIN, 24));
		scrollPane.setViewportView(textAreaAddress);
		
		comboBoxType = new JComboBox();
		comboBoxType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxType.setBounds(184, 96, 260, 30);
		panel_body.add(comboBoxType);
		
		textFieldSqft = new JTextField();
		textFieldSqft.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textFieldSqft.setColumns(10);
		textFieldSqft.setBounds(183, 143, 271, 41);
		panel_body.add(textFieldSqft);
		
		JSpinner spinnerBathRoom = new JSpinner();
		spinnerBathRoom.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerBathRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinnerBathRoom.setBounds(681, 110, 118, 41);
		panel_body.add(spinnerBathRoom);

		JSpinner spinner_AgeOfHouse = new JSpinner();
		spinner_AgeOfHouse.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_AgeOfHouse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner_AgeOfHouse.setBounds(681, 225, 118, 39);
		panel_body.add(spinner_AgeOfHouse);
		
		JSpinner spinnerBedRoom = new JSpinner();
		spinnerBedRoom.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerBedRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinnerBedRoom.setBounds(681, 59, 118, 39);
		panel_body.add(spinnerBedRoom);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(532, 332, 410, 152);
		panel_body.add(scrollPane_1);
		
		JTextArea textAreaDescription = new JTextArea();
		textAreaDescription.setFont(new Font("Monospaced", Font.PLAIN, 24));
		scrollPane_1.setViewportView(textAreaDescription);
		
		JCheckBox cbGarage = new JCheckBox("Parking");
		cbGarage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbGarage.setBounds(969, 287, 97, 39);
		panel_body.add(cbGarage);
		
		JCheckBox cbBalcony = new JCheckBox("Balcony");
		cbBalcony.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbBalcony.setBounds(965, 85, 97, 39);
		panel_body.add(cbBalcony);
		
		JCheckBox cbPool = new JCheckBox("Pool");
		cbPool.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbPool.setBounds(969, 147, 75, 39);
		panel_body.add(cbPool);
		
		JCheckBox cbBackyard = new JCheckBox("Backyard");
		cbBackyard.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbBackyard.setBounds(971, 213, 113, 39);
		panel_body.add(cbBackyard);
		
		JButton btnAdd_type = new JButton("ADD");
		btnAdd_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
					
					boolean haveBalcony=false;
					boolean havePool=false;
					boolean haveBackyard=false;
					boolean haveGarage=false;
					if(cbBalcony.isSelected()) haveBalcony=true;
					if(cbPool.isSelected()) havePool=true;
					if(cbBackyard.isSelected()) haveBackyard=true;
					if(cbGarage.isSelected()) haveGarage=true;
					
					String price=textFieldPrice.getText();
					String address=textAreaAddress.getText();
					String description=textAreaDescription.getText();
					Integer type=Integer.valueOf(comboBoxType.getSelectedIndex());
					Integer ownerID=Integer.valueOf(textFieldOwnID.getText());
					Integer squarefeet=Integer.valueOf(textFieldSqft.getText());
					Integer bedroom=Integer.valueOf(spinnerBedRoom.getValue().toString());
					Integer bathroom=Integer.valueOf(spinnerBathRoom.getValue().toString());
					Integer age=Integer.valueOf(spinner_AgeOfHouse.getValue().toString());
					P_PROPERTY property=new P_PROPERTY(0,type,squarefeet,ownerID,price,address,bedroom,bathroom,age,haveBalcony,havePool,haveBackyard,haveGarage,description);
					 if(property.addNewProperty(property)) {
						JOptionPane.showMessageDialog(null, "New Property Added To The System", "Property Add", 1);
					 }
					 else {
						JOptionPane.showMessageDialog(null, "Property NOT Added To The System", "Property Add", 2);	
					 }
			 }
			 catch(Exception ae) {  
					JOptionPane.showMessageDialog(null, "Enter proper data", "ERROR", 0);
				}
			}
		});
		btnAdd_type.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnAdd_type.setBounds(12, 577, 175, 41);
		panel_body.add(btnAdd_type);
		
		JButton btnEdit_type = new JButton("EDIT");
		btnEdit_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
             try {		
					boolean haveBalcony=false;
					boolean havePool=false;
					boolean haveBackyard=false;
					boolean haveGarage=false;
					if(cbBalcony.isSelected()) haveBalcony=true;
					if(cbPool.isSelected()) havePool=true;
					if(cbBackyard.isSelected()) haveBackyard=true;
					if(cbGarage.isSelected()) haveGarage=true;
					String price=textFieldPrice.getText();
					String address=textAreaAddress.getText();
					String description=textAreaDescription.getText();
					Integer type=Integer.valueOf(comboBoxType.getSelectedIndex());
					Integer ownerID=Integer.valueOf(textFieldOwnID.getText());
					Integer squarefeet=Integer.valueOf(textFieldSqft.getText());
					Integer bedroom=Integer.valueOf(spinnerBedRoom.getValue().toString());
					Integer bathroom=Integer.valueOf(spinnerBathRoom.getValue().toString());
					Integer age=Integer.valueOf(spinner_AgeOfHouse.getValue().toString());
					Integer ID=Integer.valueOf(textFieldID.getText());
					P_PROPERTY property=new P_PROPERTY(ID,type,squarefeet,ownerID,price,address,bedroom,bathroom,age,haveBalcony,havePool,haveBackyard,haveGarage,description); 
					 if(property.editProperty(property)) {
						JOptionPane.showMessageDialog(null, "Property information Edited ", "Property Edit", 1);
					 }
					 else {
						JOptionPane.showMessageDialog(null, "Property information NOT Edited", "Property Edit", 2);	
					 }
			 }
			 catch(Exception ae) {  
					JOptionPane.showMessageDialog(null, "Enter proper data", "ERROR", 0);
				}
			}
			
		});
		btnEdit_type.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnEdit_type.setBounds(209, 577, 175, 41);
		panel_body.add(btnEdit_type);
		
		JButton btnRemove_type = new JButton("REMOVE");
		btnRemove_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P_PROPERTY property=new P_PROPERTY();
				if(textFieldID.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter ID", "Empty ID", 2);
				}	
				
				else {
					int yes_no=JOptionPane.showConfirmDialog(null,"Do you want to delete this row","Delete Confirmation",JOptionPane.YES_NO_OPTION);
					if(yes_no==JOptionPane.YES_OPTION)
					{
						Integer propertyID=Integer.valueOf(textFieldID.getText());
					   if(property.deleteProperty(propertyID)) {
						   JOptionPane.showMessageDialog(null, "Property details deleted", "Property details Deletion", 1);
						   cbBalcony.setSelected(false);
						   cbPool.setSelected(false);
						   cbBackyard.setSelected(false);
						   cbGarage.setSelected(false);
							textFieldPrice.setText("");
							textAreaAddress.setText("");
							textAreaDescription.setText("");
							comboBoxType.setSelectedIndex(0);
							textFieldOwnID.setText("");
							textFieldSqft.setText("");
							spinnerBedRoom.setValue(0);
							spinnerBathRoom.setValue(0);
							spinner_AgeOfHouse.setValue(0);
							textFieldID.setText("");
					   }
					   else {
						   JOptionPane.showMessageDialog(null, "Property details NOT deleted", "Property details Deletion", 2);
					   }
					}
					
				}
			}
		});
		btnRemove_type.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnRemove_type.setBounds(412, 579, 175, 41);
		panel_body.add(btnRemove_type);
		
		JLabel Label_sqfeet = new JLabel("Square Feet:");
		Label_sqfeet.setForeground(Color.BLACK);
		Label_sqfeet.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label_sqfeet.setBounds(12, 150, 155, 29);
		panel_body.add(Label_sqfeet);
		
		textFieldOwnID = new JTextField();
		textFieldOwnID.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textFieldOwnID.setColumns(10);
		textFieldOwnID.setBounds(183, 209, 271, 41);
		panel_body.add(textFieldOwnID);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(184, 283, 271, 41);
		panel_body.add(textFieldPrice);
		
		JLabel lblOwnerId = new JLabel("Owner ID:");
		lblOwnerId.setForeground(Color.BLACK);
		lblOwnerId.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblOwnerId.setBounds(25, 216, 125, 29);
		panel_body.add(lblOwnerId);
		
		JLabel lblPriceusd = new JLabel("Price(inr):");
		lblPriceusd.setForeground(Color.BLACK);
		lblPriceusd.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPriceusd.setBounds(25, 283, 138, 29);
		panel_body.add(lblPriceusd);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int propertyID=Integer.valueOf(textFieldID.getText());
					P_PROPERTY property=new P_PROPERTY().searchProperty(propertyID);
					if(property!=null) {
						textAreaAddress.setText(property.getAddress());
						textAreaDescription.setText(property.getDescription());
						textFieldPrice.setText(property.getPrice());
						textFieldSqft.setText(String.valueOf(property.getSize()));
						textFieldOwnID.setText(String.valueOf(property.getOwnerId()));
						comboBoxType.setSelectedIndex(property.getType());
						spinnerBedRoom.setValue(property.getBedroom());
						spinnerBathRoom.setValue(property.getBathroom());
						spinner_AgeOfHouse.setValue(property.getAge());
						if(property.getBalcony()) cbBalcony.setSelected(true);
						if(property.getPool()) cbPool.setSelected(true);
						if(property.getBackyard()) cbBackyard.setSelected(true);
						if(property.getGarage()) cbGarage.setSelected(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Property not found", "ERROR", 0);
					}
					
			
			 }
			 catch(Exception ae) {  
					JOptionPane.showMessageDialog(null, "Enter proper id", "ERROR", 0);
				}
			}
		});
		btnSearch.setFont(new Font("Arial", Font.BOLD, 16));
		btnSearch.setBounds(347, 32, 97, 39);
		panel_body.add(btnSearch);
		
		JLabel Label_BedRoom = new JLabel("Bedrooms:");
		Label_BedRoom.setForeground(Color.BLACK);
		Label_BedRoom.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label_BedRoom.setBounds(530, 62, 129, 29);
		panel_body.add(Label_BedRoom);
		
		JLabel lblWashrooms = new JLabel("Washrooms:");
		lblWashrooms.setForeground(Color.BLACK);
		lblWashrooms.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblWashrooms.setBounds(512, 114, 155, 29);
		panel_body.add(lblWashrooms);
		
		JLabel Label_AgeOfHouse = new JLabel("Age Of The House:");
		Label_AgeOfHouse.setForeground(Color.BLACK);
		Label_AgeOfHouse.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label_AgeOfHouse.setBounds(527, 183, 232, 29);
		panel_body.add(Label_AgeOfHouse);
		
		JLabel lblNewLabel_1 = new JLabel("0 mean brand new ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(544, 244, 132, 16);
		panel_body.add(lblNewLabel_1);
		
		JLabel Label_Description = new JLabel("Desrciption/Comment:");
		Label_Description.setForeground(Color.BLACK);
		Label_Description.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label_Description.setBounds(530, 290, 288, 29);
		panel_body.add(Label_Description);

		
		JButton btnshowProperty = new JButton("SHOW PROPERTIES");
		btnshowProperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Property_table tableform=new Property_table();
				tableform.setVisible(true);
				tableform.setLocationRelativeTo(null);;
				tableform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnshowProperty.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnshowProperty.setBounds(844, 581, 313, 41);
		panel_body.add(btnshowProperty);
		
		JButton btnEdit_type_1 = new JButton("CLEAR");
		btnEdit_type_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldID.setText("");
				textAreaAddress.setText("");
				textAreaDescription.setText("");
				textFieldPrice.setText("");
				textFieldSqft.setText("");
				textFieldOwnID.setText("");
				comboBoxType.setSelectedIndex(0);
				spinnerBedRoom.setValue(0);
				spinnerBathRoom.setValue(0);
				spinner_AgeOfHouse.setValue(0);
				cbBalcony.setSelected(false);
				cbPool.setSelected(false);
				cbBackyard.setSelected(false);
				cbGarage.setSelected(false);
				
			}
		});
		btnEdit_type_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnEdit_type_1.setBounds(628, 577, 175, 41);
		panel_body.add(btnEdit_type_1);
		fillComboBox();
	}
}
