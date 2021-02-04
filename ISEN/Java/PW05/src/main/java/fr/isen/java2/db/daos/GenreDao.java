package fr.isen.java2.db.daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.isen.java2.db.entities.Genre;

public class GenreDao {
	public static List<Genre> listGenres() {
		List<Genre> listOfGenres = new ArrayList<>();
		try (Connection connection = DataSourceFactory.getDataSource()) {
			try (Statement statement = connection.createStatement()) {
				try (ResultSet results = statement.executeQuery("select * from genre")) {
					while (results.next()) {
						Genre genre = new Genre(results.getInt("idgenre"),
								results.getString("name"));
						listOfGenres.add(genre);
					}
				}
			}
		}
		catch (SQLException e) {
			// Manage Exception
			e.printStackTrace();
		}
		return listOfGenres;
	}

	public Genre getGenre(String name) {
		try (Connection connection = DataSourceFactory.getDataSource()) {
			try (PreparedStatement statement = connection.prepareStatement(
					"SELECT * FROM genre WHERE name = ?")) {
				statement.setString(1, name);
				try (ResultSet results = statement.executeQuery()) {
					if (results.next()) {
						return new Genre(results.getInt("idgenre"),
								results.getString("name"));
					}
				}
			}
		} catch (SQLException e) {
			// Manage Exception
			e.printStackTrace();
		}
		return null;
	}

	public Genre getGenre(Integer genreId) {
		try (Connection connection = DataSourceFactory.getDataSource()) {
			try (PreparedStatement statement = connection.prepareStatement(
					"select * from genre where idgenre=?")) {
				statement.setInt(1, genreId);
				try (ResultSet results = statement.executeQuery()) {
					if (results.next()) {
						return new Genre(results.getInt("idgenre"),
								results.getString("name"));
					}
				}
			}
		} catch (SQLException e) {
			// Manage Exception
			e.printStackTrace();
		}
		return null;
	}

	public Genre addGenre(String name) {
		try (Connection connection = DataSourceFactory.getDataSource()) {
			String sqlQuery = "INSERT INTO genre(name) VALUES(?)" ;
			try (PreparedStatement statement = connection.prepareStatement(
					sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
				statement.setString(1, name);
				statement.executeUpdate();
				ResultSet ids = statement.getGeneratedKeys();
				if (ids.next()) {
					return new Genre(ids.getInt(1), name);
				}
			}
		}catch (SQLException e) {
			// Manage Exception
			e.printStackTrace();
		}
		return null;
	}


}
