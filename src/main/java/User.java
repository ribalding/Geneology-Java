import java.util.List;
import org.sql2o.*;

public class User{
  private int id;
  private String user_name;
  private String password;
  private static boolean userNameCheck;
  private String relName;
  private Relative thisRel;
  private boolean tree_exists;
  private String img;

  public User(String userName, String pass){
    user_name = userName;
    password = pass;
    tree_exists = false;
  }

  public String getUserName(){
    return user_name;
  }

  public String getPassword(){
    return password;
  }

  public int getId(){
    return id;
  }

  public void addImg(String image){
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE users SET img = :img WHERE id = :id";
      con.createQuery(sql)
      .addParameter("img", image)
      .addParameter("id", this.id)
      .executeUpdate();
    }
    this.img = image;
  }

  public String getImg(){
    return this.img;
  }

  public void treeNowExists(){
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE users SET tree_exists = :tree_exists WHERE id =:id";
      con.createQuery(sql)
      .addParameter("tree_exists", true)
      .addParameter("id", this.id)
      .executeUpdate();
    }
    this.tree_exists = true;
  }

  public boolean getTreeExists(){
    return tree_exists;
  }

  public static boolean validate(String fullName, String pass, String confirmPassword){
    for(User user : User.all()){
      if(user.getUserName().equals(fullName)){
        userNameCheck = false;
        break;
      } else {
        userNameCheck = true;
      }
    }
    if((fullName.equals("")) || (pass.equals("")) || (confirmPassword.equals("")) || (!(pass.equals(confirmPassword))) || userNameCheck == false){
      return false;
    } else {
      return true;
    }
  }

  public List<Relative> getRelatives() {
    String sql = "SELECT * FROM relatives WHERE user_id = :id;";
    try (Connection con = DB.sql2o.open()){
      return con.createQuery(sql).addParameter("id", this.getId()).executeAndFetch(Relative.class);
    }
  }


  public Relative getRelative(int relTypeId){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM relatives WHERE (relation_type_id = :relTypeId) AND (user_id = :id)";
      Relative newRelative = con.createQuery(sql)
        .addParameter("relTypeId", relTypeId)
        .addParameter("id", this.id)
        .executeAndFetchFirst(Relative.class);
      return newRelative;
    }
  }

  public void save(){
    String sql = "INSERT INTO users (user_name, password, tree_exists) VALUES (:user_name, :password, :tree_exists);";
    try(Connection con = DB.sql2o.open()){
      this.id = (int) con.createQuery(sql, true)
      .addParameter("user_name", this.user_name)
      .addParameter("password", this.password)
      .addParameter("tree_exists", false)
      .executeUpdate()
      .getKey();
    }
  }

  public static List<User> all(){
    String sql = "SELECT * FROM users;";
    try (Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(User.class);
    }
  }

  @Override
   public boolean equals(Object otherUser) {
     if (!(otherUser instanceof User)) {
       return false;
     } else {
       User newUser = (User) otherUser;
       return this.getUserName().equals(newUser.getUserName()) &&
              this.getPassword().equals(newUser.getPassword());
     }
   }

   public static User find(int id){
     try (Connection con = DB.sql2o.open()) {
       String sql = "SELECT * FROM users WHERE id = :id";
       User newUser = con.createQuery(sql)
         .addParameter("id", id)
         .executeAndFetchFirst(User.class);
       return newUser;
     }
   }

   public static User findByName(String name){
     try (Connection con = DB.sql2o.open()) {
       String sql = "SELECT * FROM users WHERE user_name = :user_name";
       User newUser = con.createQuery(sql)
         .addParameter("user_name", name)
         .executeAndFetchFirst(User.class);
       return newUser;
     }
   }

   public void update(String user_name, String password) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE users SET user_name = :user_name, password = :password WHERE id =:id";
      con.createQuery(sql)
      .addParameter("user_name", user_name)
      .addParameter("password", password)
      .addParameter("id", this.id)
      .executeUpdate();
    }
  }

  public void delete() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM users WHERE id = :id";
      con.createQuery(sql)
      .addParameter("id", this.id)
      .executeUpdate();
    }
  }
}
