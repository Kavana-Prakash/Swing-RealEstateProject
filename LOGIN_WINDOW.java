package Real_estate;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;

public class LOGIN_WINDOW extends JFrame {

	private JPanel contentPane;
	private JTextField JTextField_UserName;
	private JPasswordField pwdPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			//UIManager.setLookAndFeel(new com.jtattoo.plaf.hifi.HiFiLookAndFeel());
			UIManager.setLookAndFeel(new com.jtattoo.plaf.noire.NoireLookAndFeel());
		}catch(Exception e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGIN_WINDOW frame = new LOGIN_WINDOW();
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
	public LOGIN_WINDOW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("LOGIN");
		setBounds(100, 100, 724, 555);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel JLabel_title = new JLabel("LOGIN PAGE");
		JLabel_title.setForeground(Color.BLUE);
		JLabel_title.setFont(new Font("Times New Roman", Font.BOLD, 48));
		JLabel_title.setBounds(199, 23, 310, 76);
		contentPane.add(JLabel_title);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 38));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(86, 168, 188, 68);
		contentPane.add(lblNewLabel_1);
		
		JTextField_UserName = new JTextField();
		JTextField_UserName.setForeground(Color.LIGHT_GRAY);
		JTextField_UserName.setBackground(Color.WHITE);
		JTextField_UserName.setText("Username");
		JTextField_UserName.setFont(new Font("Arial", Font.PLAIN, 28));
		JTextField_UserName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(JTextField_UserName.getText().trim().toLowerCase().equals("username"))
				{
					JTextField_UserName.setText("");
					JTextField_UserName.setForeground(Color.black);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(JTextField_UserName.getText().trim().equals("") || JTextField_UserName.getText().trim().toLowerCase().equals("username"))
				{
					JTextField_UserName.setText("Username");
					JTextField_UserName.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		JTextField_UserName.setBounds(336, 184, 211, 52);
		contentPane.add(JTextField_UserName);
		JTextField_UserName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 38));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(86, 294, 188, 58);
		contentPane.add(lblNewLabel_2);
		
		
		pwdPass = new JPasswordField();
		pwdPass.setBackground(Color.WHITE);
		pwdPass.setText("password");
		pwdPass.setForeground(Color.LIGHT_GRAY);
		pwdPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			  String password=String.valueOf(pwdPass.getPassword());
			  if(password.trim().toLowerCase().equals("password"))
			  {
				  pwdPass.setText("");
					pwdPass.setForeground(Color.BLACK);
			  }
			}
			@Override
			public void focusLost(FocusEvent e) {
				 String password=String.valueOf(pwdPass.getPassword());
				if(password.trim().equals("") || password.trim().equals("password"))
				  {
					  pwdPass.setText("password");
						pwdPass.setForeground(Color.white);
				  }
				}
		});
		
		pwdPass.setFont(new Font("Tahoma", Font.PLAIN, 30));
		pwdPass.setBounds(336, 294, 211, 48);
		contentPane.add(pwdPass);
		JButton LoginButton = new JButton("Log In");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=JTextField_UserName.getText();
				String password=String.valueOf(pwdPass.getPassword());
				String url="jdbc:mysql://localhost:3306/database1?autoReconnect=true&useSSL=false";
				 String uname="root";
				 String pswd="root";
				 String query="select * from users where username=? and password1=?";
				 java.sql.PreparedStatement ps;
				 ResultSet rs;
				 if(username.trim().toLowerCase().equals("username") || password.trim().toLowerCase().equals("password"))
					{
					    JOptionPane.showMessageDialog(null,"ENTER YOUR USERNAME AND PASSWORD FIRST","Empty Field",2);
					}
					else
					{
				       try {
					       Class.forName("com.mysql.jdbc.Driver");
					       Connection con=DriverManager.getConnection(url,uname,pswd);
					       ps=con.prepareStatement(query);
					       ps.setString(1, username);
					       ps.setString(2, password);
					       rs=ps.executeQuery();
					       if(rs.next())
					       {
					    	   MAIN_APP_WINDOW mainform=new MAIN_APP_WINDOW();
								mainform.setVisible(true);
								
								//close the login window
							     LOGIN_WINDOW.this.dispose();
					       }
					       else
					       {
					    	   JOptionPane.showMessageDialog(null,"INVALID USERNAME PASSWORD");
					    	   JTextField_UserName.setText("");
					    	   pwdPass.setText("");
							}
					       }
				            catch (ClassNotFoundException e1) {
					            e1.printStackTrace();
				           }	
				            catch (SQLException e1) {
					            e1.printStackTrace();
				            }
			           }
			}
		});
		LoginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		LoginButton.setFont(new Font("Arial", Font.BOLD, 44));
		LoginButton.setForeground(Color.BLUE);
		LoginButton.setBounds(238, 403, 200, 52);
		contentPane.add(LoginButton);
	
	}
}
