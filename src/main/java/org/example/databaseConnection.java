package org.example;

import java.util.List;

public interface databaseConnection {
    void connect();
    void create_table();
    List<Recipe> print_all_recipes();
    void search_for_recipe();
    void add_recipe_to_DB();
}
