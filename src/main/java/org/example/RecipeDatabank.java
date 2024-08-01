package org.example;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
import java.util.List;


class RecipeDatabank implements databaseConnection{
    private Connection connection;
    Dotenv dotenv = Dotenv.load();

    @Override
    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/rezeptesammlung", dotenv.get("DB_USER"), dotenv.get("DB_PASSWORD"));
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

   // @Override
    //public List<Recipe> print_all_recipes(){
     //   return List<Recipe>;
    //}

    @Override
    public void search_for_recipe(){}

    @Override
    public void add_recipe_to_DB(Recipe recipe){
        try {
            String sql = "INSERT INTO rezepte(name, typ, zutaten, anleitung) VALUES(?, ?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, recipe.get_Name());
                pstmt.setString(2, recipe.get_type());
                pstmt.setArray(3, recipe.get_Ingredients());
                pstmt.setString(4, recipe.get_instructions());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
