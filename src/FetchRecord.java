import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class FetchRecord {

	public static void main(String[] args) {
		try
		(
			// connections statements 
			// used to link with the database...
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students","root","@Farhad02");
			Statement stmt =   con.createStatement();
			
		)
		{
			ResultSet rs = stmt.executeQuery("select * from information");
			while(rs.next())
			{
				System.out.print(rs.getString("first_name"));
				System.out.print("\t");
				System.out.print(rs.getString("last_name"));
				System.out.print("\t");
//				System.out.print(rs.getInt("gender"));
//				System.out.print("\t");
			System.out.println("");
			}
			
		}
		catch(SQLException e)
		{
			
			System.out.println("error in retrival"+e);
			
		}
		// close the connections...
	}

}
