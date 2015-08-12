package register;

import java.sql.*;

public class DatabaseRegisterLoader implements RegisterLoader {

	/** set DB parameters */
	public static final String URL = "jdbc:mysql://localhost/register";
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	private Register r;
	/** set DB query */
	protected static final String DATABASE_PROPERTIES = "database.properties";
	public static final String QUERYCREATE = "CREATE TABLE register (id INT PRIMARY KEY, name VARCHAR(32) NOT NULL, phoneNumber VARCHAR(15) NOT NULL)";
	public static final String QUERYDELETE = "DROP TABLE IF EXISTS register";
	public static final String QUERYINSERT = "INSERT INTO register (id, name, phoneNumber) VALUES (?, ?, ?)";
	public static final String QUERYSELECT = "SELECT * FROM register";
	
	@Override
	public Register readRegister() {
		Person p = new Person(null, null);
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);) {
			try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(QUERYSELECT);) {
				 while(rs.next()) {
					 System.out.println("Name: " + rs.getString(2) + " phone: " + rs.getString(3));
			         p.setName(rs.getString(2)); 
			         p.setPhoneNumber(rs.getString(3));
					 //r.ArrayRegister(p);
			        }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return r;
	}

	@Override
	public void saveRegister(Register register) {
		Person p;
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);) {
			try (Statement stmt = con.createStatement();) {
				stmt.executeUpdate(QUERYDELETE);
				stmt.executeUpdate(QUERYCREATE);
			}
			try (PreparedStatement stmtPrepare = con.prepareStatement(QUERYINSERT);) {
				// insert person into table
				for (int i = 0; i < register.getCount(); i++) {
					p = register.getPerson(i);
					stmtPrepare.setInt(1, i + 1);
					stmtPrepare.setString(2, p.getName());
					stmtPrepare.setString(3, p.getPhoneNumber());
					stmtPrepare.executeUpdate();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
