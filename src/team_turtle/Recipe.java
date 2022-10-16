package team_turtle;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//A recipe must contain a name, a description, an ingredient list, 
//and step-by-step cooking instructions. 
public class Recipe {
    String title;
    String ingredients;
    String description;
    String instructions;

    public Recipe(String title, String ingredients, String description, String instructions) {
        this.title = title;
        this.ingredients = ingredients;
        this.description = description;
        this.instructions = instructions;
    }

    public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {
        // Test saving recipe to recipes.json file
        
    }

    // saves the recipe objects to the recipes.json file
    public void createRecipe()
            throws ParseException, FileNotFoundException, IOException {
        // converting String into ArrayList
        ArrayList<String> ingredientItems = new ArrayList<String>(Arrays.asList(this.ingredients.split("\\s*,\\s*")));
        ArrayList<String> sbsinstructions = new ArrayList<String>(Arrays.asList(this.instructions.split("\\s*,\\s*")));

        // each recipe saved as JSON object
        JSONObject recipeDetails = new JSONObject();
        recipeDetails.put("title", this.title);
        recipeDetails.put("ingredients", ingredientItems);
        recipeDetails.put("description", this.description);
        recipeDetails.put("instructions", sbsinstructions);

        // outer object that contains array
        JSONObject recipe = new JSONObject();
        JSONArray innerArray = new JSONArray();
        innerArray.add(recipeDetails);
        recipe.put("Recipe", innerArray);

        File f = new File("recipes.json");

 
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("recipes.json"));

        if (f.exists()) {
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray array = (JSONArray) jsonObject.get("Recipe");
            PrintWriter write = new PrintWriter(new FileWriter(f));
            Iterator<JSONObject> iterator = array.iterator();
            while (iterator.hasNext()) {
                JSONObject it = iterator.next();
                innerArray.add(it);
            }
            // innerArray.add(recipeDetails);
            recipe.put("Recipe", innerArray);
            try (FileWriter file = new FileWriter(f)){
                file.write(recipe.toJSONString());
            }catch(IOException e){
                e.printStackTrace();
            }
        } else {
            try (FileWriter file = new FileWriter("recipes.json")) {

                // We can write any JSONArray or JSONObject instance to the file
                file.write(recipe.toJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
