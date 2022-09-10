package Real_estate;
import java.sql.*;
import java.util.HashMap;

import javax.swing.JOptionPane;
public class P_TYPE {
     private int id;
     private String name;
     private String description;
     String url="jdbc:mysql://localhost:3306/database1?autoReconnect=true&useSSL=false";
	 String uname="root";
	 String pswd="root";
     //
     public Integer getID(){
    	 return id;
     }
     
     public String getName(){
    	  return name;
     }
     
     public void setName(String NAME){
    	 name=NAME;
     }
     
     public String getDescription(){
    	 return description;
     }
     
     public void setDesciption(String DESCRIPTION) {
    	 description=DESCRIPTION;
     }
     public P_TYPE() {}
     public P_TYPE(Integer ID,String NAME,String DESCRIPTION) {
    	 id=ID;
    	 name=NAME;
    	 description=DESCRIPTION; 
     }
     public boolean execTypeQuery(String queryType,P_TYPE type) {
    	 
    	 PreparedStatement ps;
    	 ResultSet rs;
    	 
    	 if(queryType.equals("add"))
    	 {
    		 try {
    			 Class.forName("com.mysql.jdbc.Driver");
  		       Connection con=DriverManager.getConnection(url,uname,pswd);
		       ps=con.prepareStatement("INSERT INTO property_type (name,description) values (?,?)");
		       //ps.setInt(1, type.getID());
		       ps.setString(1, type.getName());
		       ps.setString(2, type.getDescription());
		       return (ps.executeUpdate()>0);
    		 }
    		 catch (ClassNotFoundException e1) {
		            e1.printStackTrace();
		            return false;
	           }	
	            catch (SQLException e1) {
		            e1.printStackTrace();
		            return false;
	            }
    	 }
    	 
    	 else if(queryType.equals("edit"))
    	 {
    		 try {
    		 Class.forName("com.mysql.jdbc.Driver");
		       Connection con=DriverManager.getConnection(url,uname,pswd);
		       ps=con.prepareStatement("update property_type set name=?,description=? where id=?");
		       ps.setString(1, type.getName());
		       ps.setString(2, type.getDescription());
		       ps.setInt(3, type.getID());
		       return (ps.executeUpdate()>0);
    		 }
    		 catch (ClassNotFoundException e1) {
		            e1.printStackTrace();
		            return false;
	           }	
	            catch (SQLException e1) {
		            e1.printStackTrace();
		            return false;
	            }
    	 }
    	 
    	 else if(queryType.equals("remove"))
    	 {
    		 try {
    		 Class.forName("com.mysql.jdbc.Driver");
		       Connection con=DriverManager.getConnection(url,uname,pswd);
		       ps=con.prepareStatement("delete from property_type where id=?");
		       ps.setInt(1, type.getID());
		       return (ps.executeUpdate()>0);
    		 }
    		 catch (ClassNotFoundException e1) {
		            e1.printStackTrace();
		            return false;
	           }	
	            catch (SQLException e1) {
		            e1.printStackTrace();
		            return false;
	            }
    		 
    	 }
    	 else {
    		 JOptionPane.showMessageDialog(null, "Enter the correct query(add,edit,remove either of them)", "Invalid operation", 2);
    		 return false;
    	 }
     }
     public HashMap<String,Integer> getTypesMap() 
     {
    	 HashMap<String,Integer> map=new HashMap<>();
    	 Statement st;
    	 ResultSet rs;
    	 P_TYPE type;
    	 try {
    	  Class.forName("com.mysql.jdbc.Driver");
	      Connection con=DriverManager.getConnection(url,uname,pswd);
    	  st=con.createStatement();
    	  rs=st.executeQuery("select * from property_type");
    	  while(rs.next()) {
    		  type=new P_TYPE(rs.getInt(1),rs.getString(2),rs.getString(3));
    		  map.put(type.getName(),type.getID());
    	  }
    	 }
    	 catch(SQLException e) {
    		 e.printStackTrace(); 
    	 } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  
    	 return map;
     }
     
     
     
     
}
