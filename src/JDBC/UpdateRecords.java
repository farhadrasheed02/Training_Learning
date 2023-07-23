package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateRecords {

	public static void main(String[] args) {
		
		try
		(
			// connections statements 
			// used to link with the database...
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students","root","@Farhad02");
			Statement stmt =   con.createStatement();
			
		)
		{
//			int CountRecords = stmt.executeUpdate("update woj set salary = salary+20000 where id = 1");
			int CountRecords = stmt.executeUpdate("update woj set email = 'abc@gmail.com' where id = 1");
			System.out.println(CountRecords+" record(s) affectes");
			ResultSet rs = stmt.executeQuery("select * from woj where id=1");
			
			
			while(rs.next()) // always give boolean....
			{
				System.out.print(rs.getString("id"));
				System.out.print("\t");
				System.out.print(rs.getString("name"));
				System.out.print("\t");
				System.out.print(rs.getString("email"));
				System.out.print("\t");
				System.out.print(rs.getDouble("salary"));
				System.out.print("\t");
				System.out.println("");
			}
			
		}
		catch(SQLException e)
		{
			System.out.println("error in retrival"+e);
			
		}
	}

}
