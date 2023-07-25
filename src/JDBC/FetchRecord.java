package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class FetchRecord {
	static String user_name;     //"root";
	static String password;  //"@Farhad02";
	static String url="jdbc:mysql://localhost:3306/Students";
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter database username: ");
         user_name = scanner.next();

        System.out.println("Enter database password: ");
         password = scanner.next();

//         url = "jdbc:mysql://localhost:3306/Students";
		
		
		try
		(
			// connections statements 
			// used to link with the database...  JDBC (java database connectivity)
			
			Connection con = DriverManager.getConnection(url, user_name, password);
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
			
			System.out.println("error in retrival"+e.getMessage());
			
		}
		// close the connections...
		scanner.close();
	}

}
