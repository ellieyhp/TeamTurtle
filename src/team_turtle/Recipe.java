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
    ArrayList<String> ingredients;
    String description;
    ArrayList<String> instructions;

    public Recipe(String title, ArrayList<String> ingredients, String description, ArrayList<String> instructions) {
        this.title = title;
        this.ingredients = ingredients;
        this.description = description;
        this.instructions = instructions;
    }

    /*
     * Good to use if trying to serialize recipes
     * public static synchronized String createID() {
     * return String.valueOf(++idCounter);
     * }
     */
    public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {
        // Test saving recipe to recipes.json file
        createRecipe("fire", "fire, wood", "how to prepare fire",
                "add fire to wood");
        // getAllRecipe();
    }

    // saves the recipe objects to the recipes.json file
    public static void createRecipe(String title, String ingredients, String description, String instructions)
            throws ParseException, FileNotFoundException, IOException {
        // converting String into ArrayList
        ArrayList<String> ingredientItems = new ArrayList<String>(Arrays.asList(ingredients.split("\\s*,\\s*")));
        ArrayList<String> sbsinstructions = new ArrayList<String>(Arrays.asList(instructions.split("\\s*,\\s*")));

        // each recipe saved as JSON object
        JSONObject recipeDetails = new JSONObject();
        recipeDetails.put("title", title);
        recipeDetails.put("ingredients", ingredientItems);
        recipeDetails.put("description", description);
        recipeDetails.put("instructions", sbsinstructions);

        // outer object that contains array
        JSONObject recipe = new JSONObject();
        JSONArray innerArray = new JSONArray();
        innerArray.add(recipeDetails);
        recipe.put("Recipe", innerArray);

        File f = new File("test.json");

 
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("test.json"));

        if (f.exists()) {
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray array = (JSONArray) jsonObject.get("Recipe");
            PrintWriter write = new PrintWriter(new FileWriter(f));
            Iterator<JSONObject> iterator = array.iterator();
            while (iterator.hasNext()) {
                JSONObject it = iterator.next();
                innerArray.add(it);
            }
            innerArray.add(recipeDetails);
            recipe.put("Recipe", innerArray);
            try (FileWriter file = new FileWriter(f)){
                file.write(recipe.toJSONString());
            }catch(IOException e){
                e.printStackTrace();
            }
        } else {
            // Writing to JSON file
            try (FileWriter file = new FileWriter("test.json")) {

                // We can write any JSONArray or JSONObject instance to the file
                file.write(recipe.toJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    // public static void getAllRecipe() {
    // JSONParser jsonParser = new JSONParser();

    // try (FileReader reader = new FileReader("test.json")) {
    // // Read JSON file
    // Object obj = jsonParser.parse(reader);

    // JSONArray recipeList = (JSONArray) obj;
    // System.out.println(recipeList);

    // // Iterate over recipe array
    // recipeList.forEach(reci -> parseRecipeObject((JSONObject) reci));

    // } catch (FileNotFoundException e) {
    // e.printStackTrace();
    // } catch (IOException e) {
    // e.printStackTrace();
    // } catch (ParseException e) {
    // e.printStackTrace();
    // }
    // }

    // private static void parseRecipeObject(JSONObject recipe) {
    // // Get recipe object within list
    // JSONObject recipeObject = (JSONObject) recipe.get("recipe");

    // // Get recipe title
    // String title = (String) recipeObject.get("title");
    // System.out.println(title);

    // // Get recipe ingredients
    // String ingredients = (String) recipeObject.get("ingredients");
    // System.out.println(ingredients);

    // // Get recipe description
    // String description = (String) recipeObject.get("description");
    // System.out.println(description);

    // // Get recipe instruction
    // String instruction = (String) recipeObject.get("instruction");
    // System.out.println(instruction);
    // }

}
