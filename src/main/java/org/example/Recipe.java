package org.example;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String recipe_name;
    private List<String> ingredients;
    private String instructions;

    public Recipe(String recipe_name, String instructions){
        this.recipe_name = recipe_name;
        this.ingredients = new ArrayList<>();
        this.instructions = instructions;
    }

    public String get_Name(){
        return recipe_name;
    }

    public String get_instructions(){
        return instructions;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void add_ingredients(String ingredient){
        ingredients.add(ingredient);
    }
}
