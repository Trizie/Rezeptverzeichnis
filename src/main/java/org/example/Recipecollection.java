package org.example;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Recipecollection {

    private List<Recipe> recipes;
    private Connection connection;
    private RecipeDatabank databank;

    public Recipecollection(RecipeDatabank databank){
        recipes = new ArrayList<>();
        this.databank = databank;
    }

    public void add_recipe_to_list() {
        Scanner addRecipeScanner = new Scanner(System.in);
        System.out.println("Rezept wird zur Liste hinzugefuegt");
        System.out.println("Rezeptname eintragen:");
        String recipeName = addRecipeScanner.nextLine();
        System.out.println("Geben Sie den Rezepttyp ein (a) Fruehstueck oder b) Hauptmahlzeit");
        String type = addRecipeScanner.nextLine();
        System.out.println("Benoetigte Zutaten eintragen:");
        String ingredients = addRecipeScanner.nextLine();
        System.out.println("Anleitung eintragen:");
        String instructions = addRecipeScanner.nextLine();

        Recipe recipe;
        if (type.equalsIgnoreCase("a")) {
            recipe = new BreakfastRecipe(recipeName, type, instructions);
        } else if (type.equalsIgnoreCase("b")) {
            recipe = new MainDishRecipe(recipeName, type, instructions);
        } else {
            System.out.println("Unbekannter Rezepttyp. Rezept wird nicht hinzugefuegt.");
            return;
        }
        recipe.add_ingredients(ingredients);

        databank.add_recipe_to_DB(recipe);
    }

    public void print_recipe_list() {
        System.out.println("Rezeptliste");
    }

    public void search_for_recipe() {
        Scanner addRecipeScanner = new Scanner(System.in);
        System.out.println("Tippen Sie das gesuchte Rezept ein");
        String desiredRecipe = addRecipeScanner.nextLine();
    }

    public static void main(String[] args) {
        RecipeDatabank databank = new RecipeDatabank();
        Recipecollection recipes = new Recipecollection(databank);
        databank.connect();
        databank.create_table();
        Scanner recipeScanner = new Scanner(System.in);
        System.out.println("Rezeptverzeichnis");
        System.out.println("Bitte waehlen:");
        System.out.println("a) Alle Rezepte auflisten");
        System.out.println("b) Ein Rezept hinzufuegen");
        System.out.println("c) Nach einem Rezept suchen");
        System.out.println("d) Programmende");
        String chooseFunction = recipeScanner.nextLine();
        System.out.println(chooseFunction);

        switch(chooseFunction){
            case "a":
                recipes.print_recipe_list();
                break;
            case "b":
                recipes.add_recipe_to_list();
                break;
            case "c":
                recipes.search_for_recipe();
                break;
            case "d":
                break;
            default:
                System.out.println("Ungueltig, bitte andere Auswahl");

        }
    }

}