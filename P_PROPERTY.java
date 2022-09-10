package Real_estate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class P_PROPERTY {
    private int id;
    private int type;
    private int size;
    private int ownerid;
    private String price;
    private String address;
    private int bedroom;
    private int bathroom;
    private int age;
    private boolean balcony;
    private boolean pool;
    private boolean backyard;
    private boolean garage;
    private String description;
    String url="jdbc:mysql://localhost:3306/database1?autoReconnect=true&useSSL=false";
	 String uname="root";
	 String pswd="root";
    public int getID() {
    	return id;
    }
    public void setID(int ID) {
    	 id=ID;
    }
    
    public int getType() {
    	return type;
    }
    public void setType(int type) {
   	 this.type=type;
   }
    
    public int getSize() {
    	return size;
    }
    public void setSize(int SIZE) {
   	 size=SIZE;
   }
    
    public int getOwnerId() {
    	return ownerid;
    }
    public void setOwnerID(int oid) {
   	 ownerid=oid;
   }
    
    public int getBedroom() {
    	return bedroom;
    }
    public void setBedroom(int bedrm) {
   	 bedroom=bedrm;
   }
    
    public int getBathroom() {
    	return bathroom;
    }
    public void setBathroom(int btrm) {
   	 bathroom=btrm;
   }
    
    public int getAge() {
    	return age;
    }
    public void setAge(int AGE) {
   	 age=AGE;
   }
    
    public String getPrice() {
    	return price;
    }
    public void setPrice(String sprice) {
   	 price=sprice;
   }
    
    public String getAddress() {
    	return address;
    }
    public void setAddress(String Add) {
   	 address=Add;
   }
    
    public String getDescription() {
    	return description;
    }
    public void setDescription(String descrip) {
   	 description=descrip;
   }
    
    public boolean getBalcony() {
    	return balcony;
    }
    public void setBalcony(boolean blcn) {
   	 balcony=blcn;
   }
    
    public boolean getBackyard() {
    	return backyard;
    }
    public void setBackyard(boolean blcn) {
   	 backyard=blcn;
   }
    
    public boolean getPool() {
    	return pool;
    }
    public void setPool(boolean blcn) {
   	 pool=blcn;
   }
    
    public boolean getGarage() {
    	return garage;
    }
    public void setGarage(boolean blcn) {
   	 garage=blcn;
   }
    
    
    
    public P_PROPERTY()
    {}
    public P_PROPERTY(int ID,int TYPE,int SIZE,int OWNERID,String PRICE,String ADDRESS,int BEDROOM,int BATHROOM,int AGE,boolean BALCONY,boolean POOL,boolean BACKYARD,boolean GARAGE,String DESCRIPTION) {
    	id=ID;
    	type=TYPE;
    	size=SIZE;
    	ownerid=OWNERID;
    	price=PRICE;
    	address=ADDRESS;
    	bedroom=BEDROOM;
    	bathroom=BATHROOM;
    	age=AGE;
    	balcony=BALCONY;
    	pool=POOL;
    	backyard=BACKYARD;
    	garage=GARAGE;
    	description=DESCRIPTION;
    }

    public boolean addNewProperty(P_PROPERTY property) {
    	PreparedStatement pst;
   	 String addQuery="INSERT INTO property(type,squarefeet,ownerid,price,address,bedroom,bathroom,age,balcony,pool,backyard,garage,description)values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
   	 
   	 try {
   		Class.forName("com.mysql.jdbc.Driver");
   		Connection con=DriverManager.getConnection(url,uname,pswd);
   		pst=con.prepareStatement(addQuery);
   		pst.setInt(1,property.getType());
   		pst.setInt(2,property.getSize());
   		pst.setInt(3,property.getOwnerId());
   		pst.setString(4, property.getPrice());
   		pst.setString(5, property.getAddress());
   		pst.setInt(6, property.getBedroom());
   		pst.setInt(7, property.getBathroom());
   		pst.setInt(8, property.getAge());
   		pst.setBoolean(9, property.getBalcony());
   		pst.setBoolean(10, property.getPool());
   		pst.setBoolean(11,property.getBackyard());
   		pst.setBoolean(12, property.getGarage());
   		pst.setString(13, property.getDescription());
   		return (pst.executeUpdate()>0);
   		
   	} catch (ClassNotFoundException | SQLException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   		return false;
   	}	 

    }
    
    public boolean editProperty(P_PROPERTY property) {
    	PreparedStatement pst;
      	 String editQuery="update property set type=?,squarefeet=?,ownerid=?,price=?,address=?,bedroom=?,bathroom=?,age=?,balcony=?,pool=?,backyard=?,garage=?,description=? where id=?";
      	 
      	 try {
      		Class.forName("com.mysql.jdbc.Driver");
      		Connection con=DriverManager.getConnection(url,uname,pswd);

      		pst=con.prepareStatement(editQuery);
      		pst.setInt(1,property.getType());
      		pst.setInt(2,property.getSize());
      		pst.setInt(3,property.getOwnerId());
      		pst.setString(4, property.getPrice());
      		pst.setString(5, property.getAddress());
      		pst.setInt(6, property.getBedroom());
      		pst.setInt(7, property.getBathroom());
      		pst.setInt(8, property.getAge());
      		pst.setBoolean(9,property.getBalcony());
      		pst.setBoolean(10,property.getPool());
      		pst.setBoolean(11, property.getBackyard());
      		pst.setBoolean(12, property.getGarage());
      		pst.setString(13, property.getDescription());
      		pst.setInt(14,property.getID());
      		return(pst.executeUpdate()>0);
      		
      	} catch (ClassNotFoundException | SQLException e) {
      		// TODO Auto-generated catch block
      		e.printStackTrace();
      		return false;
      	}	 

    }
    
    public boolean deleteProperty(int propertyid) {
    	 PreparedStatement pst;
		 String deleteQuery="delete from property where id=?";
		 
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pswd);
			pst=con.prepareStatement(deleteQuery);
			pst.setInt(1, propertyid);
			return(pst.executeUpdate()>0);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	  
    }
    
  
    
    public P_PROPERTY searchProperty(int propertyid) {
    	
    	 PreparedStatement pst;
    	 ResultSet rs;
		 String searchQuery="select * from property where id=?";
		 P_PROPERTY property=null;
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pswd);
			pst=con.prepareStatement(searchQuery);
			pst.setInt(1,propertyid);
			rs=pst.executeQuery();
			
			if(rs.next()) {
				property=new P_PROPERTY(rs.getInt("id"),rs.getInt("type"),rs.getInt("squarefeet"),rs.getInt("ownerid"),rs.getString("price"),rs.getString("address"),rs.getInt("bedroom"),rs.getInt("bathroom"),rs.getInt("age"),rs.getBoolean("balcony"),rs.getBoolean("pool"),rs.getBoolean("backyard"),rs.getBoolean("garage"),rs.getString("description")) ;
			
			}
			return(property);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

    }
    public boolean addImage(int propertyID,String the_image_path) {
    	PreparedStatement pst;
   	 String addQuery="INSERT INTO property_image(property_id,the_image)values (?,?)";
   	 
   	 try {
   		Class.forName("com.mysql.jdbc.Driver");
   		Connection con=DriverManager.getConnection(url,uname,pswd);
   		FileInputStream propertyImage=new FileInputStream(new File(the_image_path));
   		pst=con.prepareStatement(addQuery);
   		pst.setInt(1,propertyID);
   		pst.setBinaryStream(2, propertyImage);
   		
   		return (pst.executeUpdate()>0);
   		
   	} catch (ClassNotFoundException | SQLException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   		return false;
   	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(null, "Image file not selected", "File selection", 2);
		return false;
	}	 

    }
    
    public HashMap<byte[],Integer>  propertyImage(int propertyId){
    	HashMap<byte[],Integer> list=new HashMap<>();
    	PreparedStatement ps;
    	ResultSet rs;
    	String query="select * from property_image where property_id=?";
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pswd);
			ps=con.prepareStatement(query);
			ps.setInt(1, propertyId);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				list.put(rs.getBytes("the_image"),rs.getInt("id"));
				
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    	return list;
    
    }

    public byte[] getImageByID(int imageID){
    	
    	PreparedStatement ps;
    	ResultSet rs;
    	String query="select the_image from property_image where id=?";
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pswd);
			ps=con.prepareStatement(query);
			ps.setInt(1, imageID);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				return rs.getBytes("the_image");
			}
			else {
				return null;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
public boolean removePropertyImage(int imageID){
    	
    	PreparedStatement ps;
    	ResultSet rs;
    	String query="delete from property_image where id=?";
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pswd);
			ps=con.prepareStatement(query);
			ps.setInt(1, imageID);

			
			return(ps.executeUpdate()>0);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }
public ArrayList<P_PROPERTY>propertiesListByOwnerID(int ownerid){
	ArrayList<P_PROPERTY> list = new ArrayList<>();
	PreparedStatement ps;
	ResultSet rs;
	String query="select * from property where ownerid=?";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,pswd);
		ps=con.prepareStatement(query);
		ps.setInt(1, ownerid);
		rs=ps.executeQuery();
		P_PROPERTY property;
		while(rs.next()) {
			property=new P_PROPERTY(rs.getInt("id"),rs.getInt("type"),rs.getInt("squarefeet"),rs.getInt("ownerid"),rs.getString("price"),rs.getString("address"),rs.getInt("bedroom"),rs.getInt("bathroom"),rs.getInt("age"),rs.getBoolean("balcony"),rs.getBoolean("pool"),rs.getBoolean("backyard"),rs.getBoolean("garage"),rs.getString("description")) ;
		    list.add(property);
		}
	}
	catch(Exception r) {
		r.printStackTrace();
	}
		
	return list;	
	
}
}


