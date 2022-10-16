package team_turtle;
//import team_turtle.Recipe; 

import java.io.*; 
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*; 
import org.json.simple.*; 
import org.json.simple.parser.*; 

class Entry { 
    String title;
    ArrayList<String> ingredients;
    String description;
    ArrayList<String> instructions;

    public Entry(String title, ArrayList<String> ingredients, String description, ArrayList<String> instructions) {
        this.title = title;
        this.ingredients = ingredients;
        this.description = description;
        this.instructions = instructions;
    }
}

public class Search { 

    static ArrayList<Entry> recipeBook = new ArrayList<Entry>(); 

    public static void main(String[] args) {

        fillRecipeBook();
        for (Entry r : recipeBook) { 
            System.out.println(); 
            System.out.println(r.title); 
            System.out.println(r.ingredients); 
            System.out.println(r.description); 
            System.out.println(r.instructions); 
        }

        System.out.println("\nsearch results: "); 

        ArrayList<Entry> results = search("rice");
        
        for (Entry r : results) { 
            System.out.println(); 
            System.out.println(r.title); 
            System.out.println(r.ingredients); 
            System.out.println(r.description); 
            System.out.println(r.instructions); 
        }
        
    }

    public static void fillRecipeBook() {

        recipeBook = new ArrayList<Entry>();
        
        JSONParser parser = new JSONParser(); 
        
        try (FileReader reader = new FileReader("team_turtle/recipes.json")) { 
            JSONObject obj = (JSONObject) parser.parse(reader); 
            JSONArray recipes = (JSONArray) obj.get("Recipe") ; 
            System.out.println(recipes); 
            for (Object recipe : recipes) { 
                parseRecipe((JSONObject) recipe); 
            }
        } catch (Exception e) { 
            e.printStackTrace();
        }
    } 

    public static void parseRecipe (JSONObject recipe) { 
        String title = (String) recipe.get("title"); 
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
        Entry r = new Entry(title, ingredients, description, instructions);
        recipeBook.add(r); 
    }

    public static ArrayList<Entry> search (String input) { 
        ArrayList<Entry> searchResults = new ArrayList<Entry>(); 
        for (Entry r: recipeBook) { 
            if (r.title.toLowerCase().matches("(.*)" + input.toLowerCase() + "(.*)")) {
              searchResults.add(r);
            }
        }
        return searchResults; 
    }

}
