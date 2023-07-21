package jdbc_simple_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ProductDeleteQuery {

	public static void main(String[] args) {
		Connection connection=null;
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			String url="jdbc:mysql://localhost:3306/jdbc-8:30";
			String user="root";
			String pass="sho@ib09";
			connection=DriverManager.getConnection(url, user, pass);
			
			Statement statement=connection.createStatement();
			
			String deleteProductQuery=" delete from product where id in (200,300)";
			int a=statement.executeUpdate(deleteProductQuery);
			System.out.println("a= " + a);
			if(a==1) {
				System.out.println("data deleted");
			}
			else {
				System.out.println("given id is not present or more than 1 id");
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
