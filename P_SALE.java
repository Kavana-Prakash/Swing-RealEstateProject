package Real_estate;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class P_SALE {
   private int id;
   private int propertyID;
   private int clientID;
   private String finalPrice;
   private String sellingDate;
   String url="jdbc:mysql://localhost:3306/database1?autoReconnect=true&useSSL=false";
	 String uname="root";
	 String pswd="root";
	 public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getPropertyID() {
			return propertyID;
		}

		public void setPropertyID(int propertyID) {
			this.propertyID = propertyID;
		}

		public int getClientID() {
			return clientID;
		}

		public void setClientID(int clientID) {
			this.clientID = clientID;
		}

		public String getFinalPrice() {
			return finalPrice;
		}

		public void setFinalPrice(String finalPrice) {
			this.finalPrice = finalPrice;
		}

		public String getSellingDate() {
			return sellingDate;
		}

		public void setSellingDate(String sellingDate) {
			this.sellingDate = sellingDate;
		}

   public P_SALE() {}
 
   public P_SALE(int ID,int PROPERTYID,int CLIENTID,String FINALPRICE,String SELLINGDATE) {
	   id=ID;
	   propertyID=PROPERTYID;
	   clientID=CLIENTID;
	   finalPrice=FINALPRICE;
	   sellingDate=SELLINGDATE;
   }
   public boolean addNewSale(P_SALE sale) {
		 PreparedStatement pst;
		 String addQuery="INSERT INTO sale (property_id,client_id,final_price,sale_date) values (?,?,?,?)";
		 
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pswd);
			pst=con.prepareStatement(addQuery);
			pst.setInt(1,sale.getPropertyID());
			pst.setInt(2, sale.getClientID());
			pst.setString(3, sale.getFinalPrice());
			pst.setString(4, sale.getSellingDate());
			return(pst.executeUpdate()>0);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	 
}
   public boolean editSale(P_SALE sale) {
		  PreparedStatement pst;
			 String editQuery="update sale set property_id=?,client_id=?,final_price=?,sale_date=? where id=?";
			 
			 try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,uname,pswd);
				pst=con.prepareStatement(editQuery);
				pst.setInt(1,sale.getPropertyID());
				pst.setInt(2, sale.getClientID());
				pst.setString(3, sale.getFinalPrice());
				pst.setString(4, sale.getSellingDate());
				pst.setInt(5,sale.getId());
				return(pst.executeUpdate()>0);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}	  
	  }

	public boolean deleteSale(int saleID) {
		  PreparedStatement pst;
			 String deleteQuery="delete from sale where id=?";
			 
			 try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,uname,pswd);
				pst=con.prepareStatement(deleteQuery);
				pst.setInt(1,saleID);
				return(pst.executeUpdate()>0);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}	  
		  
		  
		  
		  
	  }
}
