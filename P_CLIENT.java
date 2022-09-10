package Real_estate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class P_CLIENT {
	private int id;
	 private String firstName;
	 private String lastName;
	 private String Phone;
	 private String Email;
	 private String Address;
	 String url="jdbc:mysql://localhost:3306/database1?autoReconnect=true&useSSL=false";
	 String uname="root";
	 String pswd="root";
	 public int getID(){
		 return id;
	 }
	 public String getFirstName() {
		 return firstName;
	 }
	 public String getLastName() {
		 return lastName;
	 }
	 public String getPhone() {
		 return Phone;
	 }
	 public String getEmail() {
		 return Email;
	 }
	 public String getAddress() {
		 return Address;
	 }
	 public void setID(int ID) {
		 id=ID;
	 }
	 public void setFirstName(String FName) {
		 firstName=FName;
	 }
	 public void setLastName(String SName) {
		 lastName=SName;
	 }
	 public void setPhone(String PH) {
		 Phone=PH;
	 }
	 public void setEmail(String EMAIL) {
		 Email=EMAIL;
	 }
	 public void setAddress(String ADD) {
		 Address=ADD;
	 }
	 
	 public P_CLIENT()
	 {}
	 
	 public P_CLIENT(int ID,String FNAME,String LName,String PH,String EMAIL,String ADDRESS) {
		 id=ID;
		 firstName=FNAME;
		 lastName=LName;
		 Phone=PH;
		 Email=EMAIL;
		 Address=ADDRESS;
	 }
	 
	 public boolean addNewClient(P_CLIENT client) {
		 PreparedStatement pst;
		 String addQuery="INSERT INTO client (fname,sname,phone,email,address) values (?,?,?,?,?)";
		 
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pswd);
			pst=con.prepareStatement(addQuery);
			pst.setString(1,client.getFirstName());
			pst.setString(2, client.getLastName());
			pst.setString(3, client.getPhone());
			pst.setString(4, client.getEmail());
			pst.setString(5, client.getAddress());
			return(pst.executeUpdate()>0);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	 
	 }
	  public boolean editClient(P_CLIENT client) {
		  PreparedStatement pst;
			 String editQuery="update client set fname=?,sname=?,phone=?,email=?,address=? where id=?";
			 
			 try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,uname,pswd);
				pst=con.prepareStatement(editQuery);
				pst.setString(1,client.getFirstName());
				pst.setString(2, client.getLastName());
				pst.setString(3, client.getPhone());
				pst.setString(4, client.getEmail());
				pst.setString(5, client.getAddress());
				pst.setInt(6, client.getID());
				return(pst.executeUpdate()>0);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}	  
	  }
	  public boolean deleteClient(int clientID) {
		  PreparedStatement pst;
			 String deleteQuery="delete from client where id=?";
			 
			 try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,uname,pswd);
				pst=con.prepareStatement(deleteQuery);
				pst.setInt(1, clientID);
				return(pst.executeUpdate()>0);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}	  
		  
		  
		  
		  
	  }
	}


