import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStmt {

	public static void main(String[] args) {
		try
		(
			// connections statements 
			// used to link with the database...
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students","root","@Farhad02");
//			PreparedStatement pstmt =   con.prepareStatement("insert into employees(id,name) values(?,?)");
				PreparedStatement pstmt =   con.prepareStatement("select * from woj");
				//select * from information;
		)
		{
//			
//			pstmt.setString(1, "101");
//			pstmt.setString(2,"Ratan");
//			int i = pstmt.executeUpdate();
//			System.out.println(i+"records got inserted");
//			
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("Total columns "+rsmd.getColumnCount());
			System.out.println("Ist Column name :"+rsmd.getColumnName(1));
			System.out.println("Ist column type name "+rsmd.getColumnType(1));
			

			
		}
		catch(SQLException e)
		{
			System.out.println("error in retrival"+e);
			
		}

	}

}
