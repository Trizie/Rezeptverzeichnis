package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Recipecollection {

    private List<Recipe> recipes;

    public Recipecollection(){
        recipes = new ArrayList<>();
    }

    public static void add_recipe_to_list() {
        Scanner addRecipeScanner = new Scanner(System.in);
        System.out.println("Rezept wird zur Liste hinzugefuegt");
        System.out.println("Rezeptname eintragen:");
        String recipeName = addRecipeScanner.nextLine();
        System.out.println("Benoetigte Zutaten eintragen:");
        String ingredients = addRecipeScanner.nextLine();
        System.out.println("Anleitung eintragen:");
        String instructions = addRecipeScanner.nextLine();

        Recipe recipe = new Recipe(recipeName, instructions);
        recipe.add_ingredients(ingredients);
    }

    static void print_recipe_list() {
        System.out.println("Rezeptliste");
    }
    public static void main(String[] args) {
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
                print_recipe_list();
                break;
            case "b":
                add_recipe_to_list();
                break;
            case "c":
                //search_for_recipe();
                break;
            case "d":
                break;
            default:
                System.out.println("Ungueltig, bitte andere Auswahl");

        }
    }



    public void search_for_recipe() {
        Scanner addRecipeScanner = new Scanner(System.in);
        System.out.println("Tippen Sie das gesuchte Rezept ein");
        String desiredRecipe = addRecipeScanner.nextLine();
    }
}