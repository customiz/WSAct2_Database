package com.stou.lab2;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class ProductDAo {
	private Connection connection;

	public ProductDAo() {
		connection = Database.getConnection();

	}

	public void checkProduct(Product product) {
		try {
			PreparedStatement ps = connection.prepareStatement("select * from smartwatch.products where id = ?");
			ps.setInt(1, product.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) // found
			{
				updateProduct(product);

			} else {
				addProduct(product);
			}
		} catch (Exception ex) {
			System.out.println("Error in check() -->" + ex.getMessage());
		}
	}

	public void addProduct(Product product) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO smartwatch.products (id, name, `desc`, price, image) VALUES (?,?,?,?,?)");
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setString(3, product.getDesc());
			preparedStatement.setDouble(4, product.getPrice());
			preparedStatement.setNull(5, java.sql.Types.BLOB);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void deleteProduct(String id) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM smartwatch.products WHERE id = ?");
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateProduct(Product product) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE smartwatch.products SET name = ?, `desc` = ?, price = ? WHERE id = ?");
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getDesc());
			preparedStatement.setInt(3, product.getPrice());
			preparedStatement.setInt(4, product.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from smartwatch.products");
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDesc(rs.getString("desc"));
				product.setPrice(rs.getInt("price"));
				products.add(product);

			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return products;
	}

	public Product getProductById(String id) {
		Product product = new Product();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from smartwatch.products where id=?");
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDesc(rs.getString("desc"));
				product.setPrice(rs.getInt("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return product;
	}
}
