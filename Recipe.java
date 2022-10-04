    //A recipe must contain a name, a description, an ingredient list, 
    //and step-by-step cooking instructions. 
public class Recipe{
    String title;
    ArrayList<String> ingredients;
    String description;
    String instructions;

    public Recipe(String title, ArrayList<String> ingredients, String description, String instructions){
        title = this.title;
        ingredients = this.ingredients;
        description = this.description;
        instructions = this.instructions;
    }

    public static void createRecipe(){
        
    }

}