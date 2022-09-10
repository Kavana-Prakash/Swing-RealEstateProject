package Real_estate;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PROPERTY_IMAGES_WINDOW extends JFrame {

	private JPanel contentPane;
	private JTable table;
	 String url="jdbc:mysql://localhost:3306/database1?autoReconnect=true&useSSL=false";
	 String uname="root";
	 String pswd="root";
	 JLabel lblImage;
     String property_image_path="";
     int propertyID=0;
     
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
					PROPERTY_IMAGES_WINDOW frame=new PROPERTY_IMAGES_WINDOW();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
public void RefreshTable(){
		
		try {
			String query="select id,type,address from property";
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

public ImageIcon resizeImage(String path,byte[] byteImage)
{
	ImageIcon picture;
	if(byteImage != null) picture=new ImageIcon(byteImage);
	else  picture=new ImageIcon(path);
	Image img=picture.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
	ImageIcon image=new ImageIcon(img);
	return image;
	
}

	/**
	 * Create the frame.
	 */
	public PROPERTY_IMAGES_WINDOW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PROPERTY IMAGE");
		setBounds(100, 100, 1629, 774);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_title = new JPanel();
		panel_title.setLayout(null);
		panel_title.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		panel_title.setBackground(new Color(255, 99, 71));
		panel_title.setBounds(0, 0, 1611, 90);
		contentPane.add(panel_title);
		
		JLabel label_propimage = new JLabel("PROPERTY-IMAGES");
		label_propimage.setForeground(Color.WHITE);
		label_propimage.setFont(new Font("Tahoma", Font.BOLD, 36));
		label_propimage.setBounds(569, 13, 372, 64);
		panel_title.add(label_propimage);
		
		JPanel panel_body = new JPanel();
		panel_body.setLayout(null);
		panel_body.setBackground(Color.GRAY);
		panel_body.setBounds(0, 87, 1611, 640);
		contentPane.add(panel_body);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(582, 31, 305, 458);
		panel_body.add(scrollPane_1);
		JList list = new JList();
		
		
		JButton btnAdd_type = new JButton("ADD IMAGE");
		btnAdd_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P_PROPERTY property=new P_PROPERTY();
				if(propertyID!=0) {
					if(property.addImage(propertyID, property_image_path)) {
					JOptionPane.showMessageDialog(null,"Image Added To This Property", "Add Image", 1);
				}
				else {
					JOptionPane.showMessageDialog(null,"Image NOT Added To This Property", "Add Image", 2);
				}
				}
				else {
					JOptionPane.showMessageDialog(null,"Select the property first", "Add Image", 2);
				}
				
			}
		});
		btnAdd_type.setFont(new Font("Tahoma", Font.BOLD, 32));
		btnAdd_type.setBounds(909, 501, 678, 41);
		panel_body.add(btnAdd_type);
		
		JButton btnShowthisimage = new JButton("REMOVE");
		btnShowthisimage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String selectedListItem=String.valueOf(list.getSelectedValue());
					Integer imageID=Integer.valueOf(selectedListItem);
					int yes_no=JOptionPane.showConfirmDialog(null,"Do you want to delete this row","Delete Confirmation",JOptionPane.YES_NO_OPTION);
					if(yes_no==JOptionPane.YES_OPTION)
					{
					  if(new P_PROPERTY().removePropertyImage(imageID)) {
						  JOptionPane.showMessageDialog(null, "Image details deleted", "Image Deletion", 1);
						  lblImage.setIcon(null);
					 }
					 else {
						 JOptionPane.showMessageDialog(null, "Image NOT deleted", "Image Deletion", 1);
					 }
					}
					else {
						JOptionPane.showMessageDialog(null, "Operation failed", "Owner Deletion", 1);
					}
				}
				catch(Exception X) {
					JOptionPane.showMessageDialog(null, "click on image from list", "Owner Deletion", 1);
				}
			}
		});
		btnShowthisimage.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnShowthisimage.setBounds(592, 503, 295, 41);
		panel_body.add(btnShowthisimage);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 31, 548, 489);
		panel_body.add(scrollPane);
		
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String selectedListItem=String.valueOf(list.getSelectedValue());
				Integer imageID=Integer.valueOf(selectedListItem);
				byte[] image=new P_PROPERTY().getImageByID(imageID);
				lblImage.setIcon(resizeImage("",image));
			}
		});
		list.setFont(new Font("Tahoma", Font.PLAIN, 22));
		scrollPane_1.setViewportView(list);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowIndex=table.getSelectedRow();
				propertyID=Integer.valueOf(table.getValueAt(rowIndex, 0).toString());
	
				HashMap<byte[],Integer> imageListMap=new P_PROPERTY().propertyImage(propertyID);
				DefaultListModel listModel=new DefaultListModel();
				int i=0;
				for(Integer id:imageListMap.values())
				{
					listModel.add(i,id);
					i++;
				}
				list.setModel(listModel);
				
				
			}
		});
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Property ID", "PropertyType", "Address"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(95);
		table.getColumnModel().getColumn(2).setPreferredWidth(205);
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblSelectImage = new JLabel("Select Image:");
		lblSelectImage.setForeground(Color.WHITE);
		lblSelectImage.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSelectImage.setBounds(899, 28, 169, 29);
		panel_body.add(lblSelectImage);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser=new JFileChooser();
				fileChooser.setDialogTitle("Select the Property Image");
				fileChooser.setCurrentDirectory(new File("C:\\IMAGES"));
				FileNameExtensionFilter fileFilter=new FileNameExtensionFilter("Images",".jpg",".png",".jpeg");
				fileChooser.addChoosableFileFilter(fileFilter);
				
				int fileState=fileChooser.showSaveDialog(null);
				if(fileState==JFileChooser.APPROVE_OPTION) {
					String path=fileChooser.getSelectedFile().getAbsolutePath();
					lblImage.setIcon(resizeImage(path,null));
					property_image_path=path;		
				}
			}
		});
		btnBrowse.setBackground(Color.ORANGE);
		btnBrowse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBrowse.setBounds(1080, 30, 228, 29);
		panel_body.add(btnBrowse);
		
		lblImage = new JLabel("");
		lblImage.setOpaque(true);
		lblImage.setBounds(899, 95, 688, 387);
		panel_body.add(lblImage);
		
		
		JLabel Labelinst1 = new JLabel("*This table contains the properties id and address");
		Labelinst1.setForeground(Color.BLACK);
		Labelinst1.setFont(new Font("Tahoma", Font.BOLD, 16));
		Labelinst1.setBounds(32, 582, 495, 29);
		panel_body.add(Labelinst1);
		
		JLabel Labelinst2 = new JLabel("*This list contains the images id of the");
		Labelinst2.setForeground(Color.BLACK);
		Labelinst2.setFont(new Font("Tahoma", Font.BOLD, 16));
		Labelinst2.setBounds(566, 555, 321, 18);
		panel_body.add(Labelinst2);
		
		JLabel labelinst3 = new JLabel("selected property.");
		labelinst3.setForeground(Color.BLACK);
		labelinst3.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelinst3.setBounds(592, 582, 174, 16);
		panel_body.add(labelinst3);
		
		JLabel lblinst4 = new JLabel("(select property from table)");
		lblinst4.setForeground(Color.BLACK);
		lblinst4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblinst4.setBounds(592, 611, 298, 16);
		panel_body.add(lblinst4);
		
		JLabel labelinst5 = new JLabel("*select an image from list to display or browse from computer");
		labelinst5.setForeground(Color.BLACK);
		labelinst5.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelinst5.setBounds(903, 555, 516, 18);
		panel_body.add(labelinst5);
		
		JButton Property_type_Name = new JButton("PropertyType Name");
		Property_type_Name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PropertyTypeName PROPERTYform=new PropertyTypeName();
				PROPERTYform.setVisible(true);
				PROPERTYform.setLocationRelativeTo(null);
				PROPERTYform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		Property_type_Name.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Property_type_Name.setBounds(326, 550, 228, 25);
		panel_body.add(Property_type_Name);
		
		JLabel lblNewLabel = new JLabel("Press Here to know property type: ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(30, 549, 284, 29);
		panel_body.add(lblNewLabel);
		
		
		lblImage.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.WHITE));
		
		JLabel lblImageView = new JLabel("IMAGE VIEW:");
		lblImageView.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblImageView.setBounds(899, 70, 152, 16);
		panel_body.add(lblImageView);
		RefreshTable();
	}
}

