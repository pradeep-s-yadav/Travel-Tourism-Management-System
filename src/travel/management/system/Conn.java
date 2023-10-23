package travel.management.system;

import java.sql.*;

public class Conn {

	Connection c;
	Statement s;

	Conn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql:///travel_management_system", "root", "Psy@781588");
			s = c.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
