package jdbc_simple_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
public class ProductUpdateController {

	public static void main(String[] args) {
		//Register
		Connection connection=null;
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			String url="jdbc:mysql://localhost:3306/jdbc-8:30";
			String user="root";
			String pass="sho@ib09";
			connection=DriverManager.getConnection(url, user, pass);
			
			Statement statement=connection.createStatement();
			
			String updateProductQuery=" update  product set color='aura'  where id=401";
			int a=statement.executeUpdate(updateProductQuery);
			System.out.println("a= " + a);
			if(a==1) {
				System.out.println("data updated");
			}
			else {
				System.out.println("given id is not present");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
