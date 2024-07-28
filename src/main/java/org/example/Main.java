package org.example;
import java.util.Scanner;
import java.util.ArrayList;

List<String> repice_list = new ArrayList();

public class Main {
    Scanner recipeScanner = new Scanner(System.in);

    static void search_for_recipe() {
        System.out.println(recipe_list);
    }

    static void add_recipe_to_list() {
        Scanner addRecipeScanner = new Scanner(System.in);
        System.out.println("Recipe is added to list");
        System.out.println("Insert the recipe name:");
        String recipeName = addRecipeScanner.nextLine();
        System.out.println("Insert the ingredients needed:");
        String ingredients = addRecipeScanner.nextLine();
        
    }

    static void print_recipe_list() {
        System.out.println(recipe_list);
    }
    public static void main(String[] args) {
        Scanner recipeScanner = new Scanner(System.in);
        System.out.println("Rezeptverzeichnis");
        System.out.println("Bitte waehlen:");
        System.out.println("a) Alle Rezepte auflisten");
        System.out.println("b) Ein Rezept hinzufuegen");
        System.out.println("c) Nach einem Rezept suchen");
        String chooseFunction = recipeScanner.nextLine();
        System.out.println(chooseFunction);

        if (chooseFunction=="a"){
            print_recipe_list();
        }
        else if (chooseFunction=="b") {
            add_recipe_to_list();
        }
        else if (chooseFunction=="c") {
            search_for_recipe();
        }
    }
}