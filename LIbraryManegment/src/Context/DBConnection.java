package Context;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {
public static Connection getCon() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lm",
					"root","1234root");
			return con;
		}
	    catch (Exception e) {
			// TODO: handle exception
	    	System.out.println(e);
	    	return null;
		}
    }
}
