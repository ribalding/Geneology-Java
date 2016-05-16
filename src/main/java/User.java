import java.util.List;
import org.sql2o.*;

public class User{
  private int id;
  private String user_name;
  private String password;

  public User(String userName, String pass){
    user_name = userName;
    password = pass;
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

  public static boolean validate(String userName, String pass){
    if((userName == "") || (pass == "")){
      return false;
    } else {
      return true;
    }
  }

  public List<Relative> getRelatives() {
    String sql = "SELECT * FROM relatives WHERE user_id = :id;";

  }

  public void save(){
    String sql = "INSERT INTO users (user_name, password) VALUES (:user_name, :password);";
    try(Connection con = DB.sql2o.open()){
      this.id = (int) con.createQuery(sql, true)
      .addParameter("user_name", this.user_name)
      .addParameter("password", this.password)
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
              this.getPassword() == newUser.getPassword();
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
