package helper.db;

import java.util.*;
import java.sql.*;

import helper.info.*;

public class MySQLdb {
	private String url = "jdbc:mysql://localhost:3306/";
    private String user = "root"; 
    private String passwd = "galderv7994";
	private String driver = "com.mysql.jdbc.Driver";
	private static MySQLdb niredb;
    private Connection conn;
	
	private MySQLdb() {
		try {
        	Class.forName(this.driver).newInstance();
        	this.conn = DriverManager.getConnection(this.url,this.user,this.passwd);
    	} catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
	}
	public static MySQLdb getMysqlDb(){
		return(niredb == null) ? (niredb= new MySQLdb()) : niredb;
	}

	public void aginduaExekutatu(String query) {
    	try {
	    	Statement st = this.conn.createStatement();
	    	st.execute(query);  	
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
	}
	
	public ResultSet queryExekutatu(String query) {
		ResultSet res = null;
    	try {
	    	Statement st = this.conn.createStatement();
	    	 res = st.executeQuery(query); 
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return res;
	}
	
	public void updateUserInfo(String name, String surname, String address, String email, String pcode, String phone) {// METER TODOS LOS DATOS QUE PIDAN (HACer
		
		String query = "UPDATE WebsistemakGYM.User SET UserName='" + name + "', UserSurname= '" + surname + "', Address= '"+ address +"', Email= '"+ email +"', PostCode= '"+ pcode +"', Phone='"+ phone +"'";
		System.out.println("     DB query: " + query);
    	try {
	    	Statement st = this.conn.createStatement();
	    	st.execute(query);
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
	}
	
}