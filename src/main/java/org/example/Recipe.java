package org.example;

import java.util.ArrayList;
import java.util.List;

abstract class Recipe {
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

    public List<String> get_Ingredients() {
        return ingredients;
    }

    public void add_ingredients(String ingredient){
        ingredients.add(ingredient);
    }

    public abstract void print_precooking_instructions();
}

class BreakfastRecipe extends Recipe {
    public BreakfastRecipe(String name, String instructions) {
        super(name, instructions);
    }

    @Override
    public void print_precooking_instructions() {
        System.out.println("Du kannst am Vortag alle Zutaten bereit stellen, damit du morgens weniger Stress hast.");
    }
}

class MainDishRecipe extends Recipe {
    public MainDishRecipe(String name, String instructions) {
        super(name, instructions);
    }

    @Override
    public void print_precooking_instructions() {
        System.out.println("Achtung: wenn der Ofen verwendet wird darf der Geschirrspueler nicht laufen.");
    }
}