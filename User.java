public class User {
   String username;
   String password;
   ArrayList<Recipe> myRB;
   
   public User(String id, String pwd){
    username = id;
    password = pwd;
    ArrayList<Recipe> myRB = new ArrayList<Recipe>();
   }
}
