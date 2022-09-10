package Real_estate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class P_OWNER {
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
 
 public P_OWNER()
 {}
 
 public P_OWNER(int ID,String FNAME,String LName,String PH,String EMAIL,String ADDRESS) {
	 id=ID;
	 firstName=FNAME;
	 lastName=LName;
	 Phone=PH;
	 Email=EMAIL;
	 Address=ADDRESS;
 }
 
 public boolean addNewOwner(P_OWNER owner) {
	 PreparedStatement pst;
	 String addQuery="INSERT INTO property_owner (fname,sname,phone,email,address) values (?,?,?,?,?)";
	 
	 try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,pswd);
		pst=con.prepareStatement(addQuery);
		pst.setString(1,owner.getFirstName());
		pst.setString(2, owner.getLastName());
		pst.setString(3, owner.getPhone());
		pst.setString(4, owner.getEmail());
		pst.setString(5, owner.getAddress());
		return(pst.executeUpdate()>0);
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}	 
 }
  public boolean editOwner(P_OWNER owner) {
	  PreparedStatement pst;
		 String editQuery="update property_owner set fname=?,sname=?,phone=?,email=?,address=? where id=?";
		 
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pswd);
			pst=con.prepareStatement(editQuery);
			pst.setString(1,owner.getFirstName());
			pst.setString(2, owner.getLastName());
			pst.setString(3, owner.getPhone());
			pst.setString(4, owner.getEmail());
			pst.setString(5, owner.getAddress());
			pst.setInt(6, owner.getID());
			return(pst.executeUpdate()>0);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	  
  }
  public boolean deleteOwner(int ownerID) {
	  PreparedStatement pst;
		 String deleteQuery="delete from property_owner where id=?";
		 
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pswd);
			pst=con.prepareStatement(deleteQuery);
			pst.setInt(1, ownerID);
			return(pst.executeUpdate()>0);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	    
  }
}
