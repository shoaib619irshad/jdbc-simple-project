package jdbc_simple_project;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ProductDisplayController {

	public static void main(String[] args) {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/jdbc-8:30";
			String user="root";
			String pass="sho@ib09";
			connection=DriverManager.getConnection(url, user, pass);
			
			Statement statement=connection.createStatement();
			
			String displayProductQuery=" SELECT * FROM product";
			ResultSet resultSet=statement.executeQuery(displayProductQuery);
			while(resultSet.next()) {
				int id=resultSet.getInt("id");
				String name=resultSet.getString("name");
				String color=resultSet.getString("color");
				double price=resultSet.getDouble("price");
				
				System.out.println("productId= " + id);
				System.out.println("productName= " + name);
				System.out.println("productColor= " + color);
				System.out.println("productPrice= " + price);
				System.out.println("==========");
			
				
				
				
			}
			
		}catch(SQLException | ClassNotFoundException e) {
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
