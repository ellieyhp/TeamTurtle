import java.util.*;
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

    // public static synchronized String createID() {
    // return String.valueOf(++idCounter);
    // }
    public static Recipe createRecipe(String title, String ingredients, String description, String instructions) {
        ArrayList<String> ingredientItems = new ArrayList<String>(Arrays.asList(ingredients.split("\\s*,\\s*")));
        Recipe a = new Recipe(title, ingredientItems, description, instructions);
        return a;
    }

}