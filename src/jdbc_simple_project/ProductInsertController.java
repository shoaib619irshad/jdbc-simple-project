package jdbc_simple_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductInsertController {

	public static void main(String[] args) {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc-8:30";
			String user="root";
			String pass="sho@ib09";
			connection=DriverManager.getConnection(url, user, pass);
			Statement statement=connection.createStatement();
			String insertProductQuery="insert into product (id,name,color,price) values(405,'bike','black',150000)";
			statement.execute(insertProductQuery);
			System.out.println("Data===Inserted");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}
				else {
					System.out.println("first establish connection");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}

}

