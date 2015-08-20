package registerLoader;

import java.sql.*;

import core.Person;
import register.ListRegister;
import register.Register;

public class DatabaseRegisterLoader implements RegisterLoader {

	/** set DB parameters */
	public static final String URL = "jdbc:mysql://localhost/register";
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	/** set DB query */
	protected static final String DATABASE_PROPERTIES = "database.properties";
	public static final String QUERYCREATE = "CREATE TABLE register (id INT PRIMARY KEY, name VARCHAR(32) NOT NULL, phoneNumber VARCHAR(15) NOT NULL)";
	public static final String QUERYDELETE = "DROP TABLE IF EXISTS register";
	public static final String QUERYINSERT = "INSERT INTO register (id, name, phoneNumber) VALUES (?, ?, ?)";
	public static final String QUERYSELECT = "SELECT * FROM register";

	@Override
	/**
	 * Load persons from database to register.
	 * 
	 * @return register register of persons
	 */
	public Register load() {
		Register r = new ListRegister();
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);) {
			try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(QUERYSELECT);) {
				while (rs.next()) {
					r.ArrayRegister(new Person(rs.getString(2), rs.getString(3)));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return r;
	}

	/**
	 * Returns the person at the specified position in this register.
	 * 
	 * @param register
	 * 				register of persons.          
	 */
	@Override
	public void store(Register register) {
		Person p;
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);) {
			try (Statement stmt = con.createStatement();) {
				// delete table register if exist and create new table
				stmt.executeUpdate(QUERYDELETE);
				stmt.executeUpdate(QUERYCREATE);
			}
			try (PreparedStatement stmtPrepare = con.prepareStatement(QUERYINSERT);) {
				// insert person into database
				for (int i = 0; i < register.getCount(); i++) {
					p = register.getPerson(i);
					stmtPrepare.setInt(1, i + 1);
					stmtPrepare.setString(2, p.getName());
					stmtPrepare.setString(3, p.getPhoneNumber());
					stmtPrepare.executeUpdate();
				}
				System.out.println("Save register to Database");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
