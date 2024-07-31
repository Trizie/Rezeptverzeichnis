package org.example;
import java.sql.*;
import java.util.List;

class RecipeDatabank implements databaseConnection{
    private Connection connection;


    @Override
    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/rezeptesammlung", "DB_USER", "DB_PASSWORD");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create_table() {
        try (Statement stmt = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS Rezepte (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(255) NOT NULL," +
                    "typ VARCHAR(255) NOT NULL," +
                    "zutaten VARCHAR(50) NOT NULL," +
                    "anleitung TEXT NOT NULL)";
            stmt.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Recipe> print_all_recipes(){
        return sth;
    }

    @Override
    public void search_for_recipe(){}

    @Override
    public void add_recipe_to_DB(){}

}
