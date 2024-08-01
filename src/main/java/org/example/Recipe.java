package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

abstract class Recipe {
    private String recipe_name;
    private List<String> ingredients;
    private String instructions;
    private String type;

    public Recipe(String recipe_name, String type, String instructions){
        this.recipe_name = recipe_name;
        this.ingredients = new ArrayList<>();
        this.instructions = instructions;
        this.type = type;

    }

    public String get_Name(){
        return recipe_name;
    }

    public String get_type(){
        return type;
    }

    public String get_instructions(){
        return instructions;
    }

    public Array get_Ingredients() {
        return (Array) ingredients;
    }

    public void add_ingredients(String ingredient){
        ingredients.add(ingredient);
    }

    public abstract void print_precooking_instructions();
}

class BreakfastRecipe extends Recipe {
    public BreakfastRecipe(String name, String type, String instructions) {
        super(name, type, instructions);
    }

    @Override
    public void print_precooking_instructions() {
        System.out.println("Du kannst am Vortag alle Zutaten bereit stellen, damit du morgens weniger Stress hast.");
    }
}

class MainDishRecipe extends Recipe {
    public MainDishRecipe(String name, String type, String instructions) {
        super(name, type, instructions);
    }

    @Override
    public void print_precooking_instructions() {
        System.out.println("Achtung: wenn der Ofen verwendet wird darf der Geschirrspueler nicht laufen.");
    }
}