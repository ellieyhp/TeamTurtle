import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//A recipe must contain a name, a description, an ingredient list, 
//and step-by-step cooking instructions. 
public class Recipe {
    String title;
    ArrayList<String> ingredients;
    String description;
    String instructions;

    public Recipe(String title, ArrayList<String> ingredients, String description, String instructions) {
        title = this.title;
        ingredients = this.ingredients;
        description = this.description;
        instructions = this.instructions;
    }

    /*
     * Good to use if trying to serialize recipes
     * public static synchronized String createID() {
     * return String.valueOf(++idCounter);
     * }
     */

    // saves the recipe objects to the recipes.json file
    public static void createRecipe(String title, String ingredients, String description, String instructions) {
        // ingredients String into ArrayList
        ArrayList<String> ingredientItems = new ArrayList<String>(Arrays.asList(ingredients.split("\\s*,\\s*")));
        // constructing a Recipe object
        Recipe a = new Recipe(title, ingredientItems, description, instructions);

        JSONObject recipeDetails = new JSONObject();
        recipeDetails.put("title", title);
        recipeDetails.put("ingredients", ingredientItems);
        recipeDetails.put("description", description);
        recipeDetails.put("instructions", instructions);

        JSONObject recipeObject = new JSONObject();
        recipeObject.put("recipe", recipeDetails);

        // Writing to JSON file
        try (FileWriter file = new FileWriter("recipes.json")) {
            // We can write any JSONArray or JSONObject instance to the file
            file.write(recipeObject.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getAllRecipe() {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("recipes.json")) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray recipeList = (JSONArray) obj;
            System.out.println(recipeList);

            // Iterate over recipe array
            recipeList.forEach(reci -> parseRecipeObject((JSONObject) reci));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseRecipeObject(JSONObject recipe) {
        // Get recipe object within list
        JSONObject recipeObject = (JSONObject) recipe.get("recipe");

        // Get recipe title
        String title = (String) recipeObject.get("title");
        System.out.println(title);

        // Get recipe ingredients
        String ingredients = (String) recipeObject.get("ingredients");
        System.out.println(ingredients);

        // Get recipe description
        String description = (String) recipeObject.get("description");
        System.out.println(description);

        // Get recipe instruction
        String instruction = (String) recipeObject.get("instruction");
        System.out.println(instruction);        
    }

}
