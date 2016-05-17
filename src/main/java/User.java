import java.util.List;
import org.sql2o.*;

public class User{
  private int id;
  private String user_name;
  private String password;
  private static boolean userNameCheck;
  private String relName;
  private String momName;

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

  public String getFatherName(List<Relative> relList){
    for(Relative rel : relList){
      if(rel.getRelationTypeId() == 1){
        relName = rel.getRelativeName();
        break;
      }
    }
    return relName;
  }

    public String getPaternalGrandfatherName(List<Relative> relList){
      for(Relative rel : relList){
        if(rel.getRelationTypeId() == 2){
          relName = rel.getRelativeName();
          break;
        }
      }
      return relName;
    }

    public String getPaternalGrandmotherName(List<Relative> relList){
      for(Relative rel : relList){
        if(rel.getRelationTypeId() == 3){
          relName = rel.getRelativeName();
          break;
        }
      }
      return relName;
    }

    public String getFathersSibling1Name(List<Relative> relList){
      for(Relative rel : relList){
        if(rel.getRelationTypeId() == 4){
          relName = rel.getRelativeName();
          break;
        }
      }
      return relName;
    }

    public String getFathersSibling2Name(List<Relative> relList){
      for(Relative rel : relList){
        if(rel.getRelationTypeId() == 5){
          relName = rel.getRelativeName();
          break;
        }
      }
      return relName;
    }

    public String getFathersSibling1Kid1Name(List<Relative> relList){
      for(Relative rel : relList){
        if(rel.getRelationTypeId() == 6){
          relName = rel.getRelativeName();
          break;
        }
      }
      return relName;
    }

    public String getFathersSibling1Kid2Name(List<Relative> relList){
      for(Relative rel : relList){
        if(rel.getRelationTypeId() == 7){
          relName = rel.getRelativeName();
          break;
        }
      }
      return relName;
    }

    public String getFathersSibling2Kid1Name(List<Relative> relList){
      for(Relative rel : relList){
        if(rel.getRelationTypeId() == 8){
          relName = rel.getRelativeName();
          break;
        }
      }
      return relName;
    }

    public String getFathersSibling2Kid2Name(List<Relative> relList){
      for(Relative rel : relList){
        if(rel.getRelationTypeId() == 9){
          relName = rel.getRelativeName();
          break;
        }
      }
      return relName;
    }

    public String getMotherName(List<Relative> relList){
      for(Relative rel : relList){
        if(rel.getRelationTypeId() == 10){
          relName = rel.getRelativeName();
          break;
        }
      }
      return relName;
    }

    public String getMaternalGrandfatherName(List<Relative> relList){
      for(Relative rel : relList){
        if(rel.getRelationTypeId() == 11){
          relName = rel.getRelativeName();
          break;
        }
      }
      return relName;
    }

    public String getMaternalGrandmotherName(List<Relative> relList){
      for(Relative rel : relList){
        if(rel.getRelationTypeId() == 12){
          relName = rel.getRelativeName();
          break;
        }
      }
      return relName;
    }

    public String getMothersSibling1Name(List<Relative> relList){
      for(Relative rel : relList){
        if(rel.getRelationTypeId() == 13){
          relName = rel.getRelativeName();
          break;
        }
      }
      return relName;
    }

    public String getMothersSibling2Name(List<Relative> relList){
      for(Relative rel : relList){
        if(rel.getRelationTypeId() == 14){
          relName = rel.getRelativeName();
          break;
        }
      }
      return relName;
    }

    public String getMothersSibling1Kid1Name(List<Relative> relList){
      for(Relative rel : relList){
        if(rel.getRelationTypeId() == 15){
          relName = rel.getRelativeName();
          break;
        }
      }
      return relName;
    }

    public String getMothersSibling1Kid2Name(List<Relative> relList){
      for(Relative rel : relList){
        if(rel.getRelationTypeId() == 16){
          relName = rel.getRelativeName();
          break;
        }
      }
      return relName;
    }

    public String getMothersSibling2Kid1Name(List<Relative> relList){
      for(Relative rel : relList){
        if(rel.getRelationTypeId() == 17){
          relName = rel.getRelativeName();
          break;
        }
      }
      return relName;
    }

    public String getMothersSibling2Kid2Name(List<Relative> relList){
      for(Relative rel : relList){
        if(rel.getRelationTypeId() == 18){
          relName = rel.getRelativeName();
          break;
        }
      }
      return relName;
    }

    public String getUserSibling1Name(List<Relative> relList){
      for(Relative rel : relList){
        if(rel.getRelationTypeId() == 19){
          relName = rel.getRelativeName();
          break;
        }
      }
      return relName;
    }

    public String getUserSibling2Name(List<Relative> relList){
      for(Relative rel : relList){
        if(rel.getRelationTypeId() == 20){
          relName = rel.getRelativeName();
          break;
        }
      }
      return relName;
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
