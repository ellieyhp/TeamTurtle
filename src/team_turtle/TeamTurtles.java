package team_turtle;

import java.io.*; 
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*; 
import org.json.simple.*; 
import org.json.simple.parser.*; 

class Recipe { 
    String title;
    ArrayList<String> ingredients;
    String description;
    ArrayList<String> instructions;

    public Recipe(String title, ArrayList<String> ingredients, String description, ArrayList<String> instructions) {
        this.title = title;
        this.ingredients = ingredients;
        this.description = description;
        this.instructions = instructions;
    }
}

public class TeamTurtles { 
 //search for the recipe
    /*Firstly, they can search for a
    recipe by name (exact string comparison is acceptable, though substring matching,
    ignoring case, and the fuzzy search will make the application more user-friendly).
    Secondly, they can browse all existing recipes and choose the one they want. */

    //view your own recipe

    //scroll function to explore other recipes

    static ArrayList<Recipe> recipeBook; 

    public static void main(String[] args) {
        recipeBook = new ArrayList<Recipe>();
        // Scanner s = new Scanner(System.in);

        // //create a new recipe
        // /*name,description,ingredient list,step-by-step cooking instructions.*/
        // System.out.println("Please enter the name of your recipe: ");       
        // String title = s.nextLine();
        // System.out.println("Please enter a short description of your recipe: ");       
        // String description = s.nextLine();
        // System.out.println("Please list the ingredients of your recipe separated by comma: ");       
        // String ingredients = s.nextLine();
        // System.out.println("Please enter step-by-step instruction of your recipe, each step separated by comma: ");       
        // String instructions = s.nextLine();
        
        // Recipe.createRecipe(title, description, ingredients, instructions);
        fillRecipeBook();
        for (Recipe r : recipeBook) { 
            System.out.println(); 
            System.out.println(r.title); 
            System.out.println(r.ingredients); 
            System.out.println(r.description); 
            System.out.println(r.instructions); 
        }

        System.out.println("\nsearch results: "); 

        ArrayList<Recipe> results = search("rice");
        
        for (Recipe r : results) { 
            System.out.println(); 
            System.out.println(r.title); 
            System.out.println(r.ingredients); 
            System.out.println(r.description); 
            System.out.println(r.instructions); 
        }
        
    }

    public static void fillRecipeBook() { 
        
        JSONParser parser = new JSONParser(); 
        
        try (FileReader reader = new FileReader("recipes.json")) { 
            Object obj = parser.parse(reader); 
            JSONArray recipes = (JSONArray) obj; 
            System.out.println(recipes); 
            //recipes.forEach(recipe -> parseRecipe((JSONObject) recipe)); 
            for (Object recipe : recipes) { 
                parseRecipe((JSONObject) recipe); 
            }
        } catch (Exception e) { 
            e.printStackTrace();
        }
    } 

    public static void parseRecipe (JSONObject recipe) { 
        String title = (String) recipe.get("title"); 
        //System.out.println(recipe.get("ingredients").getClass().getName()); 
        JSONArray ingredientsObjArray = (JSONArray) recipe.get("ingredients"); 
        ArrayList<String> ingredients = new ArrayList<String>(); 
        for (Object ingredient: ingredientsObjArray) { 
            ingredients.add((String) ingredient); 
        }
        String description = (String) recipe.get("description"); 
        JSONArray instructionsObjArray = (JSONArray) recipe.get("instructions"); 
        ArrayList<String> instructions = new ArrayList<String>(); 
        for (Object instruction: instructionsObjArray) { 
            instructions.add((String) instruction); 
        }
        Recipe r = new Recipe(title, ingredients, description, instructions);
        recipeBook.add(r); 
    }

    public static ArrayList<Recipe> search (String input) { 
        ArrayList<Recipe> searchResults = new ArrayList<Recipe>(); 
        for (Recipe r: recipeBook) { 
            if (r.title.toLowerCase().matches("(.*)" + input.toLowerCase() + "(.*)")) {
              searchResults.add(r);
            }
        }
        return searchResults; 
    }

}
