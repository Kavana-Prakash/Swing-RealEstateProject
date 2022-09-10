package Real_estate;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PROPERTY_IMAGE_SLIDER extends JFrame {

	private JPanel contentPane;
    int propertyID;
    
    String url="jdbc:mysql://localhost:3306/database1?autoReconnect=true&useSSL=false";
	 String uname="root";
	 String pswd="root";
	 Connection con;
	 String query;
	 ResultSet rs;
	 PreparedStatement ps;
	 ArrayList<byte[]> imageslist;
	 HashMap<byte[],Integer> list;
	 
    JLabel lblImage1 ;
    int index;
   /* P_PROPERTY imglist=new P_PROPERTY();	 
	HashMap<byte[],Integer> list=imglist.propertyImage(propertyID);*/
    
	
	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args)  {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					P_PROPERTY p=new P_PROPERTY();
					PROPERTY_IMAGE_SLIDER frame = new PROPERTY_IMAGE_SLIDER();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public PROPERTY_IMAGE_SLIDER() {
		list=new HashMap<>();
		
		
		query="select * from property_image where property_id=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pswd);
			ps=con.prepareStatement(query);
			ps.setInt(1, propertyID);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				list.put(rs.getBytes("the_image"),rs.getInt("id"));
				
			}
			
			
			
		} catch (ClassNotFoundException fe) {
			// TODO Auto-generated catch block
			
			fe.printStackTrace();
			
		} catch (SQLException ge) {
			// TODO Auto-generated catch block
			ge.printStackTrace();
			
		}
		imageslist=new ArrayList<>(list.keySet());
		initcomponent();
		displayImage(propertyID);
		
		
	}
	public void displayImage(int ImageIndex) {

		Image img=new ImageIcon().getImage().getScaledInstance(lblImage1.getWidth(), lblImage1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image=new ImageIcon(img);
		lblImage1.setIcon(image); 
	}
	
	
	
	
	

	/**
	 * Create the frame.
	 */
	void initcomponent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1084, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1066, 640);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblImage1 = new JLabel("");
		lblImage1.setOpaque(true);
		lblImage1.setBackground(Color.LIGHT_GRAY);
		lblImage1.setBounds(26, 41, 1010, 489);
		panel.add(lblImage1);
		
		JLabel lblNext = new JLabel("      >");
		lblNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index++;
				if(index>=imageslist.size()) 
					index=imageslist.size()-1;
				displayImage(index);
				
				
			}
		});
		lblNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNext.setForeground(Color.BLACK);
		lblNext.setFont(new Font("Tahoma", Font.BOLD, 47));
		lblNext.setBackground(Color.BLACK);
		lblNext.setBounds(819, 558, 205, 44);
		panel.add(lblNext);
		
		JLabel lblPrevious = new JLabel("      <");
		lblPrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index--;
				if(index>0)index=0;
				displayImage(index);
			}
		});

		lblPrevious.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPrevious.setForeground(Color.BLACK);
		lblPrevious.setFont(new Font("Tahoma", Font.BOLD, 47));
		lblPrevious.setBackground(Color.BLACK);
		lblPrevious.setBounds(26, 558, 205, 44);
		panel.add(lblPrevious);
		
		lblPrevious.setBorder(BorderFactory.createMatteBorder(2,2,2,2, new Color(0,0,0)));
		lblNext.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0,0,0)));
		lblImage1.setBorder(BorderFactory.createMatteBorder(1,1,1,1, new Color(0,0,0)));
	}

	
}
