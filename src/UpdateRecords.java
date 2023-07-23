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
			int CountRecords = stmt.executeUpdate("update employees set age = age+10 where id = 11");
			System.out.println(CountRecords+" record(s) affectes");
			ResultSet rs = stmt.executeQuery("select * from employees where id=11");
			
			
			while(rs.next()) // always give bolean....
			{
				System.out.print(rs.getString("id"));
				System.out.print("\t");
				System.out.print(rs.getString("name"));
				System.out.print("\t");
				System.out.print(rs.getInt("age"));
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
