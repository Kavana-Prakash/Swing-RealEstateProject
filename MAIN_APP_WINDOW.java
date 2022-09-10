package Real_estate;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Rectangle;

public class MAIN_APP_WINDOW extends JFrame {

	private JPanel contentPane;

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
					MAIN_APP_WINDOW frame = new MAIN_APP_WINDOW();
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
	public MAIN_APP_WINDOW() {
		setBounds(new Rectangle(250, 250, 250, 250));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MAIN APP");
		setBounds(100, 100, 1094, 679);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelOptions = new JPanel();
		panelOptions.setForeground(new Color(250, 250, 250));
		panelOptions.setBackground(Color.ORANGE);
		panelOptions.setBounds(0, 75, 1076, 557);
		contentPane.add(panelOptions);
		panelOptions.setLayout(null);
		Border menu_border=BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white);
		
		JLabel Label_Property = new JLabel("Property");
		Label_Property.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Label_Property.setOpaque(true);
		Label_Property.setForeground(Color.WHITE);
		Label_Property.setBackground(Color.ORANGE);
		Label_Property.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				Label_Property.setBackground(Color.white);
				Label_Property.setForeground(Color.black);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Label_Property.setBackground(Color.orange);
				Label_Property.setForeground(Color.white);
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				PROPERTY_WINDOW PROPERTYform=new PROPERTY_WINDOW();
				PROPERTYform.setVisible(true);
				PROPERTYform.setLocationRelativeTo(null);;
				PROPERTYform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			}
		});
		Label_Property.setBounds(432, 31, 240, 36);
		panelOptions.add(Label_Property);
		Label_Property.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label_Property.setBorder(menu_border);
		
		JLabel Label_PropertyType = new JLabel("Property-Type");
		Label_PropertyType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Label_PropertyType.setBackground(Color.white);
				Label_PropertyType.setForeground(Color.black);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Label_PropertyType.setBackground(Color.orange);
				Label_PropertyType.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PROPERTY_TYPE_WINDOW propertytypeform=new PROPERTY_TYPE_WINDOW();
				propertytypeform.setVisible(true);
				//propertytypeform.pack();
				//propertytypeform.setExtendedState(JFrame.MAXIMIZED_BOTH);
				propertytypeform.setLocationRelativeTo(null);;
				propertytypeform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		Label_PropertyType.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Label_PropertyType.setOpaque(true);
		Label_PropertyType.setBackground(Color.ORANGE);
		Label_PropertyType.setForeground(Color.WHITE);
		Label_PropertyType.setBounds(432, 83, 240, 36);
		panelOptions.add(Label_PropertyType);
		Label_PropertyType.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label_PropertyType.setBorder(menu_border);
		
		JLabel Label_PropertyImages = new JLabel("Property-Images");
		Label_PropertyImages.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Label_PropertyImages.setBackground(Color.white);
				Label_PropertyImages.setForeground(Color.black);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Label_PropertyImages.setBackground(Color.orange);
				Label_PropertyImages.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				PROPERTY_IMAGES_WINDOW PROPERTYform=new PROPERTY_IMAGES_WINDOW ();
				PROPERTYform.setVisible(true);
				PROPERTYform.setLocationRelativeTo(null);;
				PROPERTYform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		Label_PropertyImages.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Label_PropertyImages.setOpaque(true);
		Label_PropertyImages.setBackground(Color.ORANGE);
		Label_PropertyImages.setForeground(Color.WHITE);
		Label_PropertyImages.setBounds(432, 132, 240, 36);
		panelOptions.add(Label_PropertyImages);
		Label_PropertyImages.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label_PropertyImages.setBorder(menu_border);
		
		JLabel Label_Owner = new JLabel("Owner");
		Label_Owner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Label_Owner.setBackground(Color.white);
				Label_Owner.setForeground(Color.black);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Label_Owner.setBackground(Color.orange);
				Label_Owner.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				OWNER_WINDOW OWNERform=new OWNER_WINDOW();
				OWNERform.setVisible(true);
				OWNERform.setLocationRelativeTo(null);;
				OWNERform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			}
		});
		Label_Owner.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Label_Owner.setOpaque(true);
		Label_Owner.setBackground(Color.ORANGE);
		Label_Owner.setForeground(Color.WHITE);
		Label_Owner.setBounds(432, 181, 240, 36);
		panelOptions.add(Label_Owner);
		Label_Owner.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label_Owner.setBorder(menu_border);
		
		JLabel Label_Client = new JLabel("Client");
		Label_Client.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Label_Client.setBackground(Color.white);
				Label_Client.setForeground(Color.black);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Label_Client.setBackground(Color.orange);
				Label_Client.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				CLIENT_WINDOW CLIENTform=new CLIENT_WINDOW();
				CLIENTform.setVisible(true);
				CLIENTform.setLocationRelativeTo(null);;
				CLIENTform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		Label_Client.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Label_Client.setOpaque(true);
		Label_Client.setBackground(Color.ORANGE);
		Label_Client.setForeground(Color.WHITE);
		Label_Client.setBounds(432, 230, 240, 36);
		panelOptions.add(Label_Client);
		Label_Client.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label_Client.setBorder(menu_border);
		
		JLabel Label_SaleWindow = new JLabel("Sale-Window");
		Label_SaleWindow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Label_SaleWindow.setBackground(Color.white);
				Label_SaleWindow.setForeground(Color.black);	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Label_SaleWindow.setBackground(Color.orange);
				Label_SaleWindow.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				SALE_WINDOW form=new SALE_WINDOW();
				form.setVisible(true);
				form.setLocationRelativeTo(null);;
				form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		Label_SaleWindow.setOpaque(true);
		Label_SaleWindow.setForeground(Color.WHITE);
		Label_SaleWindow.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label_SaleWindow.setBackground(Color.ORANGE);
		Label_SaleWindow.setBounds(432, 279, 240, 36);
		panelOptions.add(Label_SaleWindow);
		
		JPanel panelMyApp = new JPanel();
		panelMyApp.setBackground(Color.DARK_GRAY);
		panelMyApp.setBounds(0, 0, 1076, 73);
		contentPane.add(panelMyApp);
		panelMyApp.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MainApp");
		lblNewLabel.setBounds(418, 13, 190, 54);
		panelMyApp.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 42));
	}

}
