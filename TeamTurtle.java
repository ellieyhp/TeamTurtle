import java.util.*;
import java.util.Scanner;
public class TeamTurtle { 
 //search for the recipe
    /*Firstly, they can search for a
    recipe by name (exact string comparison is acceptable, though substring matching,
    ignoring case, and the fuzzy search will make the application more user-friendly).
    Secondly, they can browse all existing recipes and choose the one they want. */

    //view your own recipe

    //scroll function to explore other recipes

    public static void main(String[] args) {
        ArrayList<Recipe> recipeBook = new ArrayList<Recipe>();
        Scanner s = new Scanner(System.in);

        //create a new recipe
        /*name,description,ingredient list,step-by-step cooking instructions.*/
        System.out.println("Please enter the name of your recipe: ");       
        String title = s.nextLine();
        System.out.println("Please enter a short description of your recipe: ");       
        String description = s.nextLine();
        System.out.println("Please list the ingredients of your recipe separated by comma: ");       
        String ingredients = s.nextLine();
        System.out.println("Please enter step-by-step instruction of your recipe, each step separated by comma: ");       
        String instructions = s.nextLine();
        
        recipeBook.add(Recipe.createRecipe(title, description, ingredients, instructions));

    }
}
