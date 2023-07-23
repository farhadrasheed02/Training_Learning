import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class FetchRecord {
	static String user_name;     //"root";
	static String password;  //"@Farhad02";
	public static void main(String[] args) {
		
//		System.out.println("Enter the creditionals for the Database :-");
//		Scanner sc = new Scanner(System.in);
//		user_name=sc.toString();
//		password=sc.toString();
		try
		(
			// connections statements 
			// used to link with the database...  JDBC (java database connectivity)
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students","root","@Farhad02");
			Statement stmt =   con.createStatement();
			
		)
		{
			ResultSet rs = stmt.executeQuery("select * from woj");
			while(rs.next())
			{
				System.out.print(rs.getString("id"));
				System.out.print("\t");
				System.out.print(rs.getString("name"));
				System.out.print("\t");
				System.out.print(rs.getString("email"));
				System.out.print("\t");
				System.out.print(rs.getDouble("Salary"));
				System.out.print("\t");
			System.out.println("");
			}
			
		}
		
		catch(SQLException e)
		{
			
			System.out.println("error in retrival"+e);
			
		}
		// close the connections...
//		sc.close();
	}

}
